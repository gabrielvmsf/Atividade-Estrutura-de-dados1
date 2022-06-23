import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        StackDinamica sd = new StackDinamica();
        boolean verificação;
        int parentese = 0, colchetes = 0, chaves = 0, j = 0;

        System.out.println("Digite a expressão:");
        String palavra = scan.next();
        String vet[]=palavra.split("");
        for(int i = vet.length - 1; i>=0;i--){
            sd.push(vet[i]);
        }
        for(int i = 0; i<vet.length;i++){
            String caractere= sd.pop();
            if(caractere.equals(")")){

            }
        }
    }
}
