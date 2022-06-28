public class CarroPopular extends Carro {
    private boolean arCondicionado;

    public CarroPopular(boolean arCondicionado, String marca, String modelo, String placa, int ano, String cor,
            double valorLocação, double valorRenovação) {
        super(marca, modelo, placa, ano, cor, valorLocação, valorRenovação, 1);
        this.arCondicionado = arCondicionado;
    }

    public boolean isArCondicionado() {
        return this.arCondicionado;
    }

    public boolean getArCondicionado() {
        return this.arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

}
