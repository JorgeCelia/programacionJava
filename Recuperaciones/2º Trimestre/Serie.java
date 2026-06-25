public class Serie extends Contenido {
    private int temporadas;

    public Serie(String tit, String plat, int dur, int temp) {
        super(tit, plat, dur);
        this.temporadas = temp;
    }

    //Get y set del atributo propio
    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    //Sobreescritura del método mostrarDatos()
    public String mostrarDatos() {
        return titulo+" - "+plataforma+" - "+duracion+" min - "+temporadas+" temporadas";
    }  
}