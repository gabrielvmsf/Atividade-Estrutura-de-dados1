public class PessoaJuridica extends Cliente {
    private String cnpj;
    private Conta contaEmpresarial;

    public PessoaJuridica(String nome, String cpf, String endereco, String telefone, String celular, int idade,String cnpjString) {
        super(nome, endereco, telefone, celular, idade);
        this.cnpj = cnpjString;
    }

    public void criarContaEmpresarial(int nroConta, String nomeTitular,double valorChequeEspecial){
        this.contaEmpresarial = new ContaEmpresarial(this.cnpj, nroConta, nomeTitular, valorChequeEspecial);
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Conta getContaEmpresarial() {
        return this.contaEmpresarial;
    }

    public void setContaEmpresarial(Conta contaEmpresarial) {
        this.contaEmpresarial = contaEmpresarial;
    }
    
}
