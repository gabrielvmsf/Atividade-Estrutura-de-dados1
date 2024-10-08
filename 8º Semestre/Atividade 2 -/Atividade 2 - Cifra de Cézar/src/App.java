import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o texto para ser criptografado: ");
        String text = scan.nextLine();

        System.out.println("Digite o deslocamento do alfabeto: ");
        int deslocamento = scan.nextInt();
        
        System.out.println("\n\n");

        ExecutarTeste.testarCriptografia(text, deslocamento);
        scan.close();
    }
}
