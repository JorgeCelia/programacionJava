public class Centrocampista extends Jugador {
    // Atributos

    // Métodos
    public Centrocampista (String nom, int dor){
        super(nom, dor);
    }

    public void marcaGol() {
        puntos = puntos + 4;
    }

    public void cometePenalti() {
        puntos = puntos - 1;
    }

    public String toString() {
        return "Jugador: "+nombre+" -- Posición: Centrocampista -- Puntos: "+puntos;
    }
}