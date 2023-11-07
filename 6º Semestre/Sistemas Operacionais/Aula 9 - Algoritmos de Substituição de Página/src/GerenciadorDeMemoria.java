import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GerenciadorDeMemoria {

    private int[][] matrizSWAP;
    private int[][] matrizRAM;
    private int instrucoesPaginacoesQtd;
    private List<Integer> ordemPaginas;
    private int indiceRelogio = 0;

    public GerenciadorDeMemoria() {
        this.matrizSWAP = criarMatrizSwap(100);
        this.ordemPaginas = new ArrayList<>();
        this.matrizRAM = criarMatrizRAM(10, this.matrizSWAP);
        System.out.println("Matrizes SWAP e RAM criadas!");
        this.instrucoesPaginacoesQtd = 0;
    }

    private int[][] criarMatrizSwap(int tamSwap) {
        int[][] matrizSWAP = new int[tamSwap][6];
        Random random = new Random();

        for (int i = 0; i < tamSwap; i++) {
            matrizSWAP[i][0] = i; // N
            matrizSWAP[i][1] = i + 1; // I
            matrizSWAP[i][2] = random.nextInt(50) + 1; // D
            matrizSWAP[i][3] = 0; // R
            matrizSWAP[i][4] = 0; // M
            matrizSWAP[i][5] = random.nextInt(9900) + 100; // T
        }

        return matrizSWAP;
    }

    private int[][] criarMatrizRAM(int tamRam, int[][] matrizSWAP) {
        int[][] matrizRAM = new int[tamRam][6];
        List<Integer> indicesEscolhidos = new ArrayList<>();
        List<Integer> indicesSWAP = new ArrayList();
        for (int i = 0; i < matrizSWAP.length; i++) {
            indicesSWAP.add(i);
        }
        Collections.shuffle(indicesSWAP);

        for (int i = 0; i < tamRam; i++) {
            int indice = indicesSWAP.get(i);
            indicesEscolhidos.add(indice);

            adicionarPaginaNaOrdem(indice);

            for (int j = 0; j < 6; j++) {
                matrizRAM[i][j] = matrizSWAP[indice][j];
            }
        }

        return matrizRAM;
    }

    public void execucaoDeInstrucao() {
        Random random = new Random();
        int instrucoesClock = 0;
        while (this.instrucoesPaginacoesQtd <= 5000) {
            int valor = random.nextInt(100) + 1;
            boolean valorEncontrado = false;
            for (int i = 0; i < matrizRAM.length; i++) {
                if (matrizRAM[i][1] == valor) {
                    valorEncontrado = true;
                    matrizRAM[i][4] = 1; // atualizar o campo R
                    double chanceDeModificacao = random.nextDouble();
                    if (chanceDeModificacao <= 0.3) {
                        matrizRAM[i][2]++; // Atualizar o campo D
                        matrizRAM[i][4] = 1; // Atualizar o bit M
                    }
                }
            }
            if (!valorEncontrado) {
                gerenciarAlgoritmos(valor);
            }
            instrucoesClock++;
            if (instrucoesClock == 10) {
                zerarBitR();
                instrucoesClock = 0;
            }
        }
    }

    

    private void gerenciarAlgoritmos(int valorDeInstrucao) {

        if (this.instrucoesPaginacoesQtd == 1001) {
            System.out.println("\n------MATRIZ NRU:------");
            imprimirMatrizes();
        } else if (this.instrucoesPaginacoesQtd == 2001) {
            System.out.println("\n------MATRIZ FIFO:------");
            imprimirMatrizes();
        } else if (this.instrucoesPaginacoesQtd == 3001) {
            System.out.println("\n------MATRIZ FIFO SC:------");
            imprimirMatrizes();
        } else if (this.instrucoesPaginacoesQtd == 4001) {
            System.out.println("\n------MATRIZ RELOGIO:------");
            imprimirMatrizes();
        }

        if (this.instrucoesPaginacoesQtd <= 1000) {
           algoritmoNRU(valorDeInstrucao);
        } else if (this.instrucoesPaginacoesQtd <= 2000) {
           algoritmoFIFO(valorDeInstrucao);
        } else if (this.instrucoesPaginacoesQtd <= 3000) {
           algoritmoFIFOSC(valorDeInstrucao);
        } else if (this.instrucoesPaginacoesQtd <= 4000) {
            algoritmoRELOGIO(valorDeInstrucao);
        } else {
            algoritmoWSCLOCK(valorDeInstrucao);
        }
        this.instrucoesPaginacoesQtd++;
    }

    private void algoritmoNRU(int valorDeInstrucao) {
        // Criar quatro classes com base nos bits R e M
        ArrayList<Integer> classe0 = new ArrayList<>();
        ArrayList<Integer> classe1 = new ArrayList<>();
        ArrayList<Integer> classe2 = new ArrayList<>();
        ArrayList<Integer> classe3 = new ArrayList<>();

        // Preencher as classes com base nos bits R e M
        for (int i = 0; i < matrizRAM.length; i++) {
            int bitR = matrizRAM[i][3];
            int bitM = matrizRAM[i][4];

            int classe = (bitR << 1) | bitM;
            switch (classe) {
                case 0:
                    classe0.add(i);
                    break;
                case 1:
                    classe1.add(i);
                    break;
                case 2:
                    classe2.add(i);
                    break;
                case 3:
                    classe3.add(i);
                    break;
            }
        }

        // Escolher aleatoriamente uma página da classe de menor prioridade
        int paginaASubstituir;
        if (!classe0.isEmpty()) {
            paginaASubstituir = classe0.get(0);
        } else if (!classe1.isEmpty()) {
            paginaASubstituir = classe1.get(0);
        } else if (!classe2.isEmpty()) {
            paginaASubstituir = classe2.get(0);
        } else {
            paginaASubstituir = classe3.get(0);
        }

        atualizarPaginaSWAPeRAM(paginaASubstituir, valorDeInstrucao);

        // Atualizar a página selecionada com a nova instrução
        matrizRAM[paginaASubstituir][1] = valorDeInstrucao;

        // Remover a página da classe apropriada
        if (classe0.contains(paginaASubstituir)) {
            classe0.remove(Integer.valueOf(paginaASubstituir));
        } else if (classe1.contains(paginaASubstituir)) {
            classe1.remove(Integer.valueOf(paginaASubstituir));
        } else if (classe2.contains(paginaASubstituir)) {
            classe2.remove(Integer.valueOf(paginaASubstituir));
        } else {
            classe3.remove(Integer.valueOf(paginaASubstituir));
        }
    }

    private void adicionarPaginaNaOrdem(int pagina) {
        ordemPaginas.add(pagina);
    }

    private int removerPaginaMaisAntiga() {
        if (!ordemPaginas.isEmpty()) {
            int paginaMaisAntiga = ordemPaginas.remove(0);
            return paginaMaisAntiga;
        }
        return -1; // Retorna -1 se a lista estiver vazia
    }

    private void atualizarOrdemDaPagina(int pagina) {
        ordemPaginas.remove((Integer) pagina); // Remove a página da sua posição atual
        ordemPaginas.add(pagina); // Adiciona a página no final da ordem
    }

    private void algoritmoFIFO(int valorDeInstrucao) {
        int instrucaoRamSubstituir = removerPaginaMaisAntiga(); // Remove a página mais antiga
        if (instrucaoRamSubstituir != -1) {
            int paginaASubstituir = -1;

            // Percorre a matriz RAM para encontrar a instrução correspondente
            for (int i = 0; i < matrizRAM.length; i++) {
                if (matrizRAM[i][1] == instrucaoRamSubstituir) {
                    paginaASubstituir = i;
                    break; // Páginas encontradas, podemos sair do loop
                }
            }

            if (paginaASubstituir != -1) {
                atualizarPaginaSWAPeRAM(paginaASubstituir, valorDeInstrucao);
                adicionarPaginaNaOrdem(paginaASubstituir); // Adiciona a nova página no final da ordem
            }
        }
    }

    private void algoritmoFIFOSC(int valorDeInstrucao) {
        int paginaASubstituir = -1;
        int paginaComBitRZero = -1;

        // Procura uma página com o bit R (Referência) igual a 0, se houver
        for (int i = 0; i < matrizRAM.length; i++) {
            if (matrizRAM[i][3] == 0) {
                paginaComBitRZero = i;
                break;
            }
        }

        if (paginaComBitRZero != -1) {
            paginaASubstituir = paginaComBitRZero;
        } else {
            // Caso contrário, escolhe a página mais antiga (primeira da fila)
            int instrucaoRamSubstituir = removerPaginaMaisAntiga(); // Remove a página mais antiga
            if (instrucaoRamSubstituir != -1) {
                paginaASubstituir = -1;

                // Percorre a matriz RAM para encontrar a instrução correspondente
                for (int i = 0; i < matrizRAM.length; i++) {
                    if (matrizRAM[i][1] == instrucaoRamSubstituir) {
                        paginaASubstituir = i;
                        break;
                    }
                }
            }
        }

        // Atualiza a página selecionada com a nova instrução
        atualizarPaginaSWAPeRAM(paginaASubstituir, valorDeInstrucao);
    }

    private void algoritmoRELOGIO(int valorDeInstrucao) {
        int paginaASubstituir = -1;
        boolean paginaEncontrada = false;
    
        // Inicialmente, a posição atual no relógio é 0
        int indiceRelogio = 0;
    
        while (!paginaEncontrada) {
            if (matrizRAM[indiceRelogio][3] == 0) {
                // Se o bit R for igual a 0, a página pode ser substituída
                paginaASubstituir = indiceRelogio;
                paginaEncontrada = true;
            } else {
                // Caso contrário, atualize o bit R para 0 e avance para a próxima página no relógio
                matrizRAM[indiceRelogio][3] = 0;
                indiceRelogio = (indiceRelogio + 1) % matrizRAM.length; // Avança para a próxima página no relógio
            }
        }
    

        atualizarPaginaSWAPeRAM(paginaASubstituir, valorDeInstrucao);
    }

    private void algoritmoWSCLOCK(int valorDeInstrucao) {
        int paginaASubstituir = -1;
        boolean paginaEncontrada = false;
    
        // Sorteie o valor do envelhecimento da página (EP) entre 100 e 9999
        int EP = new Random().nextInt(9900) + 100;
        int contador = 0;
    
        while (!paginaEncontrada) {
            if (matrizRAM[indiceRelogio][3] == 0 && matrizRAM[indiceRelogio][5] <= EP) {
                // Se o bit R for igual a 0 e EP <= T, a página pode ser substituída
                paginaASubstituir = indiceRelogio;
                paginaEncontrada = true;
            } else {
                // Caso contrário, atualize o bit R para 0 e avance para a próxima página no relógio
                matrizRAM[indiceRelogio][3] = 0;
                indiceRelogio = (indiceRelogio + 1) % matrizRAM.length; // Avança para a próxima página no relógio
                contador++;
    
                // Atualize o valor de EP a cada X iterações (aqui, X é definido como 10)
                if (contador % 10 == 0) {
                    EP = new Random().nextInt(9900) + 100; // Sorteie um novo valor de EP
                }
            }
        }
    
        atualizarPaginaSWAPeRAM(paginaASubstituir, valorDeInstrucao);
    }


    private void atualizarPaginaSWAPeRAM(int paginaASubstituir, int valorDeInstrucao) {

        int instrucaoEnviadaParaSwap = matrizRAM[paginaASubstituir][1];

        // Percorra a matriz SWAP para encontrar a página correspondente
        for (int i = 0; i < matrizSWAP.length; i++) {
            if (matrizSWAP[i][1] == instrucaoEnviadaParaSwap) {
                // Atualize a linha da página na matriz SWAP com os dados da matriz RAM
                for (int j = 0; j < 6; j++) {
                    matrizSWAP[i][j] = matrizRAM[paginaASubstituir][j];
                }

                // Atualize o bit M (Bit de Modificação) para 0
                matrizSWAP[i][4] = 0;
                break; // Páginas encontradas, podemos sair do loop
            }
        }

        // Percorra a matriz SWAP para encontrar a página correspondente
        int paginaEncontrada = -1;
        for (int i = 0; i < matrizSWAP.length; i++) {
            if (matrizSWAP[i][1] == valorDeInstrucao) {
                paginaEncontrada = i;
                break;
            }
        }

        if (paginaEncontrada != -1) {
            // Atualize a linha da página na matriz SWAP com os dados da matriz RAM
            for (int j = 0; j < 6; j++) {
                matrizRAM[paginaASubstituir][j] = matrizSWAP[paginaEncontrada][j];
                //System.out.print("Passou de SWAP para RAM ");
            }
        }

        atualizarOrdemDaPagina(paginaASubstituir);
    }

    public void zerarBitR() {
        for (int i = 0; i < matrizRAM.length; i++) {
            matrizRAM[i][3] = 0; // Definir o Bit R como 0 (acesso não ocorrido)
        }
    }

    public void imprimirMatrizes() {
        System.out.println("Matriz SWAP:");
        imprimirMatriz(matrizSWAP);

        System.out.println("\nMatriz RAM:");
        imprimirMatriz(matrizRAM);
    }

    private void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(String.format("%5d", matriz[i][j]) + " ");
            }
            System.out.println();
        }
    }

}