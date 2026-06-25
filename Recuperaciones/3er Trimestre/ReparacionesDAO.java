//Clase para lanzar las sentencias SQL
//Contendrá métodos crean dichas sentencias y usa ConexionBD para conectarse, lo que permitirá que la clase que la use se desentienda del acceso a la BD

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReparacionesDAO {

    //Inserta una nueva reparación móvil
    public boolean insertaReparacionMovil(String dni, String nom, double prec, LocalDate fecha, int hor, String tipo) {
        boolean exito = false;
        //Conectamos a la BD y lanzamos la consulta
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement pst = con.prepareStatement("INSERT INTO reparaciones (tipo_reparacion, nombre_cliente, dni, precio_base, fecha_entrada, horas_trabajo, tipo_averia, limpieza_interna) VALUES ('M', ?, ?, ?, ?, ?, ?, ?)")) {  //Lanzo la consulta

            String tipoRep;

            if (tipo.equals("Pantalla")) {
                tipoRep = "P";
            } else if (tipo.equals("Batería")) {
                tipoRep = "B";
            } else {
                tipoRep = "C";
            }

            pst.setString(1, nom);
            pst.setString(2, dni);
            pst.setDouble(3, prec);
            pst.setDate(4, Date.valueOf(fecha));
            pst.setInt(5, hor);
            pst.setString(6, tipoRep);
            pst.setString(7, null);

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

    //Inserta una nueva reparación de ordenador
    public boolean insertaReparacionOrdenador(String dni, String nom, double prec, LocalDate fecha, int hor, String tipo) {
        boolean exito = false;
        //Conectamos a la BD y lanzamos la consulta
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement pst = con.prepareStatement("INSERT INTO reparaciones (tipo_reparacion, nombre_cliente, dni, precio_base, fecha_entrada, horas_trabajo, tipo_averia, limpieza_interna) VALUES ('O', ?, ?, ?, ?, ?, ?, ?)")) {  //Lanzo la consulta

            String tipoRep;

            if (tipo.equals("Sí")) {
                tipoRep = "S";
            } else {
                tipoRep = "N";
            }

            pst.setString(1, nom);
            pst.setString(2, dni);
            pst.setDouble(3, prec);
            pst.setDate(4, Date.valueOf(fecha));
            pst.setInt(5, hor);
            pst.setString(6, null);
            pst.setString(7, tipoRep);

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

    //Devuelve un ArrayList con todas las reservas
    public ArrayList<Reparacion> cargaDatosReparaciones() {
        ArrayList<Reparacion> datos = new ArrayList<>();

        //Conectamos a la BD y recogemos los datos
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM reparaciones")) {  //Pido todas las reparaciones

            try (ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                //Para cada fila, recojo los datos y los añado al ArrayList

                if (rs.getString("tipo_reparacion").equals("M")) { //Es una reparación de móvil
                    char tipoRep='X';

                    if (rs.getString("tipo_averia").equals("B")) { //Reparación de batería
                        tipoRep = 'B';
                    } else if (rs.getString("tipo_averia").equals("P")) { //Reparación de pantalla
                        tipoRep = 'P';
                    } else { //Conectividad
                        tipoRep = 'C';
                    } 

                    datos.add(new ReparacionMovil(rs.getString("nombre_cliente"),rs.getString("dni"),rs.getDouble("precio_base"),rs.getDate("fecha_entrada").toLocalDate(),rs.getInt("horas_trabajo"),tipoRep));

                } else { //Es una reparación de ordenador
                    char limpieza='X';

                    if (rs.getString("limpieza_interna").equals("S")) { //Hay que limpiarlo por dentro
                        limpieza = 'S';
                    } else { //No hay que limpiarlo por dentro
                        limpieza = 'N';
                    } 

                    datos.add(new ReparacionOrdenador(rs.getString("nombre_cliente"),rs.getString("dni"),rs.getDouble("precio_base"),rs.getDate("fecha_entrada").toLocalDate(),rs.getInt("horas_trabajo"),limpieza));
                }
            }
        }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return datos;
    }
}
