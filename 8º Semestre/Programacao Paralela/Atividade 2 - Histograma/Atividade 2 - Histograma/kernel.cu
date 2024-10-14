#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <cuda.h>
#include <cuda_runtime.h>
#include <chrono>
#include <device_launch_parameters.h>

const int TAMANHO_VETOR = 10000000;
const int NUM_BINS = 10;

__global__ void addKernel(double* vetor, int* histograma) {
    int index = blockIdx.x * blockDim.x + threadIdx.x;

    if (index < TAMANHO_VETOR) {
        int bin = static_cast<int>(vetor[index]);
        if (bin < NUM_BINS) {
            atomicAdd(&histograma[bin], 1); 
        }
    }
}

void histogramaParalelo() {
    double* vetor = new double[TAMANHO_VETOR];
    double* d_vetor;
    int* histograma, * d_histograma;

    cudaMalloc((void**)&d_histograma, NUM_BINS * sizeof(int));
    cudaMalloc((void**)&d_vetor, TAMANHO_VETOR * sizeof(double));

    auto start = std::chrono::high_resolution_clock::now();

    for (int i = 0; i < TAMANHO_VETOR; ++i) {
        vetor[i] = (double)rand() / RAND_MAX * 10;
    }

    cudaMemcpy(d_vetor, vetor, TAMANHO_VETOR * sizeof(double), cudaMemcpyHostToDevice);

    int histogramaInicial[NUM_BINS] = { 0 };
    cudaMemcpy(d_histograma, histogramaInicial, NUM_BINS * sizeof(int), cudaMemcpyHostToDevice);

    int blockSize = 256;
    int numBlocks = (TAMANHO_VETOR + blockSize - 1) / blockSize;
    addKernel << <numBlocks, blockSize >> > (d_vetor, d_histograma);

    histograma = new int[NUM_BINS];
    cudaMemcpy(histograma, d_histograma, NUM_BINS * sizeof(int), cudaMemcpyDeviceToHost);

    int sumParalelo = 0;
    for (int i = 0; i < NUM_BINS; ++i) {
        printf("Intervalo [%d, %d): %d\n", i, i + 1, histograma[i]);
        sumParalelo += histograma[i];
    }

    auto end = std::chrono::high_resolution_clock::now();
    auto elapsed = std::chrono::duration_cast<std::chrono::duration<double>>(end - start);

    printf("Somatorio: %d\n", sumParalelo);
    printf("Tempo de execucao: %.6f segundos\n", elapsed.count());

    delete[] vetor;
    delete[] histograma;
    cudaFree(d_vetor);
    cudaFree(d_histograma);
}

void histogramaSerial() {
    double* vetor = new double[TAMANHO_VETOR];
    auto start = std::chrono::high_resolution_clock::now();

    for (int i = 0; i < TAMANHO_VETOR; ++i) {
        vetor[i] = (double)rand() / RAND_MAX * 10;
    }

    int histograma[NUM_BINS] = { 0 };

    for (int i = 0; i < TAMANHO_VETOR; ++i) {
        int bin = static_cast<int>(vetor[i]);
        if (bin < NUM_BINS) {
            histograma[bin]++;
        }
    }
    int sumSerial = 0;

    for (int i = 0; i < NUM_BINS; ++i) {
        printf("Intervalo [%d, %d): %d\n", i, i + 1, histograma[i]);
        sumSerial += histograma[i];
    }

    auto end = std::chrono::high_resolution_clock::now();
    auto elapsed = std::chrono::duration_cast<std::chrono::duration<double>>(end - start);

    printf("Somatorio: %d\n", sumSerial);
    printf("Tempo de execucao: %.6f segundos\n", elapsed.count());
}

int main() {
    printf("Histograma Serial:\n");
    histogramaSerial();

    printf("Histograma Paralelo:\n");
    histogramaParalelo();

    return 0;
}