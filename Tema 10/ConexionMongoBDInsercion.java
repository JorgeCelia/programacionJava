//Clase que accede a una BD MongoDB
import com.mongodb.MongoException;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.concurrent.TimeUnit;

public class ConexionMongoBD {
    public static void main(String[] args) {
        // Definimos la URI de conexión
        String connectionString = "mongodb+srv://usuario_daw:Daw1B$@clustercelia.mkhc8y4.mongodb.net/";

        // Configuramos un Timeout (Tiempo de espera)
        // Esto evita que el programa se quede "congelado" eternamente si internet falla
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .applyToClusterSettings(builder -> 
                    builder.serverSelectionTimeout(5000, TimeUnit.MILLISECONDS)) // Espera 5 segundos máximo
                .build();

        // Abrimos la conexión con el bloque try-with-resources
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            
            MongoDatabase database = mongoClient.getDatabase("mongodbVSCodePlaygroundDB");

            try {
                // Enviamos un comando "ping" al servidor
                database.runCommand(new Document("ping", 1));
                
                // Si llegamos aquí, la conexión es real y efectiva
                System.out.println("✅ ¡Conexión exitosa a la base de datos: " + database.getName() + "!");
                
                // Ahora sí, accedemos a la colección con seguridad
                MongoCollection<Document> coleccionAlumnos = database.getCollection("alumnos");
                System.out.println("Colección 'alumnos' lista para usarse.");

                // Creamos un documento para un alumno
                Document alumno = new Document("expediente", "2026-001")
                .append("nombre", "Ana García")
                .append("edad", 19)
                .append("becado", true)
                .append("contacto", new Document("email", "ana@daw.es")
                .append("tlf", "600000000"));

                // Insertamos un solo documento
                coleccionAlumnos.insertOne(alumno);


            } catch (MongoException e) {
                // Si el ping falla o el usuario/password es incorrecto, saltará aquí
                System.err.println("❌ Error de conexión: El servidor no responde o las credenciales son incorrectas.");
                System.err.println("Detalle técnico: " + e.getLocalizedMessage());
            }

        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
        }    
    }
}
