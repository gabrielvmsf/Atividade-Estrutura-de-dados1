/*Criar um algoritmo que carregue uma matriz 12 x 4 com os valores das vendas de 
uma loja, em que cada linha represente um mês do ano, e cada coluna, uma semana do mês. Calcule e imprima: 
total vendido em cada mês do ano; 
total vendido em cada semana durante todo o ano; 
m total vendido no ano.*/

package Algoritmo440;

import java.util.Scanner;

public class Questão440 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float[][] matriz = new float[12][4];
        float totalmes, totalano, totalsem;
        int i,j;

        for(i=0;i<matriz.length;i++){
            for(j=0;j<4;j++){
                System.out.println("Mês: "+(i+1)+" Semana: "+(j+1));
                matriz[i][j]= scan.nextInt();
            }
        }
            totalano = 0;

            for(i=0;i<12;i++){
                totalmes=0;
                for(j=0;j<4;j++){
                    totalmes+=matriz[i][j];
                }
                System.out.println("total do mes "+(i+1)+" = "+totalmes);
                totalano+=totalmes;
            }

            for(j=0;j<4;j++){
                totalsem=0;
                for(i=0;i<12;i++){
                    totalsem+=matriz[i][j];
                }
                System.out.println("total da semana "+(j+1)+" = "+totalsem);
            }
            System.out.println("total do ano = "+totalano);
        }
    }
