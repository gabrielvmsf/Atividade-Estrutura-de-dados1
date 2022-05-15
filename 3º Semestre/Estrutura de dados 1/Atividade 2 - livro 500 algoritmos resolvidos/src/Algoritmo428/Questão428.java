/*A matriz dados contém na 1 coluna a matrícula do aluno; na 2, o sexo (0 para 
feminino e 1 para masculino); na 3 o código do curso, e na 4 o CR. 
Faça um algoritmo que armazene esses dados sabendo-se que: 
E o código do curso e uma parte da matrícula: aascccnnn (aa ano, s 
semestre, ccc código do curso e nnn matrícula no curso) 
Um grupo empresarial resolveu premiar a aluna com CR mais alto de um curso 
cujo código deverá ser digitado. Suponha 10 alunos e que o CR é um n2inteiro. */

package Algoritmo428;

import java.util.Scanner;

public class Questão428 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matriz = new int[2][4];
        int i, aux, codigo;
        for(i=0;i<matriz.length;i++){
            System.out.println("\ndigite matricula no formato aascccnnn: ");
            matriz[i][0]=scan.nextInt();
            aux = matriz[i][0] / 1000000;
            aux = matriz[i][0]-aux*1000000;
            matriz[i][2]=aux/1000;

            System.out.println("\nndigite sexo (0 fem 1 masc): ");
            matriz[i][1]=scan.nextInt();

            System.out.println("\ndigite CR do aluno:");
            matriz[i][3]=scan.nextInt();
        }
        System.out.println("\ndigite codigo do curso:");
        codigo=scan.nextInt();
        int pos=0;

        for(i=0;i<matriz.length;i++){
            if(matriz[i][2]==codigo && matriz[i][1]==0){
                pos=i;
            } else if(matriz [i][3] >matriz [pos] [3]){
                pos =i;
            }
        }
        System.out.println("Aluna premiada matricula: "+matriz[pos][0]+" teve CR:"+matriz[pos][3]);
    }
}
