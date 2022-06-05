public class ContaEspecial extends Conta {

    private double valorChequeEspecial;
    private double saldo;


    public ContaEspecial(int nroConta, int agencia, String nomeTitular, String cpfTitular, double valorChequeEspecial) {
        super(nroConta, agencia, nomeTitular, cpfTitular);
        this.valorChequeEspecial = valorChequeEspecial;
        this.saldo = getSaldo();
    }

    public ContaEspecial(int nroConta, String nomeTitular, String cpfTitular, double valorChequeEspecial) {
        super(nroConta, nomeTitular, cpfTitular);
        this.valorChequeEspecial = valorChequeEspecial;
        this.saldo = getSaldo();
    }

    public boolean saqueContaEspecial(double valor) {
        if (valor <= (this.saldo + valorChequeEspecial) && valor > 0) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean depositoContaEspecial(double valor) {
        if (valor > 0) {
            depositar(valor);
            this.saldo = getSaldo();
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, Conta conta) {
        if (valor <= (this.saldo + valorChequeEspecial) && valor > 0) {
            if (this.saqueContaEspecial(valor)) {
                conta.depositar(valor);
                return true;
            }
        }
        return false;
    }

    public double getValorChequeEspecial() {
        return this.valorChequeEspecial;
    }

}
