public class gestionGimnasio {
    public static void main(String[] args) {
        //LLenamos el array clientes con los datos de los clientes del gimnasio
        Cliente[] clientes = new Cliente[] {
        new Cliente("Juan", "Martínez", "Calle Real 12", "Almería", 34, 'H', 78.5, 1.79, "ES98203857789830000101", false),
        new Cliente("María", "López", "Avenida del Mar 22", "Roquetas de Mar", 29, 'M', 62.3, 1.65, "ES91210004184502000102", false),
        new Cliente("Pedro", "García", "Calle Sol 5", "Huércal de Almería", 41, 'H', 90.2, 1.82, "ES85210008130200000103", true),
        new Cliente("Laura", "Sánchez", "Calle Luna 33", "Aguadulce", 27, 'M', 55.8, 1.62, "ES79210002234510000104", false),
        new Cliente("Antonio", "Gómez", "Camino Viejo 10", "Viator", 50, 'H', 82.0, 1.75, "ES20210005982730000105", false),
        new Cliente("Lucía", "Ruiz", "Calle Levante 7", "Almería", 31, 'M', 58.4, 1.68, "ES60203872654100000106", true),
        new Cliente("Francisco", "Torres", "Paseo Marítimo 91", "Roquetas de Mar", 45, 'H', 95.1, 1.83, "ES70210008451260000107", false),
        new Cliente("Carmen", "Navarro", "Calle Jardín 4", "Benahadux", 23, 'M', 54.6, 1.60, "ES40203878945630000108", false),
        new Cliente("José", "Moreno", "Calle Granada 15", "Gádor", 37, 'H', 79.4, 1.78, "ES11210004589620000109", true),
        new Cliente("Elena", "Castro", "Calle Mayor 18", "Pechina", 33, 'M', 63.2, 1.66, "ES87210008579610000110", false),
        new Cliente("Manuel", "Flores", "Calle Córdoba 8", "Almería", 52, 'H', 88.0, 1.80, "ES30203857896520000111", false),
        new Cliente("Sara", "Durán", "Avenida Europa 11", "Roquetas de Mar", 26, 'M', 57.1, 1.64, "ES73210004412980000112", false),
        new Cliente("Javier", "Ibáñez", "Calle Málaga 21", "Vícar", 43, 'H', 91.3, 1.85, "ES51210004789630000113", true),
        new Cliente("Patricia", "Ortega", "Calle Jardines 2", "Las Norias", 39, 'M', 60.0, 1.70, "ES98203876451210000114", false),
        new Cliente("Raúl", "Serrano", "Calle Mediterráneo 14", "Almería", 24, 'H', 72.8, 1.76, "ES27210005462090000115", false),
        new Cliente("Isabel", "Ramos", "Calle Álamo 6", "Roquetas de Mar", 30, 'M', 59.4, 1.63, "ES20203876541230000116", false),
        new Cliente("Álvaro", "Molina", "Calle Romero 12", "Benahadux", 48, 'H', 84.3, 1.78, "ES35210004125890000117", true),
        new Cliente("Nuria", "Calvo", "Avenida América 4", "Viator", 27, 'M', 56.7, 1.61, "ES88210002369870000118", false),
        new Cliente("Sergio", "León", "Calle Jardines 22", "Gádor", 36, 'H', 77.1, 1.74, "ES45210008563240000119", false),
        new Cliente("Emma", "Gallego", "Calle Real 1", "Huércal de Almería", 32, 'M', 61.2, 1.67, "ES11203845896210000120", false),
        new Cliente("Mario", "Pérez", "Av. Cabo de Gata 12", "Almería", 40, 'H', 89.0, 1.82, "ES98203857789830000121", true),
        new Cliente("Clara", "Lara", "C/ Bahía 3", "Roquetas de Mar", 28, 'M', 53.7, 1.61, "ES91210004184502000122", false),
        new Cliente("David", "Esteban", "C/ Faro 9", "Aguadulce", 52, 'H', 92.4, 1.84, "ES85210008130200000123", false),
        new Cliente("Paula", "Montes", "Pza. Jardín 1", "Benahadux", 21, 'M', 51.9, 1.59, "ES79210002234510000124", false),
        new Cliente("Rubén", "Oliva", "C/ Río 10", "Gádor", 29, 'H', 78.2, 1.72, "ES20210005982730000125", false),
        new Cliente("Alicia", "Reyes", "C/ Sur 44", "Pechina", 44, 'M', 66.7, 1.69, "ES60203872654100000126", false),
        new Cliente("Héctor", "Vega", "Av. Mar 8", "Benahadux", 53, 'H', 96.5, 1.86, "ES70210008451260000127", true),
        new Cliente("Olga", "Nieto", "C/ Norte 17", "Almería", 35, 'M', 63.9, 1.65, "ES40203878945630000128", false),
        new Cliente("Andrés", "Santos", "C/ Arco 2", "Roquetas de Mar", 31, 'H', 74.2, 1.73, "ES11210004589620000129", false),
        new Cliente("Marta", "Simón", "C/ Parque 12", "Huércal de Almería", 26, 'M', 57.5, 1.64, "ES87210008579610000130", false),
        new Cliente("Hugo", "Valverde", "C/ Mirador 9", "Viator", 47, 'H', 83.4, 1.77, "ES30203857896520000131", false),
        new Cliente("Irene", "Cuesta", "Av. Mediterráneo 66", "Almería", 22, 'M', 52.1, 1.60, "ES73210004412980000132", false),
        new Cliente("Tomás", "Benítez", "C/ Cabo Verde 5", "Roquetas de Mar", 38, 'H', 88.6, 1.81, "ES51210004789630000133", false),
        new Cliente("Beatriz", "Rojas", "C/ Lavanda 12", "Las Norias", 33, 'M', 63.5, 1.68, "ES98203876451210000134", false),
        new Cliente("Rafael", "Segura", "C/ Palmeras 41", "Aguadulce", 46, 'H', 91.0, 1.83, "ES27210005462090000135", true),
        new Cliente("Natalia", "Pardo", "C/ Horizonte 7", "Benahadux", 29, 'M', 55.3, 1.62, "ES20203876541230000136", false),
        new Cliente("Diego", "Marín", "C/ Faro 18", "Almería", 58, 'H', 94.8, 1.78, "ES35210004125890000137", false),
        new Cliente("Alba", "Campos", "Av. Sol 3", "Gádor", 25, 'M', 54.7, 1.63, "ES88210002369870000138", false),
        new Cliente("Víctor", "Luna", "C/ Manantial 11", "Pechina", 42, 'H', 80.1, 1.75, "ES45210008563240000139", false),
        new Cliente("Rocío", "Andújar", "C/ Almendro 9", "Viator", 36, 'M', 62.9, 1.67, "ES11203845896210000140", true),
        new Cliente("Joaquín", "Soria", "Av. Estadio 14", "Almería", 49, 'H', 86.6, 1.79, "ES98203857789830000141", false),
        new Cliente("Ángela", "Jurado", "C/ Alfarero 3", "Roquetas de Mar", 37, 'M', 68.2, 1.72, "ES91210004184502000142", false),
        new Cliente("Samuel", "Casares", "C/ Luna 7", "Huércal de Almería", 33, 'H', 77.3, 1.74, "ES85210008130200000143", false),
        new Cliente("Julia", "Robles", "C/ Sauce 16", "Las Norias", 40, 'M', 65.0, 1.70, "ES79210002234510000144", false),
        new Cliente("Fabián", "Quesada", "C/ Aire 8", "Aguadulce", 28, 'H', 82.7, 1.77, "ES20210005982730000145", false),
        new Cliente("Lorena", "Santana", "C/ Cartaya 12", "Pechina", 26, 'M', 57.8, 1.65, "ES60203872654100000146", false),
        new Cliente("Eric", "Díaz", "C/ Pescadores 3", "Almería", 45, 'H', 93.1, 1.85, "ES70210008451260000147", true),
        new Cliente("Adriana", "Beltrán", "C/ Arena 10", "Benahadux", 34, 'M', 61.0, 1.66, "ES40203878945630000148", false),
        new Cliente("Óscar", "Miralles", "C/ Ciprés 11", "Roquetas de Mar", 52, 'H', 88.8, 1.82, "ES11210004589620000149", false),
        new Cliente("Nerea", "Salas", "C/ Jardín 14", "Huércal de Almería", 31, 'M', 59.1, 1.64, "ES87210008579610000150", false),
        new Cliente("Bruno", "Conde", "C/ Faro 29", "Almería", 44, 'H', 90.3, 1.83, "ES30203857896520000151", false),
        new Cliente("Eva", "Caballero", "C/ León 13", "Roquetas de Mar", 23, 'M', 52.7, 1.59, "ES73210004412980000152", false),
        new Cliente("Jaime", "Serrat", "C/ Puerto 15", "Aguadulce", 39, 'H', 75.4, 1.75, "ES51210004789630000153", false),
        new Cliente("Ainhoa", "Barco", "C/ Vivero 4", "Vícar", 24, 'M', 56.6, 1.62, "ES98203876451210000154", false),
        new Cliente("Raúl", "Tena", "C/ Roble 20", "Benahadux", 48, 'H', 84.0, 1.79, "ES27210005462090000155", false),
        new Cliente("Claudia", "Mena", "C/ Río 5", "Pechina", 32, 'M', 60.3, 1.67, "ES20203876541230000156", false),
        new Cliente("Pablo", "Gil", "C/ Cerro 33", "Gádor", 51, 'H', 92.6, 1.80, "ES35210004125890000157", true),
        new Cliente("Elisa", "Marcos", "C/ Calvario 2", "Almería", 29, 'M', 58.2, 1.64, "ES88210002369870000158", false),
        new Cliente("Marco", "Reina", "C/ Morera 3", "Viator", 46, 'H', 87.7, 1.78, "ES45210008563240000159", false),
        new Cliente("Helena", "Burgos", "C/ Sol 9", "Las Norias", 27, 'M', 54.9, 1.61, "ES11203845896210000160", true),
        new Cliente("Andoni", "Zamora", "C/ Miramar 7", "Aguadulce", 53, 'H', 94.4, 1.82, "ES98203857789830000161", false),
        new Cliente("Sofía", "Calderón", "C/ Almendros 19", "Benahadux", 35, 'M', 62.0, 1.66, "ES91210004184502000162", false),
        new Cliente("Iván", "Navarro", "C/ Cuatro Vientos 5", "Almería", 41, 'H', 83.2, 1.76, "ES85210008130200000163", false),
        new Cliente("Celia", "Pérez", "C/ Carrizal 12", "Gádor", 22, 'M', 51.1, 1.59, "ES79210002234510000164", false),
        new Cliente("Gonzalo", "Mateo", "C/ Alameda 21", "Pechina", 57, 'H', 89.8, 1.81, "ES20210005982730000165", false),
        new Cliente("Raquel", "Sáez", "C/ Castaño 16", "Roquetas de Mar", 33, 'M', 61.7, 1.68, "ES60203872654100000166", false),
        new Cliente("Beltrán", "Rivas", "C/ Sauce 7", "Huércal de Almería", 38, 'H', 78.1, 1.74, "ES70210008451260000167", false),
        new Cliente("Ariadna", "Solís", "C/ Molino 4", "Viator", 28, 'M', 56.2, 1.63, "ES40203878945630000168", false),
        new Cliente("Mateo", "Esteve", "Av. Alemania 14", "Las Norias", 47, 'H', 88.2, 1.79, "ES11210004589620000169", true),
        new Cliente("Teresa", "Aguilar", "C/ Acacias 8", "Benahadux", 25, 'M', 54.5, 1.62, "ES87210008579610000170", false),
        new Cliente("Julián", "Cano", "C/ Alborán 31", "Almería", 59, 'H', 96.1, 1.83, "ES30203857896520000171", false),
        new Cliente("Mónica", "Sabater", "C/ Morera 9", "Roquetas de Mar", 36, 'M', 63.0, 1.66, "ES73210004412980000172", false),
        new Cliente("Adrián", "Reig", "C/ Fuente 2", "Aguadulce", 42, 'H', 85.4, 1.80, "ES51210004789630000173", false),
        new Cliente("Aitana", "Estévez", "C/ Olivo 11", "Gádor", 24, 'M', 56.8, 1.63, "ES98203876451210000174", false),
        new Cliente("Fermín", "Pastor", "C/ Pino 15", "Huércal de Almería", 33, 'H', 79.6, 1.75, "ES27210005462090000175", false),
        new Cliente("Blanca", "Peña", "C/ Río Verde 6", "Viator", 27, 'M', 53.4, 1.60, "ES20203876541230000176", false),
        new Cliente("Álex", "Domingo", "C/ Jazmín 21", "Benahadux", 46, 'H', 86.5, 1.78, "ES35210004125890000177", true),
        new Cliente("Leticia", "Forte", "C/ Tajo 9", "Almería", 32, 'M', 58.7, 1.64, "ES88210002369870000178", false),
        new Cliente("Nicolás", "Roldán", "Av. Poeta 14", "Roquetas de Mar", 50, 'H', 92.4, 1.82, "ES45210008563240000179", false),
        new Cliente("Verónica", "Llopis", "C/ Bonilla 5", "Pechina", 30, 'M', 60.9, 1.67, "ES11203845896210000180", false),
        new Cliente("Ramón", "Garret", "C/ Maestro 19", "Aguadulce", 49, 'H', 89.9, 1.80, "ES98203857789830000181", false),
        new Cliente("Yaiza", "Lamas", "C/ Olivar 8", "Gádor", 23, 'M', 51.6, 1.58, "ES91210004184502000182", false),
        new Cliente("Santiago", "Ibáñez", "C/ Marino 3", "Viator", 41, 'H', 83.8, 1.77, "ES85210008130200000183", false),
        new Cliente("Noelia", "Mosquera", "C/ Carmona 11", "Benahadux", 28, 'M', 57.0, 1.62, "ES79210002234510000184", false),
        new Cliente("Damián", "Arcos", "Av. Constitución 4", "Almería", 55, 'H', 91.3, 1.81, "ES20210005982730000185", true),
        new Cliente("Silvia", "Jaramillo", "C/ Jardín 40", "Las Norias", 34, 'M', 62.2, 1.66, "ES60203872654100000186", false),
        new Cliente("Gabriel", "Ordóñez", "C/ Cabo 7", "Pechina", 48, 'H', 87.9, 1.79, "ES70210008451260000187", false),
        new Cliente("Pilar", "Carrasco", "C/ Acuario 1", "Roquetas de Mar", 26, 'M', 55.2, 1.61, "ES40203878945630000188", false),
        new Cliente("Leonardo", "Palomar", "C/ Veterano 11", "Huércal de Almería", 39, 'H', 81.5, 1.76, "ES11210004589620000189", false),
        new Cliente("Inés", "Hidalgo", "Av. Europa 30", "Benahadux", 31, 'M', 45, 1.65, "ES87210008579610000190", false)};

        //Tengo un array de 100 clientes

        //Cuento los clientes que tengan lesión
        int lesionados =0;
        for(int i=0; i<clientes.length; i++) { //Recorro el array
            if(clientes[i].getLesion()==true) { //Está lesionado
                lesionados++;
            }
        }
        System.out.println("El número de personas lesionadas es: "+lesionados);

        //Cuento los menores de 25 que hay en el gimnasio
        int menores =0;
        for(Cliente n: clientes) { //Recorro el array
            if(n.getEdad()<25) { //Está lesionado
                menores++;
            }
        }
        System.out.println("El número de personas menores de 25: "+menores);

        //Buscamos el nombre y apellidos de la persona con más edad del gimnasio
        int mayor =0;
        String nombreMayor="", apellidoMayor="";
        for(Cliente n: clientes) { //Recorro el array
            if(n.getEdad()>mayor) { //Es el más mayor hasta el momento
                mayor = n.getEdad();
                nombreMayor=n.getNombre();
                apellidoMayor=n.getApellido();
            }
        }
        System.out.println("La persona con más edad es "+nombreMayor+" "+apellidoMayor+" con "+mayor+" años");

        //Buscamos el nombre y apellidos de la persona con más edad del gimnasio
        int posicionmayor =0;
        mayor = 0;
        for(int i=0; i<clientes.length; i++) { //Recorro el array
            if(clientes[i].getEdad()>mayor) { //Es el más mayor hasta el momento
                mayor = clientes[i].getEdad();
                posicionmayor = i;
            }
        }
        System.out.println("La persona con más edad es "+clientes[posicionmayor].getNombre()+" "+clientes[posicionmayor].getApellido()+" con "+mayor+" años");

        //Listado de nombres, apellidos e IBAN de la gente de Almería menor de 25
        for(Cliente n: clientes) { //Recorro el array
            if(n.getMunicipio()=="Almería" && n.getEdad()<=25) { //Es de Almería y menor de 25
                System.out.println(n.getNombre()+" "+n.getApellido()+" "+n.getIBAN());
            }
        }

        //Listado de nombres, apellidos e IMC de las y los clientes con peso bajo IMC<18,5
        System.out.println("-----Personas con peso bajo-----");
        for(Cliente n: clientes) { //Recorro el array
            if(n.calculaIMC()<18.5) { //Tiene peso bajo
                System.out.println(n.getNombre()+" "+n.getApellido()+" "+n.calculaIMC());
            }
        }

        //Listado de nombres, apellidos e IMC de las y los clientes con sobrepeso IMC>25
        System.out.println("-----Personas con sobrepeso-----");
        for(Cliente n: clientes) { //Recorro el array
            if(n.calculaIMC()>25) { //Tiene peso bajo
                System.out.println(n.getNombre()+" "+n.getApellido()+" "+n.calculaIMC());
            }
        }



    } //Cerramos el main
}

    