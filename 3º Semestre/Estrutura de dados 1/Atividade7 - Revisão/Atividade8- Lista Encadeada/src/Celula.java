public class Celula {
    Celula Proxima;
    Pessoa Elemento;

    public Celula(Pessoa elemento) {
        this.Elemento = elemento;
    }

    public Celula(Celula proxima, Pessoa elemento) {
        this.Proxima = proxima;
        this.Elemento = elemento;
    }

    public void setProxima(Celula proxima) {
        this.Proxima = proxima;
    }

    public Celula getProxima() {
        return (this.Proxima);
    }

    public Pessoa getElemento() {
        return (this.Elemento);
    }
}