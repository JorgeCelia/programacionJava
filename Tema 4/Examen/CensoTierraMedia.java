class CensoTierraMedia {

   public static void main(String[] args) {
    //Creo y relleno el array con los datos
    HabitanteTM[] habitantes = new HabitanteTM[6];
    habitantes[0] = new HabitanteTM("Bilbo", "Hobbit", "La Comarca", 67, false, "vegetariana", 0.89);
    habitantes[1] = new HabitanteTM("Gandalf", "Mago", "-", 3000, true, "vegetariana", 2.01);
    habitantes[2] = new HabitanteTM("Elron", "Elfo", "Rivendell", 3500, true, "vegetariana", 1.89);
    habitantes[3] = new HabitanteTM("Gimli", "Enano", "Moria", 120, false, "omnívora", 1.78);
    habitantes[4] = new HabitanteTM("Aragorn", "Humano", "Góndor", 130, false, "omnívora", 1.78);
    habitantes[5] = new HabitanteTM("Azog", "Orco", "Mordor", 90, false, "carnívora", 2.00);
    System.out.println("***Array Creado***");

    //Busco el nombre y la edad de los inmortales
    System.out.println("***Seres inmortales***");
    for(int i=0;i<habitantes.length; i++) {
        if (habitantes[i].getInmortal()==true) {
            System.out.println(habitantes[i].getNombre()+" Edad: "+habitantes[i].getEdad());
        }
    }

   }
}
