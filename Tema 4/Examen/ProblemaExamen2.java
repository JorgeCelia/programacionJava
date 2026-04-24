import java.util.Scanner;

public class ProblemaExamen2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;
        char letra;
        boolean repetir = true;
        int contador = 0;
        char opcion;

        do {
            contador = 0;
            System.out.print("Introduce una frase: ");
            frase = sc.nextLine().toLowerCase(); //Leo la frase y la paso a minúscula
            System.out.print("Introduce una letra: ");
            letra = sc.nextLine().toLowerCase().charAt(0); //Leo la letra en minúscula

            for (int i=0; i<frase.length(); i++) { //recorro la frase
                if (frase.charAt(i)==letra) { //Encuentro la letra
                    contador++;
                }
            }

            //Saco los resultados
            if (contador>0) {
                System.out.println("**La letra "+letra+" aparece "+contador+" veces en la frase introducida");
            } else {
                System.out.println("**La letra "+letra+" no aparece en la frase introducida");
            }

            //Pido si desea repetir
            System.out.print("¿Desea realizar otra búsquedad (s/n)? ");
            opcion = sc.nextLine().toLowerCase().charAt(0);
            if (opcion=='n') {
                repetir=false;
            }

        } while(repetir==true);
        sc.close();
    }
}
