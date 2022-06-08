public class Avião {
    String nome;
    int numIdentificador;


    public Avião(String nome, int numIdentificador) {
        this.nome = nome;
        this.numIdentificador = numIdentificador;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumIdentificador() {
        return this.numIdentificador;
    }

    public void setNumIdentificador(int numIdentificador) {
        this.numIdentificador = numIdentificador;
    }
    
}
