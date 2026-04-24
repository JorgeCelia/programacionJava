public class CirculoH extends FiguraGeometricaH {
   private double radio;
   public CirculoH (double r) {
      radio = r;
   }
   public double area() {
      return 3.14 * radio * radio;
   }
   public double perimetro() {
      return 2 * 3.14 * radio;
   }
}
