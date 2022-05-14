/*Um hotel fazenda gostaria de fazer um algoritmo que pudesse controlar os se 
guintes dados dos 50 quartos 
m número de leitos por quarto; 
preço 
situação: alugado, livre ou reservado; 
e aluguel do quarto com data de entrada e de saída e numero de diárias; 
e despesas dentro do hotel; 
e valor a ser pago; 
e impressão de todos os quartos com a situação de cada um; 
e impressão dos quartos livres. 
Criar um algoritmo que funcione de acordo com o menu a seguir */

package Algoritmo400;

import java.util.Scanner;

public class Questão400 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i,contagemQ = 0;
        float despesa=0;
        int[] NumLeitos = new int[50];
        float[] Preço = new float[50];
        float[] DespesaQuarto = new float[50];
        String[] situação = new String[50];
        float[] Despesa= new float[50];
        System.out.println("");

        System.out.println("\nHotel-Fazenda Sucesso \n");
        while(true){
        System.out.println("1. Cadastra quartos\n2. Lista todos os quartos\n3. Lista quartos ocupados\n4. Aluguel/reserva quarto\n5. Entra despesas extras \n6. Calcula despesa do quarto\n7. Sai");
        int opcao = scan.nextInt();
        if(opcao==1){
            contagemQ+=1;
            System.out.println("Número de leitos do quarto "+contagemQ+":");
            NumLeitos[contagemQ]=scan.nextInt();
            System.out.println("Preço do quarto "+contagemQ+":");
            Preço[contagemQ]=scan.nextInt();
            situação[contagemQ]="livre";
        } else
        if(opcao==2){
            if(contagemQ>0){
                for(i=0;i<=contagemQ;i++){
                    if(situação[i]=="livre"){
                        System.out.println("\nO quarto "+i+" está livre");
                    } else if(situação[i]=="reservado"){
                        System.out.println("\nO quarto "+i+" está reservado");
                    }else if(situação[i]=="ocupado"){
                        System.out.println("\nO quarto "+i+" está ocupado");
                    }
                }
            }else System.out.println("não foi registrado nenhum quarto");
        } else
        if(opcao==3){
            if(contagemQ>0){
                for(i=0;i<=contagemQ;i++){
                    if(situação[i]=="ocupado"){
                        System.out.println("\nO quarto "+i+" está ocupado");
                    }
                }
            }else System.out.println("não foi registrado nenhum quarto");
        }else
        if(opcao==4){
            System.out.println("1. Alugar\n2. Reservar");
            int opcao1 = scan.nextInt();
            if(opcao1==1){
                System.out.println("Deseja alugar qual quarto? ");
                int j = scan.nextInt();
                situação[j]="ocupado";
                DespesaQuarto[j] += Preço[j];
            } else if (opcao1==2){
                System.out.println("Deseja reservar qual quarto? ");
                int j = scan.nextInt();
                situação[j]="reservado";
                DespesaQuarto[j] += Preço[j];
            }
        } else
        if(opcao==5){
            System.out.println("Entre com a despesa extra: ");
            float desp = scan.nextFloat();
            despesa+=desp;
        } else if(opcao==6){
            System.out.println("Deseja ver desepesas de qual quarto? ");
            int j = scan.nextInt();
            System.out.println("A despesa do quarto "+j+" é: "+DespesaQuarto[j]);
        } else if(opcao==7){
            break;
        } else System.out.println("Digite uma opção valida");
    }
    }
}
