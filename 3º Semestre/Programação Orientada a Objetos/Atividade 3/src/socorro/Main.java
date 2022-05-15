package socror;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Produto produto1 = new Produto();
        System.out.println("Digite o preço de custo: ");
        double precoCusto = scan.nextDouble();
        produto1.setPrecoCusto(precoCusto);

        System.out.println("Digite o preço de venda: ");
        double precoVenda = scan.nextDouble();
        if(produto1.setPrecoVenda(precoVenda)==false){
            System.out.println("Erro: O preço de venda é inferior ao preço de custo!"); 
        }
        produto1.calcularMargemLucro();
        System.out.println("Preço de custo: R$"+produto1.getPrecoCusto()+"\nPreco de venda: R$"+produto1.getPrecoVenda()+"\nMargem de lucro: R$"+produto1.getMargemLucro()+"\nMargem de lucro Percentual: "+produto1.getMargemLucroPorcentagem()+"%");
    }
}
