/*
 * Clase base que representa una reparación genérica
 */

import java.time.LocalDate;

public class Reparacion {
    protected String nombreCliente;
    protected String dni;
    protected double precioBase;
    protected LocalDate fechaEntrada;
    protected int horasTrabajo;

    // Constructor completo
    public Reparacion(String nom, String dni, double prec, LocalDate fecha, int hor) {
        this.nombreCliente = nom;
        this.dni = dni;
        this.precioBase= prec;
        this.fechaEntrada= fecha;
        this.horasTrabajo= hor;
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

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public int getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(int horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }

    //Métodos para sobreescribir
    public char getTipoAveria() {
        return 'X';
    }

    public char getLimpiezaInterna() {
        return 'X';
    }


    //Cálculo del precio total
    public double getPrecioTotal() {
        return precioBase;
    }


}