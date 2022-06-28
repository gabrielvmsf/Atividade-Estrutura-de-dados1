public class PessoaFísica extends Cliente {
    private String cpf;

    public PessoaFísica(String nome, String telefone, String endereço, String cpf) {
        super(nome, telefone, endereço, 1);
        this.cpf = cpf;
    }

    public String getcpf() {
        return this.cpf;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

}
