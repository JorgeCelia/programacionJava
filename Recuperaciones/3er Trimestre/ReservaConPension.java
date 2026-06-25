import java.time.LocalDate;

public class ReservaConPension extends Reserva {
    private String pension; //'MP' Media Pensión, 'PC' Pensión completa

    //Constructor completo
    public ReservaConPension(String nom, String dni, double prec, LocalDate fecha, int num, String pen) {
        super(nom, dni, prec, fecha, num);
        this.pension = pen;
    }

    //Get y set del atributo propio
    public String getPension() {
        return pension;
    }

    public void setPension(String pen) {
        this.pension = pen;
    }

    //Cálculo del precio total
    public double getPrecioTotal() {
        double precio;

        if (pension.equals("MP")) { //Si es media pensión
            precio = (precioNoche*numNoches) + 15;
        } else { //Es pensión completa
            precio = (precioNoche*numNoches) + 30;
        }

        return precio;
    }
}