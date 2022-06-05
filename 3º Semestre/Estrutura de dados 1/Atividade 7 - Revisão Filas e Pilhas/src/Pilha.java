public class Pilha {

    public char[] pilha;
    public int posicaoPilha;

    public Pilha() {
        this.posicaoPilha = -1;
        this.pilha = new char[10000];
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

    public char exibeUltimoValor() {
        if (this.pilhaVazia()) {
            return 0;
        }
        return this.pilha[this.posicaoPilha];
    }

    public char desempilhar() {
        if (pilhaVazia()) {
            return 0;
        }
        return this.pilha[this.posicaoPilha--];
    }

    public void empilhar(char valor) {
        if (this.posicaoPilha < this.pilha.length - 1) {
            this.pilha[++posicaoPilha] = valor;
        }
    }
}