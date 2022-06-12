import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        ListaSimples L = new ListaSimples();

        for (int i = 0; i < 20; i++) {
            Pessoa p = new Pessoa((i + 1));
            L.inserirIndice(i, p);
        }
        int i = L.getTamanho();
        int num;
        do {
            num = rand.nextInt(i);
            L.retirarIndice(num);
            i--;
        }while (L.getTamanho() > 1 && i > 0);

        System.out.println("O ganhador/sobrevivente foi a pessoa número:"+L.retirarInicio().getNum());
    }
}
