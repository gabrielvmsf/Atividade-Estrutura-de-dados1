//Criar um algoritmo que imprima o horóscopo de várias pessoas, a partir de sua 
//data de nascimento (ddmm). O fim é determinado quando se digita 9999 para 
//data; considere que a data foi digitada corretamente. 

package Algoritmo360;

import java.util.Scanner;

public class Questão360 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] UltDia = {20,19,20,20,20,20,21,22,22,22,21,21};
        String[] signo = {"Capricórnio","Aquário","Peixes","Áries","Touro","Gêmeos","Câncer","Leão","Virgem","Libra","Escorpião","Sagitário"};
        int data = 8888,dia,mes;

        while(data!=9999){
            System.out.println("\ndigite data no formato ddmm ou 9999 para terminar: ");
            data = scan.nextInt();

            dia = data/100;
            mes = data % 100;
            mes--;

            if(dia>UltDia[mes]){
                mes = (mes+1)%12;
            }
            System.out.println("signo:"+signo[mes]+"\n");
        }
    }
}
