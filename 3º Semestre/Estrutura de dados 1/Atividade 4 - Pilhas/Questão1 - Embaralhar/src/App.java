import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a palavra desejada:");
        String texto = scan.nextLine();

        Embaralhar E = new Embaralhar(texto);

        int qtd = E.getQtd();

        E.empty();

        for (int i = 0; i < qtd; i++) {
            System.out.print(E.getElementos() + " ");
        }
    }
}
