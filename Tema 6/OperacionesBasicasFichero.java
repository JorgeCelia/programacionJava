import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class OperacionesBasicasFichero {
 
    public static void main(String[] args) {
        // Usamos try-with-resources para controlar errores
        try {
            Scanner sc = new Scanner(System.in);
            String archivo, linea;
            int num1, num2;

            //Creamos el lector del fichero
            FileReader lector = new FileReader("numeros.txt");
            BufferedReader buffer = new BufferedReader(lector);

            //Pido los datos
            System.out.print("Introduce el nombre del archivo en el que quieres guardar los resultados: ");
            archivo = sc.nextLine();

            //Creo el escritor
            FileWriter escritor = new FileWriter(archivo);

            //Recorremos el fichero leyendo línea a línea
             while((linea = buffer.readLine()) != null) {
                //Separamos los elementos de la línea en un array de Strings
                String[] palabras= linea.split(" ");

                //Transformanos esos elementos a entero
                num1 = Integer.parseInt(palabras[0]);
                num2 = Integer.parseInt(palabras[1]);

                //Realizamos la operaciones y vamos construyendo el String de salida
                //Lo escribimos en el fichero
                escritor.write("Operando 1: "+num1+" Operando 2: "+num2+" Suma: "+(num1+num2)+" Resta: "+(num1-num2)+" Multiplicación: "+(num1*num2)+" División: "+((double)num1/num2)+"\n");
            }

            System.out.println("Fichero generado con éxito");

            //Cerramos las estructuras de lectura y escritura
            escritor.close();
            lector.close();
            sc.close();
            buffer.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}