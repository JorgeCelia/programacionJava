public class Perro2 extends Animal{
    //Defino sus atributos
    private String raza;

    public Perro2 (String nom, int age, String raz) {
        super(nom, age);
        this.raza = raz;
    }

    public Perro2 (String linea) {
        super(linea);
        String [] datos = linea.split(";");
        raza = datos[3];
    }

    //Me genera la línea para guardar en archivo
    public String generaDatos() {
        return "perro;"+nombre+";"+edad+";"+raza+"\n";
    }

    //Muestra la información del perro formateada
    public void muestraInfo() {
        super.muestraInfo();
        System.out.println("Tipo: perro");
        System.out.println("Raza: "+raza);
    }

}