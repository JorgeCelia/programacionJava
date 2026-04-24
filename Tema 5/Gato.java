public class Gato extends Animal {
    private String nombre;

    public Gato(String nom) {
        nombre = nom;
    }

    public void hacerSonido(){
        System.out.println("Miau");
    }

    public void presentarse(){
        System.out.println("Miau, me llamo "+nombre);
    }
}