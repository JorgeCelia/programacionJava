abstract class Animal {
    //Defino sus atributos
    String nombre;
    int edad;

    public Animal (String nom, int age){
        nombre = nom;
        edad = age;
    }

    public Animal (String linea) {
        String [] datos = linea.split(";");
        nombre = datos[1];
        edad = Integer.parseInt(datos[2]);
    }

    //Creo el método generaDatos que luego sobreescribo en las clases hijas
    public String generaDatos() {
        return "";
    }

    //Método que devuelve la edad
    public int getEdad() {
        return edad;
    }
    
    //Método que devuelve el nombre
    public String getNombre() {
        return nombre;
    }

    //Muestra la información del animal formateada
    public void muestraInfo() {
        System.out.println("--------------------------------------------");
        System.out.println("     Información de "+nombre);
        System.out.println("--------------------------------------------");
        System.out.println("Edad: "+edad);
    }

}
