/*
 * Crearemos un programa con dos coches, uno Ferrari y otro SEAT Ibiza. 
 * Les daremos valores a cada uno de sus atributos a través de los setter correspondientes. 
 * Daremos un mensaje final en el que digamos (marca modelo) tiene más autonomía que (marca modelo)
 */

class ProbarCoche {
   public static void main(String[] args) {
    //Creo los dos objetos
    Coche ferrari = new Coche();
    Coche ibiza = new Coche();

    //Introducimos los datos del Ferrari
    ferrari.setMarca("Ferrari");
    ferrari.setModelo("Testarossa");
    ferrari.setMatricula("5676JHM");
    ferrari.setPuertas(5);
    ferrari.setColor("Rojo");
    ferrari.setAutonomia(600);

    //Introducimos los datos del SEAT Ibiza
    ibiza.setMarca("SEAT");
    ibiza.setModelo("Ibiza");
    ibiza.setMatricula("2312LJM");
    ibiza.setPuertas(5);
    ibiza.setColor("Verde");
    ibiza.setAutonomia(700);

    // Comprobamos qué coche tiene más autonomía
    if(ibiza.getAutonomia()>ferrari.getAutonomia()) {
        System.out.println("El "+ibiza.getMarca()+" "+ibiza.getModelo()+" tiene más autonomía que el "+ferrari.getMarca()+" "+ferrari.getModelo());
    } else {
        System.out.println("El "+ferrari.getMarca()+" "+ferrari.getModelo()+" tiene más autonomía que el "+ibiza.getMarca()+" "+ibiza.getModelo());
    }

    ferrari.infoCoche();
    ibiza.infoCoche();

    }
}
