Algoritmo salida
	//Declaro las variables
	Definir nombre Como Cadena
	Definir edad Como Entero
	Definir volver Como Cadena
	//Inicializamos las variables		
	volver<-"si"
	
	//Ejecutamos el bucle
	Mientras volver="si" Hacer
		//Pido los datos al usuario
		Escribir "¿Cómo te llamas?"
		Leer nombre
		Escribir "¿Qué edad tienes?"
		Leer edad
		
		Escribir "Hola, ",nombre," tienes ",edad," años"
		
		Escribir "¿Desea volver a ejecutar? (si/no)"
		Leer volver
	Fin Mientras
	

	
FinAlgoritmo
