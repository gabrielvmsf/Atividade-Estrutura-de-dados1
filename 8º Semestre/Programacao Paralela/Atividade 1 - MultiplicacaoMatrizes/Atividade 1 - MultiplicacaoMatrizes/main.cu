#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <cuda.h>
#include <cuda_runtime.h>
#include <chrono>
#include <device_launch_parameters.h>


// Função para multiplicação de matrizes em formato serial
void serialMatrixMultiplication(int* matrix, int* auxiliarMatrix, int* resultMatrix, int n) {
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            int sum = 0;
            for (int k = 0; k < n; ++k) {
                sum += matrix[i * n + k] * auxiliarMatrix[k * n + j];
            }
            resultMatrix[i * n + j] = sum;
        }
    }
}

// Kernel para multiplicação de matrizes em paralelo
__global__ void parallelMatrixMultiplication(int* matrix1, int* matrix2, int* resultMatrix, int n) {
    int row = blockIdx.y * blockDim.y + threadIdx.y;
    int col = blockIdx.x * blockDim.x + threadIdx.x;

    if (row < n && col < n) {
        int sum = 0;
        for (int k = 0; k < n; ++k) {
            sum += matrix1[row * n + k] * matrix2[k * n + col];
        }
        resultMatrix[row * n + col] = sum;
    }
}

void printMatrix(int* matrix, int n) {
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			printf("[%d] ", matrix[i * n + j]);
		}
		printf("\n");
	}
}

// Função para realizar operações com matrizes
void matrixOperations(int n) {
    printf("Valor de linhas e colunas: %d\n", n);

    auto born = std::chrono::high_resolution_clock::now();

    int* matrix1 = new int[n * n];
    int* matrix2 = new int[n * n];
    int* resultMatrix = new int[n * n];

    for (int i = 0; i < n * n; i++) {
        matrix1[i] = rand() % 100;
        matrix2[i] = rand() % 100;
        resultMatrix[i] = 0;
    }

    auto start = std::chrono::high_resolution_clock::now();
    long long bornChrono = std::chrono::duration_cast<std::chrono::microseconds>(start - born).count();
    printf("Tempo de criacao: %f \n", float(bornChrono) / 1000000);

    // Multiplicação de matrizes em formato serial
    serialMatrixMultiplication(matrix1, matrix2, resultMatrix, n);

    auto resultChrono = std::chrono::high_resolution_clock::now() - start;
    long long microseconds = std::chrono::duration_cast<std::chrono::microseconds>(resultChrono).count();

    printf("Tempo para rodar (serial): %f \n", float(microseconds) / 1000000);

    // Alocação de memória na GPU
    int* d_matrix, * d_auxiliarMatrix, * d_resultMatrix;
    cudaMalloc(&d_matrix, n * n * sizeof(int));
    cudaMalloc(&d_auxiliarMatrix, n * n * sizeof(int));
    cudaMalloc(&d_resultMatrix, n * n * sizeof(int));

    // Copiar dados para a GPU
    cudaMemcpy(d_matrix, matrix1, n * n * sizeof(int), cudaMemcpyHostToDevice);
    cudaMemcpy(d_auxiliarMatrix, matrix2, n * n * sizeof(int), cudaMemcpyHostToDevice);

    // Definir a quantidade de threads e blocos
    dim3 threadsPerBlock(16, 16);
    dim3 blocksPerGrid((n + threadsPerBlock.x - 1) / threadsPerBlock.x, (n + threadsPerBlock.y - 1) / threadsPerBlock.y);

    // Multiplicação de matrizes em paralelo
    start = std::chrono::high_resolution_clock::now();
    parallelMatrixMultiplication << <blocksPerGrid, threadsPerBlock >> > (d_matrix, d_auxiliarMatrix, d_resultMatrix, n);
    cudaDeviceSynchronize();
    resultChrono = std::chrono::high_resolution_clock::now() - start;
    microseconds = std::chrono::duration_cast<std::chrono::microseconds>(resultChrono).count();
    printf("Tempo para rodar (paralelo): %f \n", float(microseconds) / 1000000);

    // Jogar resultado de volta para a CPU
    cudaMemcpy(resultMatrix, d_resultMatrix, n * n * sizeof(int), cudaMemcpyDeviceToHost);

    // Limpar memória da GPU
    cudaFree(d_matrix);
    cudaFree(d_auxiliarMatrix);
    cudaFree(d_resultMatrix);

    // Limpar memória alocada
    delete[] matrix1;
    delete[] matrix2;
    delete[] resultMatrix;
}

int main() {
    int n;
    printf("Digite o valor de linhas e colunas: ");
    std::cin >> n;
    printf("\n");

    if (n == -1) {
        int sizes[] = { 10, 100, 500, 1000, 10000, 100000 };
        for (int size : sizes) {
            printf("Executando para matriz de tamanho %dx%d\n", size, size);
            matrixOperations(size);
            printf("\n");
        }
    }
    else {
        matrixOperations(n);
    }


    return 0;
}