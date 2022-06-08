public class Fila {
    int inicio;
    int fim;
    int tamanho;
    int qtdeElementos;
    int f[];

    public Fila() {
        inicio = fim = -1;
        tamanho = 100;
        f = new int[tamanho];
        qtdeElementos = 0;
    }



    public void inserir(int e){
        if (! isFull()){
            if (inicio == -1){
                inicio = 0;
            }
            fim++;
            f[fim] = e;
            qtdeElementos++;
        }
    }

    public int retirar(){
        int e = -1;
        if (! isEmpty() ){
            e = f[inicio];
            inicio++;
            qtdeElementos--;
        }
        return e;
    }

    public boolean isEmpty(){
        return qtdeElementos==0;
    }

    public boolean isFull(){
        return qtdeElementos == f.length;
    }

    public int getTotal() {
        return this.qtdeElementos;
    }

    public void setTotal(int total) {
        this.qtdeElementos = total;
    }
    public int getPrimeiroTermo(){
        return f[inicio];
    }
}
