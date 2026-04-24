/*
 * 
 */
public class StringCuentaVocales {

    public static void main(String[] args) {
        //Declaramos las variables
        String cadena = "En un lugar de la Mancha";
        int numVocales = 0;

        //Recorro el String
        for(int i=0; i<cadena.length(); i++) {
            if (cadena.charAt(i)=='a' || cadena.charAt(i)=='e' || cadena.charAt(i)=='i' || cadena.charAt(i)=='o' || cadena.charAt(i)=='u' || cadena.charAt(i)=='A' || cadena.charAt(i)=='E' || cadena.charAt(i)=='I' || cadena.charAt(i)=='O' || cadena.charAt(i)=='U') {
                numVocales++;
            }
        }

        System.out.println("El número de vocales de la frase "+cadena+" es "+numVocales);

    }
}
    