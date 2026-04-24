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
	
	//Comprobamos si puede entrar o no
	Si sexo="M" y edad>=18 Entonces
		Escribir "¿Qué tipo de entrenamiento quieres? (Pilates/Mantenimiento/Crossfit)"
		Leer entrenamiento
		//Puede entrar al gimnasio
		Segun entrenamiento
			"Pilates":
				Escribir "Ve a la Sala 1"
			"Mantenimiento":
				Escribir "Ve a la Sala 2"
			"Crossfit":
				Escribir "Ve a la Sala 3"
			De Otro Modo:
				Escribir "Te has equivocado"
		Fin Segun
	
	SiNo
		Escribir "No puedes entrar..."
	Fin Si

FinAlgoritmo
