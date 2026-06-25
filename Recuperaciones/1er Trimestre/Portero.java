public class Portero extends Jugador {
    private int paradas;

    public Portero(String nom, String eq, int dor, int par) {
        super(nom, eq, dor);
        this.paradas = par;
    }

    //Get y set del atributo propio
    public int getParadas() {
        return paradas;
    }

    public void setParadas(int paradas) {
        this.paradas = paradas;
    }

    //Sobreescritura del método mostrarDatos()
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Paradas esta temporada: "+paradas);
    }  

    public void muestraInfo() {
        System.out.println(nombre+" - "+equipo+" - "+paradas+" paradas");
    }
}
