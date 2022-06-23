public class CelulaPilha {
    // atributos
    private String nome;
    private CelulaPilha anterior;

    public CelulaPilha() {
    }

    public CelulaPilha(String nome, CelulaPilha anterior) {
        this.nome = nome;
        this.anterior = anterior;
    }

    public String getDado() {
        return this.nome;
    }

    public void setDado(String nome) {
        this.nome = nome;
    }

    public CelulaPilha getAnterior() {
        return (this.anterior);
    }

    public void setAnterior(CelulaPilha anterior) {
        this.anterior = anterior;
    }
}