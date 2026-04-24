//Defino las funciones
Funcion resultado <- esPar ( num )
	Si num%2=0 Entonces
		resultado<-Verdadero
	SiNo
		resultado<-Falso
	Fin Si
Fin Funcion

Algoritmo esNumeroPar
	//Definimos las variables
	Definir dato Como Entero
	
	//Pedimos los datos
	Escribir "Introduce el primer número"
	Leer dato
	
	Si esPar(dato)=Verdadero Entonces
		Escribir "Es par"
	SiNo
		Escribir "Es impar"
	Fin Si
	
FinAlgoritmo
