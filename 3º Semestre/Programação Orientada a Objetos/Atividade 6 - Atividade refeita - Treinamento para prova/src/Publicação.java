import java.sql.Date;
import java.util.ArrayList;

public class Publicação {
    private Date dataPublicação;
    private String titulo;
    private ArrayList<Publicação> referências;
    private ArrayList<Autor> autores;
    private double valorMulta;
    private boolean disponivel;


    public Publicação(Date dataPublicação, String titulo, double valorMulta) {
        this.dataPublicação = dataPublicação;
        this.titulo = titulo;
        this.referências = new ArrayList<Publicação>();
        this.autores = new ArrayList<Autor>();
        this.valorMulta = valorMulta;
        this.disponivel = true;
    }


    public Date getDataPublicação() {
        return this.dataPublicação;
    }

    public void setDataPublicação(Date dataPublicação) {
        this.dataPublicação = dataPublicação;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Publicação> getReferências() {
        return this.referências;
    }

    public void addReferencia(Publicação referência) {
        this.referências.add(referência);
    }

    public void removeReferencia(Publicação referência) {
        this.referências.remove(referência);
    }

    public ArrayList<Autor> getAutores() {
        return this.autores;
    }

    public void addAutor(Autor autor) {
        this.autores.add(autor);
    }

    public void removeAutor(Autor autor) {
        this.autores.remove(autor);
    }

    public double getValorMulta() {
        return this.valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }
    

    public boolean isDisponivel() {
        return this.disponivel;
    }

    public boolean getDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

}
