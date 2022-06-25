public class CelulaPilha {
    // atributos
    private int nome;
    private CelulaPilha anterior;

    public CelulaPilha() {
    }

    public CelulaPilha(int nome, CelulaPilha anterior) {
        this.nome = nome;
        this.anterior = anterior;
    }

    public int getDado() {
        return this.nome;
    }

    public void setDado(int nome) {
        this.nome = nome;
    }

    public CelulaPilha getAnterior() {
        return (this.anterior);
    }

    public void setAnterior(CelulaPilha anterior) {
        this.anterior = anterior;
    }
}