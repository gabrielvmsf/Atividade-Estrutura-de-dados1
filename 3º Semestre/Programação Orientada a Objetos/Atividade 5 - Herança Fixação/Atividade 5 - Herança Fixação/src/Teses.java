import java.util.ArrayList;

public class Teses extends Publicações {
    private int numPag;
    private String resumo;
    private String dataDefesa;
    private String instituiçãoTeseDefendida;

    public Teses(String dataPublicação, String titulo, ArrayList<Publicações> publicaçõesReferências,
            ArrayList<Autor> autores, int numPag, String resumo, String dataDefesa, String instituiçãoTeseDefendida,
            double valorMulta) {
        super(dataPublicação, titulo, publicaçõesReferências, autores, 0, valorMulta);
        this.numPag = numPag;
        this.resumo = resumo;
        this.dataDefesa = dataDefesa;
        this.instituiçãoTeseDefendida = instituiçãoTeseDefendida;
    }

    public int getNumPag() {
        return this.numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public String getResumo() {
        return this.resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getDataDefesa() {
        return this.dataDefesa;
    }

    public void setDataDefesa(String dataDefesa) {
        this.dataDefesa = dataDefesa;
    }

    public String getInstituiçãoTeseDefendida() {
        return this.instituiçãoTeseDefendida;
    }

    public void setInstituiçãoTeseDefendida(String instituiçãoTeseDefendida) {
        this.instituiçãoTeseDefendida = instituiçãoTeseDefendida;
    }

}
