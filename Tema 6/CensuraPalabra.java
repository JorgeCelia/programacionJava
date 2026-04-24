import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


class CensuraPalabra {
    public static void main(String[] args) {
        // El nombre del fichero que vamos a utilizar para leer
        String archivo = "el_quijote.txt";
        // El nombre del fichero que vamos a utilizar para escribir
        String archivoSalida = "el_quijote_censurado.txt";

        // Esta variable contendrá el texto de cada línea del fichero
        String linea = null;

        //Palabra que vamos a censurar
        String palabra;

        Scanner sc = new Scanner(System.in);

        // Usamos try-with-resources para controlar errores
        try {
            //Creamos el lector del fichero
            FileReader lector = new FileReader(archivo);
            //Creamos el escritor del fichero de salida
            FileWriter escritor = new FileWriter(archivoSalida); 

            //Creamos el buffer asociado a ese lector
            BufferedReader buffer = new BufferedReader(lector);
            System.out.print("¿Qué palabra deseas censurar? ");
            palabra = sc.nextLine();

            //Recorremos el fichero leyendo línea a línea
             while((linea = buffer.readLine()) != null) {
                //Comprobamos si la palabra está en la línea que hemos leído
                if (linea.indexOf(palabra)!=-1) {
                    escritor.write(linea.replaceAll(palabra, "*****")+"\n");
                } 
            }
            System.out.println("Fichero censurado con éxito");
            

            //Cierro el buffer y el lector del archivo
            buffer.close();	
            lector.close();
            escritor.close();
            sc.close();
        } catch (IOException e) {
            System.err.println("Error en la lectura del fichero: " + e.getMessage());
        }
    }
}