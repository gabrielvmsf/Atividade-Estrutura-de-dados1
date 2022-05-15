/*5. Crie um programa em Java que permite o usuário digitar quantos números inteiros ele queira. 
Ao final, ao digitar -1, o programa deve exibir:
○ A quantidade de números digitados pelo usuário;
○ O maior número digitado;
○ O menor número digitado;
○ A média dos números digitados
*/

import java.util.Scanner;

public class Valores {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a quantidade de números desejada: (digite -1 para encerrar a aplicação)");
        int Valor = 0, Menor = 2147483647, Maior = -2147483648, Soma = 0;
        short  QtdNum = 0;
        
        while(true){
            Valor = scan.nextInt();
            if (Valor==-1){
                break;
            }
            QtdNum++;
            if (Menor>=Valor) {
                Menor = Valor;
            }
            if(Maior<=Valor){
                Maior = Valor;
            }
            Soma += Valor;
        }
        float Media = Soma/QtdNum;

        System.out.println("O programa registrou "+QtdNum+" números");
        System.out.println("O maior número digitado foi "+Maior);
        System.out.println("O menor número digitado foi "+Menor);
        System.out.println("A média dos números digitados foi "+Media);
    }
}