import java.sql.Date;
public class Artigos extends Publicação {

    private String resumo;

    public Artigos(Date dataPublicação, String titulo, double valorMulta, String resumo) {
        super(dataPublicação, titulo, valorMulta);
        this.resumo = resumo;
    }

    public String getResumo() {
        return this.resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

}
