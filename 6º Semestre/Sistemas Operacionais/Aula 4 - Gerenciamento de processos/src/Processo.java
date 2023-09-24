public class Processo { 
    private int pid;    // PID
    private int tp;     // Tempo de processamento
    private int cp;     // Contador de programa
    private EstadoEnum ep;     // Estado do processo - NEW:0, READY:1, RUNNING:2, WAITING:3 e TERMINATED:4
    private int nes;    // Número de vezes que realizou uma operação de E/S
    private int n_cpu;  // Número de vezes que usou CPU
    private int tempoDeExecução;

    public Processo(int pid, int tempoDeExecução) {
        this.pid = pid;
        this.tempoDeExecução = tempoDeExecução;
        this.tp = 0;
        this.cp = 1;
        this.ep = EstadoEnum.NEW;
        this.nes = 0;
        this.n_cpu = 0;
    }

    public void imprimirProcesso() {
        System.out.println("PID: " + pid);
        System.out.println("TP: " + tp);
        System.out.println("CP: " + cp);
        System.out.println("EP: " + ep);
        System.out.println("NES: " + nes);
        System.out.println("N_CPU: " + n_cpu);
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getNes() {
        return nes;
    }

    public void setNes(int nes) {
        this.nes = nes;
    }

    public int getN_cpu() {
        return n_cpu;
    }

    public void setN_cpu(int n_cpu) {
        this.n_cpu = n_cpu;
    }

    public int getTempoDeExecução() {
        return tempoDeExecução;
    }

    public void setTempoDeExecução(int tempoDeExecução) {
        this.tempoDeExecução = tempoDeExecução;
    }

    public EstadoEnum getEp() {
        return ep;
    }

    public void setEp(EstadoEnum ep) {
        this.ep = ep;
    }
    
}
