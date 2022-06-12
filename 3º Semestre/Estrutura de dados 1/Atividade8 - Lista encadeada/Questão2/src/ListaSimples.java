public class ListaSimples {
    No inicio = null;
    int tamanho = 0;

    public void inserirInicio(Pessoa info){
        No no = new No();
        no.info = info;
        no.proximo = inicio;
        inicio = no;
        tamanho++;
    }

    public Pessoa retirarInicio(){
        if(inicio == null){
            return null;
        }
        Pessoa info = inicio.info;
        inicio = inicio.proximo;
        tamanho--;
        return info;
    }

    public void inserirFim(Pessoa info){
        No no = new No();
        no.info = info;
        if(inicio == null){
            no.proximo = null;
            inicio = no;
        } else {
            No local = inicio;
            while(local.proximo!=null){
                local = local.proximo;
            }
            local.proximo=no;
            no.proximo = null;
        }
        tamanho++;
    }

    public Pessoa retirarFim(){
        if(inicio == null){
            return null;
        }
        No local = inicio;
        while(local.proximo != null){
            No aux = local;
            local = local.proximo;
            if(local.proximo == null){
                aux.proximo=null;
                tamanho--;
                return local.info;
            }
        }
        inicio = null;
        tamanho --;
        return local.info;
    }

    public void inserirIndice(int indice, Pessoa info){
        if(indice<=0){
            inserirInicio(info);
        } else if (indice>=tamanho){
            inserirFim(info);
        } else {
            No local = inicio;
            for (int i = 0; i<indice - 1;i++){
                local = local.proximo;
            }
            No no = new No();
            no.info=info;
            no.proximo = local.proximo;
            local.proximo = no;
            tamanho++;
        }
    }

    public Pessoa retirarIndice(int indice){
        if(indice <0 || indice >= tamanho || inicio == null){
            return null;
        } else if (indice == 0){
            return retirarInicio();
        } else if (indice == tamanho-1){
            return retirarFim();
        }
        No local = inicio;
        for(int i = 0; i<indice-1;i++){
            local = local.proximo;
        }
        Pessoa info = local.proximo.info;
        local.proximo = local.proximo.proximo;
        tamanho --;
        return info;
    }

    public String toString(){
        String str = "("+tamanho+") ";
        No local = inicio;
        while(local!=null){
            str += local.info + " ";
            local = local.proximo;
        }
        return str;
    }


    public No getInicio() {
        return this.inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

}