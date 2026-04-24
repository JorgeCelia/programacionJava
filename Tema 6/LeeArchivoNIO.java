import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Stream;

public class LeeArchivoNIO {
    public static void main(String[] args) {
        // Creamos la ruta del archivo
        Path ruta = Paths.get("el_quijote.txt");

        // Usamos try-with-resources para asegurar que el stream se cierre solo
        try (Stream<String> lineas = Files.lines(ruta)) {
            
            lineas.forEach(System.out::println);
            
        } catch (IOException e) {
            System.err.println("Algo falló al leer: " + e.getMessage());
        }
    }
}