/**
*MÉTODO RADIXSORT IMPLEMENTADO CON MATRIZ DE REFERENCIA Y VECTORES ESTÁTICOS
*By: Volkmar A Carrillo P 
*e-mail: carrillo.ramklov@gmail.com
*fecha-publicación: 02/04/2021
**/
package Logic;
public class RadixSort {
    
    public static void main(String[] args){
        metodo_ordenamiento RS = new metodo_ordenamiento();
        int []vectorOrdenar = {5, 48, 21, 10, 0, 30735, 899, 77, 976};
        System.out.println(RS.RadixSort(vectorOrdenar));
    }
}
