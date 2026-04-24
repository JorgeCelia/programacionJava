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
	Segun nota Hacer
		1:
			Escribir "Estás suspenso"
		2:
			Escribir "Estás suspenso"
		3:
			Escribir "Estás suspenso"
		4:
			Escribir "Estás suspenso"
		5:
			Escribir "Tienes un aprobado"
		6:
			Escribir "Tienes un aprobado"
		7:
			Escribir "Tienes un notable"
		8:
			Escribir "Tienes un notable"
		De Otro Modo:
			Escribir "Tienes un sobresaliente"
	Fin Segun
	
	
FinAlgoritmo
