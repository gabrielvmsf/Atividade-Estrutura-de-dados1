import java.util.ArrayList;

public abstract class Cliente {
    private String nome;
    private String telefone;
    private String endereço;
    private int qtdEmprestimosRealizados;
    private int qtdEmprestimosPermitidos;
    private ArrayList<Alocação> alocações;

    public Cliente(String nome, String telefone, String endereço,
            int qtdEmprestimosPermitidos) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereço = endereço;
        this.qtdEmprestimosRealizados = 0;
        this.qtdEmprestimosPermitidos = qtdEmprestimosPermitidos;// será designado -1 para classes filhas que não
                                                                 // necessitam de limite,
                                                                 // pensando em possiveis futuras classes
        this.alocações = new ArrayList<Alocação>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereço() {
        return this.endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public int getQtdEmprestimosRealizados() {
        return this.qtdEmprestimosRealizados;
    }

    public void setQtdEmprestimosRealizados(int qtdEmprestimosRealizados) {
        this.qtdEmprestimosRealizados = qtdEmprestimosRealizados;
    }

    public int getQtdEmprestimosPermitidos() {
        return this.qtdEmprestimosPermitidos;
    }

    public void setQtdEmprestimosPermitidos(int qtdEmprestimosPermitidos) {
        this.qtdEmprestimosPermitidos = qtdEmprestimosPermitidos;
    }

    public boolean contemAlocações(Alocação alocação) {
        return this.alocações.contains(alocação);
    }

    public void removeAlocações(Alocação alocação) {
        this.alocações.remove(alocação);
    }

    public void realizarAlocação(Cliente cliente, Carro carro) {
        if (carro.getDisponivel()) {
            if ((this.qtdEmprestimosRealizados <= this.qtdEmprestimosPermitidos)
                    || this.qtdEmprestimosPermitidos == -1) {
                this.qtdEmprestimosRealizados++;
                Alocação alocação = new Alocação(cliente, carro);
                this.alocações.add(alocação);
            } else
                throw new UsuarioNãoPodePegarCarroException("Úsuario não pode pegar carro!");
        } else
            throw new CarroNãoDisponivelException("Carro não disponível!");
    }

    public void renovarAlocação(Alocação alocação) {
        if (this.contemAlocações(alocação)) {
            alocação.renovar();
        } else
            throw new EmprestimoNãoExisteException("Emprestimo não existe!");
    }

    public void devolverAlocação(Alocação alocação) {
        if (this.contemAlocações(alocação)) {
            this.removeAlocações(alocação);
            alocação.devolverCarro();
            this.qtdEmprestimosRealizados--;
        } else
            throw new EmprestimoNãoExisteException("Emprestimo não existe!");
    }
}
