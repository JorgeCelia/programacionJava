/*
Clase cuenta bancaria 
Crear la clase cuenta bancaria que tenga los campos: 
    entidad bancaria
    IBAN
    saldo
    DNI del titular
    nombre y apellidos del mismo. 
Debemos crear los siguientes métodos:
    meter dinero
    sacar dinero
    conocer el saldo.
    setter y getter para el resto de atributos
    constructor para inicializar todos los atributos a los valores que le pasemos.

Crear un programa que tenga dos objetos cuenta bancaria de dos personas y bancos diferentes con un saldo inicial de 1500€.  Meter dinero en una cuenta y sacar de otra (300€ de cada una). Mostrar el nombre de la entidad y el saldo de cada una de las cuentas en un mensaje al terminar el proceso.
*/

class CuentaBancaria {
    //Definición de los atributos
   private String entidad;
   private String iban;
   private double saldo;
   private String dni;
   private String nombre;
   private String apellidos;

    //Defino los métodos
    public CuentaBancaria(String ent, String ib, double sal, String n, String a, String d) { //Constructor
        entidad = ent;
        iban = ib;
        saldo = sal;
        nombre = n;
        apellidos = a;
        dni = d;
    }

    public String getEntidad() {
        return entidad;
     }
     public void setEntidad(String txt) {
        entidad = txt;
     }
  
     public String getIBAN() {
        return iban;
     }
     public void setIBAN(String txt) {
        iban = txt;
     }

     public String getDNI() {
        return dni;
     }
     public void setDNI(String txt) {
        dni = txt;
     }

     public String getNombre() {
        return nombre;
     }
     public void setNombre(String periquito) {
        nombre = periquito;
     }

     public String getApellidos() {
        return apellidos;
     }
     public void setApellidos(String txt) {
        apellidos = txt;
     }

     public double devuelveSaldo() {    //Nos muestra el saldo que tiene la cuenta
        return saldo;
     }

     public void meterDinero(double pasta) {    //Añade dinero al saldo que haya
        saldo = saldo + pasta;
     }

     public boolean sacarDinero(double pasta) {    //Quita dinero al saldo que haya
         if ((saldo-pasta)<0) { //La cuenta se queda en negativo
            return false;
         }
         else { //Hay dinero suficiente
            saldo = saldo - pasta;
            return true;
         }
     }
}
