import java.util.Scanner;

import javax.swing.event.SwingPropertyChangeSupport;

public class App {
    public static void main(String[] args) throws Exception {
        ValidarRegex validarRegex = new ValidarRegex();
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite seu nome:");
        validarRegex.validarString(scan.next(), "^([A-Z][a-zA-Z]{1,39}\\s[A-Z][a-zA-Z]{1,39})|([A-Z][a-zA-Z]{1,39})$");
        
        System.out.println("Digite seu CPF:");
        validarRegex.validarString(scan.next(), "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$");
        
        System.out.println("Digite seu senha:");
        validarRegex.validarString(scan.next(), "[0-9][\\w]{2,8}[a-zA-Z]");

        System.out.println("Digite seu telefone:");
        validarRegex.validarString(scan.next(), "^\\+\\d{2,3}\\(\\d{2}\\)\\d{5}-\\d{4}$");

        System.out.println("Todos os dados validados!!!");
        scan.close();
    }

}