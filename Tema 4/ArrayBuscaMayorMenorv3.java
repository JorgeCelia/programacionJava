/*
 * Rellenamos un array de 10 enteros con número aleatorios entre 1 y 100
 * Buscamos el menor y el mayor de los números que hay en el array
 * Usamos For-Each
 */
public class ArrayBuscaMayorMenorv3 {
    public static void main(String[] args) {
        //Declaramos las variables
        int minimo, maximo;

        //Declaramos el array
        int serie[];

        //Creamos el array
        serie = new int[10];

        //Rellenamos el array con números aleatorios
        for(int i=0;i<serie.length;i++) {
            serie[i] = (int)(Math.random()*100+1);
        }

        //Inicializo el máximo y el mínimo al primer elemento del array
        minimo = serie[0];
        maximo = serie[0];
        //Recorro el array
        for(int y : serie) {
            if(y<minimo) { //He encontrado un nuevo minimo
                minimo = y;
            }
            if(y>maximo) { //He encontrado un nuevo máximo
                maximo = y;
            }
        }

        //Mostramos los resultados
        System.out.println("El máximo es :"+maximo);
        System.out.println("El mínimo es :"+minimo);
    }
}
    