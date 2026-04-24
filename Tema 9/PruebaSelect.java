import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaSelect {
    public static void main(String[] args) {
        // Datos de tu base de datos
        String url = "jdbc:mysql://localhost:3306/filmoteca_db";
        String user = "jorge";
        String pass = "miclave";

        try (Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM filmoteca")) {

            System.out.println("Título\t\tDirector\t\tDuración");
            System.out.println("==========================================================================");

            while (rs.next()) {
                System.out.println(rs.getString("titulo")+"\t"+rs.getString("director")+"\t"+rs.getInt("duracion"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
