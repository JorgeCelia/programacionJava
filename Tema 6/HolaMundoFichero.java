import java.io.FileWriter;
import java.io.IOException;

class HolaMundoFileWriter {
 
    public static void main(String[] args) {
        // Usamos try-with-resources para controlar errores
        try {
            FileWriter escritor = new FileWriter("prueba.txt");           
            escritor.write("¡Hola mundo!");
            
            System.out.println("Fichero generado con éxito");

            escritor.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}