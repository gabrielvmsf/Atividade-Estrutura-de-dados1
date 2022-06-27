import java.util.ArrayList;

public class Biblioteca {
    private String nome;
    private String endereço;
    private ArrayList<Publicação> Publicações;


    public Biblioteca(String nome, String endereço) {
        this.nome = nome;
        this.endereço = endereço;
        this.Publicações = new ArrayList<Publicação>();
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

    public ArrayList<Publicação> getPublicações() {
        return this.Publicações;
    }

    public void addPublicações(Publicação publicação) {
        this.Publicações.add(publicação);
    }

    public void removePublicações(Publicação publicação) {
        this.Publicações.remove(publicação);
    }

}
