import java.util.ArrayList;

public class Artigos extends Publicações {

    private String resumo;

    public Artigos(String dataPublicação, String titulo, ArrayList<Publicações> publicaçõesReferências,
            ArrayList<Autor> autores, String resumo, double valorMulta) {
                super(dataPublicação, titulo, publicaçõesReferências, autores,0,valorMulta);
        this.resumo = resumo;
    }

    public String getResumo() {
        return this.resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    

}
