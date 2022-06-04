public class PessoaFísica extends Cliente {
    private String cpf;

    public PessoaFísica(String nome, String cpf, String endereco, String telefone, String celular, int idade,String cpfFísica) {
        super(nome, endereco, telefone, celular, idade);
        this.cpf = cpfFísica;
    }

    public void criarContaCorrente(int nroConta, String nomeTitular){
        Conta contaCorrente = new ContaCorrente(nroConta, nomeTitular, cpf);
    }

    public void criarContaPoupança(int nroConta, String nomeTitular){
        Conta contaPoupança = new ContaPoupança(nroConta, nomeTitular, cpf);
    }

    public void criarContaEspecial(int nroConta, String nomeTitular, double valorChequeEspecial){
        Conta contaEspecial = new ContaEspecial(nroConta, nomeTitular, cpf, valorChequeEspecial);
    }

}
