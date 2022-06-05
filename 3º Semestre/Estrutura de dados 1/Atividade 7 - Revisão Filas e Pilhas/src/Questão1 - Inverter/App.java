import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Pilha p = new Pilha();

        System.out.println("Digite a palavra desejada");
        String palavra = scan.nextLine();
        char[] Chars = palavra.toCharArray();

        for (int i=0; i<Chars.length; i++){
            p.empilhar(Chars[i]);
        }
        
        char[] CharInvertido = new char[Chars.length];

        System.out.print("Palavra invertida: ");
        for (int i=0; i<CharInvertido.length; i++){
            System.out.print(p.desempilhar());
        }

        for (int i=0; i<Chars.length; i++){
            p.empilhar(Chars[i]);
        }

        int j = CharInvertido.length;
        int k = 0;

        for (int i=0; i<CharInvertido.length; i++){
            if(Chars[i]==p.desempilhar()){
                k++;
                if(k==Chars.length){
                    System.out.println("\nÉ um palindromo");
                }
            } else {
                System.out.println("\nNão é um palindromo");
                break;
            }
        }

    }
}
