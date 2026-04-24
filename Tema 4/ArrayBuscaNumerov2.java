/*
 * Rellenamos un array de 500 enteros con número aleatorios entre 1 y 10000
 * Pedimos un número al usuario
 * Buscamos si ese número está en el array e indicamos la posición
 * Usamos for-each
 */

import java.util.Scanner;

public class ArrayBuscaNumerov2 {
    public static void main(String[] args) {
        //Declaramos las variables
        int posicion=-1, numero;
        Scanner lector = new Scanner(System.in);
        //Declaramos el array
        int serie[];

        //Creamos el array
        serie = new int[500];

        //Rellenamos el array con números aleatorios entre 1 y 10000
        for(int i=0;i<serie.length;i++) {
            serie[i] = (int)(Math.random()*10000+1);
        }

        //Preguntamos un número al usuario
        System.out.print("Introduce el número que buscas (entre 1 y 10000): ");
        numero = lector.nextInt();

        int contador=0;

        //Buscamos el número en el array
        for(int n: serie) {
            if (numero==n) { //He encontrado el número
                posicion = contador;
                System.out.println("El número "+numero+" está en la posición "+contador);
            }
            contador++;
        }

        //Mostramos los resultados
        if(posicion==-1) { //No se ha encontrado
            System.out.println("El número "+numero+" no está en el array");
        }

        lector.close();
    }
}
    