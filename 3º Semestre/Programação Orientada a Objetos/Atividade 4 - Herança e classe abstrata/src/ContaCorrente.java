public class ContaCorrente extends Conta {

    public ContaCorrente(int nroConta, int agencia, String nomeTitular, String cpfTitular) {
        super(nroConta, agencia, nomeTitular, cpfTitular);
    }

    public ContaCorrente(int nroConta, String nomeTitular, String cpf) {
        super(nroConta, nomeTitular, cpf);
    }

    

}
