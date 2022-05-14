//Criar um algoritmo para gerenciar um sistema de reservas de mesas em uma casa 
//de espetáculo. 
//A casa possui 30 mesas de 5 lugares cada. O algoritmo deverá permitir que o 
//usuário escolha código de uma mesa (100 a 129) e forneça a quantidade de lugares desejados. O algoritmo deverá informarse foi possível realizara reserva e atualizar a reserva. Se não for possível, o algoritmo deverá emitir uma mensagem. O 
//algoritmo deve terminar quando o usuário digitar o código O (zero) para uma 
//mesa ou quando todos os 150 lugares estiverem ocupados. 

package Algoritmo369;

import java.util.Scanner;

public class Questão369 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int i,lugares,codigo=1, lugmesa;
        int[] mesa = new int[30];
        int[] qtde = new int[30];
        for(i=0;i<30;i++){
            mesa[i]=100+i;
            qtde[i]=5;
        }
        lugares=150;
        while(codigo>0 && lugares != 0){
            System.out.println("Entre com codigo (100 - 129) ou O para terminar: ");
            codigo = scan.nextInt();
            i = 0;
            while(codigo != mesa[i] && i < 29){
                i++;
            }
            if(codigo==mesa[i]){
                System.out.println("Quantidade de lugares a reservar: ");
                lugmesa = scan.nextInt();
                if(qtde[i]>=lugmesa){
                    qtde[i]-=lugmesa;
                    lugares-=lugmesa;
                } else System.out.println("não há lugares a reservar");
            } else System.out.println("código de mesa invalido");
        }
        if(lugares==0) System.out.println("Locação esgotada");
        else System.out.println("Lugares vagos");
        for(i=0;i<30;i++){
            if(qtde[i]!=0) System.out.println("\nMesa: "+mesa[i]+", Total de lugares:"+qtde[i]);
    }
}
}
