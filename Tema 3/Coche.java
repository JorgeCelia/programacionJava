/*
Clase Coche que tenga los campos:
    marca
    modelo
    autonomía
    número de puertas
    matricula
    color
Debemos incluir los siguientes métodos:
    getter y setter para cada atributo
    método infoCoche para mostrar toda la información de un coche formateada
 */

class Coche {
    //Definición de los atributos
    private String marca;
    private String modelo;
    private String matricula;
    private int puertas;
    private String color;
    private int autonomia;


    //Defino los métodos
    public String getMarca() {  //Devuelve la marca del coche
        return marca;
     }
     public void setMarca(String txt) { //Me permite modificar la marca del coche
        marca = txt;
     }

     public String getModelo() {  //Devuelve el modelo del coche
        return modelo;
     }
     public void setModelo(String txt) { //Me permite modificar el modelo del coche
        modelo = txt;
     }

     public String getMatricula() {  //Devuelve la matricula del coche
        return matricula;
     }
     public void setMatricula(String txt) { //Me permite modificar la matricula del coche
        matricula = txt;
     }

     public int getPuertas() {  //Devuelve el número de puertas del coche
        return puertas;
     }
     public void setPuertas(int valor) { //Me permite modificar el numero de puertas del coche
        puertas = valor;
     }

     public String getColor() {  //Devuelve el color del coche
        return color;
     }
     public void setColor(String txt) { //Me permite modificar el color del coche
        color = txt;
     }

     public int getAutonomia() {  //Devuelve la autonomia del coche
        return autonomia;
     }
     public void setAutonomia(int valor) { //Me permite modificar la autonomia del coche
        autonomia = valor;
     }

     public void infoCoche() { //Me muestra la información del coche
        System.out.println("***********************************");
        System.out.println(marca+" "+modelo);
        System.out.println("***********************************");
        System.out.println("Matrícula: "+matricula);
        System.out.println("Color: "+color);
        System.out.println("Autonomía: "+autonomia+"km");
        System.out.println("Número de puertas: "+puertas);

     }


}
