//Criar um algoritmo que leia o preço de compra e o preço de venda de 100 mercadorias O algoritmo devera imprimir quantas mercadorias proporcionam 
//m lucro < 10 % 
//10 % <= lucro <= 20 % 
//m lucro > 20 % 

package Algoritmo358;

import java.util.Scanner;

public class Questão358 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float[] PreçoCompra = new float[2];
        float[] PreçoVenda = new float[PreçoCompra.length];
        float resto,lucro;
        int lucromenor10 = 0;
        int lucromenor20 = 0;
        int lucromaior20 = 0;
        int i;

        for (i = 0; i < PreçoCompra.length; i++){
            System.out.println("\nDigite o preço de compra do produto "+(i+1));
            PreçoCompra[i] = scan.nextFloat();
            System.out.println("Digite o preço de venda do produto "+(i+1));
            PreçoVenda[i] = scan.nextFloat();
        }
        for (i = 0; i < PreçoCompra.length; i++){
            resto = PreçoVenda[i]-PreçoCompra[i];
            lucro = (resto/PreçoVenda[i])*100;

            if(lucro<10) lucromenor10++;
            else if (lucro<=20) lucromenor20++;
            else if (lucro>20) lucromaior20++;
        }
        System.out.println("\ntotal de mercadorias com lucro < 10%: "+lucromenor10);
        System.out.println("\ntotal de mercadorias com 10% <= lucro <= 20%: "+lucromenor20);
        System.out.println("\ntotal de mercadorias com lucro > 20%: "+lucromaior20+"\n");
    }
}
