/*3. Crie um programa em Java que ao ler um número n inteiro, digitado pelo usuário via teclado, 
imprima o n-ésimo número da sequência de Fibonacci. 
*/

import java.util.Scanner;

public class Sequência {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o n-ésimo número desejado da sequência de Fibonacci:");
        int M = scan.nextInt();
        long NumAnt = 1;
        long NumPos = 1;
        long NumFinal = 1;
        
        for(int i=0; i<=M; i++){
            if(i>2){
                NumFinal = NumPos+NumAnt;
                NumAnt = NumPos;
                NumPos = NumFinal;
            }
        }
        System.out.println("O número da sequência Fibonacci de "+M+"º termo é: "+NumFinal);
    }
}
