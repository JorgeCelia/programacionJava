import java.util.Scanner;

public class ArrayIntroduceDatos {
    public static void main(String[] args) {
        //Declaramos las variables
        Scanner lector = new Scanner(System.in);

        //Declaramos el array
        int serie[];

        //Creamos el array
        serie = new int[10];

        //Rellenamos el array
        for(int i=0;i<serie.length;i++) {
            System.out.print("Introduce el elemento "+i+": ");
            serie[i] = lector.nextInt();
        }

        //Muestro el array por pantalla
        for(int i=0;i<serie.length;i++) {
            System.out.println("Elemento "+i+": "+serie[i]);
        }

        lector.close();
    }
}
    