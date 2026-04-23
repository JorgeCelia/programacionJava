import java.util.Scanner;

public class NotaMedia {
    public static void main(String[] args) {
        //Declaramos las variables
        String asignatura;
        float trim1, trim2, trim3, media;
        
        //Pedimos los datos al usuario
        Scanner lector = new Scanner(System.in);
        System.out.print("Introduzca el nombre de la asignatura: ");
        asignatura = lector.nextLine();
        System.out.print("Introduzca la nota del primer trimestre: ");
        trim1 = lector.nextFloat();
        System.out.print("Introduzca la nota del segundo trimestre: ");
        trim2 = lector.nextFloat();
        System.out.print("Introduzca la nota del tercer trimestre: ");
        trim3 = lector.nextFloat();
        lector.close();

        //Realizo las operaciones
        media=(trim1+trim2+trim3)/3;
        System.out.println("La media que tienes en "+asignatura+" es "+media);
    }
}

    