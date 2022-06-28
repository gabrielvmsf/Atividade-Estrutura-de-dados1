public class Empresa extends Cliente {
    private String cnpj;
    private PessoaFísica pessoaFísica;

    public Empresa(String nome, String telefone, String endereço, String cnpj, PessoaFísica pessoaFísica) {
        super(nome, telefone, endereço, -1); // -1 para classes filhas que não necessitam de limite, pensando em
                                             // possiveis futuras classes
        this.cnpj = cnpj;
        this.pessoaFísica = pessoaFísica;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public PessoaFísica getPessoaFísica() {
        return this.pessoaFísica;
    }

    public void setPessoaFísica(PessoaFísica pessoaFísica) {
        this.pessoaFísica = pessoaFísica;
    }
}
