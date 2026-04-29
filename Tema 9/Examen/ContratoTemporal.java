import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoTemporal extends Contrato {
    private LocalDate fechaFin;

    public ContratoTemporal(String empleado, String dni, double salario, LocalDate fechaInicio, LocalDate fechaFin) {
        super(empleado, dni, salario, fechaInicio);
        this.fechaFin = fechaFin;
    }

    /**
     * Calcula el número total de días entre el inicio y el fin del contrato.
     * @return días de duración.
     */
    public long calculaDuracion() {
        return ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}