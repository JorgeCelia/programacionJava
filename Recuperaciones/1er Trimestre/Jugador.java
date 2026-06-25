/*
 * Clase base que representa un jugador de nuestra lista
 */
public class Jugador {
    protected String nombre;
    protected String equipo;
    protected int dorsal;

    // Constructor completo
    public Jugador(String nom, String eq, int dor) {
        this.nombre = nom;
        this.equipo = eq;
        this.dorsal = dor;
    }

    // Getters y Setters (útiles para conectar con la interfaz gráfica)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    /*Método para mostrar la información */
    public void mostrarDatos() {
        System.out.println("=== "+nombre+" ===");
        System.out.println("Equipo: "+equipo);
        System.out.println("Dorsal: "+dorsal);
    }


    public void muestraInfo() {
        System.out.println(nombre+" - "+equipo);    
    }
}