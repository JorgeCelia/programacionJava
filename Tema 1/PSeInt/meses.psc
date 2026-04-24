Algoritmo meses
	//Definimos las variables
	Definir mes Como Entero
	
	//Pedimos los datos
	Escribir "Introduce un número de mes:"
	Leer mes
	
	Si mes=1 Entonces
		Escribir "Has escrito el mes de Enero"
		Escribir "Pertenece al invierno"
	SiNo
		Si mes=2 Entonces
			Escribir "Has escrito el mes de Febrero"
			Escribir "Pertenece al invierno"
		SiNo
			Si mes=3 Entonces
				Escribir "Has escrito el mes de Marzo"
				Escribir "Pertenece al invierno"
			SiNo
				acciones_por_falso
			Fin Si
			acciones_por_falso
		Fin Si
		acciones_por_falso
	Fin Si
	
	
	Segun mes Hacer
		1:
			Escribir "Has escrito el mes de Enero"
			Escribir "Pertenece al invierno"
		2:
			Escribir "Has escrito el mes de Febrero"
			Escribir "Pertenece al invierno"
		3:
			Escribir "Has escrito el mes de Marzo"
			Escribir "Pertenece al invierno"
		4:
			Escribir "Has escrito el mes de Abril"
			Escribir "Pertenece al primavera"
		5:
			Escribir "Has escrito el mes de Mayo"
			Escribir "Pertenece al primavera"
		6:
			Escribir "Has escrito el mes de Junio"
			Escribir "Pertenece al primavera"
		7:
			Escribir "Has escrito el mes de Julio"
			Escribir "Pertenece al verano"
		8:
			Escribir "Has escrito el mes de Agosto"
			Escribir "Pertenece al verano"
		9:
			Escribir "Has escrito el mes de Septiembre"
			Escribir "Pertenece al verano"
		10:
			Escribir "Has escrito el mes de Octubre"
			Escribir "Pertenece al otoño"
		11:
			Escribir "Has escrito el mes de Noviembre"
			Escribir "Pertenece al otoño"
		12:
			Escribir "Has escrito el mes de Diciembre"
			Escribir "Pertenece al otoño"
		De Otro Modo:
			Escribir "Has escrito un mes incorrecto"
	Fin Segun
	
FinAlgoritmo
