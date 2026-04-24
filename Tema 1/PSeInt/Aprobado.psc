Algoritmo MayorEdad
	//Definimos las variables
	Definir asignatura Como Cadena
	Definir nota Como Real
	
	//Pedimos los datos
	Escribir "Dime la asignatura"
	Leer asignatura
	Escribir "Dime la nota que has sacado"
	Leer nota
	
	//Comprobamos si ha aprobado
	Si nota>=5 Entonces
		Escribir "Has aprobado "+asignatura
	SiNo
		Escribir "Has suspendido "+asignatura
	Fin Si
	
	Escribir "Fin del programa..."
	
FinAlgoritmo
