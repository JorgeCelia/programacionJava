import java.util.Scanner;

class ProbarPersona {

   public static void main(String[] args) {
      Persona a = new Persona();
      Persona b = new Persona();
      Scanner lector = new Scanner(System.in);

/*      System.out.println("Dime tu nombre: ");
      a.setNombre(lector.nextLine());
      System.out.println("Dime tu apellido: ");
      a.setApellido(lector.nextLine());
      System.out.println("¿Cuantos años tienes? ");
      a.setEdad(lector.nextInt());
      lector.nextLine(); //Limpiamos el Scanner
      System.out.println("¿Cuál es tu sexo?(H/M) ");
      a.setSexo(lector.nextLine().charAt(0));
      System.out.println("¿Cuál es tu peso? ");
      a.setPeso(lector.nextDouble());
      System.out.println("¿Cuál es tu altura? ");
      a.setAltura(lector.nextDouble());*/

      a.setNombre("Miguel");
      a.setApellido("Pérez");
      a.setEdad(23);
      a.setSexo('H');
      a.setPeso(70);
      a.setAltura(1.64);

      b.setNombre("Luisa");
      b.setApellido("García");
      b.setEdad(17);
      b.setSexo('M');
      b.setPeso(65);
      b.setAltura(1.70);


      // Ahora vamos a mostrar por pantalla la información
      // para asegurarnos que todo se ha almacenado correctamente
//      System.out.println("Nombre: " + a.getNombre() + " " +a.getApellido());
//      System.out.println("Edad: " + a.getEdad());
//      System.out.println("Sexo: " + a.getSexo());
//      System.out.println("IMC: " + a.calculaIMC());


      //a.presentaPersona();

      if (b.mayorEdad()==false) {
            System.out.println(b.getNombre()+" es menor de edad");
      } else {
            System.out.println(b.getNombre()+" es mayor de edad");
      }


      if (a.getEdad()>b.getEdad()) {
            System.out.println(a.getNombre()+" es mayor que "+b.getNombre());
      } else {
            System.out.println(b.getNombre()+" es mayor que "+a.getNombre());
      }

      a.soyMayor(b);

      lector.close();
    }
}
