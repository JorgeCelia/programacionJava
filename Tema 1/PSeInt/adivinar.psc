Algoritmo adivinar
	//Definimos las variables
	Definir objetivo Como Entero
	Definir respuesta Como Entero
	
	//Inicilizamos las variables
	objetivo<-azar(11)
	
	//Ejecutamos las órdenes
	Escribir "Dime un número del 0 al 10:"
	Leer respuesta
	
	Mientras respuesta<>objetivo Hacer //Mientras no acierte, mensaje de error y vuelve a preguntar
		Escribir "No has acertado"
		Escribir "Dime un número del 0 al 10:"
		Leer respuesta
	Fin Mientras
	
	Escribir "Has acertado, enhorabuena"
	
FinAlgoritmo
