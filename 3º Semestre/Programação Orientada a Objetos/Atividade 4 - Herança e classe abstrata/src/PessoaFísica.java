public class PessoaFísica extends Cliente {
    private String cpf;
    private Conta contaCorrente;
    private Conta contaPoupança;
    private Conta contaEspecial;


    public PessoaFísica(String nome, String cpf, String endereco, String telefone, String celular, int idade,String cpfFísica) {
        super(nome, endereco, telefone, celular, idade);
        this.cpf = cpfFísica;
    }

    public void criarContaCorrente(int nroConta, String nomeTitular){
        this.contaCorrente = new ContaCorrente(nroConta, nomeTitular, cpf);
    }

    public void criarContaPoupança(int nroConta, String nomeTitular){
        this.contaPoupança = new ContaPoupança(nroConta, nomeTitular, cpf);
    }

    public void criarContaEspecial(int nroConta, String nomeTitular, double valorChequeEspecial){
        this.contaEspecial = new ContaEspecial(nroConta, nomeTitular, cpf, valorChequeEspecial);
    }


    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Conta getContaCorrente() {
        return this.contaCorrente;
    }

    public void setContaCorrente(Conta contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public Conta getContaPoupança() {
        return this.contaPoupança;
    }

    public void setContaPoupança(Conta contaPoupança) {
        this.contaPoupança = contaPoupança;
    }

    public Conta getContaEspecial() {
        return this.contaEspecial;
    }

    public void setContaEspecial(Conta contaEspecial) {
        this.contaEspecial = contaEspecial;
    }
}
