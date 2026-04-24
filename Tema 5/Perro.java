public class Perro extends Animal {
    private String nombre;

    public Perro(String nom) {
        nombre = nom;
    }

    public void hacerSonido(){
        System.out.println("Guau");
    }

    public void presentarse(){
        System.out.println("Guau, me llamo "+nombre);
    }
}
