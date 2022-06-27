import java.sql.Date;

public class Emprestimo {
    private Date dataEmprestimo;
    private double multa;
    private Usuario usuario;
    private Publicação publicação;
    private int qtdRenovações;

    public Emprestimo(Date dataEmprestimo, Usuario usuario, Publicação publicação) {
        if (usuario.getQtdEmprestimosPermitidos() >= usuario.getQtdEmprestimosRealizados()
                || usuario.getQtdEmprestimosPermitidos() == -1) {
            if (publicação.getDisponivel()) {
                this.dataEmprestimo = dataEmprestimo;
                this.multa = 0.0;
                this.usuario = usuario;
                this.publicação = publicação;
                this.qtdRenovações = 0;
                publicação.setDisponivel(false);
                usuario.setQtdEmprestimosRealizados(usuario.getQtdEmprestimosRealizados() + 1);
            } else {
                throw new PublicaçãoNãoDisponívelException();
            }
        } else {
            throw new ExcedeuQtdException();
        }
    }

    public void renovar() {
        qtdRenovações++;
    }

    public double calcularMulta() {
        if (qtdRenovações > 3)
            return this.publicação.getValorMulta() * (qtdRenovações - 3);
        else
            return 0.0;
    }

    public boolean devolver() {
        if (publicação.getDisponivel() == false) {
            publicação.setDisponivel(true);
            usuario.setQtdEmprestimosRealizados(usuario.getQtdEmprestimosRealizados() - 1);
            this.multa = calcularMulta();
            return true;
        }
        return false;
    }

}
