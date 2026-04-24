import java.util.Scanner;

public class pruebaMatriz {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        MatrizEnteros matriz = new MatrizEnteros(5, 4);

        matriz.rellenaMatrizAleatoria(100);
        matriz.insertaValor(5, 3, 3);
        matriz.muestraMatriz();

        System.out.println("El mayor número es: "+matriz.buscaMayor());
        System.out.println("El menor número es: "+matriz.buscaMenor());

        matriz.muestraFila(3);
        matriz.muestraColumna(2);

        lector.close();
    } //Cierro el main
}