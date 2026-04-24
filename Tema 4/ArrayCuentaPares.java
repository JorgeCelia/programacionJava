/*
 * Rellenamos un array de 500 enteros con número aleatorios entre 1 y 10000
 * Contamos la cantidad de números pares que hay
 */
public class ArrayCuentaPares {
    public static void main(String[] args) {
        //Declaramos las variables
        int totalPares=0;
        //Declaramos el array
        int serie[];

        //Creamos el array
        serie = new int[500];

        //Rellenamos el array con números aleatorios entre 1 y 10000
        for(int i=0;i<serie.length;i++) {
            serie[i] = (int)(Math.random()*10000+1);
        }

        //Sumo los elementos del array
        for(int i=0; i<serie.length; i++) {
            if (serie[i]%2==0) { //El elemento es un número par
                totalPares++;
            }
        }

        //Mostramos los resultados
        System.out.println("El total de números pares es :"+totalPares);
    }
}
    