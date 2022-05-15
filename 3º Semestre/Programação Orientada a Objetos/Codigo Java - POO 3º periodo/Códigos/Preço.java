/*1. Crie um programa em Java que lê dois números reais (ponto flutuante), digitados pelo usuário 
via teclado. O primeiro número será referente ao preço da gasolina. O segundo número 
digitado será referente ao preço do etanol. A seguir faça o cálculo abaixo e indique se é 
melhor o abastecimento com etanol ou com gasolina. 
○ valorEtanol / valorGasolina 
○ Se menor ou igual a 0,7 => Abasteça com etanol
○ Senão => Abasteça com gasolina
*/

import java.util.Scanner;

public class Preço {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o preço da gasolina:");
        float PreçoGasolina = scan.nextFloat();
        System.out.println("Digite o preço do etanol:");
        float PreçoEtanol = scan.nextFloat();

        float CalculoPreço = PreçoEtanol/PreçoGasolina;

        if(CalculoPreço<=0.7){
            System.out.println("\nAbasteça com Etanol");
        } else {
            System.out.println("\nAbasteça com Gasolina");
        }
    }
}
