Algoritmo MayorEdad
	//Definimos las variables
	Definir nombre Como Cadena
	Definir edad Como Entero
	
	//Pedimos los datos
	Escribir "Dime tu nombre"
	Leer nombre
	Escribir "Dime tu edad"
	Leer edad
	
	//Comprobamos si es mayor de edad
	Si edad>=18 Entonces
		Escribir "Hola "+nombre+" eres mayor de edad"
	SiNo
		Escribir "Hola "+nombre+" eres menor de edad"		
	Fin Si
	
	Escribir "Fin del programa..."
	
FinAlgoritmo
