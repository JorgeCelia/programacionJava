import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Codificador {

    final static String abecedario = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
 
    public static char devuelveLetraCodificada(char letra, int codigo) {
        int nuevaPosicion;

        //Busco la posición de la letra
        int posicion = abecedario.indexOf(letra);

        //Calculo la posición de la letra codificada
        if ((posicion+codigo)<abecedario.length()) { //Si no hay que dar la vuelta al abecedario
            nuevaPosicion = posicion+codigo;
        } else {
            nuevaPosicion = (posicion+codigo)-abecedario.length();
        }

        return abecedario.charAt(nuevaPosicion);
    }

    public static char devuelveLetraDecodificada(char letra, int codigo) {
        int nuevaPosicion;

        //Busco la posición de la letra
        int posicion = abecedario.indexOf(letra);

        //Calculo la posición de la letra decodificada
        if ((posicion-codigo)>=0) { //Si no hay que dar la vuelta al abecedario
            nuevaPosicion = posicion-codigo;
        } else {
            nuevaPosicion = abecedario.length()-(posicion-codigo);
        }

        return abecedario.charAt(nuevaPosicion);
    }

    public static void main(String[] args) {
        int codigo;
        int opcion = 0;
        FileReader lector;
        FileWriter escritor;
        BufferedReader buffer;
        Scanner sc = new Scanner(System.in);
        String salida, linea;

        // Usamos try-with-resources para controlar errores
        try {

            while (opcion!=3) { //Menú que se repite con las opciones
                System.out.println("**************************************************");
                System.out.println("*******CODIFICACIÓN Y DECODIFCACIÓN DE TEXTO******");
                System.out.println("**************************************************");
                System.out.println("Elije una opción:");
                System.out.println("1. Codificar un archivo");
                System.out.println("2. Decodificar un archivo");
                System.out.println("3. Salir");
                System.out.print("Tu opción: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1: //Elige codificar
                        //Pedimos los datos al usuario
                        System.out.print("Introduce el código de codificación: ");
                        codigo = sc.nextInt();

                        //Creamos el lector del fichero
                        lector = new FileReader("original.txt");
                        buffer = new BufferedReader(lector);

                        //Creo el escritor
                        escritor = new FileWriter("codificado.txt");

                        //Recorremos el fichero leyendo línea a línea
                        while((linea = buffer.readLine()) != null) {
                            salida = "";
                            //Recorro cada caracter de la línea
                            for (int i=0; i<linea.length(); i++) { //Transformo caracter a caracter de la línea leída
                                //Lo añado a la línea de salida
                                if(linea.charAt(i)!=' ') { //Si no es un espacio, transformo la letra
                                    salida = salida + devuelveLetraCodificada(linea.charAt(i), codigo);
                                } else { //Si es un espacio lo escribo
                                    salida = salida + ' ';
                                }
                            }
                            //Escribo la línea de salida
                            escritor.write(salida+"\n");
                        }

                        System.out.println("Fichero codificado.txt generado con éxito");
                        
                        //Cerramos las estructuras de lectura y escritura
                        escritor.close();
                        lector.close();
                        buffer.close();
                        break;
                
                    case 2: //Elige decodificar
                        //Pedimos los datos al usuario
                        System.out.print("Introduce el código de decodificación: ");
                        codigo = sc.nextInt();

                        //Creamos el lector del fichero
                        lector = new FileReader("codificado.txt");
                        buffer = new BufferedReader(lector);

                        //Creo el escritor
                        escritor = new FileWriter("decodificado.txt");

                        //Recorremos el fichero leyendo línea a línea
                        while((linea = buffer.readLine()) != null) {
                            salida = "";
                            //Recorro cada caracter de la línea
                            for (int i=0; i<linea.length(); i++) { //Transformo caracter a caracter de la línea leída
                                //Lo añado a la línea de salida
                                if(linea.charAt(i)!=' ') { //Si no es un espacio, transformo la letra
                                    salida = salida + devuelveLetraDecodificada(linea.charAt(i), codigo);
                                } else { //Si es un espacio lo escribo
                                    salida = salida + ' ';
                                }
                            }
                            //Escribo la línea de salida
                            escritor.write(salida+"\n");
                        }

                        System.out.println("Fichero decodificado.txt generado con éxito");
                        
                        //Cerramos las estructuras de lectura y escritura
                        escritor.close();
                        lector.close();
                        buffer.close();
                        
                        break;

                    default:
                        break;
                }

            }

            sc.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}