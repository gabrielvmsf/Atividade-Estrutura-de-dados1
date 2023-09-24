import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class SistemaOperacional {
    private int serialPID;
    private ArrayList<Processo> tabelaDeProcessos;
    private String arquivoSaida = "saidaLOG.txt";

    private Random random = new Random();

    private Processo processoEmExecução;

    public SistemaOperacional() {
        this.serialPID = 0;
        this.tabelaDeProcessos = new ArrayList<>();

        this.processoEmExecução = null;
    }

    public Processo criarProcesso(int tempoDeExecução) {
        Processo processo = new Processo(serialPID, tempoDeExecução);
        tabelaDeProcessos.add(processo);
        this.serialPID += 1;

        return processo;
    }

    public void inciarEscalonaçãoDeProcessos() {
        imprimirTabelaDeProcessosEArquivo();

        // Mudando estados para READY
        for (Processo processo : tabelaDeProcessos) {
            processo.setEp(EstadoEnum.READY);
            imprimirTabelaDeProcessosEArquivo();
        }

        while (existeProcessosPendentes()) {

            boolean recebeuES = false;

            if (tabelaDeProcessos.get(0).getEp() == EstadoEnum.WAITING) {
                Processo ultimoWaiting = tabelaDeProcessos.get(0);
                for (Processo processo : tabelaDeProcessos) {
                    if (processo.getEp() == EstadoEnum.WAITING) {
                        ultimoWaiting = processo;
                        if (random.nextInt(100) < 30) {
                            processo.setEp(EstadoEnum.READY);
                            if (tabelaDeProcessos.indexOf(processo) != 0) {
                                tabelaDeProcessos.add(0, tabelaDeProcessos.remove(tabelaDeProcessos.indexOf(processo)));
                            }
                            recebeuES = true;
                            System.out.println("Processo de PID " + processo.getPid()
                                    + " saiu de ESPERANDO para PRONTO devido, pois recebeu instrução de E/S");
                            break;
                        }
                    }
                }

                int index = tabelaDeProcessos.indexOf(ultimoWaiting);
                if (index >= 0 && index + 1 < tabelaDeProcessos.size()) {
                    if (tabelaDeProcessos.get(index + 1) == null) {
                        continue;
                    } else if (!recebeuES && tabelaDeProcessos.get(tabelaDeProcessos.indexOf(ultimoWaiting) + 1)
                        .getEp() == EstadoEnum.READY) {
                    tabelaDeProcessos.add(0, tabelaDeProcessos.remove(tabelaDeProcessos.indexOf(ultimoWaiting) + 1));
                    System.out.println("Processo de PID " + tabelaDeProcessos.get(0).getPid()
                            + " passou na frente, pois processos em ESPERANDO não receberam E/S");
                }
                } 
            }

            if (tabelaDeProcessos.get(0).getEp() == EstadoEnum.READY) {

                Processo analiseProcesso = processoExecutando(tabelaDeProcessos.remove(0));
                if (analiseProcesso.getEp() == EstadoEnum.READY) {
                    for (Processo processo : tabelaDeProcessos) {
                        if (processo == null || processo.getEp() == EstadoEnum.TERMINATED) {
                            tabelaDeProcessos.add(tabelaDeProcessos.indexOf(processo) - 1, analiseProcesso);
                            break;
                        }
                    }
                } else if (analiseProcesso.getEp() == EstadoEnum.WAITING) {

                    Processo ultimoWaiting = analiseProcesso;

                    for (Processo processo : tabelaDeProcessos) {
                        if (processo.getEp() == EstadoEnum.WAITING) {
                            ultimoWaiting = analiseProcesso;
                        }
                    }
                    if (tabelaDeProcessos.get(tabelaDeProcessos.indexOf(ultimoWaiting) + 1) == null) {
                        tabelaDeProcessos.add(analiseProcesso);
                    } else
                        tabelaDeProcessos.add((tabelaDeProcessos.indexOf(ultimoWaiting) + 1), analiseProcesso);

                } else if (analiseProcesso.getEp() == EstadoEnum.TERMINATED) {
                    tabelaDeProcessos.add(analiseProcesso);
                }

            }

            imprimirTabelaDeProcessosEArquivo();
        }
    }

    private Processo processoExecutando(Processo processoParaExecutar) {

        if (processoParaExecutar.getEp() == EstadoEnum.READY) {
            processoParaExecutar.setEp(EstadoEnum.RUNNING);
            this.processoEmExecução = processoParaExecutar;

            for (int i = 0; i < 1000; i++) {

                // Verificar se ele chegou no tempo de execução desejado, caso sim, retorna para
                // Terminated
                if (processoParaExecutar.getTp() == processoParaExecutar.getTempoDeExecução()) {
                    System.out.println("Processo de PID " + processoParaExecutar.getPid()
                            + " está TERMINADO, pois completou todos seus ciclos");
                    processoParaExecutar.setEp(EstadoEnum.TERMINATED);

                    this.processoEmExecução = null;

                    break;
                }

                processoParaExecutar.setTp(processoParaExecutar.getTp() + 1);
                processoParaExecutar.setCp(processoParaExecutar.getTp() + 1);

                // 5% de chance de receber um instrução de entrada ou saída
                if (random.nextInt(100) < 5) {
                    // Processo foi adicionado para Waiting devido a E/S
                    processoParaExecutar.setEp(EstadoEnum.WAITING);
                    this.processoEmExecução = null;

                    System.out.println("Processo de PID " + processoParaExecutar.getPid()
                            + " saiu de EXECUTANDO para ESPERANDO devido a operação de E/S");

                    break;
                }

                // Verificar se completou 1000 ciclos, caso sim, retorna para Ready
                if (i == 999) {
                    processoParaExecutar.setEp(EstadoEnum.READY);
                    System.out.println("Processo de PID " + processoParaExecutar.getPid()
                            + " saiu de EXECUTANDO para PRONTO, pois completou 1000 ciclos");
                    this.processoEmExecução = null;
                }

            }
            return processoParaExecutar;
        }

        return null;
    }

    public void ImprimindoTabelaDeProcessos() {
        System.out.println("----------------------------------------------------------------");
        for (Processo processo : tabelaDeProcessos) {
            ImprimindoEstado(processo);
        }
        System.out.println("----------------------------------------------------------------");
    }

    // Função para imprimir tabelaDeProcessos e escrever em um arquivo
    public void imprimirTabelaDeProcessosEArquivo() {
        if (Files.exists(Paths.get(arquivoSaida))) {
            try {
                Files.delete(Paths.get(arquivoSaida));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida))) {
            writer.write("----------------------------------------------------------------");
            writer.newLine();
            for (Processo processo : tabelaDeProcessos) {
                String estado = obterEstado(processo);
                writer.write(estado);
                writer.newLine();
            }
            writer.write("----------------------------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Função auxiliar para obter o estado do processo como string
    private String obterEstado(Processo processo) {
        return "PID: " + processo.getPid() + " - Estado: " + processo.getEp() + " - Tempo de processamento:"
                + processo.getTp();
    }

    private void ImprimindoEstado(Processo processo) {
        System.out.println("PID: " + processo.getPid() + " - Estado: " + processo.getEp() + " - Tempo de processamento:"
                + processo.getTp());
    }

    public boolean existeProcessosPendentes() {
        if (existeReadyPendente() || existeWaitingPendente())
            return true;
        return false;
    }

    public boolean existeReadyPendente() {
        for (Processo processo : tabelaDeProcessos) {
            if (processo.getEp() == EstadoEnum.READY) {
                return true;
            }

        }
        return false;
    }

    public boolean existeWaitingPendente() {
        for (Processo processo : tabelaDeProcessos) {
            if (processo.getEp() == EstadoEnum.WAITING)
                return true;
        }
        return false;
    }

    public boolean todosProcessosForamTerminados() {
        int terminado = 0;
        for (Processo processo : tabelaDeProcessos) {
            if (processo.getEp() == EstadoEnum.TERMINATED) {
                terminado += 1;
                System.out.println("terminado!");
            }
        }

        if (terminado == serialPID - 1) {
            System.out.println("todosProcessosForamTerminados?: " + (terminado == serialPID));
            return true;
        }
        System.out.println("falso");
        return false;
    }

    public Processo getProcessoEmExecução() {
        return processoEmExecução;
    }
}