public class CensoInstituto {
    public static void main(String[] args) {
        //Creo el arry con los miembros del instituto
        MiembroInstituto escolar[] = new MiembroInstituto[4];

        //Relleno el array
        escolar[0]= new Estudiante("Ana López","12345H","1DAW");
        escolar[1]= new Estudiante("Fran Sánchez","43345K","1ASIR");
        escolar[2]= new Profesor("Luis Pérez","19875F","Matemáticas");
        escolar[3]= new Profesor("Petra García","67435T","Informática");

        //Voy presentando a los miembros
        for (int i=0; i<escolar.length; i++) {
            escolar[i].presentarse();
        }

        System.out.println(escolar[1].toString());

    }

}