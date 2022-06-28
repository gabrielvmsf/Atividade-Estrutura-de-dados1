import java.util.ArrayList;

public class Locadora {
    private String nome;
    private String endereço;
    private String telefone;
    private ArrayList<Carro> carros;

    public Locadora(String nome, String endereço, String telefone, ArrayList<Carro> carros) {
        this.nome = nome;
        this.endereço = endereço;
        this.telefone = telefone;
        this.carros = new ArrayList<Carro>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return this.endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Carro> getCarros() {
        return this.carros;
    }

    public void addCarros(Carro carro) {
        this.carros.add(carro);
    }

    public void removeCarros(Carro carro) {
        this.carros.remove(carro);
    }

}
