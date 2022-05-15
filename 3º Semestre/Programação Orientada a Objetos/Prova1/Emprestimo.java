package javaapplication5;

public class Emprestimo {

    private Livros livro;
    private Usuario usuario;
    private String dataInicio;
    private String dataEntrega;
    private double multa;
    private int qtdEmprestimo;

    public Emprestimo(Usuario usuario, Livros livro, String dataInicio, String dataEntrega) {
        if (livro.isSituação() == true) {
            this.usuario = usuario;
            this.livro = livro;
            this.dataInicio = dataInicio;
            this.dataEntrega = dataEntrega;
            this.multa = 0;
            this.qtdEmprestimo = 0;
            livro.setSituação(false);
        }
    }

    public void renovar(Usuario usuario, Livros livro) {
        int i = this.qtdEmprestimo;
        i += 1;
        if (i > 3) {
            this.multa += 1.00;
        }
        this.qtdEmprestimo = i;
    }

    public void entregar() {
        System.out.println("\nMulta: " + this.multa);
        livro.setSituação(true);
    }

}
