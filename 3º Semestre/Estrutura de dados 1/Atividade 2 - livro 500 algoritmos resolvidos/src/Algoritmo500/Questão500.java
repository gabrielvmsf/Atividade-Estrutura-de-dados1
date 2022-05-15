/*Uma editora envia remessas, para cada estado do Brasil e para o DF, sempre em pacotes com 100 livros O numero de pacotes enviados por vez depende de cada esta 
do/DF Observaras tabelas a seguir e fazer um algoritmo que deixe o usuario entrar 
com os dados para as duas matrizes e depois escolher se deseja imprimir todos os 
dados, os totais para um dos tipos, mensalmente, totais de todos os tipos em um 
mês. Sabe-se que a segunda tabela contém o número de pacotes, estipulado pela 
editora no envio de cada remessa para cada estado/DF por tipo e a primeira contém o número de remessas feitas por mês para cada estado/DF, e que, em cada remessa, todos os tipos são enviados. A consulta poderá ser feita várias vezes.*/

package Algoritmo500;

import java.util.Scanner;

public class Questão500 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] tabela2 = new int[7][27];
        int[][] tabela1 = new int[27][3];
        int[][] tabela = new int [7][3];
        int L,c,m,op,tipo,mes;
        for(L=0;L<7;L++){
            for(c=0;c<27;c++){
                System.out.println("\tipo:"+(L+1)+" estado: "+(c+1));
                tabela2[L][c] = scan.nextInt();
            }
        }
        for(L=0;L<27;L++){
            for(c=0;c<3;c++){
                System.out.println("estado: "+(L+1)+" mes: "+(c+1));
                tabela1[L][c] = scan.nextInt();
            }
        }
        
        for(L=0;L<7;L++){
            for(c=0;c<3;c++){
                tabela[L][c]=0;
                for(m=0;m<27;m++){
                    tabela[L][c]=tabela[L][c]+tabela2[L][m]*tabela1[m][c];
                }
            }
        }
        do
        {
            System.out.println("Escolha a impressao");
            System.out.println("\n1 - Todos os dados");
            System.out.println("\n2 - Um tipo mensalmente");
            System.out.println("\n3 - Todos os tipos por mes");
            System.out.println("\n4 - Sair");
            System.out.println("\nOpção");
            op = scan.nextInt();
            switch(op){
            case 1:
            System.out.println("JAN FEV MAR");
            for(L=0;L<7;L++){
                System.out.println((L+1+"\n"));
                for(c=0;c<3;c++){
                    System.out.println(tabela[L][c]+"\n");
                }
            }
            break;
            case 2:
            System.out.println("Digite tipo:");
            tipo = scan.nextInt();
            while(tipo<1||tipo>7){
                System.out.println("TIPO INVALIDO. digite tipo (1-7):");
                tipo = scan.nextInt();
            }
            for(c=0;c<3;c++){
                System.out.println(tabela[tipo][c]+"\n");
            }
            break;
            case 3:
            System.out.println("Digite mes (1 jan 2 Fev 3 Mar):");
            mes = scan.nextInt();
            while(mes<1||mes>3){
                System.out.println("\nMes Invalido. Digite mes (1 Jan 2 Fev 3 Mar): ");
                mes = scan.nextInt();
            }
            for(L=0;L<7;L++);{
                System.out.println("\n"+tabela[L][mes]);
            }
            break;
            case 4:
            System.out.println("Fim");
            break;
        }
    } while(op == 4);
    }
}
