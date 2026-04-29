import java.time.LocalDate;

/**
 * Clase base que representa un contrato genérico en el sistema de RRHH.
 */
public abstract class Contrato {
    protected String empleado;
    protected String dni;
    protected double salario;
    protected LocalDate fechaInicio;

    // Constructor completo
    public Contrato(String empleado, String dni, double salario, LocalDate fechaInicio) {
        this.empleado = empleado;
        this.dni = dni;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
    }

    // Getters y Setters (útiles para conectar con la interfaz gráfica)
    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}