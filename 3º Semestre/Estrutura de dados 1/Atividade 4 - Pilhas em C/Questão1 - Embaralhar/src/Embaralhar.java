public class Embaralhar {
    String[] elementos;
    char[] arrayinv;
    int top, qtd, qtdPalavra;
    String texto;

    public Embaralhar(String texto) {
        elementos = new String[qtd];
        elementos = texto.split(" ");

        this.texto = texto;
        this.qtd = elementos.length;
        top = -1;

        for (int i = 0; i < qtd; i++) {
            push(elementos[i]);
        }

    }

    public void push(String x) {
        top++;
        this.qtdPalavra = x.length();
        this.arrayinv = new char[qtdPalavra];

        int j = 0;

        for (int i = (qtdPalavra - 1); i > -1; i--) {
            arrayinv[i] = x.charAt(j);
            j++;
        }

        elementos[top] = String.valueOf(arrayinv);
    }

    public int getQtd() {
        return qtd;
    }

    public String pop() {
        String e;
        e = elementos[top];
        top--;

        return e;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void empty() {
        top = -1;
    }

    public boolean isFull() {
        return (top == (qtd - 1));
    }

    public String top() {
        return elementos[top];
    }

    public String getElementos() {
        top++;
        return top();
    }
}
