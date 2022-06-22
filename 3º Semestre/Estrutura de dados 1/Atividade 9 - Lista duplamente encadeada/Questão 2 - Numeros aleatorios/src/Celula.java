public class Celula {
    Celula Proxima; // Aponta para a próxima célula
    Celula Anterior; // Aponta para a célula anterior
    int Elemento; // Objeto armazenado

    // Métodos – Construtores das células
    Celula(Celula prox, int ele) {
        this.Proxima = prox;
        this.Anterior = null;
        this.Elemento = ele;
    }

    // Métodos – Construtores das células
    Celula(int ele) {
        this.Proxima = null;
        this.Anterior = null;
        this.Elemento = ele;
    }

    // Métodos
    void setProxima(Celula prox) {
        this.Proxima = prox;
    }

    // Métodos
    void setAnterior(Celula ant) {
        this.Anterior = ant;
    }

    // Métodos
    Celula getProxima() {
        return (this.Proxima);
    }

    // Métodos
    Celula getAnterior() {
        return (this.Anterior);
    }

    // Métodos
    int getElemento() {
        return (this.Elemento);
    }
}