public class Delantero extends Jugador {
    // Atributos

    // Métodos
    public Delantero (String nom, int dor){
        super(nom, dor);
    }

    public void marcaGol() {
        puntos = puntos + 3;
    }

    public void cometePenalti() {
        puntos = puntos - 1;
    }

    public String toString() {
        return "Jugador: "+nombre+" -- Posición: Delantero -- Puntos: "+puntos;
    }
}