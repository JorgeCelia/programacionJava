import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class LeerArchivo {
    public static void main(String[] args) {
        // El nombre del fichero que vamos a utilizar
        String archivo = "el_quijote.txt";

        // Esta variable contendrá el texto de cada línea del fichero
        String linea = null;

        // Usamos try-with-resources para controlar errores
        try {
            //Creamos el lector del fichero
            FileReader lector = new FileReader(archivo);

            //Creamos el buffer asociado a ese lector
            BufferedReader buffer = new BufferedReader(lector);

            //Recorremos el fichero leyendo línea a línea
            /*
             while((linea = buffer.readLine()) != null) {
                // Mostramos el contenido del fichero en pantalla
                System.out.println(linea);
            }	
            */
            linea = buffer.readLine();
            while(linea != null) {
                // Mostramos el contenido del fichero en pantalla
                System.out.println(linea);
            
                linea = buffer.readLine();
            }	

            //Cierro el buffer y el lector del archivo
            buffer.close();	
            lector.close();
        } catch (IOException e) {
            System.err.println("Error en la lectura del fichero: " + e.getMessage());
        }
    }
}