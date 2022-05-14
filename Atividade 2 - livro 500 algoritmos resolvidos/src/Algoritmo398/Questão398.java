/*A Fabrica de Queijo Rio Novense deseja elaborar um algoritmo para controlar o 
estoque e as vendas. Inicialmente, deverão ser lidos e armazenados em vetores: o 
código, a quantidade disponível em estoque e o preço de venda dos produtos. O 
término do cadastramento é determinado quando se digita -1 para o código do 
produto. Sabe-se que a Fábrica de Queijo Rio Novense trabalha com no máximo 
50 produtos diferentes. 
A segunda fase do algoritmo é a venda. Deverá ser lido o código do produto a ser 
vendido e a quantidade requerida. Se o código do produto estiver cadastrado, a 
venda poderá ser realizada; caso contrário, a mensagem Produto Não-Cadastrado deverá ser exibida no monitor. Caso o produto esteja disponível, a venda só 
poderá ser realizada se a quantidade disponível no estoque for suficiente para 
atender ao pedido. Nesse caso, você deverá abater do estoque a quantidade vendida. Se o estoque não for suficiente para atender ao pedido, a mensagem Estoque Insuficiente deverá ser exibida no monitor. O final das vendas será detectado 
quando o código do produto for igual a zero. 
No final devera aparecer uma listagem no video contendo o total vendido no dia 
e a relação de todos os produtos do estoque, com suas respectivas quantidades, 
em ordem decrescente de quantidades disponíveis. */

package Algoritmo398;

import java.util.Scanner;

public class Questão398 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] codigo = new int[50];
        int[] qtdestoque = new int[codigo.length];
        float[] PreçoVenda = new float[codigo.length];
        int i,cd,posicao=0;
        for(i=0; i<codigo.length;i++){ //deverão ser lidos e armazenados em vetores
            System.out.println("\nDigite o código do produto "+(i+1)+": ");
            cd=scan.nextInt();
            if(cd==-1) break;
            codigo[i]=cd;
            System.out.println("Digite a quantidade do produto "+(i+1)+" em estoque: ");
            qtdestoque[i]=scan.nextInt();
            System.out.println("Digite o preço do produto "+(i+1)+": ");
            PreçoVenda[i]=scan.nextFloat();

            posicao++;
        }

        int total=0,qtd,k=0,l=0,j,cod;
        for(i=0;i<=posicao;i++){
            System.out.println("Digite o código do produto a ser vendido: ");
            cod = scan.nextInt();
            if(cod==0) break;

            for(j=0;j<=posicao;j++){
                if(cod==codigo[j]){
                    k=j;
                    break;
                } else 
                {System.out.println("Produto não cadastrado");
                l=-1;
            }
            }

            if(l==-1) continue;

            System.out.println("Digite a quantidade desejada do produto "+(k+1));
            qtd=scan.nextInt();
            if(qtdestoque[k]>=qtd){
                qtdestoque[k]-=qtd;
                total+=total+qtd;
                
            } else System.out.println("Quantidade em estoque não suficiente");
        }

        System.out.println("Total vendido no dia: "+total+" produtos");
        for(i=0;i<posicao;i++){
            System.out.println("Produto "+(i+1)+" em estoque: "+qtdestoque[i]);
        }
    }
}
