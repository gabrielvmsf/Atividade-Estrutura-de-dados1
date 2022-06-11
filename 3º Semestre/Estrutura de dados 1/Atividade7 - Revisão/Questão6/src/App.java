import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        Fila f = new Fila();
        Pilha p = new Pilha();
        int i = 0;

        while (i<=2000) {
            i++;
            if (i <= 1000) {
                int num = rand.nextInt(10000);
                f.insere(num);
            } else {
                int num = rand.nextInt(10000);
                num*=(-1);
                f.insere(num);
            }
        }
        i = 0;
        
        System.out.println("número retirado da pilha: ");
        while (i < 2000) {
            i++;
            if (f.primeiroTermo() >= 0 && !f.filaVazia()) {
                p.empilhar(f.remover());
            } else if(!p.pilhaVazia()){
                if(p.pilhaVazia()) break;
                System.out.print(p.desempilhar()+" ");
            }
        }
        System.out.println("\nFim Programa!");
    }
}