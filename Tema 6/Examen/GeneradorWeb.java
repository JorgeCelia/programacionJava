import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class GeneradorWeb {
    public static void main(String[] args) {
        //Variables necesarias para almacenar la información
        Scanner lector = new Scanner(System.in);
        int opcion=0;
        String title=""; //Aquí almacenaré el título de la página
        String titulo=""; //Aquí almacenaré el título que saldrá en el cuerpo de la página
        String color=""; //Aquí almacenaré el color de fondo de la página
        ArrayList <String> parrafos = new ArrayList<>(); //Aquí iré almacenando los párrafos de la web

        do {
            //Menú principal
            System.out.println("****************************************");
            System.out.println("***********Generador Web****************");
            System.out.println("****************************************");
            System.out.println("1- Título de la página");
            System.out.println("2- Título del cuerpo de la página");
            System.out.println("3- Color de fondo de la página");
            System.out.println("4- Insertar nuevo párrafo");
            System.out.println("5- Salir y generar la página web");
            System.out.print("Introduce tu opción: ");
            opcion = Integer.parseInt(lector.nextLine());

            switch (opcion) {
                case 1: //Título de la página
                    System.out.print("Introduce el título de la página: ");
                    title = lector.nextLine();
                    break;

                case 2: //Título principal en el body
                    System.out.print("Introduce el título que aparecerá en el cuerpo de la página: ");
                    titulo = lector.nextLine();
                    break;
            
                case 3: //Color de la página
                    System.out.print("Introduce el color de fondo de la página: ");
                    color = lector.nextLine();
                    break;

                case 4: //Inserción de párrafos
                    System.out.print("Introduce el texto del párrafo: ");
                    parrafos.add(lector.nextLine());
                    break;

                default: //Salir
                    break;
            };

        } while (opcion!=5);
        lector.close();

        //Pasamos a preparar la página web y las estructuras necesarias para escribirla
        try {
            FileWriter escritor = new FileWriter("miweb.html");

            //Vamos generando la página web con los campos introducidos
            escritor.write("<html>\n");
            //Cabecera
            escritor.write("<head>\n");
            escritor.write("<title>"+title+"</title>\n");
            escritor.write("</head>\n");

            //Cuerpo de la página
            if (!color.equals("")) { //Ha puesto un color
                escritor.write("<body bgcolor=\""+color+"\">\n");
            } else {
                escritor.write("<body>\n");
            }

            //Título en la página
            escritor.write("<h1 align=\"center\">"+titulo+"</h1>\n");

            //Metemos los párrafos que haya incluido en la página
            for (String parrafo: parrafos) {
                escritor.write("<p>"+parrafo+"</p>\n");
            }

            escritor.write("</body>\n");
            escritor.write("</html>\n");

            //Cierro el escritor
            escritor.close();

            //Muestro un mensaje de éxito
            System.out.println("===Página generada con éxito===");
        } catch (IOException e) {
            System.out.println("Error al abrir el fichero "+e.getMessage());
        }
    }
}
