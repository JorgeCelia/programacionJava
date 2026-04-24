Funcion pintaAsteriscos ( dato )
	//Dibuja tantos asteriscos como valor haya en el dato
	Para contador<-1 Hasta dato Con Paso 1 Hacer
		Escribir "*"
	Fin Para
Fin Funcion

Algoritmo DibujaAsteriscos
	//Definimos las variables
	Definir cantidad Como Entero
	
	//Preguntamos al usuario
	Escribir "¿Cuántos astericos quieres dibujar en pantalla?"
	Leer cantidad
	
	pintaAsteriscos(cantidad)
	
FinAlgoritmo
