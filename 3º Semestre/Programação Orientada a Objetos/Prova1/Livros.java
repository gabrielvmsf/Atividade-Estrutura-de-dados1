package javaapplication5;

public class Livros {

    private String título;
    private String nomeAutor;
    private String editora;
    private short edição;
    private int vezesEmprestadoLivro;
    private boolean situação;

    public Livros(String título, String nomeAutor, String editora, short edição, boolean situação) {
        this.título = título;
        this.nomeAutor = nomeAutor;
        this.editora = editora;
        this.edição = edição;
        vezesEmprestadoLivro = 0;
        situação = true;
    }

    public int getVezesEmprestadoLivro() {
        return vezesEmprestadoLivro;
    }

    public void setVezesEmprestadoLivro(int vezesEmprestadoLivro) {
        this.vezesEmprestadoLivro = vezesEmprestadoLivro;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public short getEdição() {
        return edição;
    }

    public void setEdição(short edição) {
        this.edição = edição;
    }

    public boolean isSituação() {
        return situação;
    }

    public void setSituação(boolean situação) {
        this.situação = situação;
    }

}
