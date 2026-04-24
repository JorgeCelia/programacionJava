public class Rectangulo implements FiguraGeometrica {
   private double base, altura;
   public Rectangulo (double b, double h) {
      base = b;
      altura = h;
   }
   public double area() {
      return base*altura;
   }
   public double perimetro() {
      return 2*(base+altura);
   }
}