Algoritmo notas_case
	//Definimos las variables
	Definir asignatura como Cadena
	Definir nota como Entero
	
	//Pedimos los datos
	Escribir "Dime la asignatura:"
	Leer nombre
	Escribir "¿Qué nota has sacado?"
	Leer nota
	
	//Comprobamos la nota
	Si nota<5 Entonces
		Escribir "Estás suspenso"
	SiNo
		Si nota<7 Entonces
			Escribir "Tienes un aprobado"
		SiNo
			Si nota<9 Entonces
				Escribir "Tienes un notable"
			SiNo
				Escribir "Tienes un sobresaliente"
			Fin Si
		Fin Si
	Fin Si	
	
FinAlgoritmo
