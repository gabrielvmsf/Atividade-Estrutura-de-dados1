import java.util.ArrayList;

public class Livros extends Publicações {
    private int numEdição;
    private String nomeEditora;
    private String ISBN;

    public Livros(String dataPublicação, String titulo, ArrayList<Publicações> publicaçõesReferências,
            ArrayList<Autor> autores,int numEdição, String nomeEditora, String ISBN, double valorMulta) {
        super(dataPublicação, titulo, publicaçõesReferências, autores,0,valorMulta);
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
