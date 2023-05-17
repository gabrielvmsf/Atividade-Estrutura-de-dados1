import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarRegex {

    Scanner scan;

    public ValidarRegex() {
        scan = new Scanner(System.in);
    }

    private boolean retornarVerificação(String regexString) {
        String validarString = scan.next();

        return validarString(validarString, regexString);
    }

    public boolean validarString(String validarString, String regexString) {
        Pattern pattern = Pattern.compile(regexString);
        Matcher macher = pattern.matcher(validarString);

        if (macher.matches())
            System.out.println("Campo Valido\n");
        else {
            System.out.println("Campo Invalido, digite novamente!");
            retornarVerificação(regexString);
        }

        return macher.matches();
    }
}