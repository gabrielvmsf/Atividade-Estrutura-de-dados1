import javax.swing.JOptionPane;

public class App {
    static int[][][] transicao = { { { 0, 1 }, { 0 } }, { {}, { 2 } }, { {}, {} } };
    static int estadoInicial = 0;
    static int[] aceitacao = { 2 };

    public static void main(String[] args) throws Exception {

        // entrada --> processamento --> saida
        String c = JOptionPane.showInputDialog("Digite uma cadeia");

        // processamento
        int[] estadosAtuais = { estadoInicial };
        int[] estadosFinais = verifica(c, estadosAtuais, 0);

        if (verifica(estadosFinais)) {
            System.out.println("Aceita");
        } else {
            System.out.println("Rejeita");
        }
    }

    private static int[] verifica(String entrada, int[] estados, int posicao) {
        if (posicao == entrada.length()) {
            imprime(entrada, estados[0], posicao);
            if (verifica(estados)) {
                return estados;
            }
            System.out.println("<<backtrack>> Fim da cadeia");
            return null;
        }
        int elemento = Integer.parseInt(entrada.substring(posicao, posicao + 1));
        for (int i : estados) {
            imprime(entrada, i, posicao);
            int[] novosEstados = transicao[i][elemento];
            if (novosEstados.length == 0) {
                System.out.println("<<backtrack>> sem opcoes");
                return null;
            }
            int[] transicoes = verifica(entrada, novosEstados, posicao + 1);
            if(transicoes!=null) return transicoes;
        }
        return null;
    }

    private static boolean verifica(int[] estados) {
        if (estados == null)
            return false;
        for (int i : estados) {
            for (int j : aceitacao) {
                if (i == j)
                    return true;
            }
        }
        return false;
    }

    public static void imprime(String entrada, int estado, int posicao) {
        System.out.println(entrada.substring(0, posicao));
        System.out.println("[q" + estado + "]");
        System.out.println(entrada.substring(posicao));
    }

}
