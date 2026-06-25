/*
 * Clase base que representa un contenido de nuestra plataforma de streaming
 */
public class Contenido {
    protected String titulo;
    protected String plataforma;
    protected int duracion;

    // Constructor completo
    public Contenido(String tit, String plat, int dur) {
        this.titulo = tit;
        this.plataforma = plat;
        this.duracion = dur;
    }

    // Getters y Setters (útiles para conectar con la interfaz gráfica)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void muestraInfo() {
    }

    /*Método para mostrar la información */
    public String mostrarDatos() {
        return titulo+" - "+plataforma+" - "+duracion+" min";
    }

}