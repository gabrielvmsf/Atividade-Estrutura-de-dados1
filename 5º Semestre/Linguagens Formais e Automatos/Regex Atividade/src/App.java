import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a regex:");
        Pattern pattern = Pattern.compile(scan.nextLine());

        String cadeia = "";

        // verificar uma quantidade n de cadeias em relação ao regex
        // digite -1 para parar o loop
        while (true) {
            System.out.println("\nDigite a cadeia para conferir:");
            cadeia = scan.nextLine();

            if (cadeia.equals("-1"))
                break;

            Matcher macher = pattern.matcher(cadeia);
            System.out.println("resultado: " + macher.matches());
        }
        
        System.out.println("Fim do programa!");

        scan.close();
    }
}