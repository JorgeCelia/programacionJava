import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaDB {
    public static void main(String[] args) {
        // Datos de tu base de datos
        String url = "jdbc:mysql://localhost:3306/filmoteca_db";
        String usuario = "jorge";
        String password = "miclave";

        System.out.println("Conectando...");

        try (Connection con = DriverManager.getConnection(url, usuario, password)) {
            System.out.println("¡Conexión exitosa a MySQL!");
            
        } catch (SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
    }
}
