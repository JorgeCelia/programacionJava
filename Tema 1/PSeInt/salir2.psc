Algoritmo salida
	//Declaro las variables
	Definir nombre Como Cadena
	Definir edad Como Entero
	Definir volver Como Logico
	Definir respuesta como Cadena
	//Inicializamos las variables		
	volver<-Verdadero
	
	//Ejecutamos el bucle
	Mientras volver=Verdadero Hacer
		//Pido los datos al usuario
		Escribir "¿Cómo te llamas?"
		Leer nombre
		Escribir "¿Qué edad tienes?"
		Leer edad
		
		Escribir "Hola, ",nombre," tienes ",edad," años"
		
		Escribir "¿Desea volver a ejecutar? (si/no)"
		Leer respuesta
		Si respuesta="si" Entonces
			volver<-Verdadero
		SiNo
			volver<-Falso
		Fin Si
	Fin Mientras
	

	
FinAlgoritmo
