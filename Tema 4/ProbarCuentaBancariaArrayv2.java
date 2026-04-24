import java.util.Scanner;

class ProbarCuentaBancariaArrayv2 {

   public static void main(String[] args) {

        CuentaBancaria cuentas[] = {new CuentaBancaria("Cajamar","ES9012341234123412341234", 1500, "Pepa", "Rodriguez Perez", "45123123U"), new CuentaBancaria("BBVA","ES9044441234888812341234", 1500, "Luis", "Garcia Lopez", "76111999T"), new CuentaBancaria("Bankinter","ES9012888834123412341234", 1500, "Luisa", "Hernandez Hernandez", "00883123F"), new CuentaBancaria("Unicaja","ES9012341234876542341234", 1500, "Tomás", "Garcia Felices", "56189123J"), new CuentaBancaria("Santander","ES901234112234412341234", 1500, "Andrés", "López Sánchez", "89712321P")};

      //Saco 300€ de dos cuentas
      cuentas[1].sacarDinero(300);
      cuentas[4].sacarDinero(300);

      //Busco las cuentas con más de 1400€
      for(int i=0; i<cuentas.length; i++) {
        if(cuentas[i].devuelveSaldo()>1400) { //Si la cuenta tiene más de 1400€
            System.out.println("IBAN: "+cuentas[i].getIBAN()+" Entidad: "+cuentas[i].getEntidad());
        }
      }

      //Meto dinero en una cuenta
      cuentas[3].meterDinero(500);

      //Recorro el array para buscar la cuenta con más dinero
      int posicion=0;
      double maxDinero=0;

      for(int i=0; i<cuentas.length; i++) {
        if(cuentas[i].devuelveSaldo()>maxDinero) { //Hay alguien con más dinero que el anterior
            maxDinero = cuentas[i].devuelveSaldo();
            posicion = i;
        }
      }

      //Sacamos por pantalla los datos de la persona con más dinero
      System.out.println("Nombre: "+cuentas[posicion].getNombre()+ " Apellidos: "+cuentas[posicion].getApellidos());

    }
}
