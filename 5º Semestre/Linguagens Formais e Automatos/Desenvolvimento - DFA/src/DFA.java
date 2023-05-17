import java.util.Scanner;

public class DFA {
    static int [][] transicao = {{0,1},{1,0}};
    static int estadoInicial;
    static int[] aceitação = {1};
    
    public DFA() {
        estadoInicial = 0;
        entrada();
    }
    
    //entrada --> processamento --> saida
    private void entrada(){
        //entrada
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite uma cadeia:");
        String cadeia = scan.nextLine();
        scan.close();
    }
}
