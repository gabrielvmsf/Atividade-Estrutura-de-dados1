public class CarroSUV extends Carro {
    private double tamanhoPortaMalas;
    private String tipoDeTração;
    private String tipoDeCombustivel;

    public CarroSUV(double tamanhoPortaMalas, String tipoDeTração, String tipoDeCombustivel, String marca,
            String modelo, String placa, int ano, String cor, double valorLocação, double valorRenovação) {
        super(marca, modelo, placa, ano, cor, valorLocação, valorRenovação, 3);
        this.tamanhoPortaMalas = tamanhoPortaMalas;
        this.tipoDeTração = tipoDeTração;
        this.tipoDeCombustivel = tipoDeCombustivel;
    }

    public double getTamanhoPortaMalas() {
        return this.tamanhoPortaMalas;
    }

    public void setTamanhoPortaMalas(double tamanhoPortaMalas) {
        this.tamanhoPortaMalas = tamanhoPortaMalas;
    }

    public String getTipoDeTração() {
        return this.tipoDeTração;
    }

    public void setTipoDeTração(String tipoDeTração) {
        this.tipoDeTração = tipoDeTração;
    }

    public String getTipoDeCombustivel() {
        return this.tipoDeCombustivel;
    }

    public void setTipoDeCombustivel(String tipoDeCombustivel) {
        this.tipoDeCombustivel = tipoDeCombustivel;
    }

}
