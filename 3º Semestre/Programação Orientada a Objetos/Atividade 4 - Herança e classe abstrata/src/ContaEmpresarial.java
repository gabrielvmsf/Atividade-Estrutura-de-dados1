public class ContaEmpresarial extends Conta {
    private String cnpjTitular;
    public ContaEmpresarial(int nroConta, int agencia, String nomeTitular, String cnpjTitular) {
        super(nroConta, agencia, nomeTitular);
        this.cnpjTitular = cnpjTitular;
    }

    public ContaEmpresarial(int nroConta, String nomeTitular, String cnpjTitular) {
        super(nroConta, nomeTitular);
        this.cnpjTitular = cnpjTitular;
    }
}