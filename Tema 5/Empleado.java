/*
Clase Empleado
 */

class Empleado extends Persona{
    //Definición de los atributos
    private double sueldo;

    //Defino el constructor
    public Empleado(String nombre, int edad, double sueldo){
        //Debo llamar al constructor de la clase de la que hereda Empleado
        super(nombre,edad);
        this.sueldo = sueldo;
    }

    //Método para cambiar el nombre de la persona
    public void setNombre(String nom){
        this.nombre = nom;
    }

    //Método para cambiar la edad de la persona
    public void setEdad(int ed){
        super.edad = ed; //Sería lo mismo que this.edad=ed
    }

    //Método para mostrar los datos de la persona
    public void muestraDatos(){
        super.muestraDatos();
        System.out.println("Sueldo: "+sueldo+"€");
    }
}
