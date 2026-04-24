/*
 * 
 */
import java.util.Scanner;

public class StringOperaciones {

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

    public static int cuentaEspacios(String s) {
        //Nos devuelve el número de espacios del String que le pasemos
        int numEspacios=0;

        //Recorro el String
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i)==' ') {
                numEspacios++;
            }
        }
        return numEspacios;
    }

    public static int cuentaPalabras(String s) {
        //Nos devuelve el número de palabras del String que le pasemos
        return cuentaEspacios(s)+1;
    }

    public static int cuentaConsonantes(String s) {
        //Nos devuelve el número de consonantes del String que le pasemos
        return s.length()-(cuentaEspacios(s)+cuentaVocales(s));
    }

    public static void invierteCadena(String s) {
        //Muestra por pantalla la cadena al revés
        for (int i=s.length()-1;i>=0;i--) {
            System.out.print(s.charAt(i));
        }
    }

    public static String invierteCadenav2(String s) {
        //Devuelve un string con la cadena al revés
        String resultado="";
        for (int i=s.length()-1;i>=0;i--) {
            resultado=resultado+s.charAt(i);
        }
        return resultado;
    }

    public static void troceaCadena(String s) {
        //Muestra por las palabras de una cadena por separado
        int ultimoCorte = 0;
        int nuevoCorte = 0;
        for (int i=0;i<s.length();i++) {
            //Busco un espacio
            if (s.charAt(i)==' ') { //He encontrado un espacio
                nuevoCorte=i;
                System.out.println(s.substring(ultimoCorte,nuevoCorte));
                ultimoCorte = i+1; //Actualizo la posición del último corte
            }
            if (i==s.length()-1) { //Ya estamos en el final
                System.out.println(s.substring(ultimoCorte,s.length()));                
            }
//            System.out.println("i="+i+" ultimo corte= "+ultimoCorte+" nuevo corte = "+nuevoCorte);
        }
    }

    public static void main(String[] args) {
        //Declaramos las variables
        String cadena;
        char repetir = 's';
        Scanner lector = new Scanner(System.in);

        do {
            //Pido la frase al usuario
            System.out.print("Introduce una frase: ");
            cadena = lector.nextLine();

            System.out.println("El número de vocales de la frase "+cadena+" es "+cuentaVocales(cadena));
            System.out.println("Tiene "+cuentaEspacios(cadena)+" espacios");
            System.out.println("Tiene "+cuentaPalabras(cadena)+" palabras");
            System.out.println("Tiene "+cuentaConsonantes(cadena)+" consonantes");
            System.out.print("La frase al revés es: "+invierteCadenav2(cadena));
//            invierteCadena(cadena);
            System.out.println();
            troceaCadena(cadena);

            //Pregunto si desea repetir
            System.out.print("¿Desea ejecutar de nuevo?(s/n): ");
            repetir = lector.nextLine().toLowerCase().charAt(0);
        } while(repetir=='s');

        lector.close();
    }
}
    