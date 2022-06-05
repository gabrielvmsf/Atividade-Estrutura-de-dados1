public class ContaEmpresarial extends ContaEspecial {
    private String cnpjTitular;

    public ContaEmpresarial(String cnpjTitular, int nroConta, String nomeTitular, String cpfTitular, double valorChequeEspecial) {
        super(nroConta, nomeTitular, cpfTitular, valorChequeEspecial);
        this.cnpjTitular = cnpjTitular;
    }
}