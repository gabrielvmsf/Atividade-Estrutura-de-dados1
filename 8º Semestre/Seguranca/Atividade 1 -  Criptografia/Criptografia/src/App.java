import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Criptografia criptografia = new Criptografia();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o texto a ser criptografado:");
        String texto = scanner.nextLine().toLowerCase();

        criptografia.GerarKey(texto.split(""));

        String textoCodificado = criptografia.Codificar(texto);
        System.out.println("Texto Codificado: " + textoCodificado);

        String textoDecodificado = criptografia.Decodificar(textoCodificado);
        System.out.println("Texto Decodificado: " + textoDecodificado);

        scanner.close();
    }
}
