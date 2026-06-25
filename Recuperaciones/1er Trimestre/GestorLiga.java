import java.util.Scanner;

public class GestorLiga {   


    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        //Array que contendrá los jugadores
        Jugador[] jugadores = new Jugador[5];

        //Añado los datos al array
        jugadores[0] = new Jugador("Pedri Gonzalez", "FC Barcelona", 8);
        jugadores[1] = new Jugador("Vinicius Junior", "Real Madrid", 7);
        jugadores[2] = new Portero("Unai Simon", "Athletic Club", 1, 98);
        jugadores[3] = new Jugador("Antoine Girezmann", "Atlético de Madrid", 7);
        jugadores[4] = new Portero("David Raya", "Arsenal", 1, 112);

        //1. Mostrar úncamente los porteros
        System.out.println("*** PORTEROS EN LA LIGA ***");
        System.out.println();
       for (int i=0; i<jugadores.length; i++) {
            if (jugadores[i] instanceof Portero) { //es un portero
                jugadores[i].muestraInfo();
            }
        }

        //2. Trabajo con Strings
        System.out.println();
        System.out.println("*** Búsqueda de jugadores ***");
        System.out.print("Introduzca el nombre y/o apellido a buscar: ");
        String valor = lector.nextLine().toLowerCase();
        System.out.println();

        for (int i=0; i<jugadores.length; i++) {
            if (jugadores[i].getNombre().contains(valor)) { //El nombre contiene el dato introducido
                jugadores[i].muestraInfo();
            }          
        }

        //3. Trabajo con Arrays
        System.out.println();
        System.out.println("*** Apartado de Arrays ***");
        System.out.println();
        int mayorDorsal=jugadores[0].getDorsal(), totalDorsales=0;
        for (int i=0; i<jugadores.length; i++) {
            totalDorsales = totalDorsales + jugadores[i].getDorsal();
            if (jugadores[i].getDorsal()>mayorDorsal) { //Hay un dorsal mayor
                mayorDorsal = jugadores[i].getDorsal();
            }          
        }
        System.out.println("Dorsal más alto: "+mayorDorsal);
        System.out.println("Media de dorsales: "+((double)totalDorsales/jugadores.length));

        //Cerramos el lector de entrada de datos
        lector.close();
    }
}