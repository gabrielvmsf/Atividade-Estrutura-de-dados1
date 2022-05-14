/*Uma floricultura conhecedora de sua clientela gostaria de fazer um algoritmo 
que pudesse controlar sempre um estoque mínimo de determinadas plantas, 
pois todo dia, pela manhã, o dono faz novas aquisições. Criar um algoritmo que 
deixe cadastrar50 tipos de plantas e nunca deixar o estoque ficarabaixo do ideal. */

package Algoritmo425;

import java.util.Scanner;

public class Questão425 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] qtde = new int[3][3];
        String[] nome = new String[3];

        for(int i=0;i<nome.length;i++){
            System.out.println("digite nome da "+ (i + 1) +" planta: ");
            nome[i]=scan.next();
            
            System.out.println("digite quantidade em estoque: ");
            qtde[i][0]=scan.nextInt();

            System.out.println("digite a quantidade ideal: ");
            qtde[i][1]=scan.nextInt();

            if(qtde[i][0]<qtde[i][1]){
                qtde[i][2]=qtde[i][1]-qtde[i][0];
            } else qtde[i][2]=0;
        }

        for(int i=0;i<5;i++){
            System.out.println("\n"+nome[i]+"-"+qtde[i][2]);
            System.out.println("\n");
        }
    }
}