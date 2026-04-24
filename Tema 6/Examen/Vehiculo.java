public class Vehiculo {
   //Defino los atributos
   protected String marca;
   protected String modelo;
   protected double precio;

   //Defino los métodos
   public Vehiculo(String mar, String mod, double pre) { //Constructor
      this.marca = mar;
      this.modelo = mod;
      this.precio = pre;
   }

   public String getMarca() {
       return marca;
   }

   public String getModelo() {
       return modelo;
   }

   public double getPrecio() {
       return precio;
   }

   public void setPrecio(double precio) {
       this.precio = precio;
   }

   public String getDatosExtra() { //Este método deberá ser sobreescrito por las clases hijas poruqe Vehiculo no tiene dato extra
      return "";
   }

   public double impuestos() { //Lo mismo que el anterior. Deberá ser sobreescrito por las clases hijas ya que no hay un impuesto genérico para Vehiculo
      return 0;
   }

}