//La calse Profesor hereda de MiembroInsituto
class Profesor extends MiembroInstituto {
    //Atributos
    private String materia;

    //Métodos
    public Profesor(String nom, String id, String materia){
        super(nom, id); //Llamamos al constructor de la clase padre
        this.materia = materia;
    }

    public void presentarse() {
        System.out.println("Nombre: "+nombre+" DNI: "+dni+" Asignatura: "+materia);
    }

}