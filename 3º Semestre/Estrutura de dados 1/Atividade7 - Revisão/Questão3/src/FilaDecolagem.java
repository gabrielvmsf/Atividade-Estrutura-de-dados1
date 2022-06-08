public class FilaDecolagem {
    int inicio;
    int fim;
    int tamanho;
    int qtdeElementos;
    Avião f[];

    public FilaDecolagem() {
        this.inicio = fim = -1;
        this.tamanho = 500;
        this.f = new Avião[tamanho];
        this.qtdeElementos = 0;
    }



    public void inserir(Avião e){
        if (! isFull()){
            if (this.inicio == -1){
                this.inicio = 0;
            }
            this.fim++;
            f[fim] = e;
            this.qtdeElementos++;
        }
    }

    public Avião retirar(){
        Avião e = null;
        if (! isEmpty() ){
            e = f[inicio];
            this.inicio++;
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
    public Avião getPrimeiroTermo(){
        Avião e = f[inicio];
        return e;
    }


    public int getInicio() {
        return this.inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFim() {
        return this.fim;
    }

    public void setFim(int fim) {
        this.fim = fim;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getQtdeElementos() {
        return this.qtdeElementos;
    }

    public void setQtdeElementos(int qtdeElementos) {
        this.qtdeElementos = qtdeElementos;
    }

}

