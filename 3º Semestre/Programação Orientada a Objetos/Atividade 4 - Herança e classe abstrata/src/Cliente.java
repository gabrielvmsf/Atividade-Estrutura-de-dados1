public abstract class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private String celular;
    private int idade;


    public Cliente(String nome, String endereco, String telefone, String celular, int idade) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.celular = celular;
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
