//Armazenar nomes e notas das PR 1 e PR2 de 15 alunos. Calcular e armazenar a média arredondada. Armazenar também a situação do aluno: AP ou RP. Imprimir 
//uma listagem contendo nome notas media e situação de cada aluno tabulando

package Algoritmo356;

import java.util.Scanner;

public class Questão356 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] NomeAlunos = new String[15];
        float[] Nota1 = new float[NomeAlunos.length];
        float[] Nota2 = new float[NomeAlunos.length];
        int[] média = new int[NomeAlunos.length];
        String[] Situação = new String[NomeAlunos.length];
        int i;
        float média1;

        System.out.println("Digite o nome de 15 alunos:");
        
        for (i = 0; i < NomeAlunos.length; i++){
            NomeAlunos[i] = scan.next();
        }

        for (i = 0; i < NomeAlunos.length; i++){
            System.out.println("\nDigite a nota da prova 1 do Aluno(a) "+NomeAlunos[i]+" :");
            Nota1[i] = scan.nextFloat();
            System.out.println("Digite a nota da prova 2 do Aluno(a) "+NomeAlunos[i]+" :");
            Nota2[i] = scan.nextFloat();
        }
        for (i = 0; i < NomeAlunos.length; i++){
            média1 = (Nota1[i]+ Nota2[i])/2;
            média[i] = Math.round(média1); //arredondar

            if(média[i]>=6) Situação[i] = "Aprovado";
            else Situação[i] = "Reprovado";

            System.out.println("\nO(a) aluno(a) "+NomeAlunos[i]+" com notas "+Nota1[i]+" e "+Nota2[i]+" possui média de "+média[i]+" e sua situação é: "+Situação[i]);
        }
    }
}