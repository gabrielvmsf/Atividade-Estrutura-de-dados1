## Simulador de Escalonamento de Processos
Este projeto implementa um simulador de escalonamento de processos em um sistema operacional. A simulação envolve a criação e gerenciamento de processos com diferentes estados, tempo de execução e interações de E/S. A atividade proposta descreve um ambiente em que vários processos são executados em ordem de PID (Identificador de Processo) e seguem um conjunto de regras específicas.

## Funcionalidades
O simulador inclui as seguintes funcionalidades:

- Criação de processos com PID sequenciais e tempos de execução distintos.
- Transições de estado dos processos de "NEW" para "READY".
- Execução dos processos no estado "READY" com um Quantum de 1000 ciclos.
- Possibilidade de processos realizarem operações de E/S (5% de chance a cada ciclo).
- Processos bloqueados podem voltar ao estado "READY" com uma probabilidade de 30%.
- Troca de contexto quando um processo atinge o Quantum ou completa sua execução.
- Armazenamento de dados dos processos em um arquivo de log.
- Impressão das mudanças de estados dos processos no console.

## Estrutura do Projeto
- Processo.java: Classe que representa os processos e suas características.
- SistemaOperacional.java: Classe principal que gerencia a simulação e as transições de estado dos processos.
- EstadoEnum.java: Enumeração que define os estados possíveis dos processos.
- App.java: Classe de ponto de entrada do programa que configura e inicia a simulação.

## Como Usar
- Clone o repositório para a sua máquina local.
- Abra o projeto em um ambiente de desenvolvimento Java.
- Execute a classe App.java para iniciar a simulação.
- Os resultados da simulação, incluindo as mudanças de estados dos processos, serão impressos no console e registrados em um arquivo de log chamado saidaLOG.txt.

## Contribuição
Sinta-se à vontade para contribuir com melhorias ou correções neste projeto. Basta fazer um fork do repositório, criar uma nova branch para sua contribuição e enviar um pull request quando estiver pronto.

## Autor
Gabriel Vieira Melo

Este é um projeto de simulação de escalonamento de processos com fins educacionais e didáticos. Esperamos que seja útil para aprender sobre o funcionamento básico de um sistema operacional e escalonamento de processos.