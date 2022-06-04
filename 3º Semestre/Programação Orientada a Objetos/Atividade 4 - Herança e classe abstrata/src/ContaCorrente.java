public class ContaCorrente extends Conta {

    private String cnpjTitular;

    public ContaCorrente(int nroConta, int agencia, String nomeTitular, String cpfTitular) {
        super(nroConta, agencia, nomeTitular, cpfTitular);
    }

    public ContaCorrente(int nroConta, String nomeTitular, String cnpjTitular) {
        super(nroConta, nomeTitular, cnpjTitular);
    }

    public String getCnpjTitular() {
        return this.cnpjTitular;
    }

    public void setCnpjTitular(String cnpjTitular) {
        this.cnpjTitular = cnpjTitular;
    }

}
