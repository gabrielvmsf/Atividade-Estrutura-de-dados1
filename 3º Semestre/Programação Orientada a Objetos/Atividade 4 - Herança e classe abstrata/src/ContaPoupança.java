public class ContaPoupança extends Conta {

    public ContaPoupança(int nroConta, int agencia, String nomeTitular, String cpfTitular) {
        super(nroConta, agencia, nomeTitular, cpfTitular);
    }

    public ContaPoupança(int nroConta, String nomeTitular, String cpfTitular) {
        super(nroConta, nomeTitular, cpfTitular);
    }

    public void rendimento(){
        depositar((getSaldo() * 0.005));
    }
}

