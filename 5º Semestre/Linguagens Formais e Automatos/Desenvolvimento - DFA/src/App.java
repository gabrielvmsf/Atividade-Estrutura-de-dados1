import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
    //matriz de transição ; alfabeto; estado inicial; estados finais; conjunto de estados;
    static int [][] transicao = {{0,1},{1,0}};
    static int estadoInicial = 0;
    static int[] aceitação = {1};

    public static void main(String[] args) throws Exception {
        //entrada --> processamento --> saida

        //entrada
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite uma cadeia:");
        String cadeia = scan.nextLine();
        scan.close();
        
        //processamento

        //preparação para pre processamento
        int estadoAtual = estadoInicial;
        int posicao = 0;

        //processamento
        while(posicao < cadeia.length()){
            char elemento = cadeia.charAt(posicao);
            int elementoInt = Integer.parseInt(elemento+"");

            estadoAtual = transicao[estadoAtual][elementoInt];

            posicao++;
        }
        Boolean cadeiaValida = false;

        for(int i=0;i<aceitação.length;i++){
            if(estadoAtual == aceitação[i]){
                cadeiaValida = true;
            }
            if(cadeiaValida){
                System.out.println("A cadeia é valida");
                break;
            }
        }
        if(!cadeiaValida){
            System.out.println("A cadeia é invalida");
        }
    }
}