import java.sql.Date;
import java.util.ArrayList;

public abstract class Usuario {
    private String Nome;
    private String telefone;
    private String email;
    private String cpf;
    private int qtdEmprestimosPermitidos;
    private int qtdEmprestimosRealizados;
    private ArrayList<Emprestimo> emprestimos;

    public Usuario(String Nome, String telefone, String email, String cpf, int qtdEmprestimosPermitidos) {
        this.Nome = Nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.qtdEmprestimosPermitidos = qtdEmprestimosPermitidos;
        this.emprestimos = new ArrayList<>();
        this.qtdEmprestimosRealizados = 0;
    }

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
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

    public int getQtdEmprestimosPermitidos() {
        return this.qtdEmprestimosPermitidos;
    }

    public void setQtdEmprestimosPermitidos(int qtdEmprestimosPermitidos) {
        this.qtdEmprestimosPermitidos = qtdEmprestimosPermitidos;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return this.emprestimos;
    }

    public int getQtdEmprestimosRealizados() {
        return this.qtdEmprestimosRealizados;
    }

    public void setQtdEmprestimosRealizados(int qtdEmprestimosRealizados) {
        this.qtdEmprestimosRealizados = qtdEmprestimosRealizados;
    }

    public void criarAddEmprestimos(Date dataEmprestimo, Usuario usuario, Publicação publicação) {
        try {
            Emprestimo emprestimo = new Emprestimo(dataEmprestimo, usuario, publicação);// try
            this.emprestimos.add(emprestimo);
        } catch (PublicaçãoNãoDisponívelException e) {
            System.out.println("Publicação não disponível");
        } catch (ExcedeuQtdException e) {
            System.out.println("Excedeu a quantidade de emprestimos");
        }

    }

    public void removeEmprestimos(Emprestimo emprestimo) {
        this.emprestimos.remove(emprestimo);
    }
}
