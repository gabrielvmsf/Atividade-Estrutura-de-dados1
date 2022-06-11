import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Fila f1 = new Fila();
        Fila f2 = new Fila();
        Random rand = new Random();

        while(!f1.isFull()){   
            f1.inserir(rand.nextInt(1000));
        }
        f1.inverter(f2);

        /*for(int i = 0; i<f2.getQtdeElementos();i++){
            System.out.println();
        }*/

        System.out.println("Fim do programa! / Executado com sucesso");
    }
}
