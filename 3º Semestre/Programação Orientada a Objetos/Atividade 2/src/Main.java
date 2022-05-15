import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ContaCorrente conta1 = new ContaCorrente();
        short op;
        conta1.saldo = 1200;
        conta1.nomeUsuario = "Gabriel Vieira Melo";
        conta1.agencia = "0000-0";
        conta1.dataValidade = "12/2023";
        conta1.operacao = "Conta Poupança";

        System.out.println("Seja bem vindo(a) "+conta1.nomeUsuario+" seu saldo atual é: R$"+conta1.saldo);
        while(true){
        System.out.println("Digite a operação desejada: \n(1) Saque\n(2) Deposito \n(3) Transferência\n(4) Sair da aplicação");
        op = scan.nextShort();
        if (op==1) conta1.sacar();
        else if (op == 2) conta1.depositar();
        else if (op == 3) conta1.transferencia();
        else if (op == 4) break;
        else System.out.println("Opção invalida");

        System.out.println("Saldo atual:"+conta1.saldo+"\n");
    }
    }
}
