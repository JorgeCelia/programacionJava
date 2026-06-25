import java.time.LocalDate;

public class ReparacionMovil extends Reparacion {
    private char tipoAveria; //'P' Pantalla, 'B' Batería, 'C' Conectividad

    //Constructor completo
    public ReparacionMovil(String nom, String dni, double prec, LocalDate fecha, int hor, char tipo) {
        super(nom, dni, prec, fecha, hor);
        this.tipoAveria = tipo;
    }

    //Get y set del atributo propio
    public char getTipoAveria() {
        return tipoAveria;
    }

    public void setTipoAveria(char tipoAveria) {
        this.tipoAveria = tipoAveria;
    }

    //Cálculo del precio total
    public double getPrecioTotal() {
        double precio;

        if (tipoAveria=='P') { //Hay que arreglar la pantalla
            precio = precioBase + (horasTrabajo*15) + 40;
        } else if (tipoAveria=='B') { //Hay que arreglar la batería
            precio = precioBase + (horasTrabajo*15) + 25;
        } else { //Hay que arreglar la conectividad
            precio = precioBase + (horasTrabajo*15) + 15;
        }

        return precio;
    }

}