import java.util.Scanner;

public class App {

    static int[][][] transicao = {{{0},{0,1}},{{},{}}};
    static int estadoInicial = 0;
    static int[] aceitacao = {1};

    public static void main(String[] args) throws Exception {
        //entrada --> processamento --> saida

        //entrada
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite uma cadeia:");
        String cadeia = scan.nextLine();
        scan.close();
        
        //processamento

        //preparacao para pre processamento
        int[] estadoAtual;
        estadoAtual[0] = estadoInicial;
        int posicaoEstado = 0;

        int posicao = 0;

        for(int i = 0; i < cadeia.length(); i++){
            char elemento = cadeia.charAt(posicao);
            int elementoInt = Integer.parseInt(elemento+"");

            int k = 0;
            while(transicao[estadoAtual[posicaoEstado]][elementoInt][k] == 1 || transicao[estadoAtual[posicaoEstado]][elementoInt][k] == 2){ 
                estadoAtual[posicaoEstado] = transicao[estadoAtual[posicaoEstado]][elementoInt][k];
                posicaoEstado++;
                k++;
            }
        }
        Boolean cadeiaValida = false;

        for(int i=0;i<aceitacao.length;i++){
            for(int k = 0; k<posicaoEstado;k++){
                if(estadoAtual[k] == aceitacao[i]){
                    cadeiaValida = true;
                }
                if(cadeiaValida){
                    System.out.println("A cadeia é valida");
                } else {
                    System.out.println("A cadeia é invalida");
                }
            } 
        }
    }
}
