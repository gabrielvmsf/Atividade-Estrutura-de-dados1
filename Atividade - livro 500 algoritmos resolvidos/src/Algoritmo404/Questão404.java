/*Criar um algoritmo que leia os elementos de matriz inteira 10 x 10 e escreva somente os elementos acima da diagonal principal */

package Algoritmo404;

import java.util.Scanner;

public class Questão404 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] Matriz = new int[3][3];
        int i,j;
        for(i=0;i<Matriz.length;i++){
            for(j=0;j<Matriz.length;j++){
                System.out.println("["+(i+1)+"]"+"["+(j+1)+"]:");
                Matriz[i][j]= scan.nextInt();
            }
        }
        System.out.println("\nACIMA DA DIAGONAL PRINCIPAL\n");
        for(i=0;i<=(Matriz.length)-1;i++){
            for(j=i+1;j<=Matriz.length;j++){
                System.out.println("\n"+Matriz[i][j]);
            }
        }
    }
}
