import java.util.Scanner;
public class Batalla {
    public static void main(String[] args) {
        //Inicializamos las variables y los objetos
        Scanner sc = new Scanner(System.in);
        int opcion = 0, valor=0;
        Guerrero g = new Guerrero("Thor",100,15);
        Caballero c = new Caballero("Lancelot",100,10,30);

        System.out.println("==COMIENZA LA BATALLA==");

        do {
            //Mostramos el menú
            System.out.println("==ELIJE UN MOVIMIENTO==");
            System.out.println("1- Guerrero ataca Caballero");
            System.out.println("2- Caballero ataca Guerrero");
            System.out.println("3- Guerrero bebe poción curativa");
            System.out.println("4- Caballero bebe poción curativa");
            System.out.println("5- Caballero arregla armadura");
            System.out.println("6- Salir");
            System.out.print("Tu opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: //Guerrero ataca caballero               
                    System.out.println("---->"+g.getNombre()+" ataca a "+c.getNombre());
                    c.recibeAtaque(g);

                    //Revisamos si el caballero sigue vivo
                    if(c.estaVivo()==false) {
                        System.out.println("El caballero ha sido derrotado");
                        opcion=6; //Nos salimos del programa
                    }
                break;
            
                case 2: //Caballero ataca guerrero
                    System.out.println("---->"+c.getNombre()+" ataca a "+g.getNombre());
                    g.recibeAtaque(c);

                    //Revisamos si el guerrero sigue vivo
                    if(!g.estaVivo()) {
                        System.out.println("El guerrero ha sido derrotado");
                        opcion=6; //Nos salimos del programa
                    }
                    break;

                case 3: //Guerrero bebe poción curativa
                    System.out.print("¿Cuánta vida tiene la poción? ");
                    valor = sc.nextInt();
                    g.bebePocionCurativa(valor);
                    System.out.println(".... Vida añadida al guerrero");
                    break;

                case 4: //Caballero bebe poción curativa
                    System.out.print("¿Cuánta vida tiene la poción? ");
                    valor = sc.nextInt();
                    c.bebePocionCurativa(valor);
                    System.out.println(".... Vida añadida al caballero");
                    break;

                case 5: //Caballero arregla armadura          
                    System.out.print("¿En cuántos puntos mejoramos la armadura? ");
                    valor = sc.nextInt();
                    c.arreglaArmadura(valor);
                    System.out.println(".... Armadura del caballero reparada");
                    break;

                default:
                    break;
            }

        } while (opcion!=6);

        //Muestro los resultados finales
        System.out.println("==FINAL DE LA BATALLA==");
        System.out.println(g.toString());
        System.out.println(c.toString());

        sc.close();
    }
}
