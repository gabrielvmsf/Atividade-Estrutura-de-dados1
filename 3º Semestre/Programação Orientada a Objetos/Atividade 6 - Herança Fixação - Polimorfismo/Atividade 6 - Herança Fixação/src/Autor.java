public class Autor {
    private String nome;
    private String titulação;

    public Autor(String nome, String titulação) {
        this.nome = nome;
        this.titulação = titulação;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulação() {
        return this.titulação;
    }

    public void setTitulação(String titulação) {
        this.titulação = titulação;
    }

}
