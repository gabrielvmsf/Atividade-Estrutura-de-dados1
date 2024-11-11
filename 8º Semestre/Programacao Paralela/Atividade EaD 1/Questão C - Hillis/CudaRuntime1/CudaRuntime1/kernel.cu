#include <iostream>
#include <vector>
#include <cmath>
#include <cuda_runtime.h>

// Função kernel para realizar uma etapa de Hillis-Steele
__global__ void hillisSteeleKernel(float* d_input, float* d_output, int n, int step) {
    int idx = blockIdx.x * blockDim.x + threadIdx.x;
    int offset = 1 << step; // Calcula 2^step

    if (idx < n) {
        if (idx >= offset) {
            d_output[idx] = d_input[idx] + d_input[idx - offset];
        }
        else {
            d_output[idx] = d_input[idx];
        }
    }
}

// Estrutura para armazenar informações de desempenho
struct PerformanceMetrics {
    float executionTime; // Tempo de execução em milissegundos
    size_t workAmount;    // Quantidade de trabalho (número de operações)
    int steps;            // Número de passos (etapas)
};

// Função que executa o algoritmo Hillis-Steele e coleta métricas
PerformanceMetrics hillisSteele(const std::vector<float>& input) {
    int n = input.size();
    float* d_input;
    float* d_output;

    // Aloca memória na GPU
    cudaMalloc(&d_input, n * sizeof(float));
    cudaMalloc(&d_output, n * sizeof(float));

    // Copia dados para a GPU
    cudaMemcpy(d_input, input.data(), n * sizeof(float), cudaMemcpyHostToDevice);

    int steps = std::ceil(std::log2(n)); // Número de etapas
    int blockSize = 256;
    int gridSize = (n + blockSize - 1) / blockSize;

    cudaEvent_t start, stop;
    cudaEventCreate(&start);
    cudaEventCreate(&stop);
    cudaEventRecord(start);

    // Loop pelas etapas de Hillis-Steele
    for (int s = 0; s < steps; ++s) {
        hillisSteeleKernel << <gridSize, blockSize >> > (d_input, d_output, n, s);
        cudaMemcpy(d_input, d_output, n * sizeof(float), cudaMemcpyDeviceToDevice); // Atualiza o vetor de entrada
    }

    // Registra o tempo de execução
    cudaEventRecord(stop);
    cudaEventSynchronize(stop);
    float time;
    cudaEventElapsedTime(&time, start, stop);

    cudaEventDestroy(start);
    cudaEventDestroy(stop);

    // Copia o resultado de volta para a CPU
    std::vector<float> output(n);
    cudaMemcpy(output.data(), d_output, n * sizeof(float), cudaMemcpyDeviceToHost);

    // Libera a memória da GPU
    cudaFree(d_input);
    cudaFree(d_output);

    std::cout << "Resultado final: " << output.back() << "\n";

    // Coleta as métricas de desempenho
    PerformanceMetrics metrics;
    metrics.executionTime = time;
    metrics.workAmount = n * steps; // Quantidade de trabalho (número de operações)
    metrics.steps = steps; // Número de etapas

    return metrics;
}

int main() {
    std::vector<int> sizes = { 100, 1000, 10000, 100000, 1000000, 10000000 };

    for (int size : sizes) {
        std::vector<float> input(size, 1.0f); // Inicializa o array com valores 1.0 para simplificar a verificação

        std::cout << "Tamanho do array: " << size << "\n";
        PerformanceMetrics metrics = hillisSteele(input);
        std::cout << "Tempo de execução: " << metrics.executionTime << " ms\n";
        std::cout << "Quantidade de trabalho: " << metrics.workAmount << " operações\n";
        std::cout << "Número de passos: " << metrics.steps << "\n\n";
    }

    return 0;
}