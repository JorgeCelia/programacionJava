public class BibliotecaDigital {   


    public static void main(String[] args) {
        //Array que contendrá las publicaciones
        Publicacion[] publicaciones = new Publicacion[5];

        //Añado los datos al array
        publicaciones[0] = new Publicacion("1984", "George Orwell", 326);
        publicaciones[1] = new Publicacion("El señor de los anillos", "J.R.R. Tolkien", 576);
        publicaciones[2] = new Comic("La cosa del pantano", "Alan Moore", 121, "Stephen Bissette");
        publicaciones[3] = new Comic("The Sandman", "Nail Gaiman", 231, "John Totleben");
        publicaciones[4] = new Comic("Watchmen", "Alan Moore", 432, "Dave Gibbons");

        //1. Mostrar úncamente los cómics
        System.out.println("*** CÓMICS DISPONIBLES ***");
        for (int i=0; i<publicaciones.length; i++) {
            if (publicaciones[i] instanceof Comic) { //es un cómic
                publicaciones[i].muestraInfo();
            }
        }

        //2. Trabajo con Strings
        System.out.println("");
        System.out.println("*** Apartado de Strings ***");
        int contadorTitulos=0, contadorVocales=0;
        for (int i=0; i<publicaciones.length; i++) {
            if (publicaciones[i].getTitulo().length()<10) { //El título tiene menos de 10 caracteres
                contadorTitulos++;
            }
            
            if (publicaciones[i].getTitulo().toLowerCase().charAt(0)=='a' || publicaciones[i].getTitulo().toLowerCase().charAt(0)=='e' || publicaciones[i].getTitulo().toLowerCase().charAt(0)=='i' || publicaciones[i].getTitulo().toLowerCase().charAt(0)=='o' || publicaciones[i].getTitulo().toLowerCase().charAt(0)=='u') { //El título empieza por vocal
                contadorVocales++;
            }
        }
        System.out.println("Número de títulos de menos de 10 caracteres: "+contadorTitulos);
        System.out.println("Número de títulos que empiezan por vocal: "+contadorVocales);

        //3. Trabajo con Arrays
        System.out.println("");
        System.out.println("*** Apartado de Arrays ***");
        int mayorPaginas=publicaciones[0].getPaginas(), totalPaginas=0;
        for (int i=0; i<publicaciones.length; i++) {
            totalPaginas = totalPaginas + publicaciones[i].getPaginas();
            if (publicaciones[i].getPaginas()>mayorPaginas) { //Hay una publicación con más páginas
                mayorPaginas = publicaciones[i].getPaginas();
            }          
        }
        System.out.println("Mayor número de página: "+mayorPaginas);
        System.out.println("Media de páginas: "+((double)totalPaginas/publicaciones.length));
    }
}