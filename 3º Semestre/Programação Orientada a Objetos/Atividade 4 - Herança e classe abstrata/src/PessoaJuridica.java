public class PessoaJuridica extends Cliente {
    private String cnpj;

    public PessoaJuridica(String nome, String cpf, String endereco, String telefone, String celular, int idade,String cnpjString) {
        super(nome, endereco, telefone, celular, idade);
        this.cnpj = cnpjString;
    }

    public void criarContaEmpresarial(int nroConta, String nomeTitular){
        Conta contaEmpresarial = new ContaEmpresarial(nroConta, nomeTitular, cnpj);
    }
}
