import java.util.ArrayList;

public abstract class Publicações {
    private String dataPublicação;
    private String titulo;
    private ArrayList<Publicações> publicaçõesReferências = new ArrayList<Publicações>();
    private ArrayList<Autor> autores = new ArrayList<Autor>();
    private int qtdEmprestado;
    private double valorMulta;

    public Publicações(String dataPublicação, String titulo, ArrayList<Publicações> publicaçõesReferências, ArrayList<Autor> autores,int qtdEmprestado,double valorMulta) {
        this.dataPublicação = dataPublicação;
        this.titulo = titulo;
        this.publicaçõesReferências = publicaçõesReferências;
        this.autores = autores;
        this.qtdEmprestado = qtdEmprestado;
        this.valorMulta = valorMulta;
    }


    public String getDataPublicação() {
        return this.dataPublicação;
    }

    public void setDataPublicação(String dataPublicação) {
        this.dataPublicação = dataPublicação;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Publicações> getPublicaçõesReferências() {
        return this.publicaçõesReferências;
    }

    public void setPublicaçõesReferências(ArrayList<Publicações> publicaçõesReferências) {
        this.publicaçõesReferências = publicaçõesReferências;
    }

    public ArrayList<Autor> getAutores() {
        return this.autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public int getQtdEmprestado() {
        return this.qtdEmprestado;
    }

    public void setQtdEmprestado(int qtdEmprestado) {
        this.qtdEmprestado = qtdEmprestado;
    }

    public double getValorMulta() {
        return this.valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }
    

}
