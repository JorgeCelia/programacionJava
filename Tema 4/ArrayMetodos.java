/*
 * Rellenamos un array de 10 enteros con número aleatorios entre 1 y 100
 */
public class ArrayMetodos {
    public static void rellenaArray(int array[]) {
        //Rellena el array con número aleatorios entre 1 y 100
        for (int i=0;i<array.length;i++) {
            array[i] = (int)(Math.random()*100+1);
        }
    }
    
    public static void rellenaArrayMinMax(int array[], int min, int max) {
        //Rellena el array con número aleatorios entre min y max
        for (int i=0;i<array.length;i++) {
            array[i] = (int)(Math.random()*(max-min)+min);
        }
    }
    
    public static boolean estaElemento(int array[], int elemento) {
        //Me dice si un elemento está en un array
        boolean encontrado = false;

        for(int n:array) {
            if(n==elemento) { //He encontrado el elemento
                encontrado = true;
            }
        }
        return encontrado;
    }

    public static int posicionElemento(int array[], int elemento) {
        //Me dice la posición de un elemento en un array (si no está devolvemos -1)
        int posicion=-1;

        for (int i=0;i<array.length;i++) {
            if (array[i]==elemento){ // He encontrado el elemento
                posicion=i;
            }
        }
        return posicion;
    }

    public static int minArray(int array[]) {
        //Me dice cuál es el mínimo número en un array de enteros
        int minimo;
        minimo = array[0];

        for (int n:array) {
            if (n<minimo){ // He encontrado un nuevo minimo
                minimo=n;
            }
        }
        return minimo;
    }

    public static int maxArray(int array[]) {
        //Me dice cuál es el máximo número en un array de enteros
        int maximo;
        maximo = array[0];

        for (int n:array) {
            if (n>maximo){ // He encontrado un nuevo máximo
                maximo=n;
            }
        }
        return maximo;
    }

    public static double calculaMedia(int array[]) {
        //Calcula la media de todos los elementos de un array de enteros
        int suma=0;
        double media;
        for (int n:array) {
            suma=suma+n;
        }
        media = (double)suma/array.length;
        return media;
    }

    public static void main(String[] args) {
        //Declaramos las variables

        //Declaramos el array
        int serie[];

        //Creamos el array
        serie = new int[10];

        //Rellenamos el array con números aleatorios
        rellenaArrayMinMax(serie,1,20);

        //Muestro el array por pantalla
        for(int n:serie) {
            System.out.println(n+" ");
        }

        //Busco un número
        if (posicionElemento(serie, 7)!=-1) {
            System.out.println("El número 7 está en la posición "+posicionElemento(serie, 7));
        } else {
            System.out.println("El número 7 no está en el array");
        }

        //Saco el mínimo y el máximo
        System.out.println("El mínimo en el array es "+minArray(serie));
        System.out.println("El máximo en el array es "+maxArray(serie));

        //Saco su media
        System.out.println("La media del array es "+calculaMedia(serie));

    }
}
    