public class Bicicleta extends Vehiculo {
   //Defino los atributos
   private String tipo;

   //Defino los métodos
   public Bicicleta(String mar, String mod, double pre, String type) { //Constructor
      super(mar, mod, pre);
      this.tipo = type;
   }

   public String getDatosExtra() { //Este método sobreescribe el mismo de la clase Padre
      return tipo;
   }

   public double impuestos() { //Este método sobreescribe el mismo de la clase Padre. Las bicicletas tienen un 10% de impuestos
      return precio*0.1;
   }

}