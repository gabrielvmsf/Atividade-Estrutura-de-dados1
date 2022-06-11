public class App {
    public static void main(String[] args) throws Exception {
        Pilha p = new Pilha();
        Fila f = new Fila();
        for(int i = 1; i<=20;i++){
            f.insere(i);
        }
        while(!f.filaVazia()){
            p.empilhar(f.remover());
        }
        while(!p.pilhaVazia()){
            f.insere(p.desempilhar());
        }
        while(!f.filaVazia()){
            System.out.print(f.remover()+" ");
        }
    }
}
