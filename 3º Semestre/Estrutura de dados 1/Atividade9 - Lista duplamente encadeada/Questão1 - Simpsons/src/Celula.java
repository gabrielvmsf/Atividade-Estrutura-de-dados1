public class Celula {
    Celula Proxima; // Aponta para a próxima célula
    Celula Anterior; // Aponta para a célula anterior
    String Elemento; // Objeto armazenado

    // Métodos – Construtores das células
    Celula(Celula prox, String ele) {
        this.Proxima = prox;
        this.Anterior = null;
        this.Elemento = ele;
    }

    // Métodos – Construtores das células
    Celula(String ele) {
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
    String getElemento() {
        return (this.Elemento);
    }
}