import java.util.ArrayList;
import java.util.List;

public class Fila {
    List<Integer> num = new ArrayList<Integer>();

    void insere(int a) {
        this.num.add(a);
    }

    int remover() {
        return this.num.remove(0);
    }

    boolean filaVazia() {
        return this.num.isEmpty();
    }

    void esvaziar() {
        this.num.clear();
    }

    int tamanhoFila() {
        return this.num.size();
    }

    int primeiroTermo(){
        return this.num.get(0);
    }
}