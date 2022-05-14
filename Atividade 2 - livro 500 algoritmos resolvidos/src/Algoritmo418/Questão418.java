//Entrar com valores inteiros para uma matriz A[4] [4] e para uma matriz 8[4] [4]. 
//Gerar e imprimir a matriz SOMA [4] [4]. 

package Algoritmo418;

import java.util.Scanner;

public class Questão418 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] MatrizA = new int[2][2];
        int[][] MatrizB = new int[MatrizA.length][MatrizA.length];
        int[][] MatrizSoma = new int[MatrizA.length][MatrizA.length];
        int i,j;
        System.out.println("Matriz A: \n");
        for(i=0;i<MatrizA.length;i++){
            for(j=0;j<MatrizA.length;j++){
                System.out.println("["+(i+1)+"]"+"["+(j+1)+"]:");
                MatrizA[i][j]= scan.nextInt();
            }
        }
        System.out.println("Matriz B: \n");
        for(i=0;i<MatrizB.length;i++){
            for(j=0;j<MatrizB.length;j++){
                System.out.println("["+(i+1)+"]"+"["+(j+1)+"]:");
                MatrizB[i][j]= scan.nextInt();
            }
        }
        for(i=0;i<MatrizB.length;i++){
            for(j=0;j<MatrizB.length;j++){
                MatrizSoma[i][j]=MatrizA[i][j]+MatrizB[i][j];
            }
        }
        System.out.println("Matriz A: \n");
        for(i=0;i<MatrizB.length;i++){
            for(j=0;j<MatrizB.length;j++){
                System.out.println(MatrizA[i][j]+"     ");
            }
            System.out.println("\n");
        }
        System.out.println("Matriz B: \n");
        for(i=0;i<MatrizB.length;i++){
            for(j=0;j<MatrizB.length;j++){
                System.out.println(MatrizB[i][j]+"     ");
            }
        }
        System.out.println("Matriz Soma: \n");
        for(i=0;i<MatrizB.length;i++){
            for(j=0;j<MatrizB.length;j++){
                System.out.println(MatrizSoma[i][j]+"     ");
            }
        }
    }
}
