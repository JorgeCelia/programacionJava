/*
 * 
 */
public class StringCuentaVocalesv2 {

    public static void main(String[] args) {
        //Declaramos las variables
        String cadena = "En un lugar de la Mancha";
        String cadena2 = cadena.toLowerCase();
        int numVocales = 0;

        //Recorro el String
        for(int i=0; i<cadena2.length(); i++) {
            if (cadena2.charAt(i)=='a' || cadena2.charAt(i)=='e' || cadena2.charAt(i)=='i' || cadena2.charAt(i)=='o' || cadena2.charAt(i)=='u') {
                numVocales++;
            }
        }

        System.out.println("El número de vocales de la frase "+cadena+" es "+numVocales);

    }
}
    