//Clase para lanzar las sentencias SQL
//Contendrá métodos crean dichas sentencias y usa ConexionBD para conectarse, lo que permitirá que la clse que la use se desentienda del acceso a la BD

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReservasDAO {

    //Inserta una nueva reserva estándar
    public boolean insertaReservaEstandar(String dni, String nom, double prec, LocalDate fecha, int num, String tipo) {
        boolean exito = false;
        //Conectamos a la BD y lanzamos la consulta
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement pst = con.prepareStatement("INSERT INTO reservas (tipo_reserva, nombre_cliente, dni, precio_noche, fecha_entrada, num_noches, tipo_habitacion, pension) VALUES ('E', ?, ?, ?, ?, ?, ?, ?)")) {  //Lanzo la consulta

            String tipoEstandar;

            if (tipo.equals("Individual")) {
                tipoEstandar = "I";
            } else if (tipo.equals("Doble")) {
                tipoEstandar = "D";
            } else {
                tipoEstandar = "S";
            }

            pst.setString(1, nom);
            pst.setString(2, dni);
            pst.setDouble(3, prec);
            pst.setDate(4, Date.valueOf(fecha));
            pst.setInt(5, num);
            pst.setString(6, tipoEstandar);
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

    //Inserta una nueva reserva estándar
    public boolean insertaReservaPension(String dni, String nom, double prec, LocalDate fecha, int num, String tipo) {
        boolean exito = false;
        //Conectamos a la BD y lanzamos la consulta
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement pst = con.prepareStatement("INSERT INTO reservas (tipo_reserva, nombre_cliente, dni, precio_noche, fecha_entrada, num_noches, tipo_habitacion, pension) VALUES ('P', ?, ?, ?, ?, ?, ?, ?)")) {  //Lanzo la consulta

            String tipoPension;

            if (tipo.equals("Media Pensión")) {
                tipoPension = "MP";
            } else {
                tipoPension = "PC";
            }

            pst.setString(1, nom);
            pst.setString(2, dni);
            pst.setDouble(3, prec);
            pst.setDate(4, Date.valueOf(fecha));
            pst.setInt(5, num);
            pst.setString(6, null);
            pst.setString(7, tipoPension);

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
    public ArrayList<Reserva> cargaDatosReservas() {
        ArrayList<Reserva> datos = new ArrayList<>();

        //Conectamos a la BD y recogemos los datos
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM reservas")) {  //Pido todas las reservas

            try (ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                //Para cada fila, recojo los datos y los añado al ArrayList

                if (rs.getString("tipo_reserva").equals("E")) { //Es una reserva estándar
                    char tipoHabitacion='X';

                    if (rs.getString("tipo_habitacion").equals("I")) { //Habitación individual
                        tipoHabitacion = 'I';
                    } else if (rs.getString("tipo_habitacion").equals("D")) { //Habitación Doble
                        tipoHabitacion = 'D';
                    } else { //Suite
                        tipoHabitacion = 'S';
                    } 

                    datos.add(new ReservaEstandar(rs.getString("nombre_cliente"),rs.getString("dni"),rs.getDouble("precio_noche"),rs.getDate("fecha_entrada").toLocalDate(),rs.getInt("num_noches"),tipoHabitacion));

                } else { //Es una reserva con pensión
                    datos.add(new ReservaConPension(rs.getString("nombre_cliente"),rs.getString("dni"),rs.getDouble("precio_noche"),rs.getDate("fecha_entrada").toLocalDate(),rs.getInt("num_noches"),rs.getString("pension")));
                }
            }
        }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return datos;
    }
}
