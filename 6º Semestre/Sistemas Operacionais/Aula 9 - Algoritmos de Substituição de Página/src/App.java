public class App {
    public static void main(String[] args) throws Exception {
        GerenciadorDeMemoria gerenciadorDeMemoria = new GerenciadorDeMemoria();
        gerenciadorDeMemoria.imprimirMatrizes();
        gerenciadorDeMemoria.execucaoDeInstrucao();
        System.out.println("\n------ MATRIZES FINAIS (após execução do WSCLOCK): ------");
        gerenciadorDeMemoria.imprimirMatrizes();
    }
}
