import java.util.ArrayList;

public abstract class Úsuario {
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private int qtdRenovações;
    private ArrayList<Emprestimo> emprestimosRealizados = new ArrayList<Emprestimo>();

    public Úsuario(String nome, String telefone, String email, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.qtdRenovações = 0;
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

    public boolean realizarEmprestimo(Publicações publicação, Úsuario usuario) {
        Emprestimo emprestimo = new Emprestimo(publicação, usuario);
        emprestimosRealizados.add(emprestimo);
        return true;
    }

    public boolean devolverEmprestimo(Emprestimo emprestimo, Úsuario usuario) {
        if (emprestimosRealizados.contains(emprestimo)) {
            Publicações publicação = emprestimo.getPublicação();
            emprestimo.devolverEmprestimo(publicação, usuario);
            emprestimosRealizados.remove(emprestimo);
            return true;
        }
        return false;
    }
}
