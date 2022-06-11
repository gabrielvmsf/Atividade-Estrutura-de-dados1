import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a operação desejada:");
        while (true) {

            FilaDecolagem decolagem = new FilaDecolagem();

            System.out.println(
                    "(1) Listar o número de aviões aguardando na fila de decolagem;\n(2) Autorizar a decolagem do primeiro avião da fila;\n(3) Adicionar um avião à fila de espera;\n(4) Listar todos os aviões na fila de espera;\n(5) Listar as características do primeiro avião da fila;\n(6) Sair do programa");
            int opção = scan.nextInt();

            if (opção == 1) {
                if (!(decolagem.isEmpty())) {
                    System.out.println("Existem " + decolagem.getTotal() + " aviões na fila de decolagem");
                } else
                    System.out.println("A fila está vazia!");
            } else if (opção == 2) {
                if (!(decolagem.isFull())) {
                    System.out.println("Autorizada a decolagem do primeiro avião da fila");
                    decolagem.retirar();
                } else
                    System.out.println("A fila está cheia!");
            } else if (opção == 3) {
                System.out.println("Digite o nome:");
                String nome = scan.next();
                System.out.println("Digite o identificador");
                int numIdentificador = scan.nextInt();
                Avião avião = new Avião(nome, numIdentificador);
                decolagem.inserir(avião);
            } else if (opção == 4) {
                int i = 0;
                decolagem.mostrar();
            } else if (opção == 5) {
                System.out.println("inicio = "+decolagem.getInicio());
                System.out.println("o primeiro avião da fila tem o identificador "
                        + decolagem.getPrimeiroTermo().getNumIdentificador() + " e nome "
                        + decolagem.getPrimeiroTermo().getNome());
            }

            if (opção == 6) {
                System.out.println("Programa finalizado!");
                break;
            }

        }
    }
}
