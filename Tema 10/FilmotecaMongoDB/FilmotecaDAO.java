
import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

//Clase para acceder a la BD
//Contendrá métodos que usen el EMF y devuelvan los datos en un formato que no dependa de la BD

public class FilmotecaDAO {
    //Devuelve en un ArrayList todos los datos de la filmoteca
    public ArrayList<Pelicula> cargaDatosBruto() {
        //Conectamos a la BD y recogemos los datos
        MongoDatabase database = ConexionBD.getConexion();

        //Accedemos a la colección con seguridad
        MongoCollection<Document> coleccionPeliculas = database.getCollection("filmoteca");

        //Metemos todos los elementos de la Colección en un Iterable
        FindIterable<Document> resultados = coleccionPeliculas.find();

        ArrayList<Pelicula> datos = new ArrayList<>();

        for (Document p : resultados) {
            datos.add(new Pelicula(p.getString("titulo"), p.getString("director"), p.getString("genero"), p.getInteger("duracion"), p.getString("pais"), p.getInteger("anio")));
        }        

        return datos;
    }

    //Busca las películas del director, las carga en el ArrayList y devuelve el número de filas de la consulta
    public ArrayList<Pelicula> cargaDatosBusquedaDirector(String title) {
        //Conectamos a la BD y recogemos los datos
        MongoDatabase database = ConexionBD.getConexion();

        //Accedemos a la colección con seguridad
        MongoCollection<Document> coleccionPeliculas = database.getCollection("filmoteca");
        ArrayList<Pelicula> datos = new ArrayList<>();

        // Creamos el filtro: donde el campo "director" sea igual a director A Buscar. La "i" nos permite buscar ya sean mayúsculas o minúsculas
        FindIterable<Document> resultados = coleccionPeliculas.find(Filters.regex("director", title, "i"));
        
        datos = new ArrayList<>();

        for (Document p : resultados) {
            datos.add(new Pelicula(p.getString("titulo"), p.getString("director"), p.getString("genero"), p.getInteger("duracion"), p.getString("pais"), p.getInteger("anio")));
        }        

        return datos;
    }

    //Inserta una película en la BD
    public boolean insertaPelicula(Pelicula p) {
        //Conectamos a la BD y recogemos los datos
        MongoDatabase database = ConexionBD.getConexion();

        //Accedemos a la colección con seguridad
        MongoCollection<Document> coleccionPeliculas = database.getCollection("filmoteca");
        boolean exito = false;
        
        //Creo un documento nuevo con la pelicula pasada como parámetro
        Document doc = new Document("titulo", p.getTitulo())
            .append("director", p.getDirector())
            .append("genero", p.getGenero())
            .append("duracion", p.getDuracion())
            .append("pais", p.getNacionalidad())
            .append("anio", p.getYear());

        //Lo añado a la colección
        try {
           coleccionPeliculas.insertOne(doc);
           exito = true;
        } catch (MongoException e) {
            System.out.println("Se ha producido un error al insertar la palícula: " + e.getMessage());
        }

        return exito;
    }

    //Borra la película cuyo título nos pasan
    public boolean borraPelicula(String tit) {
        //Conectamos a la BD y recogemos los datos
        MongoDatabase database = ConexionBD.getConexion();

        //Accedemos a la colección con seguridad
        MongoCollection<Document> coleccionPeliculas = database.getCollection("filmoteca");
        boolean exito = false;

        // Ejecutamos la eliminación
        DeleteResult resultado = coleccionPeliculas.deleteOne(Filters.eq("titulo", tit));

        //Si se ha borrado algo devolvemos true
        if (resultado.getDeletedCount() > 0) {
            exito = true;
        }
    
        return exito;
    }

    //Actualiza el director de la película cuyo título nos pasan
    public boolean actualizaDirectorPelicula(String tit, String dir) {
        //Conectamos a la BD y recogemos los datos
        MongoDatabase database = ConexionBD.getConexion();

        //Accedemos a la colección con seguridad
        MongoCollection<Document> coleccionPeliculas = database.getCollection("filmoteca");
        boolean exito = false;

        //Definimos el criterio de búsqueda
        Bson filtro = Filters.eq("titulo", tit);

        //Definimos la actualización (Qué campo cambia y a qué valor)
        Bson actualizacion = Updates.set("director", dir);

        //Ejecutamos la actualización
        UpdateResult resultado = coleccionPeliculas.updateOne(filtro, actualizacion);

        //Comprobamos el resultado
        if (resultado.getModifiedCount() > 0) {
            exito = true;
        }

        return exito;
    }

    //Devuelve una pelicula aleatoria en el objeto Pelicula
    public Pelicula peliculaAleatoria() {
        //Conectamos a la BD y recogemos los datos
        MongoDatabase database = ConexionBD.getConexion();

        //Accedemos a la colección con seguridad
        MongoCollection<Document> coleccionPeliculas = database.getCollection("filmoteca");

        //Sacamos un documento aleatorio de entre toda la colección filmoteca
        Document peliculaAleatoria = coleccionPeliculas.aggregate(Arrays.asList(Aggregates.sample(1))).first();

        //Creo una película con dicho documento
        Pelicula p = new Pelicula(peliculaAleatoria.getString("titulo"), peliculaAleatoria.getString("director"), peliculaAleatoria.getString("genero"), peliculaAleatoria.getInteger("duracion"), peliculaAleatoria.getString("pais"), peliculaAleatoria.getInteger("anio"));

        return p;
    }
}
