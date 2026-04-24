//Clase para lanzar las sentencias SQL
//Contendrá métodos crean dichas sentencias y usa ConexionBD para conectarse, lo que permitirá que la clse que la use se desentienda del acceso a la BD

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmotecaDAO {

    //Carga en el ArrayList pasado como parámetro todos los datos de la filmoteca
    public void cargaDatosBruto(ArrayList<Pelicula> datos) {
        //Conectamos a la BD y recogemos los datos
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM filmoteca")) {  //Pido toda la tabla

            try (ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                //Para cada fila, recojo los datos y los añado al ArrayList
                datos.add(new Pelicula(rs.getString("titulo"),rs.getString("director"),rs.getString("genero"),rs.getInt("duracion"),rs.getString("pais"),rs.getInt("anio")));
            }
        }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Busca las películas del director, las carga en el ArrayList y devuelve el número de filas de la consulta
    public int cargaDatosBusquedaDirector(ArrayList<Pelicula> datos, String title) {
        //Conectamos a la BD y recogemos los datos
        int filasDevueltas = 0;

        try (Connection con = ConexionBD.getConexion();
            //Pido las peliculas con ese director independientemente de mayúsculas o minúsculas y si su nombre contiene esa palabra
            PreparedStatement pst = con.prepareStatement("SELECT * FROM filmoteca WHERE LOWER(director) LIKE ?")) {  

            pst.setString(1, "%"+title.toLowerCase()+"%");

            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    //Para cada fila, recojo los datos y los añado al ArrayList
                    datos.add(new Pelicula(rs.getString("titulo"),rs.getString("director"),rs.getString("genero"),rs.getInt("duracion"),rs.getString("pais"),rs.getInt("anio")));

                    //Aumento en 1 el número de filas
                    filasDevueltas++;
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return filasDevueltas;
    }

    //Inserta una película con los datos pasados
    public boolean insertaPelicula(String tit, String dir, String gen, int dur, String nac, int year) {
        boolean exito = false;
        //Conectamos a la BD y lanzamos la consulta
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement pst = con.prepareStatement("INSERT INTO filmoteca (titulo, director, genero, duracion, pais, anio) VALUES (?, ?, ?, ?, ?, ?)")) {  //Lanzo la consulta

            pst.setString(1, tit);
            pst.setString(2, dir);
            pst.setString(3, gen);
            pst.setInt(4, dur);
            pst.setString(5, nac);
            pst.setInt(6, year);

            try{
                int valor=pst.executeUpdate();

                if (valor>0) { //Ha afectado a más de 0 filas
                    exito=true; 
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            
            return exito;
    }

    //Borra la película cuyo título nos pasan
    public boolean borraPelicula(String tit) {
        boolean exito = false;
        //Conectamos a la BD y lanzamos la consulta
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement pst = con.prepareStatement("DELETE FROM filmoteca WHERE titulo=?")) {  //Lanzo la consulta

            pst.setString(1, tit);

            try{
                int valor=pst.executeUpdate();

                if (valor>0) { //Ha afectado a más de 0 filas
                    exito=true; 
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            
        return exito;
    }

    //Actualiza el director de la película cuyo título nos pasan
    public boolean actualizaDirectorPelicula(String tit, String dir) {
        boolean exito = false;
        //Conectamos a la BD y lanzamos la consulta
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement pst = con.prepareStatement("UPDATE filmoteca SET director=? WHERE titulo=?")) {  //Lanzo la consulta

            pst.setString(1, dir);
            pst.setString(2, tit);

            try{
                int valor=pst.executeUpdate();

                if (valor>0) { //Ha afectado a más de 0 filas
                    exito=true; 
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            
        return exito;
    }

    //Devuelve una pelicula aleatoria en el objeto Pelicula
    public Pelicula peliculaAleatoria() {
        Pelicula p = new Pelicula("","","",0,"",0);
        
        //Conectamos a la BD y lanzamos la consulta
        try (Connection con = ConexionBD.getConexion();
            //Pido una pelicula aleatoria
            PreparedStatement pst = con.prepareStatement("SELECT * FROM filmoteca ORDER BY RAND() LIMIT 1")) {  

            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    //Recojo los datos de la única fila y genero el objeto Pelicula con los mismos
                    p = new Pelicula(rs.getString("titulo"),rs.getString("director"),rs.getString("genero"),rs.getInt("duracion"),rs.getString("pais"),rs.getInt("anio"));
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return p;
    }
}
