Funcion resultado <- centigrados_a_fahrenheit ( dato )
	//Transforma el dato dado en grados Centígrados a grados Fahrenheit
	resultado<-(dato*9/5)+32
Fin Funcion

Funcion resultado <- fahrenheit_a_centigrados ( dato )
	//Transforma el dato dado en grados Fahrenheit a grados Centígrados
	resultado<-(dato-32)*5/9
Fin Funcion

Algoritmo ConversionTemperatura
	//Definimos las variables
	Definir temperatura Como Real
	Definir escala Como Caracter
	
	//Pedimos los datos al usuario/a
	Escribir "¿Qué temperatura quieres convertir?"
	Leer temperatura
	Escribir "¿En qué unidades está expresada? (f-Fahrenheit c-Grados centígrados)"
	Leer escala
	
	//Transformo la información dada
	Si escala='f' Entonces
		Escribir temperatura, "ºF son ",fahrenheit_a_centigrados(temperatura),"ºC"
	SiNo
		Escribir temperatura, "ºC son ",centigrados_a_fahrenheit(temperatura),"ºF"
	Fin Si
	
FinAlgoritmo