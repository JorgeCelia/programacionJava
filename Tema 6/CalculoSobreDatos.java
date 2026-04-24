import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalculoSobreDatos {
    public static void main(String[] args) {
        try {
            //Creo las estructuras de lectura y los arrays
            FileReader lector = new FileReader("datos.txt");
            BufferedReader buffer = new BufferedReader(lector);
            int[] operandos1 = new int[100];
            int[] operandos2 = new int[100];
            String linea;
            int contador = 0;

            System.out.println("===Leyendo datos===");
            //Leo el fichero línea a línea
            while((linea = buffer.readLine()) != null) {
                //Parto la línea por el caracter "/"
                String [] operandos = linea.split("/");

                //Relleno los arrays
                operandos1[contador] = Integer.parseInt(operandos[0]);
                operandos2[contador] = Integer.parseInt(operandos[1]);
                contador++;
            }

            int suma1=0, suma2=0;

            //Realizar los cálculos
            for (int i=0; i<100; i++) {
                suma1 = suma1 + operandos1[i]; 
                suma2 = suma2 + operandos2[i]; 
            }

            //Muestro los resultados
            System.out.println("*******************************************");
            System.out.println("*****RESULTADOS DE LAS OPERACIONES******");
            System.out.println("*******************************************");
            System.out.println("Suma de los primeros operandos: "+suma1);
            System.out.println("Media de los segundos operandos: "+(double)suma2/100);

            //Cierro el lector
            buffer.close();
            lector.close();

        } catch (IOException e) {
                System.out.println("Error al abrir el fichero "+e.getMessage());
        }
    }
}