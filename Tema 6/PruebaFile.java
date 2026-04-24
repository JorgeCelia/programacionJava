import java.io.File;
import java.util.Scanner;

public class PruebaFile {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String nombre;
            // Pedimos el archivo o carpeta que queremos buscar
            System.out.print("Introduce el nombre del archivo o carpeta: ");
            nombre = sc.nextLine();
        
            File f = new File(nombre);

            System.out.println("***Elemento buscado: "+f.getAbsolutePath());

            if (f.isDirectory()) { //Es una carpeta
                System.out.println("Es una carpeta");
            } else {
                if (f.isFile()) { //Es una archivo
                    System.out.println("Es un archivo");
                    if (f.exists()) { //El archivo existe
                        if (f.canRead()) {
                            System.out.println("El archivo "+nombre+" tiene permisos de lectura");
                        }
                        else
                        {
                            System.out.println("El archivo "+nombre+" no tiene permisos de lectura");
                        }

                        if (f.canWrite()) {
                            System.out.println("El archivo "+nombre+" tiene permisos de escritura");
                        }
                        else
                        {
                            System.out.println("El archivo "+nombre+" no tiene permisos de escritura");
                        }
                    }
                } else {
                    System.out.println("No existe ese archivo o carpeta");                    
                }
            }
            sc.close();
        }
}