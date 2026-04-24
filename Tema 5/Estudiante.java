//La clase Estudiante hereda de MiembroInsituto
class Estudiante extends MiembroInstituto {
    //Atributos
    private String curso;

    //Métodos
    public Estudiante(String nom, String id, String cur){
        super(nom, id); //Llamamos al constructor de la clase padre
        this.curso = cur;
    }

    public void presentarse() {
        System.out.println("Nombre: "+nombre+" DNI: "+dni+" Curso: "+curso);
    }

    public String toString() {
        return "Nombre: "+nombre+" DNI: "+dni+" Curso: "+curso;
    }
}