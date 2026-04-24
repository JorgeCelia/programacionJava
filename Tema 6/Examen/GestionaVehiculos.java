import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class GestionaVehiculos {
    public static void main(String[] args) {
        //Variables necesarias para almacenar la información
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        ArrayList <Vehiculo> vehiculos = new ArrayList<>(); //Aquí iré almacenando los vehiculos que vaya leyendo e insertando
        String linea;
        String marca, modelo, tipo;
        double precio;
        int puertas, cilindrada;

        //Leemos la información contenida en el archivo 
        try {
            FileReader lector = new FileReader("vehiculos.txt");
            BufferedReader buffer = new BufferedReader(lector);

            //Leemos el fichero línea a línea
            while((linea = buffer.readLine()) != null) {
                String[] datos = linea.split("#");

                //Según el tipo de vehículo llamo a un constructor o a otro y rellenamos el ArrayList
                if (datos[0].equals("Coche")) { // Es un coche
                    vehiculos.add(new Coche(datos[1], datos[2], Double.parseDouble(datos[3]), Integer.parseInt(datos[4])));
                }

                if (datos[0].equals("Moto")) { // Es una motocicleta
                    vehiculos.add(new Moto(datos[1], datos[2], Double.parseDouble(datos[3]), Integer.parseInt(datos[4])));
                }

                if (datos[0].equals("Bicicleta")) { // Es una bicicleta
                    vehiculos.add(new Bicicleta(datos[1], datos[2], Double.parseDouble(datos[3]), datos[4]));
                }
            }

            //Muestro un mensaje de éxito
            System.out.println("===Fichero vehiculos.txt leido con éxito===");
            //Cerramos las estructuras de lectura
            lector.close();
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error al abrir el fichero "+e.getMessage());
        }


        do {
            //Menú principal
            System.out.println("****************************************");
            System.out.println("********Gestión de Vehículos************");
            System.out.println("****************************************");
            System.out.println("1- Mostrar vehículos");
            System.out.println("2- Introducir nuevo coche");
            System.out.println("3- Introducir nueva moto");
            System.out.println("4- Introducir nueva bicicleta");
            System.out.println("5- Salir y escribir datos");
            System.out.print("Introduce tu opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1: //Mostrar vehículos
                    System.out.println("LISTADO DE VEHÍCULOS");
                    System.out.println("Tipo\t\tMarca\tModelo\tPrecio\tDato Extra");
                    System.out.println("----------------------------------------------------------------");

                    for (Vehiculo v: vehiculos) {
                        if (v instanceof Coche) { // Es un coche
                            System.out.println("Coche\t\t"+v.getMarca()+"\t"+v.getModelo()+"\t"+v.getPrecio()+"€\t"+v.getDatosExtra()+" puertas");
                        } else if (v instanceof Moto) {
                            System.out.println("Moto\t\t"+v.getMarca()+"\t"+v.getModelo()+"\t"+v.getPrecio()+"€\t"+v.getDatosExtra()+"cc");
                        } else if (v instanceof Bicicleta) {
                            System.out.println("Bicicleta\t"+v.getMarca()+"\t"+v.getModelo()+"\t"+v.getPrecio()+"€\t"+v.getDatosExtra());
                        }
                    }
                    break;

                case 2: //Introducir un nuevo coche
                    System.out.println("---Nuevo Coche---");
                    System.out.print("Introduce la marca: ");
                    marca = sc.nextLine();
                    System.out.print("Introduce el modelo: ");
                    modelo = sc.nextLine();
                    System.out.print("Introduce el precio: ");
                    precio = Double.parseDouble(sc.nextLine());
                    System.out.print("Introduce el número de puertas: ");
                    puertas = Integer.parseInt(sc.nextLine());

                    //Lo añadimos a la lista de vehículos
                    vehiculos.add(new Coche(marca, modelo, precio, puertas));
                    System.out.println("->->->Coche añadido con éxito");
                    break;
            
                case 3: //Introducir una nueva moto
                    System.out.println("---Nueva Moto---");
                    System.out.print("Introduce la marca: ");
                    marca = sc.nextLine();
                    System.out.print("Introduce el modelo: ");
                    modelo = sc.nextLine();
                    System.out.print("Introduce el precio: ");
                    precio = Double.parseDouble(sc.nextLine());
                    System.out.print("Introduce la cilindrada: ");
                    cilindrada = Integer.parseInt(sc.nextLine());

                    //Lo añadimos a la lista de vehículos
                    vehiculos.add(new Moto(marca, modelo, precio, cilindrada));
                    System.out.println("->->->Moto añadida con éxito");
                    break;

                case 4: //Introducir una nueva bicicleta
                    System.out.println("---Nueva Bicicleta---");
                    System.out.print("Introduce la marca: ");
                    marca = sc.nextLine();
                    System.out.print("Introduce el modelo: ");
                    modelo = sc.nextLine();
                    System.out.print("Introduce el precio: ");
                    precio = Double.parseDouble(sc.nextLine());
                    System.out.print("Introduce el tipo de bicicleta: ");
                    tipo = sc.nextLine();

                    //Lo añadimos a la lista de vehículos
                    vehiculos.add(new Bicicleta(marca, modelo, precio, tipo));
                    System.out.println("->->->Bicicleta añadida con éxito");
                    break;

                default: //Salir
                    break;
            };

        } while (opcion!=5);
        sc.close();

        //Pasamos a preparar la página web y las estructuras necesarias para escribirla
        try {
            FileWriter escritor = new FileWriter("vehiculos.txt");

            for (Vehiculo v: vehiculos) {
                if (v instanceof Coche) { // Es un coche
                    escritor.write("Coche#"+v.getMarca()+"#"+v.getModelo()+"#"+v.getPrecio()+"#"+v.getDatosExtra()+"\n");
                } else if (v instanceof Moto) {
                    escritor.write("Moto#"+v.getMarca()+"#"+v.getModelo()+"#"+v.getPrecio()+"#"+v.getDatosExtra()+"\n");
                } else if (v instanceof Bicicleta) {
                    escritor.write("Bicicleta#"+v.getMarca()+"#"+v.getModelo()+"#"+v.getPrecio()+"#"+v.getDatosExtra()+"\n");
                }
            }

            //Cierro el escritor
            escritor.close();

            //Muestro un mensaje de éxito
            System.out.println("===Datos escritos con éxito===");
        } catch (IOException e) {
            System.out.println("Error al abrir el fichero "+e.getMessage());
        }
    }
}
