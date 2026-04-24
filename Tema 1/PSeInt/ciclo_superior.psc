Algoritmo ciclo_superior
	//Definimos las variables
	Definir nombre como Cadena
	Definir estudios como Cadena
	
	//Pedimos los datos
	Escribir "Dime tu nombre:"
	Leer nombre
	Escribir "¿Cuáles son tus estudios? (FP Medio/Bachillerato/ESO)"
	Leer estudios
	
	//Comprobamos si cumple las condiciones
	Si estudios="FP Medio" o estudios="Bachillerato" Entonces
		Escribir "Puedes matricularte en el ciclo superior"
	SiNo
		Escribir "No puedes matricularte en el ciclo superior"
	Fin Si

FinAlgoritmo
