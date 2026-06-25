public class Medicamento extends Producto {
    private boolean receta;

    public Medicamento(String nom, String lab, double pre, boolean rec) {
        super(nom, lab, pre);
        this.receta = rec;
    }

    //Get y set del atributo propio
    public boolean getReceta() {
        return receta;
    }

    public void setReceta(boolean receta) {
        this.receta = receta;
    }  

    //Sobreescritura del método mostrarDatos()
    public String mostrarDatos() {
        if (receta) {
            return nombre+" - "+laboratorio+" - "+precio+"€"+" - Requiere receta";
        } else {
            return nombre+" - "+laboratorio+" - "+precio+"€"+" - Sin receta";
        }
    }
}