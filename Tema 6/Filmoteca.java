import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Filmoteca {
    //Colores de letra para sacar la información. RESET vuelve al color normal
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_ROJO = "\u001B[31m";
    public static final String ANSI_VERDE = "\u001B[32m";
    public static final String ANSI_AMARILLO = "\u001B[33m";
    public static final String ANSI_AZUL = "\u001B[34m";
    public static final String ANSI_CIAN = "\u001B[36m";
    public static final String ANSI_BLANCO = "\u001B[37m";
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        FileReader archivo;
        BufferedReader buffer;
        String linea;
        ArrayList<Pelicula> peliculas = new ArrayList<>();
       
        //Leo el archivo de películas
        try {
            //Creo las estructuras para leer del archivo
            archivo = new FileReader("filmoteca.txt");
            buffer = new BufferedReader(archivo);

            //Voy leyendo línea a línea del archivo
            while((linea = buffer.readLine()) != null) {
                peliculas.add(new Pelicula(linea)); //Con cada línea crea un objeto película
            }
 
            //Cierro las estructuras de lectura
            archivo.close();
            buffer.close();

            System.out.println(ANSI_CIAN+"===Archivo filmoteca.txt recuperado con éxito==="+ANSI_RESET);
            System.out.println(ANSI_CIAN+"Hemos recuperado "+peliculas.size()+" peliculas"+ANSI_RESET);
        } catch (IOException e) {
            System.out.println(ANSI_ROJO+"Error al abrir el fichero "+e.getMessage()+ANSI_RESET);
        }


        //Muestro el listado de las películas de un director
        String valor;
        int contador=0, menu=0;
        String director, titulo, genero, nacionalidad;
        int duracion, year;

        do {
            System.out.println(ANSI_VERDE+"*******************************************"+ANSI_RESET);
            System.out.println(ANSI_VERDE+"*******FILMOTECA DEL CELIA VIÑAS***********"+ANSI_RESET);
            System.out.println(ANSI_VERDE+"*******************************************"+ANSI_RESET);
            System.out.println("1. Búsqueda por director");
            System.out.println("2. Listado de comedias españolas posteriores a 2010");
            System.out.println("3. Búsqueda de películas por nacionalidad");
            System.out.println("4. Insertar nueva película");
            System.out.println("5. Salir");
            System.out.print("Tu opción: ");
            menu = lector.nextInt();

            switch (menu) {
                case 1: //Búsqueda por director
                        lector.nextLine(); //Limpiamos el buffer
                        System.out.print("Introduce un director: ");
                        valor = lector.nextLine();
                        System.out.println("-------------------------------------------------");
                        System.out.println("-----------Películas de "+valor+"----------------");
                        System.out.println("-------------------------------------------------");

                        for(Pelicula p:peliculas) {
                            if(p.getDirector().compareTo(valor)==0) { //Encuentra una pelicula del director
                                System.out.println(p.getTitulo());
                                contador++;
                            }
                        }
                        if(contador==0) { //No hay ninguna película de ese director
                            System.out.println("No tenemos películas de "+valor+" en el catálogo");
                        }
                        System.out.println("+++++++++++++++++++++++++++++++++++++");
                    break;
            
                case 2: //Listado de comedias españolas posteriores a 2010
                        System.out.println("-------------------------------------------------");
                        System.out.println("----Comedias españolas posteriores a 2010--------");
                        System.out.println("-------------------------------------------------");

                        //Título de las comedias españolas posteriores a 2010
                        for(Pelicula p:peliculas) {
                            if(p.getNacionalidad().equals("España") && p.getGenero().equals("Comedia") && p.getYear()>2010) {
                                System.out.println(p.getTitulo());
                            }
                        }
                        System.out.println("+++++++++++++++++++++++++++++++++++++");
                    break;

                case 3: //Búsqueda de películas por nacionalidad
                        //Sacamos el título y el año de las películas del país elegido en el menú
                        int opcion = 0;
                        System.out.println(ANSI_AZUL+"Elige un país: "+ANSI_RESET);
                        System.out.println("1- España");
                        System.out.println("2- EE.UU.");
                        System.out.println("3- Japón");
                        System.out.println("4- Nueva Zelanda");
                        System.out.println("5- Reino Unido");
                        System.out.print("Tu opción: ");
                        opcion = lector.nextInt();

                        String pais="";

                        switch (opcion) {
                            case 1:
                                pais = "España";
                            break;
                            case 2:
                                pais = "EE.UU.";
                            break;
                            case 3:
                                pais = "Japón";
                            break;
                            case 4:
                                pais = "Nueva Zelanda";
                            break;
                            case 5:
                                pais = "Reino Unido";
                            break;                                    
                            default:
                            break;
                        }

                        System.out.println("-------------------------------------------------");
                        System.out.println("-----------Películas de "+pais+"-----------------");
                        System.out.println("-------------------------------------------------");
                        for(Pelicula p:peliculas) {
                            if(p.getNacionalidad().equals(pais)) {
                                System.out.println(p.getTitulo()+" "+p.getYear());
                            }
                        }
                    break;

                case 4: //Insertar nueva película
                        lector.nextLine();
                        System.out.println("-------------------------------------------------");
                        System.out.println("-----Introducción de una nueva película----------");
                        System.out.println("-------------------------------------------------");
                        System.out.print("Título: ");
                        titulo=lector.nextLine();
                        System.out.print("Director: ");
                        director=lector.nextLine();
                        System.out.print("Género: ");
                        genero=lector.nextLine();
                        System.out.print("Duración (en minutos): ");
                        duracion=Integer.parseInt(lector.nextLine());
                        System.out.print("Nacionalidad: ");
                        nacionalidad=lector.nextLine();
                        System.out.print("Año de producción: ");
                        year=Integer.parseInt(lector.nextLine());

                        //Añadimos el nuevo objeto con los datos instroducidos al array
                        peliculas.add(new Pelicula(titulo, director, genero, duracion, nacionalidad, year));

                        System.out.println(ANSI_AZUL+"Película insertada correctamente"+ANSI_RESET);
                    break;

                default:
                    break;
            }

        } while(menu!=5);

        lector.close();

        //Creo las estructuras de escritura en el fichero
        try {
            FileWriter escritor = new FileWriter("filmoteca.txt");

            //Escribimos las películas en el fichero con el formato dado
            for (Pelicula p: peliculas) {
                escritor.write(p.cadenaFichero()+"\n");
            }

            //Cierro el escrito
            escritor.close();

            System.out.println(ANSI_CIAN+"===Archivo filmoteca.txt creado con éxito==="+ANSI_RESET);
            System.out.println(ANSI_CIAN+"Hemos guardado "+peliculas.size()+" peliculas"+ANSI_RESET);
        } catch (IOException e) {
            System.out.println(ANSI_ROJO+"Error al abrir el fichero "+e.getMessage()+ANSI_RESET);
        }


    } //Cierro el main
}