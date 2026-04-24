/*
Para leer un fichero línea a línea en Java de forma eficiente, el "equipo dinámico" suele ser FileReader y BufferedReader.
Aquí está el motivo: FileReader lee el archivo carácter por carácter (lo cual es lento si vas a leer mucho), 
mientras que BufferedReader agrupa esos caracteres en un "búfer" y te permite usar el método .readLine()
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class LeerFichero {
 
    public static void main(String[] args) {
        String nombreFichero = "prueba.txt";

        // Usamos try-with-resources para cerrar ambos flujos automáticamente
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
            
            String linea;
            System.out.println("Contenido del fichero:");
            
            // Leemos línea a línea hasta que se llegue al final (null)
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}