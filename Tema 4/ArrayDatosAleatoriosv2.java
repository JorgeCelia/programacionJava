/*
 * Rellenamos un array de 10 enteros con número aleatorios entre 1 y 100
 */
public class ArrayDatosAleatoriosv2 {
    public static void main(String[] args) {
        //Declaramos las variables

        //Declaramos el array
        int serie[];

        //Creamos el array
        serie = new int[10];

        //Rellenamos el array con números aleatorios
        for(int i=0;i<serie.length;i++) {
            serie[i] = (int)(Math.random()*100+1);
        }

        //Muestro el array por pantalla
        for(int n:serie) {
            System.out.println(n+" ");
        }
    }
}
    