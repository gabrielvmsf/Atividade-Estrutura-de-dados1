public class ÚsuarioEspecial extends Úsuario {

    public ÚsuarioEspecial(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, email, cpf);
    }

    @Override
    public boolean emprestimo(Publicações publicação) {
        setPublicaçãoEmprestada(publicação);
        return false;
    }

}
