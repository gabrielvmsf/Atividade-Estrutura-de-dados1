/*Criar um algoritmo que declare uma matriz 5 x 5 e armazene em um vetor o maior 
elemento cadastrado em cada coluna da matriz e em um vetor o menor elemento cadastrado em cada coluna da matriz. Imprima: 
m toda a matriz; 
o vetor a; 
m o vetor b; 
m (a + b)/2. */

package Algoritmo445;

import java.util.Scanner;

public class Questão445 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matriz = new int[5][5];
        int[] matrizmenor = new int[5];
        int[] matrizmaior = new int[5];
        int i, j,cont;
        int  maior,menor;
        for(i=0;i<matriz.length;i++){
            for(j=0;j<5;j++){
                System.out.println("["+(i+1)+"]"+"["+(j+1)+"]:");
                matriz[i][j]= scan.nextInt();
            }
        }
        for(i=0;i<matriz.length;i++){
            maior = matriz[0][i];
            menor = matriz[0][i];
            for(j=0;j<5;j++){
                if(matriz[j][i]>maior) maior = matriz[j][i];
                else if (matriz[j][i]<menor) menor = matriz[j][i];
            }
            matrizmaior[i] = maior;
            matrizmenor[i] = menor;
        }
        System.out.println("Toda a matriz\n");
        for(i=0;i<matriz.length;i++){
            for(j=0;j<5;j++){
                System.out.println(matriz[i][j]);
            }
        }
        System.out.println("Maiores elementos:\n");

        for(i=0;i<matriz.length;i++){
            System.out.println(matrizmaior[i]);
        }
        System.out.println("Menores elementos:\n");

        for(i=0;i<matriz.length;i++){
            System.out.println(matrizmenor[i]);
        }
        System.out.println("Resultados:\n");
        for(i=0;i<matriz.length;i++){
            System.out.println((matrizmaior[i]+matrizmenor[i])/2+"\n");
        }
    }
}
