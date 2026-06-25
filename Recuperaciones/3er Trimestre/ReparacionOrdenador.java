import java.time.LocalDate;

public class ReparacionOrdenador extends Reparacion {
    private char limpiezaInterna; //'S' Sí, 'N' No

    //Constructor completo
    public ReparacionOrdenador(String nom, String dni, double prec, LocalDate fecha, int hor, char lim) {
        super(nom, dni, prec, fecha, hor);
        this.limpiezaInterna = lim;
    }

    //Get y set del atributo propio
    public char getLimpiezaInterna() {
        return limpiezaInterna;
    }

    public void setLimpiezaInterna(char limpiezaInterna) {
        this.limpiezaInterna = limpiezaInterna;
    }

    //Cálculo del precio total
    public double getPrecioTotal() {
        double precio;

        precio = precioBase + (horasTrabajo*20);

        if (limpiezaInterna=='S') { //Hay que limpiar el ordenador por dentro
            precio = precio + 30;
        }

        return precio;
    }
}