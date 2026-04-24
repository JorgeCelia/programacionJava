import java.util.Scanner;
import java.util.ArrayList;

public class ProblemaExamen3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int longitud, islas=0;

        //Pedimos la longitud del ArrayList
        System.out.print("Introduce el tamaño del Array: ");
        longitud = sc.nextInt();

        //Creo el arrayList
        ArrayList lista = new ArrayList();

        //Relleno el ArrayList
        for (int i=0; i<longitud; i++) {
            lista.add((int)(Math.random()*10+1));            
        }

        //Mostramos el array
        System.out.print("Array: ");
        for (int i=0; i<lista.size(); i++) {
            System.out.print(lista.get(i)+" ");
        }
        System.out.println();

        //Buscamos las islas
        for (int i=1; i<lista.size(); i++) {
            if(lista.get(i)==lista.get(i-1)) { //Hay una isla
                islas++;
            }
        }

        //Mostramos los resultados
        System.out.println("**Resultado: Hay "+islas+" islas de números en el array");

        sc.close();
    }
}
