import java.util.Scanner;

class ProbarCuentaBancaria {

   public static void main(String[] args) {
      CuentaBancaria cuenta1 = new CuentaBancaria("Cajamar","ES9012341234123412341234", 1500, "Pepa", "Rodriguez Perez", "45123123U");
      CuentaBancaria cuenta2 = new CuentaBancaria("BBVA","ES9044441234888812341234", 1500, "Luis", "Garcia Lopez", "76111999T");

      cuenta1.meterDinero(300);
      if (cuenta2.sacarDinero(3000)==false) {   //No ha podido sacar el dinero
         System.out.println("No tienes fondos suficientes");
      }

      System.out.println("La cuenta de la entidad "+cuenta1.getEntidad()+" tiene de saldo "+cuenta1.devuelveSaldo()+"€");
      System.out.println("La cuenta de la entidad "+cuenta2.getEntidad()+" tiene de saldo "+cuenta2.devuelveSaldo()+"€");

    }
}
