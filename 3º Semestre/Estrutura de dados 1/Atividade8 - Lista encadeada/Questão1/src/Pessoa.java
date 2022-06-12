public class Pessoa {
    private int num;
    private String nome;
    private String telefone;
    private String endereço;
    private String CPF;


    public Pessoa(int num) {
        this.num = num;
    }


    public Pessoa(String nome, String telefone, String endereço, String CPF) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereço = endereço;
        this.CPF = CPF;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereço() {
        return this.endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getCPF() {
        return this.CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
}
