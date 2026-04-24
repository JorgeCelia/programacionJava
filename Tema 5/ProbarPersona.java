class ProbarPersona {

   public static void main(String[] args) {
      Persona a = new Persona("Sonia",56);
      Empleado b = new Empleado("Juan", 23, 1200);

      b.setEdad(34);

      a.muestraDatos();
      b.muestraDatos();
   }
}
