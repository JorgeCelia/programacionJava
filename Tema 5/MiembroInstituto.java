/*
Clase Miembro Instituto
 */

class MiembroInstituto{
    //Definición de los atributos
    protected String nombre;
    protected String dni;

    //Definición de los métodos
    public MiembroInstituto(String nom, String id){
        this.nombre = nom;
        this.dni = id;
    }

    public void presentarse(){
        //Lo crero vacío para que en el array de MiembroInstituto pueda usarlo en las clases hijas
    }
}
