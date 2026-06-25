/*
 * Clase base que representa una reserva genérica
 */

import java.time.LocalDate;

public class Reserva {
    protected String nombreCliente;
    protected String dni;
    protected double precioNoche;
    protected LocalDate fechaEntrada;
    protected int numNoches;

    // Constructor completo
    public Reserva(String nom, String dni, double prec, LocalDate fecha, int num) {
        this.nombreCliente = nom;
        this.dni = dni;
        this.precioNoche= prec;
        this.fechaEntrada= fecha;
        this.numNoches= num;
    }

    // Getters y Setters
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public int getNumNoches() {
        return numNoches;
    }

    public void setNumNoches(int numNoches) {
        this.numNoches = numNoches;
    }

    //Métodos para sobreescribir
    public String getPension() {
        return "";
    }

    public char getTipoHabitacion() {
        return 'X';
    }


    //Cálculo del precio total
    public double getPrecioTotal() {
        return numNoches*precioNoche;
    }

}