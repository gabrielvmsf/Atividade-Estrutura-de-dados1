import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<Conta> contas = new ArrayList<Conta>();
        ArrayList<Integer> ordem = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        int nroConta;
        String nomeTitular;
        String cpfTitular;
        System.out.println("\n<<Banco>>\n");
        while (true) {
            System.out.println(
                    "\n1. Criar uma nova conta\n2 Exibir o saldo, ou extrato, de uma conta\n3 Sacar um valor de uma conta\n4 Depositar um valor em uma conta\n5 Transferir valores de uma conta para outra\n0. Sair do programa");
            int i = scan.nextInt();
            if (i == 0)
                break;
            if (i == 1) { // Criar conta
                System.out.println("Digite o nro da conta: ");
                nroConta = scan.nextInt();
                System.out.println("Digite o nome do titular: ");
                nomeTitular = scan.next();
                System.out.println("Digite o cpf do titular: ");
                cpfTitular = scan.next();
                Conta conta = new Conta(nroConta, nomeTitular, cpfTitular);
                contas.add(conta);
                ordem.add(nroConta);
            } else if (i == 2) { // Realizar extrato
                System.out.println("Digite o numero da conta no qual quer ver o extrato/saldo:");
                nroConta = scan.nextInt();

                int ContaOrdem = ordem.indexOf(nroConta);
                Conta contaRecuperada = (Conta) contas.get(ContaOrdem);
                contaRecuperada.extrato();
            } else if (i == 3) { // Saque
                System.out.println("Digite o numero da conta no qual quer realizar saque:");
                nroConta = scan.nextInt();

                int ContaOrdem = ordem.indexOf(nroConta);
                Conta contaRecuperada = (Conta) contas.get(ContaOrdem);

                System.out.println("Digite a quantidade a ser sacada:");
                Double valor = scan.nextDouble();
                if (contaRecuperada.sacar(valor) == true) {
                    System.out.println("Saque efetuado com sucesso!");
                    // contaRecuperada.sacar(valor);
                    contas.set(ContaOrdem, contaRecuperada);
                } else
                    System.out.println("Saque não efetuado");
            } else if (i == 4) { // Deposito
                System.out.println("Digite o numero da conta no qual quer realizar deposito:");
                nroConta = scan.nextInt();

                int ContaOrdem = ordem.indexOf(nroConta);
                Conta contaRecuperada = (Conta) contas.get(ContaOrdem);

                System.out.println("Digite a quantidade a ser depositada:");
                Double valor = scan.nextDouble();
                contaRecuperada.depositar(valor);
                System.out.println("Deposito efetuado com sucesso!");
                contas.set(ContaOrdem, contaRecuperada);
            } else if (i == 5) {
                System.out.println("Digite o numero da conta no qual quer realizar transferência:");
                nroConta = scan.nextInt();
                System.out.println("Digite a quantidade a ser transferida:");
                Double valor = scan.nextDouble();
                System.out.println("Digite o numero da conta que receberá transferência:");
                int nroConta2 = scan.nextInt();

                int ContaOrdem = ordem.indexOf(nroConta);
                Conta contaRecuperada = (Conta) contas.get(ContaOrdem);

                ContaOrdem = ordem.indexOf(nroConta2);
                Conta contaRecuperada2 = (Conta) contas.get(ContaOrdem);

                if (contaRecuperada.transferir(valor, contaRecuperada2) == true) {
                    System.out.println("Transferência realizada com sucesso!");
                } else
                    System.out.println("Transferência não efetuada");

            }
        }

    }
}
