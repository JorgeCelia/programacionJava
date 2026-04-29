//Clase para el acceso a la BD
//Contendrá métodos para crear la conexión y utilizarla desde cualquier ptra clase

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/programacion";
    private static final String USER = "daw1b";
    private static final String PASS = "Daw1B$";

    private static Connection conexion = null;

    // Constructor privado para evitar que se creen instancias con 'new'
    private ConexionBD() {}

    public static Connection getConexion() throws SQLException {
        // Si la conexión no existe o se ha cerrado, la creamos
        if (conexion == null || conexion.isClosed()) {
            try {
                conexion = DriverManager.getConnection(URL, USER, PASS);
            } catch (SQLException e) {
                System.err.println("Error al conectar: " + e.getMessage());
                throw e; 
            }
        }
        return conexion;
    }

    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar: " + e.getMessage());
            }
        }
    }
}
