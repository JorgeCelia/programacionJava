public class Jugador {
    // Atributos
    protected String nombre;
    protected int dorsal;
    protected double puntos;

    // Métodos
    public Jugador (String nom, int dor){
        nombre = nom;
        dorsal = dor;
        puntos = 0;
    }

    public void setPuntos(double valor) {
        puntos = valor;
    }

    public double getPuntos() {
        return puntos;
    }

    public void tarjetaAmarilla() {
        puntos = puntos - 1;
    }

    public void tarjetaRoja() {
        puntos = puntos - 3;
    }

    public void cometeFalta() {
        puntos = puntos - 0.3;
    }

    public void cometePenalti() {
    }

    public void paraPenalti() {
    }

    public void marcaGol() {
    }

    public void encajaGol() {
    }
}