public class Personaje {
    //Atributos de la clase
    protected String nombre;
    protected double vida;
    protected boolean vivo;

    //Métodos
    //Constructor
    public Personaje(String nom, double life) { 
        nombre = nom;
        vida = life;
        vivo = true;
    }

    public String getNombre(){
        return nombre;
    }

    public void bebePocionCurativa(int valor) {
        //Aumenta la vida en el valor dado
        vida = vida + valor;

        if(vida>100) {vida= 100;} //La vida no puede ser mayor que 100
    }

    public void restaVida(double valor) {
        //Disminuye la vida en el valor dado
        vida = vida - valor;

        if(vida<=0) {
            vida= 0;
            vivo= false;
        } //La vida no puede ser menor que 0
        //El personaje ha muerto
    }

    public boolean estaVivo(){
        //Nos dice si el personaje está vivo o no
        return vivo;
    }
}