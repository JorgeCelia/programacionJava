public class Moto extends Vehiculo {
   //Defino los atributos
   private int cilindrada;

   //Defino los métodos
   public Moto(String mar, String mod, double pre, int cilin) { //Constructor
      super(mar, mod, pre);
      this.cilindrada = cilin;
   }

   public String getDatosExtra() { //Este método sobreescribe el mismo de la clase Padre
      return ""+cilindrada+"";
   }

   public double impuestos() { //Este método sobreescribe el mismo de la clase Padre. Las motos tienen un 15% de impuestos
      return precio*0.15;
   }

}