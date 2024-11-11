#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <cuda_runtime.h>

// Função de Reduce Serial na CPU
float reduceSerial(const std::vector<float>& data) {
    float result = 0;
    for (size_t i = 0; i < data.size(); ++i) {
        result += data[i];
    }
    return result;
}

// Estrutura para armazenar informações de desempenho
struct PerformanceMetrics {
    float executionTime; // Tempo de execução em milissegundos
    size_t workAmount;    // Quantidade de trabalho (número de elementos)
    int steps;            // Número de passos (neste caso, pode ser o tamanho do vetor)
};

// Função para medir tempo de execução e coletar métricas
PerformanceMetrics measureTime(const std::vector<float>& data) {
    PerformanceMetrics metrics;
    cudaEvent_t start, stop;
    cudaEventCreate(&start);
    cudaEventCreate(&stop);

    cudaEventRecord(start);
    float result = reduceSerial(data); // Executa o Reduce Serial
    cudaEventRecord(stop);

    cudaEventSynchronize(stop);
    cudaEventElapsedTime(&metrics.executionTime, start, stop);
    metrics.workAmount = data.size(); // Quantidade de trabalho é o tamanho do vetor
    metrics.steps = metrics.workAmount; // Número de passos pode ser o mesmo que o tamanho do vetor
    std::cout << "Resultado da soma: " << result << "\n";

    cudaEventDestroy(start);
    cudaEventDestroy(stop);
    return metrics;
}

int main() {
    std::srand(static_cast<unsigned>(std::time(0)));

    // Diferentes tamanhos de arrays para teste
    std::vector<int> sizes = { 100, 1000, 10000, 100000, 1000000, 10000000 };

    for (int size : sizes) {
        std::vector<float> data(size);

        // Preenchendo o array com valores aleatórios
        for (int i = 0; i < size; ++i) {
            data[i] = static_cast<float>(std::rand()) / RAND_MAX;
        }

        // Medindo o tempo de execução e coletando métricas
        PerformanceMetrics metrics = measureTime(data);
        std::cout << "Tamanho do array: " << size
            << " -> Tempo de execução: " << metrics.executionTime << " ms"
            << ", Quantidade de trabalho: " << metrics.workAmount
            << ", Número de passos: " << metrics.steps << "\n";
    }

    return 0;
}