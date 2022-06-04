//Classe conta criada em aula

public abstract class Conta implements Comparable<Conta>{
   private int nroConta;
   private int agencia;
   private String nomeTitular;
   private String cpfTitular;
   //String nomeBanco;
   //int nroBanco;
   private double saldo;

   public Conta(int nroConta, int agencia, String nomeTitular, String cpfTitular){
      this.nroConta = nroConta;
      this.agencia = agencia;
      this.nomeTitular = nomeTitular;
      this.cpfTitular = cpfTitular;
      this.saldo = 0.0;
   }

   public Conta(int nroConta, int agencia, String nomeTitular){
      this.nroConta = nroConta;
      this.agencia = agencia;
      this.nomeTitular = nomeTitular;

      this.saldo = 0.0;
   }


   public Conta(int nroConta, String nomeTitular, String cpfTitular){
      this.nroConta = nroConta;
      this.nomeTitular = nomeTitular;
      this.cpfTitular = cpfTitular;

      this.agencia = 123;
      this.saldo = 0.0;
   }
   public Conta(int nroConta, String nomeTitular){
      this.nroConta = nroConta;
      this.nomeTitular = nomeTitular;

      this.agencia = 123;
      this.saldo = 0.0;
   }


   public double getSaldo(){
      return this.saldo;
   }

   public int getNroConta() {
      return this.nroConta;
   }

   public void setNroConta(int nroConta) {
      this.nroConta = nroConta;
   }

   public int getAgencia() {
      return this.agencia;
   }

   public void setAgencia(int agencia) {
      this.agencia = agencia;
   }

   public String getNomeTitular() {
      return this.nomeTitular;
   }

   public void setNomeTitular(String nomeTitular) {
      this.nomeTitular = nomeTitular;
   }

   public String getCpfTitular() {
      return this.cpfTitular;
   }

   public void setCpfTitular(String cpfTitular) {
      this.cpfTitular = cpfTitular;
   }


   public boolean depositar(double valor){
      if(valor > 0){
         this.saldo += valor;
         return true;
      }
      return false;
   }


   public boolean sacar(double valor){
      if(valor > 0 && valor <= this.saldo){
         this.saldo -= valor;
         return true;
      }
      return false;
   }

   public boolean transferir(double valor, Conta conta){
      if(this.sacar(valor)){
         conta.depositar(valor);
         return true;
      }
      return false;
   }

   public void extrato(){//Totalmente errado fazer isso!
      System.out.println("<<<<< Dados da Conta >>>>>");
      System.out.println("Nome titular: "+this.nomeTitular);
      System.out.println("Número conta: "+this.nroConta);
      System.out.println("Saldo R$"+this.saldo);
      System.out.println("-------------------------------\n\n");
   }

   @Override
   public int compareTo(Conta c) {
      if(this.nroConta > c.getNroConta()) return 1;
      if(this.nroConta < c.getNroConta()) return -1;
      return 0;
   }


   @Override
   public boolean equals(Object obj) {

      if(obj.getClass() == Conta.class){
         Conta c = (Conta) obj;
         return this.nroConta == c.getNroConta();
      }
      return false;
   }


}
