/*
Clase Pelicula que tenga los campos:
    titulo
    director
    género
    duración
    nacionalidad
    año
Debemos incluir los siguientes métodos:
    getter y setter para cada atributo
    método infoPelicula para mostrar toda la información de una pelicula formateada
 */

class Pelicula {
    //Definición de los atributos
    private String titulo;
    private String director;
    private String genero;
    private int duracion;
    private String nacionalidad;
    private int year;

    //Defino el constructor
    public Pelicula(String tit, String dir, String gen, int dur, String nac, int agno) {
        titulo = tit;
        director = dir;
        genero = gen;
        duracion = dur;
        nacionalidad = nac;
        year = agno;
    }

    //Defino los métodos get set
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }    

    //Defino el resto de métodos
     public void infoPelicula() { //Me muestra la información de la pelicula
        System.out.println("***********************************");
        System.out.println(titulo);
        System.out.println("***********************************");
        System.out.println("Director: "+director);
        System.out.println("Género: "+genero);
        System.out.println("Duración: "+duracion+" minutos");
        System.out.println("Nacionalidad: "+nacionalidad);
        System.out.println("Año de producción: "+year);
     }




}
