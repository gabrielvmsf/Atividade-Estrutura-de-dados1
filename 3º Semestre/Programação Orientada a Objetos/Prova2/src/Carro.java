public abstract class Carro {
    private String marca;
    private String modelo;
    private String placa;
    private int ano;
    private String cor;
    private double valorLocação;
    private double valorRenovação;
    private int qtdRenovaçãoSemCusto;
    private boolean disponivel;

    public Carro(String marca, String modelo, String placa, int ano, String cor, double valorLocação,
            double valorRenovação, int qtdRenovaçãoSemCusto) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
        this.valorLocação = valorLocação;
        this.valorRenovação = valorRenovação;
        this.qtdRenovaçãoSemCusto = qtdRenovaçãoSemCusto;
        this.disponivel = true;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValorLocação() {
        return this.valorLocação;
    }

    public void setValorLocação(double valorLocação) {
        this.valorLocação = valorLocação;
    }

    public double getValorRenovação() {
        return this.valorRenovação;
    }

    public void setValorRenovação(double valorRenovação) {
        this.valorRenovação = valorRenovação;
    }

    public int getQtdRenovaçãoSemCusto() {
        return this.qtdRenovaçãoSemCusto;
    }

    public void setQtdRenovaçãoSemCusto(int qtdRenovaçãoSemCusto) {
        this.qtdRenovaçãoSemCusto = qtdRenovaçãoSemCusto;
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
