public abstract class Úsuario {
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private int qtdRenovações;
    private double multa;

    public Úsuario(String nome, String telefone, String email, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.qtdRenovações = 0;
        this.multa = 0.00;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    

    public int getQtdRenovações() {
        return this.qtdRenovações;
    }

    public void setQtdRenovações(int qtdRenovações) {
        this.qtdRenovações = qtdRenovações;
    }


    public double getMulta() {
        return this.multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }


    public abstract boolean emprestimo(Publicações publicação);

    public void renovarEmprestimo(Publicações publicação) {
        this.qtdRenovações++;
    }

    public abstract double devolverEmprestimo(Publicações publicação);
}
