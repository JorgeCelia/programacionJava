/*
 * 
 */
import java.util.Scanner;

public class StringCuentaVocalesv3 {

    public static void main(String[] args) {
        //Declaramos las variables
        String cadena;
        String cadena2;
        int numVocales = 0;
        Scanner lector = new Scanner(System.in);

        //Pido la frase al usuario
        System.out.print("Introduce una frase: ");
        cadena = lector.nextLine();

        cadena2 = cadena.toLowerCase();
        //Recorro el String
        for(int i=0; i<cadena2.length(); i++) {
            if (cadena2.charAt(i)=='a' || cadena2.charAt(i)=='e' || cadena2.charAt(i)=='i' || cadena2.charAt(i)=='o' || cadena2.charAt(i)=='u') {
                numVocales++;
            }
        }

        System.out.println("El número de vocales de la frase "+cadena+" es "+numVocales);

        lector.close();

    }
}
    