public class Array1 {
    public static void main(String[] args) {
        //Declaramos el array
        int serie[];

        //Creamos el array
        serie = new int[5];

        //Introducimos datos
        serie[0]=1;
        serie[1]=13;
        serie[2]=21;
        serie[3]=14;
        serie[4]=6;

        //Mostramos los datos del array
        for(int i=0;i<5;i++) {
            System.out.println("Elemento "+i+": "+serie[i]);
        }
    }
}
    