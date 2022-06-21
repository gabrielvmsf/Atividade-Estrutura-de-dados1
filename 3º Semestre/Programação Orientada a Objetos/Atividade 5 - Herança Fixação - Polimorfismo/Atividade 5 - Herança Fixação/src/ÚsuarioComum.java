public class ÚsuarioComum extends Úsuario {

    private int qtdEmprestimos;
    private Publicações publicaçãoEmprestada;

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

    public Publicações getPublicaçãoEmprestada() {
        return this.publicaçãoEmprestada;
    }

    public void setPublicaçãoEmprestada(Publicações publicaçãoEmprestada) {
        this.publicaçãoEmprestada = publicaçãoEmprestada;
    }

    @Override
    public boolean emprestimo(Publicações publicação) {
        if (publicação.getQtdEmprestado() == 0 && getQtdEmprestimos() == 0) {
            publicação.setQtdEmprestado(1);
            setQtdEmprestimos(1);
            setPublicaçãoEmprestada(publicação);
            return true;
        }
        return false;
    }
    @Override
    public double devolverEmprestimo(Publicações publicação){
        qtdEmprestimos--;
        publicação.setQtdEmprestado(0);
        publicaçãoEmprestada = null;
        
        if (getQtdRenovações() > 3) {
            this.setMulta((getQtdRenovações()  - 3) * publicação.getValorMulta());
            setQtdRenovações(0);
            return getMulta();
        }
        setQtdRenovações(0);
        setMulta(0);
        return getMulta();
    }

}
