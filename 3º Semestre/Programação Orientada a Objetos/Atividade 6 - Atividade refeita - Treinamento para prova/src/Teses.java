import java.sql.Date;

public class Teses extends Publicação {
    private int numPag;
    private String resumo;
    private String dataDefesa;
    private String instituiçãoTeseDefendida;
    private int numAutores;


    public Teses(int numPag, String resumo, String dataDefesa, String instituiçãoTeseDefendida, Date dataPublicação, String titulo, double valorMulta) {
        super(dataPublicação, titulo, valorMulta);
        this.numPag = numPag;
        this.resumo = resumo;
        this.dataDefesa = dataDefesa;
        this.instituiçãoTeseDefendida = instituiçãoTeseDefendida;
        this.numAutores = 0;
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

    @Override
    public void addAutor(Autor autor) {
        if(this.numAutores==0){
            this.numAutores=1;
            super.addAutor(autor);
        }
    }

    @Override
    public void removeAutor(Autor autor) {
        super.removeAutor(autor);
        this.numAutores = 0;
    }
    

}
