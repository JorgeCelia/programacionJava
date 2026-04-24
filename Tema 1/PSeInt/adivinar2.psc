Algoritmo adivinar
	// Definimos las variables
	Definir objetivo Como Entero
	Definir respuesta Como Entero
	// Inicilizamos las variables
	objetivo <- azar(11)
	// Ejecutamos las órdenes
	Repetir
		Escribir 'Dime un número del 0 al 10:'
		Leer respuesta
		Si respuesta<>objetivo Entonces
			Escribir 'No has acertado'
		FinSi
	Hasta Que respuesta=objetivo
	Escribir 'Has acertado, enhorabuena'
FinAlgoritmo
