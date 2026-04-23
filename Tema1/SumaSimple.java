import java.util.Scanner;

public class SumaSimple {
    public static void main(String[] args) {
        //Declaramos las variables
        int num1, num2, suma;
        
        //Pedimos los datos al usuario
        Scanner lector = new Scanner(System.in);
        System.out.print("Introduzca el primer número: ");
        num1 = lector.nextInt();
        System.out.print("Introduzca el segundo número: ");
        num2 = lector.nextInt();
        lector.close();

        //Realizo las operaciones
        suma=num1+num2;
        System.out.println("La suma de los dos números es: "+suma);
    }
}

    