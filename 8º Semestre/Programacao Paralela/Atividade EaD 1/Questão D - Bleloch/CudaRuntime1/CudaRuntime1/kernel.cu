#include <iostream>
#include <vector>
#include <cmath>
#include <cuda_runtime.h>

// Kernel para a Fase Up-Sweep (Redução)
__global__ void upSweepKernel(float* d_data, int n, int step) {
    int idx = blockIdx.x * blockDim.x + threadIdx.x;
    int distance = 1 << step; // Distância para o passo atual

    if (idx < n && idx % (distance * 2) == 0 && idx + distance < n) {
        d_data[idx + distance * 2 - 1] += d_data[idx + distance - 1];
    }
}

// Kernel para a Fase Down-Sweep (Distribuição)
__global__ void downSweepKernel(float* d_data, int n, int step) {
    int idx = blockIdx.x * blockDim.x + threadIdx.x;
    int distance = 1 << step;

    if (idx < n && idx % (distance * 2) == 0 && idx + distance < n) {
        float temp = d_data[idx + distance - 1];
        d_data[idx + distance - 1] = d_data[idx + distance * 2 - 1];
        d_data[idx + distance * 2 - 1] += temp;
    }
}

// Função principal que executa o algoritmo de Blelloch
float blellochScan(const std::vector<float>& input) {
    int n = input.size();
    float* d_data;

    // Aloca memória na GPU e copia o vetor inicial para a GPU
    cudaMalloc(&d_data, n * sizeof(float));
    cudaMemcpy(d_data, input.data(), n * sizeof(float), cudaMemcpyHostToDevice);

    int steps = std::ceil(std::log2(n)); // Número de etapas
    int blockSize = 256;
    int gridSize = (n + blockSize - 1) / blockSize;

    cudaEvent_t start, stop;
    cudaEventCreate(&start);
    cudaEventCreate(&stop);
    cudaEventRecord(start);

    // Fase Up-Sweep (Redução)
    for (int step = 0; step < steps; ++step) {
        upSweepKernel << <gridSize, blockSize >> > (d_data, n, step);
        cudaDeviceSynchronize();  // Certifique-se de que a etapa esteja concluída
    }

    // Inicializa o último valor com 0 para a Fase Down-Sweep
    cudaMemset(&d_data[n - 1], 0, sizeof(float));

    // Fase Down-Sweep (Distribuição)
    for (int step = steps - 1; step >= 0; --step) {
        downSweepKernel << <gridSize, blockSize >> > (d_data, n, step);
        cudaDeviceSynchronize();  // Certifique-se de que a etapa esteja concluída
    }

    // Registra o tempo de execução
    cudaEventRecord(stop);
    cudaEventSynchronize(stop);
    float time;
    cudaEventElapsedTime(&time, start, stop);

    cudaEventDestroy(start);
    cudaEventDestroy(stop);

    // Copia o resultado de volta para a CPU
    std::vector<float> result(n);
    cudaMemcpy(result.data(), d_data, n * sizeof(float), cudaMemcpyDeviceToHost);

    // Libera a memória da GPU
    cudaFree(d_data);

    std::cout << "Último valor do vetor resultado: " << result.back() << "\n";
    return time;
}

int main() {
    std::vector<int> sizes = { 100, 1000, 10000, 100000, 1000000, 10000000 };

    for (int size : sizes) {
        std::vector<float> input(size, 1.0f); // Inicializa o array com valores 1.0 para simplificar a verificação
        int steps = std::ceil(std::log2(size)); // Número de etapas
        int work = size * steps; // Quantidade de trabalho total realizada

        std::cout << "Tamanho do array: " << size << "\n";
        float time = blellochScan(input);
        std::cout << "Tempo de execução: " << time << " ms\n";
        std::cout << "Quantidade de trabalho: " << work << " operações\n";
        std::cout << "Número de passos: " << steps << "\n\n";
    }

    return 0;
}
