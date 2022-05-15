/*4. Crie um programa em Java que irá ler 10 números e armazená-los em um vetor na ordem em 
que foram digitados. Em seguida, crie um novo vetor com os valores na ordem invertida. Ao 
final imprima o vetor original e o vetor invertido.
*/

import java.util.Scanner;

public class Vetores {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite 10 números para serem armazenados no vetor:");
        int[] VetorA = new int[10];
        int[] VetorB = new int[10];
        int i;
        for(i=0; i<=9;i++){
            VetorA[i] = scan.nextInt();;
        }
        int j = 9;
        for(i=0; i<=9;i++){
            VetorB[j] = VetorA[i];
            j--;
        }
        System.out.println("Vetor original: ");
        for(i=0; i<=9;i++){
            System.out.println(VetorA[i]);
        }
        System.out.println("\nVetor invertido: ");
        for(i=0; i<=9;i++){
            System.out.println(VetorB[i]);
        }
    }
}