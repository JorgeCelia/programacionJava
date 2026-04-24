import java.util.Scanner;
public class PruebaFiguraGeometrica {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int opcion=0;
        double altura, base, radio;
        Rectangulo rect;
        Circulo circle;

        do {
            System.out.println("****************************************");
            System.out.println("********Figura Geométricas**************");
            System.out.println("****************************************");
            System.out.println("1- Calcular dimensiones del rectángulo");
            System.out.println("2- Calcular dimensiones del círculo");
            System.out.println("3- Salir");
            System.out.print("Introduce tu opción: ");
            opcion = lector.nextInt();

            switch (opcion) {
                case 1: //Rectángulo
                    System.out.print("Introduce la longitud de la base del rectángulo: ");
                    base = lector.nextDouble();
                    System.out.print("Introduce la longitud de la altura del rectángulo: ");
                    altura = lector.nextDouble();
                    rect = new Rectangulo(base, altura);

                    System.out.println("--Resultado--");
                    System.out.printf("El área del rectángulo es %.2f\n",rect.area());
                    System.out.printf("El perímetro del rectángulo es %.2f\n",rect.perimetro());
                    System.out.println("");
                    break;

                case 2: //Círculo
                    System.out.print("Introduce la longitud del radio del círculo: ");
                    radio = lector.nextDouble();
                    circle = new Circulo(radio);
                    
                    System.out.println("--Resultado--");
                    System.out.printf("El área del circulo es %.2f\n",circle.area());
                    System.out.printf("El perímetro del círculo es %.2f\n",circle.perimetro());
                    System.out.println("");
                    break;
            
                default: //Salir
                    break;
            };

        } while (opcion==1 || opcion==2);
        lector.close();
    }
}
