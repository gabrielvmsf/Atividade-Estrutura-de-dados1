public class Fila{
    int inicio;
    int fim;
    int tamanho;
    int qtdeElementos;
    int f[];

    public Fila(){
        inicio = fim = -1;
        tamanho = 100;
        f = new int[tamanho];
        qtdeElementos = 0;
    }

    public boolean isEmpty(){
        if (qtdeElementos == 0){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if (qtdeElementos == tamanho - 1){
            return true;
        }
        return false;
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

    public void retirar(){
        if (! isFull() ){
            inicio++;
            qtdeElementos--;
        }
    }

    public void imprimir(){
        String elementos = "";
            for (int i = inicio; i<fim; i++) {
                //elementos += f[i];
                System.out.print(" "+f[i]+" ");
            }
    }
    public boolean find(int num){
        for(int i = inicio; i<fim; i++){
            if(f[i]==num){
                return true;
            }
        }
        return false;
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