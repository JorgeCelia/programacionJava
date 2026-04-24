class HabitanteTM {
    //Definición de los atributos
   private String nombre;
   private String raza;
   private String region;
   private int edad;
   private boolean inmortal;
   private String dieta;
   private double altura;

   public HabitanteTM(String nom, String raz, String reg, int ed, boolean in, String diet, double alt) {
        nombre =nom;
        raza = raz;
        region = reg;
        edad = ed;
        inmortal = in;
        dieta = diet;
        altura = alt;
   }

    //Defino los métodos
   public String getNombre() {
      return nombre;
   }
   public void setNombre(String txt) {
      nombre = txt;
   }

   public int getEdad() {
      return edad;
   }
   public void setEdad(int n) {
      edad = n;
   }

   public double getAltura() {
      return altura;
   }
   public void setAltura(double n) {
      altura = n;
   }

   public boolean getInmortal() {
    return inmortal;
    }

}
