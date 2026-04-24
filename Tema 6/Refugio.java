import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Refugio {
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
        Scanner lector = new Scanner(System.in);
        FileReader archivo;
        BufferedReader buffer;
        String linea;
        ArrayList<Animal> animales = new ArrayList<>();

        String nombre, raza, dato;
        int edad;
        boolean caza;
        int contador=0;

        //Leemos el fichero con los datos del refugio
        try {
            //Creo las estructuras para leer del archivo
            archivo = new FileReader("refugio.txt");
            buffer = new BufferedReader(archivo);

            //Voy leyendo línea a línea del archivo
            while((linea = buffer.readLine()) != null) {
                String [] datos = linea.split(";");

                if (datos[0].equals("perro")) { //Es un perro
                    animales.add(new Perro2(datos[1], Integer.parseInt(datos[2]), datos[3]));
                }

                if (datos[0].equals("gato")) { //Es un gato
                    animales.add(new Gato(datos[1], Integer.parseInt(datos[2]), Boolean.parseBoolean(datos[3])));
                }
            }
 
            //Cierro las estructuras de lectura
            archivo.close();
            buffer.close();

            System.out.println(ANSI_CIAN+"===Archivo refugio.txt recuperado con éxito==="+ANSI_RESET);
            System.out.println(ANSI_CIAN+"Hemos recuperado los datos de "+animales.size()+" animales"+ANSI_RESET);
        } catch (IOException e) {
            System.out.println(ANSI_ROJO+"Error al abrir el fichero "+e.getMessage()+ANSI_RESET);
        }

        do {
            System.out.println(ANSI_VERDE+"*******************************************"+ANSI_RESET);
            System.out.println(ANSI_VERDE+"*******REFUGIO DE ANIMALES******************"+ANSI_RESET);
            System.out.println(ANSI_VERDE+"*******************************************"+ANSI_RESET);
            System.out.println("1. Insertar nuevo perro");
            System.out.println("2. Insertar nuevo gato");
            System.out.println("3. Búsqueda de animal por edad");
            System.out.println("4. Insertar de animal por nombre");
            System.out.println("5. Salir");
            System.out.print("Tu opción: ");
            opcion = Integer.parseInt(lector.nextLine());

            switch (opcion) {
                case 1: //Inserción de un nuevo perro
                    //Pedimos los datos que necesitamos
                    System.out.print("Introduce el nombre del perro: ");
                    nombre = lector.nextLine();
                    System.out.print("Introduce la edad del perro: ");
                    edad = Integer.parseInt(lector.nextLine());
                    System.out.print("Introduce la raza del perro: ");
                    raza = lector.nextLine();

                    //Lo insertamos en el arrayList
                    animales.add(new Perro2(nombre, edad, raza));
                    System.out.println(ANSI_AMARILLO+"===Datos del perro insertados con éxito==="+ANSI_RESET);
                    
                    break;
            
                case 2: //Inserción de un nuevo gato
                    //Pedimos los datos que necesitamos
                    System.out.print("Introduce el nombre del gato: ");
                    nombre = lector.nextLine();
                    System.out.print("Introduce la edad del gato: ");
                    edad = Integer.parseInt(lector.nextLine());
                    System.out.print("Introduce si es cazador o no (s/n): ");
                    dato = lector.nextLine();
                    if (dato.equalsIgnoreCase("s")) {caza=true;}
                    else {caza=false;}

                    //Lo insertamos en el arrayList
                    animales.add(new Gato(nombre, edad, caza));
                    System.out.println(ANSI_AMARILLO+"===Datos del gato insertados con éxito==="+ANSI_RESET);
                    
                    break;

                case 3: //Búsqueda de animales por edad
                    //Pedimos los datos que necesitamos
                    System.out.print("Introduce la edad del animal: ");
                    edad = Integer.parseInt(lector.nextLine());
                    contador = 0;

                    for (Animal a:animales) {
                        if (a.getEdad()==edad) { //Hemos encontrado un animal con esa edad
                            a.muestraInfo();
                            contador++;
                        }
                    }

                    if (contador==0) { //No hay ningún animal de esa edad
                        System.out.println(ANSI_ROJO+"===No hay ningún animal con esa edad==="+ANSI_RESET);
                    }
                    
                    break;

                case 4: //Búsqueda de animales por nombre
                    //Pedimos los datos que necesitamos
                    System.out.print("Introduce el nombre del animal: ");
                    nombre = lector.nextLine();
                    contador = 0;

                    for (Animal a:animales) {
                        if (a.getNombre().toLowerCase().equals(nombre.toLowerCase())) { //Hemos encontrado un animal con ese nombre
                            a.muestraInfo();
                            contador++;
                        }
                    }

                    if (contador==0) { //No hay ningún animal de ese nombre
                        System.out.println(ANSI_ROJO+"===No hay ningún animal con ese nombre==="+ANSI_RESET);
                    }
                    
                    break;

                default:
                    break;
            }

        } while (opcion!=5);

        //Escribimos el arrayList en el fichero
        try {
            //Creo las estructuras para leer del archivo
            FileWriter escritor = new FileWriter("refugio.txt");

            for (Animal a:animales) {
                escritor.write(a.generaDatos());
            }
 
            //Cierro las estructuras de escritura
            escritor.close();

            System.out.println(ANSI_CIAN+"===Archivo refugio.txt guardado con éxito==="+ANSI_RESET);
            System.out.println(ANSI_CIAN+"Hemos guardado los datos de "+animales.size()+" animales"+ANSI_RESET);
        } catch (IOException e) {
            System.out.println(ANSI_ROJO+"Error al abrir el fichero "+e.getMessage()+ANSI_RESET);
        }

        lector.close();
    }
}
