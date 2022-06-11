public class Pilha {

    public int[] pilha;
    public int posicaoPilha;
    public int tamanhoFila;

    public Pilha() {
        this.tamanhoFila = 1000;
        this.posicaoPilha = -1;
        this.pilha = new int[tamanhoFila];
    }

    public boolean pilhaVazia() {
        if (this.posicaoPilha == -1) {
            return true;
        }
        return false;
    }

    public int tamanho() {
        if (this.pilhaVazia()) {
            return 0;
        }
        return this.posicaoPilha + 1;
    }

    public int exibeUltimoValor() {
        if (this.pilhaVazia()) {
            return 0;
        }
        return this.pilha[this.posicaoPilha];
    }

    public int desempilhar() {
        if (pilhaVazia()) {
            return 0;
        }
        return this.pilha[this.posicaoPilha--];
    }

    public void empilhar(int valor) {
        if (this.posicaoPilha < this.pilha.length - 1) {
            this.pilha[++posicaoPilha] = valor;
        }
    }
    public void imprimir(){
        String elementos = "";
            for (int i = 0; i<tamanhoFila; i++) {
                if(pilha[i] == -1) break;
                //elementos += pilha[i];
                System.out.print(" "+pilha[i]+" ");
            }
    }
}