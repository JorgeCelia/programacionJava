/*
Vamos pidiendo números al usuario y guardándolos en un ArrayList hasta que meta un 0
Una vez lo haga, sacamos el array por pantalla y calculamos la media, el máximo y el mínimo de todos
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListMediaMaxMin {

    public static void main(String[] args) {
        //Declaramos las variables
        ArrayList lista = new ArrayList();
        Scanner lector = new Scanner(System.in);
        int numero, max, min, suma;

        //Vamos pidiendo números al usuario hasta que introduzca un 0
        do {
            System.out.print("Introduce un número (0 para acabar): ");
            numero = lector.nextInt();

            if (numero!=0) {    //Meto los números menos el cero
                lista.add(numero);
            }
        } while(numero!=0);

        //Mostramos el array por pantalla
        System.out.println(lista);

        //Calculamos la media, el máximo y el mínimo del array
        max = (int)lista.get(0);
        min = (int)lista.get(0);
        suma = 0;

        for (int i=1; i<lista.size(); i++) {    //Recorremos el arrayList
            if ((int)lista.get(i)>max) {max = (int)lista.get(i);} //Encuentro un nuevo máximo
            if ((int)lista.get(i)<min) {min = (int)lista.get(i);} //Encuentro un nuevo mínimo
            suma = suma + (int)lista.get(i);
        }
        System.out.println("El máximo en el array es: "+max);
        System.out.println("El mínimo en el array es: "+min);
        System.out.println("La media de los elementos del array es: "+((double)suma/lista.size()));

        lector.close();
    }
}
    