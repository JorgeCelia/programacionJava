import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Protectora {
    //Colores de letra para sacar la información. RESET vuelve al color normal
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_ROJO = "\u001B[31m";
    public static final String ANSI_VERDE = "\u001B[32m";
    public static final String ANSI_AMARILLO = "\u001B[33m";
    public static final String ANSI_AZUL = "\u001B[34m";
    public static final String ANSI_CIAN = "\u001B[36m";
    public static final String ANSI_BLANCO = "\u001B[37m";
    public static void main(String[] args) {
        //Defino las variables
        int opcion=0;
        ArrayList<Perro> perros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        FileWriter escritor;
        FileReader lector;
        BufferedReader buffer;
        String linea;

        //Añado la información al array
        //perros.add(new Perro("Toby", "Pastor alemán", 10, 35.0));
        //perros.add(new Perro("Sam", "Mestizo", 15, 22.3));
        //perros.add(new Perro("Debby", "Collie", 7, 40.0));
        //perros.add(new Perro("Nyx", "Mestizo", 1, 8.5));

        //Muestro el menú
        do {
            System.out.println("****************************************************");
            System.out.println("*************GESTIÓN DE LA PROTECTORA***************");
            System.out.println("****************************************************");
            System.out.println("1. Escribir información a archivo");
            System.out.println("2. Recuperar información del archivo");
            System.out.println("3. Mostrar la información del array");
            System.out.println("4. Salir");
            System.out.print("Tu opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: //Escribir a fichero
                    try {
                        //Creo el escritor del fichero
                        escritor = new FileWriter("InformacionProtectora.txt");
                        //Recorremos el array con los perros y los escribo en el archivo con el formato adecuado
                        for (Perro p: perros) {
                           escritor.write(p.cadenaFichero()+"\n");
                        }

                        //Cierro el fichero
                        escritor.close();
                        
                        //Muestro mensaje de éxito
                        System.out.println(ANSI_VERDE+"->->->Archivo InformacionProtectora.txt creado con éxito"+ANSI_RESET);

                    } catch (IOException e) {
                        System.out.println("Error al abrir el fichero "+e.getMessage());
                    }
                    break;
            
                case 2: //Leer de fichero
                    try {
                        //Creo las estructuras para leer del archivo
                        lector = new FileReader("InformacionProtectora.txt");
                        buffer = new BufferedReader(lector);

                        //Con cada línea creao un perro nuevo y lo añado al arrayList
                        while((linea = buffer.readLine()) != null) {
                            perros.add(new Perro(linea));
                        }

                        //Muestro mensaje de éxito
                        System.out.println(ANSI_VERDE+"->->->Archivo InformacionProtectora.txt leido con éxito"+ANSI_RESET);

                        //Cierro las estructuras de lectura
                        lector.close();
                        buffer.close();
                    } catch (IOException e) {
                        System.out.println("Error al abrir el fichero "+e.getMessage());
                    }
                    
                    break;

                case 3: //Mostrar array
                    System.out.println("===ANIMALES EN LA PROTECTORA===");

                    //Recorremos el array con los perros
                    for (Perro p: perros) {
                        System.out.println(p.toString()); 
                    }

                    break;

                default:
                    break;
            }

        } while (opcion != 4);

        sc.close();
    }
}