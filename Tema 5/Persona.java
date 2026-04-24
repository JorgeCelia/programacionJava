/*
Clase persona
 */

class Persona {
    //Definición de los atributos
   protected String nombre;
   protected int edad;

   //Creo el constructor de la clase persona
   public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
   }

    //Método para mostrar los datos de la persona
    public void muestraDatos(){
        System.out.println("==Información==");
        System.out.println("Nombre: "+nombre);
        System.out.println("Edad: "+edad+" años");
    }
}
