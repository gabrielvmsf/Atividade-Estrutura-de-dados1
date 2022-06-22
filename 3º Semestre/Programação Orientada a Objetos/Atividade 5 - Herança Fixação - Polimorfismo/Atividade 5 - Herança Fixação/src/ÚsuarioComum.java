public class ÚsuarioComum extends Úsuario {

    private int qtdEmprestimos;
    private Emprestimo emprestimoAtual;

    public ÚsuarioComum(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, email, cpf);
        this.qtdEmprestimos = 0;
    }

    public int getQtdEmprestimos() {
        return this.qtdEmprestimos;
    }

    public void setQtdEmprestimos(int qtdEmprestimos) {
        this.qtdEmprestimos = qtdEmprestimos;
    }

    public Emprestimo getEmprestimoAtual() {
        return this.emprestimoAtual;
    }

    public void setEmprestimoAtual(Emprestimo emprestimoAtual) {
        this.emprestimoAtual = emprestimoAtual;
    }

    @Override
    public boolean realizarEmprestimo(Publicações publicação, Úsuario usuario) {
        if (getQtdEmprestimos() == 0) {
            qtdEmprestimos=1;
            super.realizarEmprestimo(publicação,usuario);
            return true;
        }
        return false;
    }

    @Override
    public boolean devolverEmprestimo(Emprestimo emprestimo) {
        qtdEmprestimos = 0;
        return super.devolverEmprestimo(emprestimo);
    }
}
