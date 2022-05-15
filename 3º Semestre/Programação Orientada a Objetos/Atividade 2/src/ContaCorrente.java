import java.util.Scanner;

public class ContaCorrente {
        Scanner scan = new Scanner(System.in);
        int saldo;
        String nomeUsuario;
        String agencia;
        int numeroConta;
        String dataValidade;
        String operacao;

    int sacar(){

        System.out.println("Digite a quantidade a ser sacada: ");
        int qtdS = scan.nextInt();
        if (qtdS<=saldo){
            if(qtdS>0) saldo -= qtdS;
            else System.out.println("Digite um saldo positivo!");
        } else System.out.println("Você não possui essa quantidade de dinheiro!");

        return saldo;
    }

    int depositar(){
        System.out.println("Digite a quantidade a ser depositada: ");
        int qtdD = scan.nextInt();
        if(qtdD>0) saldo += qtdD;
        else System.out.println("Digite um saldo positivo!");

        return saldo;
    }

    int transferencia(){
        System.out.println("Digite a quantidade a ser transferida: ");
        int qtdD = scan.nextInt();
        if (qtdD<=saldo){
            if(qtdD>0) saldo -= qtdD;
            else System.out.println("Digite um saldo positivo!");
        } else System.out.println("Você não possui essa quantidade de dinheiro!");

        return saldo;
    }
}