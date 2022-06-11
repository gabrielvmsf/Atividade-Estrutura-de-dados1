import java.util.ArrayList;
public class Biblioteca {
    private String nome;
    private String endereço;
    private ArrayList<Livros> livros = new ArrayList<Livros>();
    private ArrayList<Artigos> artigos = new ArrayList<Artigos>();
    //private ArrayList<Publicações> outrasPublicações = new ArrayList<Publicações>();


    public Biblioteca(String nome, String endereço, ArrayList<Livros> livros, ArrayList<Artigos> artigos) {
        this.nome = nome;
        this.endereço = endereço;
        this.livros = livros;
        this.artigos = artigos;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return this.endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public ArrayList<Livros> getLivros() {
        return this.livros;
    }

    public void setLivros(ArrayList<Livros> livros) {
        this.livros = livros;
    }

    public ArrayList<Artigos> getArtigos() {
        return this.artigos;
    }

    public void setArtigos(ArrayList<Artigos> artigos) {
        this.artigos = artigos;
    }

}
