import java.sql.Date;

public class UsuarioComum extends Usuario{

    public UsuarioComum(String Nome, String telefone, String email, String cpf) {
        super(Nome, telefone, email, cpf, 1);
    }
    
    @Override
    public void criarAddEmprestimos(Date dataEmprestimo, Usuario usuario, Publicação publicação) {
        if(getQtdEmprestimosRealizados()<=getQtdEmprestimosPermitidos()) super.criarAddEmprestimos(dataEmprestimo, usuario, publicação);
        else throw new ExcedeuQtdException("O úsuario excedeu a quantidade de emprestimos permitidas");
    }
}
