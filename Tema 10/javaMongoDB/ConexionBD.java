//Clase para el acceso a la BD
//Contendrá métodos para crear la conexión y utilizarla desde cualquier ptra clase
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConexionBD{
    // Definimos la URI de conexión
    private static final String connectionString = "mongodb+srv://usuario_daw:Daw1B$@clustercelia.mkhc8y4.mongodb.net/";

    //Usamos una sola instancia de acceso a la BD para toda la aplicación
    private static MongoClient mongoClient = null;
    private static MongoDatabase database = null;

    public static MongoDatabase getConexion() throws MongoException {

        if (mongoClient == null) {
            try {
                mongoClient = MongoClients.create(connectionString);
                database = mongoClient.getDatabase("programacion");
                System.out.println("¡Conexión exitosa a la base de datos: " + database.getName() + "!");               
            } catch (Exception e) {
                System.err.println("Error al conectar: " + e.getMessage());
            }
        }

        return database;
    }

    // Solo llamamos a esto cuando cerremos la app completa
    public static void cerrarConexion() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexión cerrada.");
        }
    }
}
