import java.util.Scanner;

public class calculaIVA {
    public static void main(String[] args) {
        //Declaramos las variables
        double precio, iva;
        
        //Pedimos los datos al usuario
        Scanner lector = new Scanner(System.in);
        System.out.print("Introduzca el precio que ha pagado: ");
        precio = lector.nextDouble();
        lector.close();

        //Realizo las operaciones
        iva = precio * 0.21;
        System.out.println("Has pagado "+precio+"€ de los cuales "+iva+"€ son de IVA");
    }
}

    