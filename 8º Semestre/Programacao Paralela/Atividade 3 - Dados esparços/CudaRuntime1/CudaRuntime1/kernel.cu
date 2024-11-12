#include <iostream>
#include <vector>
#include <cuda_runtime.h>
#include <chrono>

#define IDX2C(i,j,ld) (((j)*(ld))+(i))

using namespace std;
using namespace std::chrono;

// Funcao de multiplicacao serial
void serialMatrixVectorMultiplication(const vector<float>& matrix, const vector<float>& vec, vector<float>& result, int m, int n) {
    int denseCount = 0;
    for (int i = 0; i < m; i++) {
        float sum = 0.0f;
        for (int j = 0; j < n; j++) {
            if (matrix[IDX2C(i, j, m)] != 0) {  // Ignora valores esparsos
                sum += matrix[IDX2C(i, j, m)] * vec[j];
                denseCount++;
            }
        }
        result[i] = sum;
    }
    cout << "Dados densos (nao-zero) na matriz: " << denseCount << endl;
}

// Funcao Kernel para multiplicacao paralela
__global__ void sparseMatrixVectorMultiplication(const float* matrix, const float* vec, float* result, int m, int n) {
    int row = blockIdx.x * blockDim.x + threadIdx.x;
    if (row < m) {
        float sum = 0.0f;
        for (int j = 0; j < n; j++) {
            float val = matrix[IDX2C(row, j, m)];
            if (val != 0) {  // Ignora valores esparsos
                sum += val * vec[j];
            }
        }
        result[row] = sum;
    }
}

void runTest(int m, int n) {
    // Inicializa a matriz e o vetor com valores esparsos
    vector<float> matrix(m * n, 0);
    vector<float> vec(n, 1.0f);
    vector<float> result_serial(m, 0.0f);
    vector<float> result_parallel(m, 0.0f);

    // Preenche a matriz com alguns valores densos
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (rand() % 4 == 0) {  // Coloca um valor diferente de zero em 25% das posicoes
                matrix[IDX2C(i, j, m)] = static_cast<float>(rand() % 10 + 1);
            }
        }
    }

    // Multiplicacao Serial
    auto start = high_resolution_clock::now();
    serialMatrixVectorMultiplication(matrix, vec, result_serial, m, n);
    auto end = high_resolution_clock::now();
    double serialTime = duration_cast<microseconds>(end - start).count();
    cout << "\n--- Multiplicacao Serial ---" << endl;
    cout << "Tempo de execucao serial: " << serialTime << " microsegundos" << endl;

    // Preparacao para multiplicacao paralela
    float* d_matrix, * d_vec, * d_result;
    cudaMalloc((void**)&d_matrix, m * n * sizeof(float));
    cudaMalloc((void**)&d_vec, n * sizeof(float));
    cudaMalloc((void**)&d_result, m * sizeof(float));

    cudaMemcpy(d_matrix, matrix.data(), m * n * sizeof(float), cudaMemcpyHostToDevice);
    cudaMemcpy(d_vec, vec.data(), n * sizeof(float), cudaMemcpyHostToDevice);

    // Multiplicacao Paralela
    int blockSize = 256;
    int numBlocks = (m + blockSize - 1) / blockSize;

    start = high_resolution_clock::now();
    sparseMatrixVectorMultiplication << <numBlocks, blockSize >> > (d_matrix, d_vec, d_result, m, n);
    cudaDeviceSynchronize();
    end = high_resolution_clock::now();

    double parallelTime = duration_cast<microseconds>(end - start).count();
    cout << "--- Multiplicacao Paralela ---" << endl;
    cout << "Tempo de execucao paralela: " << parallelTime << " microsegundos" << endl;

    // Copia resultado de volta
    cudaMemcpy(result_parallel.data(), d_result, m * sizeof(float), cudaMemcpyDeviceToHost);

    // Libera memoria
    cudaFree(d_matrix);
    cudaFree(d_vec);
    cudaFree(d_result);

    // Validacao e comparacao de desempenho
    bool isCorrect = true;
    for (int i = 0; i < m; i++) {
        if (abs(result_serial[i] - result_parallel[i]) > 1e-5) {
            isCorrect = false;
            break;
        }
    }
    cout << "--- Resultados ---" << endl;
    cout << "Resultados corretos: " << (isCorrect ? "Sim" : "Nao") << endl;
    cout << "Aceleracao obtida: " << serialTime / parallelTime << "x" << endl;
}

int main() {
    srand(time(0));

    cout << "\n--- Teste de Multiplicacao Matriz-Vetor ---" << endl;

    cout << "\nTeste 1: 100x100" << endl;
    runTest(100, 100);

    cout << "\nTeste 2: 1000x100" << endl;
    runTest(1000, 100);

    cout << "\nTeste 3: 10000x100" << endl;
    runTest(10000, 100);

    cout << "\nTeste 4: 100000x100" << endl;
    runTest(100000, 100);

    cout << "\nTeste 5: 1000000x100" << endl;
    runTest(1000000, 100);

    cout << "\nTeste 6: 10000000x100" << endl;
    runTest(10000000, 100);

    return 0;
}
