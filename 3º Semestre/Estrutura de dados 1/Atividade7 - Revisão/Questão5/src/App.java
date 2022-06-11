import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        Fila fila = new Fila();
        Pilha pilha = new Pilha();
        int i = 0;
        int num;
        while(i!=1000){
            i++;
            num = rand.nextInt(1000);
            if(fila.find(num)){
                pilha.empilhar(num);
            } else {
                fila.inserir(num);
            }
        }
        pilha.empilhar(-1);
        System.out.println("Números fila:");
        fila.imprimir();
        System.out.println("\nNúmeros pilha:");
        pilha.imprimir();
    }
}
