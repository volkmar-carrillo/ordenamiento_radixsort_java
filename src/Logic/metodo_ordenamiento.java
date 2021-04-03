/**
*MÉTODO RADIXSORT IMPLEMENTADO CON MATRIZ DE REFERENCIA Y VECTORES ESTÁTICOS
*By: Volkmar A Carrillo P 
*e-mail: carrillo.ramklov@gmail.com
*fecha-publicación: 02/04/2021
**/
package Logic;

public class metodo_ordenamiento {

    //Atributos
    private int[][] matriz;

    //Constructor
    metodo_ordenamiento() {
        System.out.println("¡Estructuras de Datos Dinámicos y Algoritmos - Método de Ordenamiento RadixSort!");
    }

    //Métodos
    public String RadixSort(int[] vectorDesordenado) {
        //Definimos la matriz a trabajar
        definirDimensiones(vectorDesordenado);
        //Evalua cuando se toma la unidad, decena, centena, ...
        int numEvaluar = 1, pos;
        String retorno = mostrar(vectorDesordenado, "***VECTOR A ORDENAR***");

        //Se realizan las 6 iteraciones de la filosofia del metodo
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < vectorDesordenado.length; j++) {
                //Digito evaluar
                pos = ((int) (vectorDesordenado[j] / numEvaluar)) % 10;
                //Asignamos el valor en la posicion [pos, matriz[i,0]]
                matriz[pos][matriz[pos][0]] = vectorDesordenado[j];
                //Actualizamos el valor de la columna 0
                matriz[pos][0]++;
            }
            numEvaluar *= 10;
            //Actualizar el vector desordenado
            actualizarVectorDesordenado(vectorDesordenado);
            definirDimensiones(vectorDesordenado);
        }
        retorno += "\n" + mostrar(vectorDesordenado, "***VECTOR ORDENADO POR RADIXSORT***");
        retorno += "By: Volkmar Carrillo";
        return (retorno);
    }

    private void definirDimensiones(int[] vector) {
        int filas = 10;
        int columnas = vector.length + 1;

        matriz = new int[filas][columnas];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < columnas; j++) {
                if (j == 0) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = -1;
                }
            }
        }
    }

    private void actualizarVectorDesordenado(int[] vectorDesordenado) {
        int indice = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 1; j < matriz[0].length; j++) {
                if (matriz[i][j] != -1) {
                    vectorDesordenado[indice] = matriz[i][j];
                    indice = indice + 1;
                }
            }
        }
    }

    private String mostrar(int[] vector, String cadena) {
        String show = "";
        show += cadena + "\n[ ";
        for (int i = 0; i < vector.length - 1; i++) {
            //show += "[ " + vector[i] + " ]\n";
            show += vector[i] + ", ";
        }
        show += vector[vector.length - 1] + " ]\n\n";
        return (show);
    }
}