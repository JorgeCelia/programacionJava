public class Gato extends Animal{
    //Defino sus atributos
    private boolean esCazador;

    public Gato (String nom, int age, boolean caza) {
        super(nom, age);
        this.esCazador = caza;
    }

    //Me genera la línea para guardar en archivo
    public String generaDatos() {
        return "gato;"+nombre+";"+edad+";"+esCazador+"\n";
    }

    //Muestra la información del gato formateada
    public void muestraInfo() {
        super.muestraInfo();
        System.out.println("Tipo: gato");
        if (esCazador) {System.out.println("Es cazador");}
        else {System.out.println("No es cazador");}
    }

}