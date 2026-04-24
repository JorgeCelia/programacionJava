public class Guerrero extends Personaje {
    //Atributos
    protected double fuerza;

    //Métodos
    //Constructor
    public Guerrero(String nom, double life, double fuer) { 
        super(nom, life); //Llamamos al constructor de Personaje
        fuerza = fuer;
    }

    public String toString(){
        //Devuelve la información del Guerrero
        return nombre+" Vida: "+vida;
    }

    public double getFuerza(){
        return fuerza;
    }

    public void recibeAtaque(Guerrero warrior){
        //Me ataca un guerrero
        //Pierdo la vida igual a su fuerza
        restaVida(warrior.getFuerza());
    }
}