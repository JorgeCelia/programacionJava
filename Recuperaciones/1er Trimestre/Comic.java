public class Comic extends Publicacion {
    private String ilustrador;

    public Comic(String tit, String aut, int pags, String ilust) {
        super(tit, aut, pags);
        this.ilustrador = ilust;
    }

    //Get y set del atributo propio
    public String getIlustrador() {
        return ilustrador;
    }

    public void setIlustrador(String ilustrador) {
        this.ilustrador = ilustrador;
    }

    //Sobreescritura del método mostrarDatos()
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Ilustrador: "+ilustrador);
    }  

    public void muestraInfo() {
        System.out.println(titulo+" - "+autor+" - "+ilustrador);
    }
}