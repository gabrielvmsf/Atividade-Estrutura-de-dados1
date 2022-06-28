public class CarroLuxo extends Carro {
    private int quantidadeAirbags;
    private double tamanhoPortaMalas;
    private boolean gpsIntegrado;

    public CarroLuxo(int quantidadeAirbags, double tamanhoPortaMalas, boolean gpsIntegrado, String marca, String modelo,
            String placa, int ano, String cor, double valorLocação, double valorRenovação) {
        super(marca, modelo, placa, ano, cor, valorLocação, valorRenovação, 5);
        this.quantidadeAirbags = quantidadeAirbags;
        this.tamanhoPortaMalas = tamanhoPortaMalas;
        this.gpsIntegrado = gpsIntegrado;
    }

    public int getQuantidadeAirbags() {
        return this.quantidadeAirbags;
    }

    public void setQuantidadeAirbags(int quantidadeAirbags) {
        this.quantidadeAirbags = quantidadeAirbags;
    }

    public double getTamanhoPortaMalas() {
        return this.tamanhoPortaMalas;
    }

    public void setTamanhoPortaMalas(double tamanhoPortaMalas) {
        this.tamanhoPortaMalas = tamanhoPortaMalas;
    }

    public boolean isGpsIntegrado() {
        return this.gpsIntegrado;
    }

    public boolean getGpsIntegrado() {
        return this.gpsIntegrado;
    }

    public void setGpsIntegrado(boolean gpsIntegrado) {
        this.gpsIntegrado = gpsIntegrado;
    }

}
