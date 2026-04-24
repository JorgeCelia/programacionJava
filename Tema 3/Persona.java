/*
Clase persona
 */

class Persona {
    //Definición de los atributos
   private String nombre;
   private String apellido;
   private int edad;
   private char sexo;
   private double peso;
   private double altura;

    //Defino los métodos
   public String getNombre() {
      return nombre;
   }
   public void setNombre(String txt) {
      nombre = txt;
   }

   public String getApellido() {
      return apellido;
   }

   public void setApellido(String txt) {
      apellido = txt;
   }

   public int getEdad() {
      return edad;
   }
   public void setEdad(int n) {
      edad = n;
   }

   public String getSexo() {
      String s="";
      if (sexo == 'H') {s = "Hombre";}
      if (sexo == 'M') {s = "Mujer";}
      if ((sexo != 'H') && (sexo != 'M')) s = "Desconocido";
      return s;
   }
   public void setSexo(char s) {
      sexo = s;
   }

   public double getPeso() {
      return peso;
   }
   public void setPeso(double n) {
      peso = n;
   }

   public double getAltura() {
      return altura;
   }
   public void setAltura(double n) {
      altura = n;
   }

   public double calculaIMC() { //Calcula el Indice de masa corporal de la persona
      return peso/(altura*altura);
   }

   public void presentaPersona() { //Muestra los datos de la persona
      System.out.println("*************************************");
      System.out.println(nombre+" "+apellido);
      System.out.println("*************************************");
      System.out.println("Edad: "+edad);
      if (sexo=='H') {
         System.out.println("Sexo: Hombre");
      } else {
         System.out.println("Sexo: Mujer");
      }
      System.out.println("Peso: "+peso);
      System.out.println("Altura: "+altura);
      System.out.printf("IMC: %.2f\n",calculaIMC());
   }

   public boolean mayorEdad() {
      if (edad<18) {return false;}
      else {return true;}
   }

   public void soyMayor(Persona p) {
      if (edad>p.getEdad()) {
         System.out.println("Soy mayor que "+p.getNombre());
      } else {
         System.out.println("Soy menor que "+p.getNombre());
      }
   }
}
