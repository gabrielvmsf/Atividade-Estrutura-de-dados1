/*2. Um caixa eletrônico opera com notas de 50, 10, 5 e 1. Como medida de segurança, a cada 
vez que o cliente deseja sacar dinheiro, o valor é dado de forma a fornecer um pequeno 
volume de notas (supondo que o cliente sempre esteja dentro do seu limite). Esta medida é 
feita para que a quantidade sacada não “faça muito volume” quando guardada pelo cliente. 
Por exemplo, se o cliente quiser sacar 166 não são dadas 166 notas de 1; não são dadas 33 
notas de 5 e 1 nota de 1; são dadas 3 notas de 50, 1 nota de 10, 1 nota de 5 e 1 nota de 1. 
Assim, a resposta a ser impressa é 3 1 1 1. Faça um programa em C que leia a quantia (valor 
inteiro positivo) a ser sacada e imprima as quantidades de notas de 50, 10, 5 e 1 a serem 
fornecidas aos clientes.

*/

import java.util.Scanner;

public class CaixaEletrônico {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
         System.out.println("Digite a quantia a ser sacada: ");
         int Valor = scan.nextInt();
         int Nota50 = 0;
         int Nota10 = 0;
         int Nota5 = 0;
         int Nota1 = 0;

         while(true){
             if(Valor>=50){
                 Valor -= 50;
                 Nota50 += 1;
             } else
             if(Valor>=10){
                 Valor -=10;
                 Nota10 += 1;
             } else 
             if(Valor>=5){
                 Valor -= 5;
                 Nota5 += 1;
             } else 
             if(Valor>=1){
                 Valor -= 1;
                 Nota1 += 1;
             } else {
                 break;
             }
         }
         System.out.println("Notas de 50/Notas de 10/Notas de 5/Notas de 1:");
         System.out.println(Nota50+" "+Nota10+" "+Nota5+" "+Nota1);
    }
}
