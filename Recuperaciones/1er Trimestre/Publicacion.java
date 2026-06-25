/*
 * Clase base que representa una publicación de nuestro catálogo
 */
public class Publicacion {
    protected String titulo;
    protected String autor;
    protected int paginas;

    // Constructor completo
    public Publicacion(String tit, String aut, int pags) {
        this.titulo = tit;
        this.autor = aut;
        this.paginas = pags;
    }

    // Getters y Setters (útiles para conectar con la interfaz gráfica)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    /*Método para mostrar la información */
    public void mostrarDatos() {
        System.out.println("==="+titulo+"===");
        System.out.println("Autor: "+autor);
        System.out.println("Páginas: "+paginas);
    }

    public void muestraInfo() {
    }
}