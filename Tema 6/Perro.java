public class Perro {
    //Defino sus atributos
    private String nombre;
    private String raza;
    private int edad;
    private double peso;

    //Defino sus métodos
    public Perro (String nombre, String raza, int edad, double peso) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
    }

    public Perro (String linea) { //Construye un objeto Perro a partir de una de las líneas del archivo
        String [] datos = linea.split(";"); //Parto la línea en base a los ;
        //Mete cada dato en su campo correspondiente
        this.nombre = datos[0];
        this.raza = datos[1];
        this.edad = Integer.parseInt(datos[2]);
        this.peso = Double.parseDouble(datos[3]);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String toString() { 
    //Devolvemos la información del perro en una cadena de caracteres
        return "Nombre: "+nombre+" Raza: "+raza+" Edad: "+edad+" años Peso: "+peso+"kg";
    }

    public String cadenaFichero() { 
    //Devolvemos la información del perro adaptada a como se va a escribir en el fichero
        return nombre+";"+raza+";"+edad+";"+peso;
    }
}