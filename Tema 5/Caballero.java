public class Caballero extends Guerrero {
    //Atributos
    protected double armadura;

    //Métodos
    //Constructor
    public Caballero(String nom, double life, double fuer, double armor) { 
        super(nom, life, fuer); //Llamamos al constructor de Guerrero
        armadura = armor;
    }
   
    public String toString(){
        //Devuelve la información del Caballero
        return nombre+" Vida: "+vida+" Armadura: "+armadura;
    }

    public void arreglaArmadura(int valor) {
        //Aumenta el valor de la armadura en el número que pasemos
        armadura = armadura + valor;

        if(armadura>100) {armadura=100;} //La armadura no puede valer más de 100
    }

    public void restaArmadura(double valor) {
        //Disminuye la armadura en el valor dado
        armadura = armadura - valor;

        if(armadura<=0) {
            armadura= 0;
        } //La armadura no puede ser menor que 0
    }

    public void recibeAtaque(Guerrero warrior){
        //Me ataca un guerrero
        if (armadura>0) { //Tengo armadura
            restaVida((warrior.getFuerza()*1.5)/2);
            restaArmadura(warrior.getFuerza());
        } else { //No me queda armadura
            restaVida(warrior.getFuerza()*1.5);
        }

        //Pierdo la vida igual a su fuerza
        restaVida(warrior.getFuerza());
    }
}