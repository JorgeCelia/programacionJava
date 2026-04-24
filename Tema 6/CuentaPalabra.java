import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


class CuentaPalabra {
    public static void main(String[] args) {
        // El nombre del fichero que vamos a utilizar
        String archivo = "el_quijote.txt";

        // Esta variable contendrá el texto de cada línea del fichero
        String linea = null;

        //Contador de palabras
        int contador = 0;
        String palabra;

        Scanner sc = new Scanner(System.in);

        // Usamos try-with-resources para controlar errores
        try {
            //Creamos el lector del fichero
            FileReader lector = new FileReader(archivo);

            //Creamos el buffer asociado a ese lector
            BufferedReader buffer = new BufferedReader(lector);
            System.out.print("¿Qué palabra deseas buscar? ");
            palabra = sc.nextLine().toLowerCase();

            //Recorremos el fichero leyendo línea a línea
             while((linea = buffer.readLine()) != null) {
                //Comprobamos si la palabra está en la línea que hemos leído
                if (linea.toLowerCase().indexOf(palabra)!=-1) {
                    contador++;
                } 
            }
            System.out.println("La palabra "+palabra+" aparece "+contador+" veces");
            

            //Cierro el buffer y el lector del archivo
            buffer.close();	
            lector.close();
            sc.close();
        } catch (IOException e) {
            System.err.println("Error en la lectura del fichero: " + e.getMessage());
        }
    }
}