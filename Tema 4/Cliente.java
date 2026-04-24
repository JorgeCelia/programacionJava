/*
Clase cliente de un gimnasio
 */

class Cliente {
    //Definición de los atributos
   private String nombre;
   private String apellido;
   private String direccion;
   private String municipio;
   private int edad;
   private char sexo;
   private double peso;
   private double altura;
   private String iban;
   private boolean lesiones;

   public Cliente(String nom, String ape, String dir, String mun, int ed, char sex, double pe, double alt, String ib, boolean les) {
      nombre = nom;
      apellido = ape;
      direccion = dir;
      municipio = mun;
      edad = ed;
      sexo = sex;
      peso = pe;
      altura = alt;
      iban = ib;
      lesiones = les;
   }

   //Getter y Setter
   public boolean getLesion() { //Nos dice si está lesionado o no
      return lesiones;
   }

   public int getEdad() { //Nos da la edad
      return edad;
   }

   public String getNombre() { //Nos da el nombre
      return nombre;
   }

   public String getApellido() { //Nos da los apellidos
      return apellido;
   }

   public String getIBAN() { //Nos da el IBAN del cliente
      return iban;
   }

   public String getMunicipio() { //Nos da el municipio
      return municipio;
   }

   public double calculaIMC() { //Calcula el Indice de masa corporal de la persona
      return peso/(altura*altura);
   }

   public void presentaCliente() { //Muestra los datos del cliente
      System.out.println("*************************************");
      System.out.println(nombre+" "+apellido);
      System.out.println("*************************************");
      System.out.println("Edad: "+edad);
      System.out.println("IBAN: "+iban);
      System.out.println("Dirección: "+direccion);
      System.out.println("Municipio: "+municipio);
      if (sexo=='H') {
         System.out.println("Sexo: Hombre");
      } else {
         System.out.println("Sexo: Mujer");
      }
      if (lesiones==true) {
        System.out.println("Está lesionado/a");
      } else {
        System.out.println("No está lesionado/a");
      }
      System.out.println("Peso: "+peso);
      System.out.println("Altura: "+altura);
      System.out.printf("IMC: %.2f\n",calculaIMC());
   }

}
