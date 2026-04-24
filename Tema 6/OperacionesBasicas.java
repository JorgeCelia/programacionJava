import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class OperacionesBasicas {
 
    public static void main(String[] args) {
        // Usamos try-with-resources para controlar errores
        try {
            Scanner lector = new Scanner(System.in);
            String archivo;
            int num1, num2;

            //Pido los datos
            System.out.print("Introduce el nombre del archivo en el que quieres guardar los resultados: ");
            archivo = lector.nextLine();
            System.out.print("Introduce el primer operando: ");
            num1 = lector.nextInt();
            System.out.print("Introduce el segundo operando: ");
            num2 = lector.nextInt();

            //Creo el archivo en el que voy a escribir
            FileWriter escritor = new FileWriter(archivo);
            escritor.write("Suma: "+(num1+num2)+"\n"); //Suma
            escritor.write("Resta: "+(num1-num2)+"\n"); //Resta
            escritor.write("Multiplicación: "+(num1*num2)+"\n"); //Multiplicación
            escritor.write("División: "+((double)num1/num2)+"\n"); //División
            
            System.out.println("Fichero generado con éxito");

            escritor.close();
            lector.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}