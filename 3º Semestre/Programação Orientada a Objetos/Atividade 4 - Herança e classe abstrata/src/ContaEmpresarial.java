public class ContaEmpresarial extends ContaEspecial {
    private String cnpjTitular;

    public ContaEmpresarial(String cnpj, int nroConta, String nomeTitular, double valorChequeEspecial) {
        super(nroConta, nomeTitular, valorChequeEspecial);
        this.cnpjTitular = cnpj;
    }
}