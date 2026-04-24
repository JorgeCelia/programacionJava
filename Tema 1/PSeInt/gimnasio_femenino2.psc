Algoritmo gimnasio_femenino
	//Definimos las variables
	Definir nombre como Cadena
	Definir edad Como Entero
	Definir sexo Como Caracter
	Definir entrenamiento como Cadena
	
	//Pedimos los datos
	Escribir "Dime tu nombre:"
	Leer nombre
	Escribir "¿Cuál es tu edad?"
	Leer edad
	Escribir "¿Eres hombre o mujer? (H/M)"
	Leer sexo
	Escribir "¿Qué tipo de entrenamiento quieres? (Pilates/Mantenimiento/Crossfit)"
	Leer entrenamiento
	
	//Comprobamos si puede entrar o no
	Si sexo="M" y edad>=18 Entonces
		//Puede entrar al gimnasio
		Si entrenamiento="Pilates" Entonces
			Escribir "Ve a la Sala 1"
		SiNo
			Si entrenamiento="Mantenimiento" Entonces
				Escribir "Ve a la Sala 2"
			SiNo
				Escribir "Ve a la Sala 3"
			Fin Si
		Fin Si
	SiNo
		Escribir "No puedes entrar..."
	Fin Si

FinAlgoritmo
