/*
 * Clase base que representa un producto de los disponibles en nuestra farmacia
 */
public class Producto {
    protected String nombre;
    protected String laboratorio;
    protected double precio;

    // Constructor completo
    public Producto(String nom, String lab, double pre) {
        this.nombre = nom;
        this.laboratorio = lab;
        this.precio = pre;
    }

    // Getters y Setters (útiles para conectar con la interfaz gráfica)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void muestraInfo() {
    }


    /*Método para mostrar la información */
    public String mostrarDatos() {
        return nombre+" - "+laboratorio+" - "+precio+"€";
    }

}