public class Portero extends Jugador {
    // Atributos

    // Métodos
    public Portero (String nom, int dor){
        super(nom, dor);
    }

    public void parada() {
        puntos = puntos + 1;
    }

    public void paraPenalti() {
        puntos = puntos + 3;
    }

    public void encajaGol() {
        puntos = puntos - 1;
    }

    public String toString() {
        return "Jugador: "+nombre+" -- Posición: Portero -- Puntos: "+puntos;
    }
}