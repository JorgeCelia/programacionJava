Funcion resultado <- diaSemana ( num )
	Segun num Hacer //Devuelvo el día de la semana correspondiente a num
		1:
			resultado<-"Lunes"
		2:
			resultado<-"Martes"
		3:
			resultado<-"Miércoles"
		4:
			resultado<-"Jueves"
		5:
			resultado<-"Viernes"
		6:
			resultado<-"Sábado"
		7:
			resultado<-"Domingo"
		De Otro Modo:
			resultado<-"ERROR"
	Fin Segun
Fin Funcion


Algoritmo diaSem
	//Defino las variables
	Definir dia como Entero
	
	//Pido los datos
	Repetir
		Escribir "Introduce un número del 1 al 7:"
		Leer dia
	Hasta Que dia>=1 y dia <=7
	
	//Devuelvo resultados
	Escribir "El día de la semana que has introducido es ",diaSemana(dia)
FinAlgoritmo
