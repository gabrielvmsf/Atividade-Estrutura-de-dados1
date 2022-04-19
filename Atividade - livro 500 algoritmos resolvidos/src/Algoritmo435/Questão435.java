//Criar um algoritmo que leia uma matriz 5 x 5 inteira e apresente uma determinada coluna da matriz, solicitada via teclado.

package Algoritmo435;

import java.util.Scanner;

public class Questão435 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int var=5;
        int[][] matriz = new int[var][var];
        int i,j;

        for(i=0;i<matriz.length;i++){
            for(j=0;j<matriz.length;j++){
                System.out.println("["+(i+1)+"]"+"["+(j+1)+"]:");
                matriz[i][j]= scan.nextInt();
            }
        }

        System.out.println("Digite número da coluna(1-5) ou -999 para acabar: ");
        int c = scan.nextInt();
        while(true){
            while(c<1||c>5){
                System.out.println("Digite número da coluna entre 1 - 5: ");
                c = scan.nextInt();
        }
        if(c==-999) break;
    
    c=c-1;
    System.out.println("Coluna:"+(c+1)+"\n");
    for(i=0;i<matriz.length;i++){
        System.out.println(matriz[i][c]+"\n");
        
    }
}
    
}
}
