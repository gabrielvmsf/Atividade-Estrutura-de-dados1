public class Emprestimo {
    private Publicações publicação;
    private Úsuario usuario;
    private int qtdRenovações;
    private double multa;
    private boolean verificarverificarDisponibilidade;

    public Emprestimo(Publicações publicação, Úsuario usuario) {
        this.verificarverificarDisponibilidade = this.emprestimo(publicação, usuario);
        this.qtdRenovações = 0;
        this.multa = 0.00;
    }

    public Publicações getPublicação() {
        return this.publicação;
    }

    public Úsuario getUsuario() {
        return this.usuario;
    }

    public int getQtdRenovações() {
        return this.qtdRenovações;
    }

    public double getMulta() {
        return this.multa;
    }

    public void setQtdRenovações(int qtdRenovações) {
        this.qtdRenovações = qtdRenovações;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
    
    public boolean isVerificarDisponibilidade() {
        return this.verificarverificarDisponibilidade;
    }


    private boolean emprestimo(Publicações publicação, Úsuario usuario) {
        if (publicação.getQtdEmprestado() == 0) {
            publicação.setQtdEmprestado(1);
            this.publicação = publicação;
            this.usuario = usuario;
            return true;
        }
        return false;
    }

    public void renovarEmprestimo(Publicações publicação) {
        this.qtdRenovações++;
    }

    public double devolverEmprestimo(Publicações publicação, Úsuario usuario) {
        if (publicação.getQtdEmprestado() == 1) {
            publicação.setQtdEmprestado(0);
            if (getQtdRenovações() > 3) {
                multa = (qtdRenovações - 3) * publicação.getValorMulta();
                qtdRenovações = 0;
                return multa;
            }
            qtdRenovações = 0;
            multa = 0.00;
            return multa;
        }
        return -1;
    }

}
