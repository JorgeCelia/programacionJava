//Defino las funciones
Funcion resultado <- esMultiplo ( num1, num2 )
	Si num1%num2=0 Entonces //num1 es múltiplo de num2
		resultado<-Verdadero
	SiNo
		resultado<-Falso
	Fin Si
Fin Funcion

Algoritmo esMult
	//Definimos las variables
	Definir dato1 Como Entero
	Definir dato2 Como Entero
	
	//Pedimos los datos
	Escribir "Introduce el primer número"
	Leer dato1
	Escribir "Introduce el segundo número"
	Leer dato2
	
	Si esMultiplo(dato1,dato2)=Verdadero Entonces
		Escribir dato1," es múltiplo de ",dato2
	SiNo
		Escribir dato1," no es múltiplo de ",dato2
	Fin Si
	
FinAlgoritmo
