public class Alocação {
    private Cliente cliente;
    private Carro carro;
    private int qtdRenovações;
    private double multa;
    private double valorTotal;

    public Alocação(Cliente cliente, Carro carro) {
        this.cliente = cliente;
        this.carro = carro;
        this.qtdRenovações = 0;
        this.multa = 0.0;
        this.valorTotal = 0.0;
        carro.setDisponivel(false);
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return this.carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public void renovar() {
        this.qtdRenovações++;
    }

    private double calcularAdicionalRenovação() {
        if (this.qtdRenovações > this.carro.getQtdRenovaçãoSemCusto()) {
            return (this.qtdRenovações - this.carro.getQtdRenovaçãoSemCusto()) * this.carro.getValorRenovação();
        }
        return 0.0;
    }

    public double devolverCarro() {
        this.multa = calcularAdicionalRenovação();
        this.valorTotal = this.multa + this.carro.getValorLocação();
        this.carro.setDisponivel(true);
        return valorTotal;
    }
}
