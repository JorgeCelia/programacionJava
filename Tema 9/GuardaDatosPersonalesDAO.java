//Clase para lanzar las sentencias SQL
//Contendrá métodos crean dichas sentencias y usa ConexionBD para conectarse, lo que permitirá que la clse que la use se desentienda del acceso a la BD

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GuardaDatosPersonalesDAO {

    //Inserta un usuario con los datos pasados
    public boolean insertaUsuario(String nom, String ape, int edad, String direccion) {
        boolean exito = false;
        //Conectamos a la BD y lanzamos la consulta
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement pst = con.prepareStatement("INSERT INTO usuarios (nombre, apellidos, edad, direccion) VALUES (?, ?, ?, ?)")) {  //Lanzo la consulta

            pst.setString(1, nom);
            pst.setString(2, ape);
            pst.setInt(3, edad);
            pst.setString(4, direccion);

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

}
