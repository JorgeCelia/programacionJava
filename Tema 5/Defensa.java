public class Defensa extends Jugador {
    // Atributos

    // Métodos
    public Defensa (String nom, int dor){
        super(nom, dor);
    }

    public void marcaGol() {
        puntos = puntos + 4;
    }

    public void cometePenalti() {
        puntos = puntos - 1.5;
    }

    public void encajaGol() {
        puntos = puntos - 1;
    }

    public String toString() {
        return "Jugador: "+nombre+" -- Posición: Defensa -- Puntos: "+puntos;
    }
}