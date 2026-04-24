import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PruebaConsulta {
    public static void main(String[] args) {
        // Datos de tu base de datos
        String url = "jdbc:mysql://localhost:3306/filmoteca_db";
        String user = "jorge";
        String pass = "miclave";
        Scanner lector = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM filmoteca WHERE director = ?")) {

                //Pedimos al usuario los datos
            System.out.print("Introduce el nombre del director: ");
            String dato = lector.nextLine();

            pst.setString(1, dato);
            try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString("titulo")+"\t"+rs.getInt("duracion"));
            }
        }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        lector.close();
    }
}
