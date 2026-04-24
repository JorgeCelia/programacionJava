Algoritmo Operaciones
	//Definimos las variables
	Definir operador1 Como Entero
	Definir operador2 Como Entero
	Definir resultado Como Entero
	Definir resultadoDiv Como Real
	//Pedimos al usuario los operadores
	Escribir "Introduce el primer operador"
	Leer operador1
	Escribir "Introduce el segundo operador"
	Leer operador2
	//Calculamos las soluciones y las mostramos por pantalla
	resultado<-operador1+operador2
	Escribir "La suma de los dos números es: ",resultado
	
	resultado<-operador1-operador2
	Escribir "La resta de los dos números es: ",resultado
	
	resultado<-operador1*operador2
	Escribir "La multiplicación de los dos números es: ",resultado
	
	resultadoDiv<-operador1/operador2
	Escribir "La división de los dos números es: ",resultadoDiv
	
	resultado<-operador1%operador2
	Escribir "El resto de dividir los dos números es: ",resultado

FinAlgoritmo
