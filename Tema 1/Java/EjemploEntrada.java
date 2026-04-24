import java.util.Scanner;

public class EjemploEntrada {
    public static void main(String[] args) {
        // 1. Crear un objeto Scanner
        Scanner entrada = new Scanner(System.in);
        // 2. Solicitar y leer un nombre (String)
        System.out.println("Introduzca su nombre:");
        String nombre = entrada.nextLine();
        // 3. Solicitar y leer una edad (int)
        System.out.println("Introduzca su edad:");
        int edad = entrada.nextInt();
        // 4. Mostrar los datos introducidos
        System.out.println("Hola, " + nombre + "! Tienes " + edad + " años.");
        // Cerrar el objeto Scanner para liberar recursos
        entrada.close();
    }
}

    