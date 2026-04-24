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
	

	//Ejecutamos el bucle
	Si inicio>tope Entonces
		Escribir "El inicio es mayor que el final. Saliendo..."
	SiNo
		Para contador<-inicio Hasta tope Con Paso 1 Hacer
			Si contador%2=0 Entonces //El número es par
				Escribir contador
			Fin Si
		Fin Para
		
	Fin Si
FinAlgoritmo
