import java.io.FileWriter;
import java.io.IOException;

public class GeneraFichero {
    public static void main(String[] args) {
        int num1, num2;
        try {
            //Estructuras de escritura en fichero
            FileWriter escritor = new FileWriter("datos.txt");

            //Escribimos en fichero
            System.out.println("===Escribiendo datos===");
            for (int i=0; i<100; i++) {
                num1 = (int)(Math.random()*1000+1);
                num2 = (int)(Math.random()*1000+1);

                escritor.write(num1+"/"+num2+"\n");
            }

            //Cierro el escritor
            escritor.close();
            System.out.println("===Fichero datos.txt generado con éxito===");

        } catch (IOException e) {
                System.out.println("Error al abrir el fichero "+e.getMessage());
        }



    }
}