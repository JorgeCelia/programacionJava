//Clase para lanzar las sentencias SQL
//Contendrá métodos crean dichas sentencias y usa ConexionBD para conectarse, lo que permitirá que la clse que la use se desentienda del acceso a la BD

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ContratoDAO {

    //Carga en el ArrayList pasado como parámetro todos los contratos temporales
    public void cargaContratosTemporales(ArrayList<ContratoTemporal> datos) {
        //Conectamos a la BD y recogemos los datos
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM contratos WHERE tipo_contrato='T'")) {  //Pido los contratos temporales

            try (ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                //Para cada fila, recojo los datos y los añado al ArrayList
                datos.add(new ContratoTemporal(rs.getString("nombre_empleado"),rs.getString("dni"),rs.getDouble("salario"),rs.getDate("fecha_inicio").toLocalDate(),rs.getDate("fecha_fin").toLocalDate()));
            }
        }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Carga en el ArrayList pasado como parámetro todos los contratos indefinidos
    public void cargaContratosIndefinidos(ArrayList<ContratoIndefinido> datos) {
        //Conectamos a la BD y recogemos los datos
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM contratos WHERE tipo_contrato='I'")) {  //Pido los contratos indefinidos

            try (ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                //Para cada fila, recojo los datos y los añado al ArrayList
                datos.add(new ContratoIndefinido(rs.getString("nombre_empleado"),rs.getString("dni"),rs.getDouble("salario"),rs.getDate("fecha_inicio").toLocalDate()));
            }
        }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Inserta un nuevo contrato indefinido
    public boolean insertaContratoIndefinido(String dni, String nom, double sal, LocalDate fecha) {
        boolean exito = false;
        //Conectamos a la BD y lanzamos la consulta
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement pst = con.prepareStatement("INSERT INTO contratos (tipo_contrato, nombre_empleado, dni, salario, fecha_inicio) VALUES ('I', ?, ?, ?, ?)")) {  //Lanzo la consulta

            pst.setString(1, nom);
            pst.setString(2, dni);
            pst.setDouble(3, sal);
            pst.setDate(4, Date.valueOf(fecha));

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

    //Inserta un nuevo contrato temporal
    public boolean insertaContratoTemporal(String dni, String nom, double sal, LocalDate fecha, LocalDate fecha_fin) {
        boolean exito = false;
        //Conectamos a la BD y lanzamos la consulta
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement pst = con.prepareStatement("INSERT INTO contratos (tipo_contrato, nombre_empleado, dni, salario, fecha_inicio, fecha_fin) VALUES ('T', ?, ?, ?, ?, ?)")) {  //Lanzo la consulta

            pst.setString(1, nom);
            pst.setString(2, dni);
            pst.setDouble(3, sal);
            pst.setDate(4, Date.valueOf(fecha));
            pst.setDate(5, Date.valueOf(fecha_fin));

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

    //BUsca el tipo de contrato para un DNI concreto
    public char buscaTipoContratoDNI(String dni) {
        char resultado = 'X';
        //Conectamos a la BD y recogemos los datos
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement pst = con.prepareStatement("SELECT tipo_contrato FROM contratos WHERE dni=?")) {  //Pido los contratos de ese DNI
            pst.setString(1, dni);

            try (ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                //Para cada fila, recojo los datos y los añado al ArrayList
                if (rs.getString("tipo_contrato").equals("I")) { //Es un contrato indefinido
                    resultado = 'I';
                } else { //Es un contrato temporal
                    resultado = 'T';
                }
            }
        }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    //Devuelve el contrato indefinido para el DNI dado
    public ContratoIndefinido devuelveContratoIndefinido(String dni) {
        ContratoIndefinido c = new ContratoIndefinido("", "", 0, null);
        
        //Conectamos a la BD y lanzamos la consulta
        try (Connection con = ConexionBD.getConexion();
            //Pido una pelicula aleatoria
            PreparedStatement pst = con.prepareStatement("SELECT * FROM contratos WHERE dni=?")) {  
            pst.setString(1, dni);

            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    //Recojo los datos de la única fila y genero el objeto Pelicula con los mismos
                    c = new ContratoIndefinido(rs.getString("nombre_empleado"),rs.getString("dni"),rs.getDouble("salario"),rs.getDate("fecha_inicio").toLocalDate());
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return c;
    }

    //Devuelve el contrato temporal para el DNI dado
    public ContratoTemporal devuelveContratoTemporal(String dni) {
        ContratoTemporal c = new ContratoTemporal("", "", 0, null, null);
        
        //Conectamos a la BD y lanzamos la consulta
        try (Connection con = ConexionBD.getConexion();
            //Pido una pelicula aleatoria
            PreparedStatement pst = con.prepareStatement("SELECT * FROM contratos WHERE dni=?")) {  
            pst.setString(1, dni);

            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    //Recojo los datos de la única fila y genero el objeto Pelicula con los mismos
                    c = new ContratoTemporal(rs.getString("nombre_empleado"),rs.getString("dni"),rs.getDouble("salario"),rs.getDate("fecha_inicio").toLocalDate(),rs.getDate("fecha_fin").toLocalDate());
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return c;
    }

}
