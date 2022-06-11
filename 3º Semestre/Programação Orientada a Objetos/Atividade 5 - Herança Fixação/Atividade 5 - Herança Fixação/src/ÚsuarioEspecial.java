public class ÚsuarioEspecial extends Úsuario {

    public ÚsuarioEspecial(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, email, cpf);
    }

    @Override
    public boolean emprestimo(Publicações publicação) {
        setPublicaçãoEmprestada(publicação);
        return false;
    }

    @Override
    public double devolverEmprestimo(Publicações publicação){
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
