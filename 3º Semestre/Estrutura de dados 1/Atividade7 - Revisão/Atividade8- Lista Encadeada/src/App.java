import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        ListaLigada L = new ListaLigada();

        for(int i = 0; i<20;i++){
            Pessoa p = new Pessoa((i+1));
            L.adiciona(p);
        }
        int i = 21;
        int num;
        while(L.tamanho() > 1 && i>0){
            num = rand.nextInt(i);
            System.out.println(L.PegaCelula(num));
            i--;
        }
        System.out.println("O ganhador/sobrevivente foi a pessoa número: "+L.pega(0).getNum());
    }
}
