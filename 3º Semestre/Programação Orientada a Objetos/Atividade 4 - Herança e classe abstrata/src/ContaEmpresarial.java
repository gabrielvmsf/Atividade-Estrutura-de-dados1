public class ContaEmpresarial extends ContaEspecial {
    private String cnpjTitular;

    public ContaEmpresarial(String cnpjTitular, int nroConta, String nomeTitular, double valorChequeEspecial) {
        super(nroConta, nomeTitular, valorChequeEspecial);
        this.cnpjTitular = cnpjTitular;
    }
}