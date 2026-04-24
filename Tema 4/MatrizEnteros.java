/*
Clase MatrizEnteros
 */

class MatrizEnteros {
    //Definición de los atributos
    private int[][] matriz;

    //Defino el constructor
    public MatrizEnteros(int filas, int columnas) {
        matriz = new int[filas][columnas];
    }

    public void muestraMatriz() { //Nos muestra el contenido de la matriz
        System.out.println("Filas: "+matriz.length);

        for(int i=0; i<matriz.length; i++) { //Recorro las filas
            for (int j=0; j<matriz[i].length; j++) { //Para cada fila, recorro sus columnas
                System.out.print(matriz[i][j]+"\t");
                //System.out.print("Fila: "+i+" Columna: "+j+" ");
            }
            System.out.println();
        }
    }

    public void rellenaMatrizAleatoria(int n) { //rellena la matriz con números aleatorios entre 1 y n
        for(int i=0; i<matriz.length; i++) { //Recorro las filas
            for (int j=0; j<matriz[i].length; j++) { //Para cada fila, recorro sus columnas
                matriz[i][j] = (int)(Math.random()*n+1);
            }
        }
    }

    public void insertaValor(int valor, int fila, int columna) { //Inserta el valor en la posición dada por la fila y la columna
        matriz[fila][columna] = valor;
    }

    public int buscaMayor() { //Devuelve el mayor valor dentro de la matriz
        int mayor = matriz[0][0];
        for(int i=0; i<matriz.length; i++) { //Recorro las filas
            for (int j=0; j<matriz[i].length; j++) { //Para cada fila, recorro sus columnas
                if(matriz[i][j]>mayor) { //Encuentro un número más grande
                    mayor = matriz[i][j];
                }
            }
        }
        return mayor;
    }

    public int buscaMenor() { //Devuelve el menor valor dentro de la matriz
        int menor = matriz[0][0];
        for(int i=0; i<matriz.length; i++) { //Recorro las filas
            for (int j=0; j<matriz[i].length; j++) { //Para cada fila, recorro sus columnas
                if(matriz[i][j]<menor) { //Encuentro un número más pequeño
                    menor = matriz[i][j];
                }
            }
        }
        return menor;
    }

    public void muestraFila(int fila) { //Muestra el contenido de la fila que pasemos como parámetro
        System.out.println("Fila: "+fila);       
        for(int i=0; i<matriz[fila].length; i++) { //Recorro la fila indicada
            System.out.print(matriz[fila][i]+"\t");
        }
        System.out.println();
    }

    public void muestraColumna(int columna) { //Muestra el contenido de la columna que pasemos como parámetro
        System.out.println("Columna: "+columna);       
        for(int i=0; i<matriz.length; i++) { //Recorro las filas y saco el elemento de la columna indicada
            System.out.print(matriz[i][columna]+"\t");
        }
        System.out.println();
    }
}
