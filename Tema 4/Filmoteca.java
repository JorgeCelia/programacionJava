import java.util.Scanner;

public class Filmoteca {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
       
        // Declaración e inicialización del array de objetos Pelicula usando {}
    Pelicula[] peliculas = {
    new Pelicula("Avatar", "James Cameron", "Ciencia ficción", 162, "EE.UU.", 2009),
    new Pelicula("Titanic", "James Cameron", "Romance", 195, "EE.UU.", 1997),
    new Pelicula("Vengadores: Endgame", "Anthony y Joe Russo", "Acción", 181, "EE.UU.", 2019),
    new Pelicula("Jurassic Park", "Steven Spielberg", "Ciencia ficción", 127, "EE.UU.", 1993),
    new Pelicula("El Rey León", "Roger Allers y Rob Minkoff", "Animación", 88, "EE.UU.", 1994),
    new Pelicula("Forrest Gump", "Robert Zemeckis", "Drama", 142, "EE.UU.", 1994),
    new Pelicula("El Caballero Oscuro", "Christopher Nolan", "Acción", 152, "EE.UU.", 2008),
    new Pelicula("Matrix", "Lana y Lilly Wachowski", "Ciencia ficción", 136, "EE.UU.", 1999),
    new Pelicula("Gladiator", "Ridley Scott", "Acción", 155, "EE.UU.", 2000),
    new Pelicula("Interestelar", "Christopher Nolan", "Ciencia ficción", 169, "EE.UU.", 2014),
    new Pelicula("Inception", "Christopher Nolan", "Ciencia ficción", 148, "EE.UU.", 2010),
    new Pelicula("El Señor de los Anillos: La Comunidad del Anillo", "Peter Jackson", "Fantasía", 178, "Nueva Zelanda", 2001),
    new Pelicula("El Señor de los Anillos: Las Dos Torres", "Peter Jackson", "Fantasía", 179, "Nueva Zelanda", 2002),
    new Pelicula("El Señor de los Anillos: El Retorno del Rey", "Peter Jackson", "Fantasía", 201, "Nueva Zelanda", 2003),
    new Pelicula("Harry Potter y la piedra filosofal", "Chris Columbus", "Fantasía", 152, "Reino Unido", 2001),
    new Pelicula("Harry Potter y la cámara secreta", "Chris Columbus", "Fantasía", 161, "Reino Unido", 2002),
    new Pelicula("Harry Potter y el prisionero de Azkaban", "Alfonso Cuarón", "Fantasía", 142, "Reino Unido", 2004),
    new Pelicula("Harry Potter y el cáliz de fuego", "Mike Newell", "Fantasía", 157, "Reino Unido", 2005),
    new Pelicula("Harry Potter y la Orden del Fénix", "David Yates", "Fantasía", 138, "Reino Unido", 2007),
    new Pelicula("Harry Potter y el misterio del príncipe", "David Yates", "Fantasía", 153, "Reino Unido", 2009),
    new Pelicula("Harry Potter y las reliquias de la muerte - Parte 1", "David Yates", "Fantasía", 146, "Reino Unido", 2010),
    new Pelicula("Harry Potter y las reliquias de la muerte - Parte 2", "David Yates", "Fantasía", 130, "Reino Unido", 2011),
    new Pelicula("Star Wars: Una nueva esperanza", "George Lucas", "Ciencia ficción", 121, "EE.UU.", 1977),
    new Pelicula("Star Wars: El Imperio contraataca", "Irvin Kershner", "Ciencia ficción", 124, "EE.UU.", 1980),
    new Pelicula("Star Wars: El retorno del Jedi", "Richard Marquand", "Ciencia ficción", 131, "EE.UU.", 1983),
    new Pelicula("Star Wars: El despertar de la fuerza", "J.J. Abrams", "Ciencia ficción", 138, "EE.UU.", 2015),
    new Pelicula("Star Wars: Los últimos Jedi", "Rian Johnson", "Ciencia ficción", 152, "EE.UU.", 2017),
    new Pelicula("Star Wars: El ascenso de Skywalker", "J.J. Abrams", "Ciencia ficción", 142, "EE.UU.", 2019),
    new Pelicula("Spider-Man: No Way Home", "Jon Watts", "Acción", 148, "EE.UU.", 2021),
    new Pelicula("Iron Man", "Jon Favreau", "Acción", 126, "EE.UU.", 2008),
    new Pelicula("Los Vengadores", "Joss Whedon", "Acción", 143, "EE.UU.", 2012),
    new Pelicula("Capitán América: Civil War", "Anthony y Joe Russo", "Acción", 147, "EE.UU.", 2016),
    new Pelicula("Guardians de la Galaxia", "James Gunn", "Ciencia ficción", 121, "EE.UU.", 2014),
    new Pelicula("Pantera Negra", "Ryan Coogler", "Acción", 134, "EE.UU.", 2018),
    new Pelicula("El Hombre de Acero", "Zack Snyder", "Acción", 143, "EE.UU.", 2013),
    new Pelicula("Joker", "Todd Phillips", "Drama", 122, "EE.UU.", 2019),
    new Pelicula("La Liga de la Justicia", "Zack Snyder", "Acción", 242, "EE.UU.", 2021),
    new Pelicula("Deadpool", "Tim Miller", "Acción", 108, "EE.UU.", 2016),
    new Pelicula("Logan", "James Mangold", "Acción", 137, "EE.UU.", 2017),
    new Pelicula("Piratas del Caribe: La maldición de la Perla Negra", "Gore Verbinski", "Aventuras", 143, "EE.UU.", 2003),
    new Pelicula("Piratas del Caribe: El cofre del hombre muerto", "Gore Verbinski", "Aventuras", 151, "EE.UU.", 2006),
    new Pelicula("Piratas del Caribe: En el fin del mundo", "Gore Verbinski", "Aventuras", 169, "EE.UU.", 2007),
    new Pelicula("Toy Story", "John Lasseter", "Animación", 81, "EE.UU.", 1995),
    new Pelicula("Toy Story 2", "John Lasseter", "Animación", 92, "EE.UU.", 1999),
    new Pelicula("Toy Story 3", "Lee Unkrich", "Animación", 103, "EE.UU.", 2010),
    new Pelicula("Up", "Pete Docter", "Animación", 96, "EE.UU.", 2009),
    new Pelicula("Buscando a Nemo", "Andrew Stanton", "Animación", 100, "EE.UU.", 2003),
    new Pelicula("Monstruos S.A.", "Pete Docter", "Animación", 92, "EE.UU.", 2001),
    new Pelicula("Los Increíbles", "Brad Bird", "Animación", 115, "EE.UU.", 2004),
    new Pelicula("Ratatouille", "Brad Bird", "Animación", 111, "EE.UU.", 2007),
    new Pelicula("Del revés (Inside Out)", "Pete Docter", "Animación", 95, "EE.UU.", 2015),
    new Pelicula("Coco", "Lee Unkrich y Adrian Molina", "Animación", 105, "EE.UU.", 2017),
    new Pelicula("Frozen", "Chris Buck y Jennifer Lee", "Animación", 102, "EE.UU.", 2013),
    new Pelicula("Shrek", "Andrew Adamson y Vicky Jenson", "Animación", 90, "EE.UU.", 2001),
    new Pelicula("Kung Fu Panda", "Mark Osborne y John Stevenson", "Animación", 92, "EE.UU.", 2008),
    new Pelicula("Madagascar", "Eric Darnell y Tom McGrath", "Animación", 86, "EE.UU.", 2005),
    new Pelicula("Los Minions", "Kyle Balda y Pierre Coffin", "Animación", 91, "EE.UU.", 2015),
    new Pelicula("Gru, mi villano favorito", "Pierre Coffin y Chris Renaud", "Animación", 95, "EE.UU.", 2010),
    new Pelicula("El Viaje de Chihiro", "Hayao Miyazaki", "Animación", 125, "Japón", 2001),
    new Pelicula("Mi Vecino Totoro", "Hayao Miyazaki", "Animación", 86, "Japón", 1988),
    new Pelicula("La La Land", "Damien Chazelle", "Musical", 128, "EE.UU.", 2016),
    new Pelicula("Bohemian Rhapsody", "Bryan Singer", "Biografía", 134, "Reino Unido", 2018),
    new Pelicula("Rocketman", "Dexter Fletcher", "Biografía", 121, "Reino Unido", 2019),
    new Pelicula("Avatar: El sentido del agua", "James Cameron", "Ciencia ficción", 192, "EE.UU.", 2022),
    new Pelicula("E.T. el extraterrestre", "Steven Spielberg", "Ciencia ficción", 115, "EE.UU.", 1982),
    new Pelicula("Indiana Jones y el arca perdida", "Steven Spielberg", "Aventuras", 115, "EE.UU.", 1981),
    new Pelicula("Indiana Jones y el templo maldito", "Steven Spielberg", "Aventuras", 118, "EE.UU.", 1984),
    new Pelicula("Indiana Jones y la última cruzada", "Steven Spielberg", "Aventuras", 127, "EE.UU.", 1989),
    new Pelicula("Misión Imposible", "Brian De Palma", "Acción", 110, "EE.UU.", 1996),
    new Pelicula("Misión Imposible: Nación secreta", "Christopher McQuarrie", "Acción", 131, "EE.UU.", 2015),
    new Pelicula("Top Gun", "Tony Scott", "Acción", 110, "EE.UU.", 1986),
    new Pelicula("Top Gun: Maverick", "Joseph Kosinski", "Acción", 131, "EE.UU.", 2022),
    new Pelicula("Terminator", "James Cameron", "Ciencia ficción", 107, "EE.UU.", 1984),
    new Pelicula("Terminator 2: El juicio final", "James Cameron", "Ciencia ficción", 137, "EE.UU.", 1991),
    new Pelicula("Alien: El octavo pasajero", "Ridley Scott", "Terror", 117, "EE.UU.", 1979),
    new Pelicula("Aliens", "James Cameron", "Acción", 137, "EE.UU.", 1986),
    new Pelicula("Depredador", "John McTiernan", "Acción", 107, "EE.UU.", 1987),
    new Pelicula("Rambo", "Ted Kotcheff", "Acción", 93, "EE.UU.", 1982),
    new Pelicula("Rocky", "John G. Avildsen", "Deportes", 120, "EE.UU.", 1976),
    new Pelicula("Creed", "Ryan Coogler", "Deportes", 133, "EE.UU.", 2015),
    new Pelicula("El Padrino", "Francis Ford Coppola", "Crimen", 175, "EE.UU.", 1972),
    new Pelicula("El Padrino: Parte II", "Francis Ford Coppola", "Crimen", 202, "EE.UU.", 1974),
    new Pelicula("El Padrino: Parte III", "Francis Ford Coppola", "Crimen", 162, "EE.UU.", 1990),
    new Pelicula("Pulp Fiction", "Quentin Tarantino", "Crimen", 154, "EE.UU.", 1994),
    new Pelicula("Kill Bill Vol. 1", "Quentin Tarantino", "Acción", 111, "EE.UU.", 2003),
    new Pelicula("Kill Bill Vol. 2", "Quentin Tarantino", "Acción", 137, "EE.UU.", 2004),
    new Pelicula("Django Desencadenado", "Quentin Tarantino", "Western", 165, "EE.UU.", 2012),
    new Pelicula("Malditos Bastardos", "Quentin Tarantino", "Bélico", 153, "EE.UU.", 2009),
    new Pelicula("Érase una vez en Hollywood", "Quentin Tarantino", "Comedia dramática", 161, "EE.UU.", 2019),
    new Pelicula("Regreso al Futuro", "Robert Zemeckis", "Ciencia ficción", 116, "EE.UU.", 1985),
    new Pelicula("Regreso al Futuro II", "Robert Zemeckis", "Ciencia ficción", 108, "EE.UU.", 1989),
    new Pelicula("Regreso al Futuro III", "Robert Zemeckis", "Ciencia ficción", 118, "EE.UU.", 1990),
    new Pelicula("Cazafantasmas", "Ivan Reitman", "Comedia", 105, "EE.UU.", 1984),
    new Pelicula("Los Cazafantasmas (2016)", "Paul Feig", "Comedia", 116, "EE.UU.", 2016),
    new Pelicula("Jumanji", "Joe Johnston", "Aventuras", 104, "EE.UU.", 1995),
    new Pelicula("Jumanji: Bienvenidos a la jungla", "Jake Kasdan", "Aventuras", 119, "EE.UU.", 2017),
    new Pelicula("Jumanji: Siguiente nivel", "Jake Kasdan", "Aventuras", 123, "EE.UU.", 2019),
    new Pelicula("The Batman", "Matt Reeves", "Acción", 176, "EE.UU.", 2022),
    new Pelicula("Batman Begins", "Christopher Nolan", "Acción", 140, "EE.UU.", 2005),
    new Pelicula("El Padrino", "Francis Ford Coppola", "Crimen", 175, "EE.UU.", 1972),
    new Pelicula("Salvar al Soldado Ryan", "Steven Spielberg", "Bélico", 169, "EE.UU.", 1998),
    new Pelicula("Braveheart", "Mel Gibson", "Bélico", 178, "EE.UU.", 1995),
    new Pelicula("Corazón Valiente", "Mel Gibson", "Bélico", 178, "EE.UU.", 1995),
    new Pelicula("El Sexto Sentido", "M. Night Shyamalan", "Terror", 107, "EE.UU.", 1999),
    new Pelicula("El Club de la Lucha", "David Fincher", "Drama", 139, "EE.UU.", 1999),
    new Pelicula("Seven", "David Fincher", "Crimen", 127, "EE.UU.", 1995),
    new Pelicula("La Red Social", "David Fincher", "Drama", 120, "EE.UU.", 2010),
    new Pelicula("El Renacido", "Alejandro G. Iñárritu", "Aventuras", 156, "EE.UU.", 2015),
    new Pelicula("Birdman", "Alejandro G. Iñárritu", "Comedia dramática", 119, "EE.UU.", 2014),
    new Pelicula("Titanes, hicieron historia", "Boaz Yakin", "Deportes", 113, "EE.UU.", 2000),
    new Pelicula("Jurassic World", "Colin Trevorrow", "Ciencia ficción", 124, "EE.UU.", 2015),
    new Pelicula("Park Jurásico III", "Joe Johnston", "Ciencia ficción", 92, "EE.UU.", 2001),
    new Pelicula("El Gran Showman", "Michael Gracey", "Musical", 105, "EE.UU.", 2017),
    new Pelicula("La Bella y la Bestia", "Bill Condon", "Musical", 129, "EE.UU.", 2017),
    new Pelicula("Aladdín", "Guy Ritchie", "Aventuras", 128, "EE.UU.", 2019),
    new Pelicula("Rapunzel", "Nathan Greno y Byron Howard", "Animación", 100, "EE.UU.", 2010),
    new Pelicula("Mulán", "Tony Bancroft y Barry Cook", "Animación", 88, "EE.UU.", 1998),
    new Pelicula("Hércules", "Ron Clements y John Musker", "Animación", 93, "EE.UU.", 1997),
    new Pelicula("Tarzán", "Chris Buck y Kevin Lima", "Animación", 88, "EE.UU.", 1999),
    new Pelicula("Zootrópolis", "Rich Moore", "Animación", 108, "EE.UU.", 2016),
    new Pelicula("Encanto", "Jared Bush y Byron Howard", "Animación", 102, "EE.UU.", 2021),
    new Pelicula("Padre no hay más que uno", "Santiago Segura", "Comedia", 98, "España", 2019),
    new Pelicula("Ocho apellidos vascos", "Emilio Martínez-Lázaro", "Comedia", 98, "España", 2014),
    new Pelicula("Ocho apellidos catalanes", "Emilio Martínez-Lázaro", "Comedia", 106, "España", 2015),
    new Pelicula("El laberinto del fauno", "Guillermo del Toro", "Fantasía", 118, "España", 2006),
    new Pelicula("Tadeo Jones", "Enrique Gato", "Animación", 92, "España", 2012),
    new Pelicula("Campeones", "Javier Fesser", "Comedia", 124, "España", 2018),
    new Pelicula("Celda 211", "Daniel Monzón", "Thriller", 113, "España", 2009),
    new Pelicula("La isla mínima", "Alberto Rodríguez", "Thriller", 105, "España", 2014),
    new Pelicula("Mar adentro", "Alejandro Amenábar", "Drama", 125, "España", 2004),
    new Pelicula("Ágora", "Alejandro Amenábar", "Histórica", 127, "España", 2009),
    new Pelicula("El orfanato", "J.A. Bayona", "Terror", 105, "España", 2007)};

        //Muestro el listado de las películas de un director
        String valor;
        int contador=0;
        System.out.print("Introduce un director: ");
        valor = lector.nextLine();
        System.out.println("Películas de "+valor);
        System.out.println("-------------------------------------------------");

        for(Pelicula p:peliculas) {
            if(p.getDirector().compareTo(valor)==0) { //Encuentra una pelicula del director
                System.out.println(p.getTitulo());
                contador++;
            }
        }
        if(contador==0) { //No hay ninguna película de ese director
            System.out.println("No tenemos películas de "+valor+" en el catálogo");
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++");

        //Título de las comedias españolas posteriores a 2010
        System.out.println("Comedias españolas posteriores a 2010");
        System.out.println("-------------------------------------");
        for(Pelicula p:peliculas) {
            if(p.getNacionalidad()=="España" && p.getGenero()=="Comedia" && p.getYear()>2010) {
                System.out.println(p.getTitulo());
            }
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++");

        //Sacamos el título y el año de las películas del país elegido en el menú
        int opcion = 0;
        System.out.println("Elige una opción del menú: ");
        System.out.println("1- España");
        System.out.println("2- EE.UU.");
        System.out.println("3- Japón");
        System.out.println("4- Nueva Zelanda");
        System.out.println("5- Reino Unido");
        System.out.print("Tu opción: ");
        opcion = lector.nextInt();

        String pais="";

        switch (opcion) {
            case 1:
                pais = "España";
                break;
            case 2:
                pais = "EE.UU.";
                break;
            case 3:
                pais = "Japón";
                break;
            case 4:
                pais = "Nueva Zelanda";
                break;
            case 5:
                pais = "Reino Unido";
                break;                                    
            default:
                break;
        }
        System.out.println("Películas de "+pais);
        System.out.println("--------------------------");
        for(Pelicula p:peliculas) {
            if(p.getNacionalidad()==pais) {
                System.out.println(p.getTitulo()+" "+p.getYear());
            }
        }



        lector.close();
    } //Cierro el main
}