public class Carro {
    private int numId;
    private String marca;
    private String nomeDono;


    public Carro(int numId, String marca, String nome) {
        this.numId = numId;
        this.marca = marca;
        this.nomeDono = nome;
    }

    public Carro(int numId) {
        this.numId = numId;
    }
    

    public int getNumId() {
        return this.numId;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return this.nomeDono;
    }

    public void setNome(String nome) {
        this.nomeDono = nome;
    }

}
