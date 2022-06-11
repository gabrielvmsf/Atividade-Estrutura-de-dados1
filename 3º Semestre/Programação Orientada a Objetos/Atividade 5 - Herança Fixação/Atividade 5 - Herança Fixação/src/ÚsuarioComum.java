public class ÚsuarioComum extends Úsuario {

    private int qtdEmprestimos;
    
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


    @Override
    public boolean emprestimo(Publicações publicação) {
        if(publicação.getQtdEmprestado()==0 && getQtdEmprestimos()==0){
            publicação.setQtdEmprestado(1); setQtdEmprestimos(1);
            setPublicaçãoEmprestada(publicação);
            return true;
        }
        return false;
    }

    
}
