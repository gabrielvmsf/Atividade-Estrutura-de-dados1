/*Criar um algoritmo que armazene dados inteiros em uma matriz de ordem cinco e 
imprima:. toda a matriz e uma outra matriz formada pelos números que se encontram em posições cuja linha mais coluna formam um numero par 
*/

package Algoritmo412;

import java.util.Scanner;

public class Questão412 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] Matriz = new int[2][2];
        int i,j;

        for(i=0;i<Matriz.length;i++){
            for(j=0;j<Matriz.length;j++){
                System.out.println("["+(i+1)+"]"+"["+(j+1)+"]:");
                Matriz[i][j]= scan.nextInt();
            }
        }
        System.out.println("Matriz normal:");
        for(i=0;i<Matriz.length;i++){
            //System.out.println("\n");
            for(j=0;j<Matriz.length;j++){
                System.out.println(Matriz[i][j]);
            }
        }
        System.out.println("\noSo os elementos nas posicoes cuja num par");
        for(i=0;i<Matriz.length;i++){
            //System.out.println("\n");
            for(j=0;j<Matriz.length;j++){
                if((i + j) % 2 ==0){
                    System.out.println(Matriz[i][j]);
                }
            }
        }
    }
}
