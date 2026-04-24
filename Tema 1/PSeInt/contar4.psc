Algoritmo contar
	//Declaro las variables
	Definir contador Como Entero
	Definir tope Como Entero
	Definir inicio Como Entero
	
	//Pido los datos al usuario
	Escribir "Indica el número desde el que quieres que cuente:"
	Leer inicio
	Escribir "Indica el número hasta el que quieres que cuente:"
	Leer tope
	
	//Inicializamos las variables	
	contador<-inicio

	//Ejecutamos el bucle
	Si inicio>tope Entonces
		Escribir "El inicio es mayor que el final. Saliendo..."
	SiNo
		Repetir
			Escribir contador
			contador <- contador+1
		Hasta Que contador>tope
		
//		Mientras contador<=tope Hacer
//			Escribir contador
//			contador <- contador+1
//		Fin Mientras
	Fin Si
FinAlgoritmo
