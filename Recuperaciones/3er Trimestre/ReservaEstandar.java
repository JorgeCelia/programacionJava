import java.time.LocalDate;

public class ReservaEstandar extends Reserva {
    private char tipoHabitacion; //'I' Individual, 'D' Doble, 'S' Suite

    //Constructor completo
    public ReservaEstandar(String nom, String dni, double prec, LocalDate fecha, int num, char hab) {
        super(nom, dni, prec, fecha, num);
        this.tipoHabitacion = hab;
    }

    //Get y set del atributo propio
    public char getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(char hab) {
        this.tipoHabitacion = hab;
    }

    //Cálculo del precio total
    public double getPrecioTotal() {
        return numNoches*precioNoche;
    }
}