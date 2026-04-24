public class Coche extends Vehiculo {
   //Defino los atributos
   private int numPuertas;

   //Defino los métodos
   public Coche(String mar, String mod, double pre, int puertas) { //Constructor
      super(mar, mod, pre);
      this.numPuertas = puertas;
   }

   public String getDatosExtra() { //Este método sobreescribe el mismo de la clase Padre
      return ""+numPuertas+"";
   }

   public double impuestos() { //Este método sobreescribe el mismo de la clase Padre. Los coches tienen un 21% de impuestos
      return precio*0.21;
   }

}