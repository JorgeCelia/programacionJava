/*
 * Rellenamos un array de 10 enteros con número aleatorios entre 1 y 100
 * Calculamos la suma de los elementos del array
 * Calculamos la media de los elementos del array
 */
public class ArrayOperaciones {
    public static void main(String[] args) {
        //Declaramos las variables
        int suma=0;
        double media=0;
        //Declaramos el array
        int serie[];

        //Creamos el array
        serie = new int[10];

        //Rellenamos el array con números aleatorios
        for(int i=0;i<serie.length;i++) {
            serie[i] = (int)(Math.random()*100+1);
        }

        //Sumo los elementos del array
        for(int i=0; i<serie.length; i++) {
            suma = suma + serie[i];
        }

        //Calculo su media
        media = (double)suma/serie.length;

        //Mostramos los resultados
        System.out.println("La suma de los elementos es :"+suma);
        System.out.printf("La media de los elementos es %.2f\n",media);
    }
}
    