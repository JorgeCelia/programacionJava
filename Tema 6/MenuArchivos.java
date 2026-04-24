import java.io.File;
import java.util.Scanner;

public class MenuArchivos {
    //Colores de letra para sacar la información. RESET vuelve al color normal
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_ROJO = "\u001B[31m";
    public static final String ANSI_VERDE = "\u001B[32m";
    public static final String ANSI_AMARILLO = "\u001B[33m";
    public static final String ANSI_AZUL = "\u001B[34m";
    public static final String ANSI_CIAN = "\u001B[36m";
    public static final String ANSI_BLANCO = "\u001B[37m";

    public static void muestraInfo(File f) {
        //Muestra la información de un archivo con el formato que hemos diseñado en clase
        System.out.print(ANSI_AZUL+f.getName()+ANSI_RESET+"\t");

        //Compruebo el permiso de lectura
        if(f.canRead()) { //El archivo tiene permisos de lectura
            System.out.print(ANSI_VERDE+"r"+ANSI_RESET);
        } else { //El archivo no tiene permisos de lectura
            System.out.print(ANSI_ROJO+"r"+ANSI_RESET);
        }

        //Compruebo el permiso de escritura
        if(f.canWrite()) { //El archivo tiene permisos de escritura
            System.out.print(ANSI_VERDE+"w"+ANSI_RESET);
        } else { //El archivo no tiene permisos de escritura
            System.out.print(ANSI_ROJO+"w"+ANSI_RESET);
        }

        //Compruebo el permiso de ejecución
        if(f.canExecute()) { //El archivo tiene permisos de ejecución
            System.out.print(ANSI_VERDE+"x"+ANSI_RESET);
        } else { //El archivo no tiene permisos de lectura
            System.out.print(ANSI_ROJO+"x"+ANSI_RESET);
        }

        System.out.print(" "+f.length()+"B");

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre;
        File f, arch;
        int opcion;

        //Menú para el usuario
        do {
            System.out.println("**********TRABAJO CON ARCHIVOS*************");
            System.out.println("1. Listar carpeta");
            System.out.println("2. Borrar archivo");
            System.out.println("3. Buscar archivo");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: //Elige listar carpeta
                    f = new File("."); //Creamos un objeto File apuntando a la carpeta actual
                    System.out.println("****Listado de la carpeta: "+f.getAbsolutePath()+"*****");

                    for (String s: f.list()) {
                        arch = new File(s);
                        if (arch.isDirectory()) //Es una carpeta
                        {
                            System.out.println(ANSI_AMARILLO+s+ANSI_RESET);
                        }

                        if (arch.isFile()) //Es un archivo
                        {
                            muestraInfo(arch);
                        }
                    }
                    
                    break;
            
                case 2: //Elige borrar archivo
                    sc.nextLine(); //Limpiamos el scanner
                    System.out.print("¿Qué archivo deseas borrar? ");
                    nombre = sc.nextLine();

                    //Creo un archivo con el nombre dado
                    arch = new File(nombre);

                    //Compruebo si existe. Si existe lo borro, si no muestro un error
                    if (arch.exists()) {
                        arch.delete();
                        System.out.println(ANSI_VERDE+"El archivo "+nombre+" borrado correctamente"+ANSI_RESET);
                    } else {
                        System.out.println(ANSI_ROJO+"El archivo "+nombre+" no se ha podido borrar"+ANSI_RESET);
                    }
                    break;

                case 3: //Elige buscar archivo
                    sc.nextLine(); //Limpiamos el scanner
                    System.out.print("¿Qué archivo deseas buscar? ");
                    nombre = sc.nextLine();

                    //Creo un archivo con el nombre dado
                    arch = new File(nombre);

                    //Compruebo si existe. Si existe muestro su información. Si no, muestro un error
                    if (arch.exists()) {
                        muestraInfo(arch);
                    } else {
                        System.out.println(ANSI_ROJO+"El archivo "+nombre+" no existe"+ANSI_RESET);
                    }
                    break;

                default:
                    break;
            }

        } while(opcion!=4);

        sc.close();
    }
}