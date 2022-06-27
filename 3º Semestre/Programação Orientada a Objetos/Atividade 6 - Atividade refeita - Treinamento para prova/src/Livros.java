import java.sql.Date;

public class Livros extends Publicação {
    private int numEdição;
    private String nomeEditora;
    private String ISBN;


    public Livros(int numEdição, String nomeEditora, String ISBN,Date dataPublicação, String titulo, double valorMulta) {
        super(dataPublicação, titulo, valorMulta);
        this.numEdição = numEdição;
        this.nomeEditora = nomeEditora;
        this.ISBN = ISBN;
    }

    public int getNumEdição() {
        return this.numEdição;
    }

    public void setNumEdição(int numEdição) {
        this.numEdição = numEdição;
    }

    public String getNomeEditora() {
        return this.nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }


}
