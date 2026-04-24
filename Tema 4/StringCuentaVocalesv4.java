/*
 * 
 */
import java.util.Scanner;

public class StringCuentaVocalesv4 {

    public static int cuentaVocales(String s) {
        //Nos devuelve el número de vocales del String que le pasemos
        int numVocales=0;
        String cadena2;

        cadena2 = s.toLowerCase();
        //Recorro el String
        for(int i=0; i<cadena2.length(); i++) {
            if (cadena2.charAt(i)=='a' || cadena2.charAt(i)=='e' || cadena2.charAt(i)=='i' || cadena2.charAt(i)=='o' || cadena2.charAt(i)=='u') {
                numVocales++;
            }
        }
        return numVocales;
    }

    public static void main(String[] args) {
        //Declaramos las variables
        String cadena;
        Scanner lector = new Scanner(System.in);

        //Pido la frase al usuario
        System.out.print("Introduce una frase: ");
        cadena = lector.nextLine();

        System.out.println("El número de vocales de la frase "+cadena+" es "+cuentaVocales(cadena));

        lector.close();

    }
}
    