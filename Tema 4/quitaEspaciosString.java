import java.util.Scanner;

public class quitaEspaciosString {
    public static void main(String[] args) {
        //Definimos las variables que vamos a utilizar
        String cadena;

        //Pedimos los datos al usuario
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        cadena = sc.nextLine().toUpperCase(); //Lo paso a mayúscula

        for (int i=0; i<cadena.length(); i++) {
            if(cadena.charAt(i)!=' ') { //Sólo muestro los caracteres que no sean el espacio en blanco
                System.out.print(cadena.charAt(i));
            }
        }
        System.out.println();
        sc.close();
    }
}
