import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoIndefinido extends Contrato {

    public ContratoIndefinido(String empleado, String dni, double salario, LocalDate fechaInicio) {
        super(empleado, dni, salario, fechaInicio);
    }

    /**
     * Calcula cuántos días han pasado desde el inicio del contrato hasta hoy.
     * @return días transcurridos.
     */
    public long tiempoTrabajado() {
        return ChronoUnit.DAYS.between(fechaInicio, LocalDate.now());
    }
}