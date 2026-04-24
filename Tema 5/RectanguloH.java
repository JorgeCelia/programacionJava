public class RectanguloH extends FiguraGeometricaH {
   private double base, altura;
   private String color;
   public RectanguloH (double b, double h){
      base = b;
      altura = h;
   }
   public double area() {
      return base*altura;
   }
   public double perimetro() {
      return 2*(base+altura);
   }

   public String getColor() { return "Hola"; }

}

 