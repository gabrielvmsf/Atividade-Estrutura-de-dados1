public class App {
    public static void main(String[] args) throws Exception {
        SistemaOperacional so = new SistemaOperacional();

        so.criarProcesso(10000);
        so.criarProcesso(5000);
        so.criarProcesso(7000);
        so.criarProcesso(3000);
        so.criarProcesso(3000);
        so.criarProcesso(8000);
        so.criarProcesso(2000);
        so.criarProcesso(5000);
        so.criarProcesso(4000);
        so.criarProcesso(10000);

        so.inciarEscalonaçãoDeProcessos();
        so.ImprimindoTabelaDeProcessos();

        System.out.println("Fim!");
    }
}
