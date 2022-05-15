package socror;

public class Produto {
    private String nome;
    private double precoCusto;
    private double precoVenda;
    private double margemLucro;


    public Produto(String nome,double precoCusto,double precoVenda){
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.margemLucro = calcularMargemLucro();
    }
    public Produto(double precoCusto,double precoVenda){
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.margemLucro = calcularMargemLucro();
    }
    public Produto(){

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoCusto() {
        return this.precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return this.precoVenda;
    }

    public Boolean setPrecoVenda(double precoVenda) {
        if (precoVenda<precoCusto){
            return false;
        } else this.precoVenda = precoVenda;
        return true;
    }

    public double getMargemLucro() {
        return this.margemLucro;
    }

    public void setMargemLucro(double margemLucro) {
        this.margemLucro = margemLucro;
    }

    public double calcularMargemLucro(){
        this.margemLucro = this.precoVenda - this.precoCusto ;
        return this.margemLucro;
    }
    public double getMargemLucroPorcentagem(){
        double MargemLucroPorcentagem = (this.precoCusto / this.precoVenda) * 100;
        return MargemLucroPorcentagem;
    }

}
