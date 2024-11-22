#include <iostream>
#include <fstream>
#include <chrono>
#include <vector>
#include <cstring>
#include <cuda_runtime.h>
#include <sstream> 



#ifdef _WIN32
#include <direct.h>
#define mkdir(path, mode) _mkdir(path)
#else
#include <sys/stat.h>
#endif

#define THREADS_PER_BLOCK 1024

// Estrutura para representar um pixel RGB
struct Pixel {
    unsigned char r, g, b;
};

// Função para criar diretório
void createDirectory(const std::string& path) {
#ifdef _WIN32
    _mkdir(path.c_str());
#else
    mkdir(path.c_str(), 0777);
#endif
}

// Função para ler o cabeçalho e dados da imagem BMP
bool readBMP(const std::string& filename, int& width, int& height, std::vector<Pixel>& pixels) {
    std::ifstream file(filename, std::ios::binary);
    if (!file.is_open()) {
        std::cerr << "Erro ao abrir o arquivo BMP." << std::endl;
        return false;
    }

    // Ler cabeçalho BMP
    unsigned char header[54];
    file.read(reinterpret_cast<char*>(header), 54);

    // Validar formato BMP
    if (header[0] != 'B' || header[1] != 'M') {
        std::cerr << "Arquivo não é um BMP válido." << std::endl;
        return false;
    }

    // Extrair dimensões da imagem
    width = *(int*)&header[18];
    height = *(int*)&header[22];

    // Validar tamanho mínimo
    if (width < 500 || height < 500) {
        std::cerr << "Imagem muito pequena. Deve ter pelo menos 500x500 pixels." << std::endl;
        return false;
    }

    // Calcular tamanho do array de pixels
    int row_padded = (width * 3 + 3) & (~3);
    pixels.resize(width * height);

    // Ler pixels
    unsigned char* row = new unsigned char[row_padded];
    for (int i = 0; i < height; i++) {
        file.read(reinterpret_cast<char*>(row), row_padded);
        for (int j = 0; j < width; j++) {
            pixels[i * width + j] = { row[j * 3 + 2], row[j * 3 + 1], row[j * 3] };
        }
    }

    delete[] row;
    file.close();
    return true;
}

// Função para salvar a imagem em escala de cinza
bool saveBMP(const std::string& filename, int width, int height, const std::vector<unsigned char>& grayscale) {
    std::ofstream file(filename, std::ios::binary);
    if (!file.is_open()) {
        std::cerr << "Erro ao salvar o arquivo BMP." << std::endl;
        return false;
    }

    // Cabeçalho BMP (54 bytes padrão)
    unsigned char header[54] = { 0 };
    header[0] = 'B';
    header[1] = 'M';
    *(int*)&header[2] = 54 + width * height; // Tamanho do arquivo
    header[10] = 54;                        // Offset para dados de pixel
    header[14] = 40;                        // Tamanho do cabeçalho DIB
    *(int*)&header[18] = width;
    *(int*)&header[22] = height;
    header[26] = 1;                         // Planos
    header[28] = 24;                        // Bits por pixel

    file.write(reinterpret_cast<char*>(header), 54);

    // Escrever pixels em escala de cinza
    int row_padded = (width * 3 + 3) & (~3);
    unsigned char* row = new unsigned char[row_padded];
    for (int i = 0; i < height; i++) {
        memset(row, 0, row_padded);
        for (int j = 0; j < width; j++) {
            unsigned char gray = grayscale[i * width + j];
            row[j * 3] = row[j * 3 + 1] = row[j * 3 + 2] = gray;
        }
        file.write(reinterpret_cast<char*>(row), row_padded);
    }

    delete[] row;
    file.close();
    return true;
}

// Função CUDA para conversão de escala de cinza
__global__ void convertToGrayscaleCUDA(Pixel* d_pixels, unsigned char* d_grayscale, int width, int height) {
    int idx = blockIdx.x * blockDim.x + threadIdx.x;
    if (idx < width * height) {
        Pixel p = d_pixels[idx];
        d_grayscale[idx] = static_cast<unsigned char>((p.r * 0.298 + p.g * 0.587 + p.b * 0.114) / 3.0);
    }
}

// Função serial para conversão
void convertToGrayscaleSerial(const std::vector<Pixel>& pixels, std::vector<unsigned char>& grayscale, int width, int height) {
    for (int i = 0; i < width * height; i++) {
        Pixel p = pixels[i];
        grayscale[i] = static_cast<unsigned char>((p.r * 0.298 + p.g * 0.587 + p.b * 0.114) / 3.0);
    }
}

// Função principal
int main() {
    const std::string inputFile = "input.bmp"; // Nome do arquivo de entrada
    const std::string outputDir = "output";   // Diretório base de saída

    // Criar diretório base
    createDirectory(outputDir);

    // Variáveis para armazenar informações da imagem
    int width, height;
    std::vector<Pixel> pixels;

    // Ler imagem BMP
    if (!readBMP(inputFile, width, height, pixels)) {
        return 1;
    }

    // Imprimir tamanho da imagem
    std::cout << "Dimensões da imagem: " << width << "x" << height << std::endl;

    // Vetor para armazenar a imagem em escala de cinza
    std::vector<unsigned char> grayscaleSerial(width * height);
    std::vector<unsigned char> grayscaleCUDA(width * height);

    // Repetições: 1, 10, 100, 1000
    std::vector<int> testCases = { 1, 10, 100, 1000 };
    std::ofstream resultFile(outputDir + "/performance_results.txt");

    // Iterar sobre os casos de teste
    for (int testCase : testCases) {
        std::cout << "\nExecutando para " << testCase << " imagens..." << std::endl;

        // Serial
        auto startSerial = std::chrono::high_resolution_clock::now();
        for (int i = 0; i < testCase; i++) {
            convertToGrayscaleSerial(pixels, grayscaleSerial, width, height);
        }
        auto endSerial = std::chrono::high_resolution_clock::now();
        auto durationSerial = std::chrono::duration_cast<std::chrono::microseconds>(endSerial - startSerial);

        // Paralela (CUDA)
        Pixel* d_pixels;
        unsigned char* d_grayscale;
        cudaMalloc(&d_pixels, pixels.size() * sizeof(Pixel));
        cudaMalloc(&d_grayscale, grayscaleCUDA.size() * sizeof(unsigned char));
        cudaMemcpy(d_pixels, pixels.data(), pixels.size() * sizeof(Pixel), cudaMemcpyHostToDevice);

        auto startCUDA = std::chrono::high_resolution_clock::now();
        for (int i = 0; i < testCase; i++) {
            int totalPixels = width * height;
            int blocks = (totalPixels + THREADS_PER_BLOCK - 1) / THREADS_PER_BLOCK;
            convertToGrayscaleCUDA << <blocks, THREADS_PER_BLOCK >> > (d_pixels, d_grayscale, width, height);
            cudaMemcpy(grayscaleCUDA.data(), d_grayscale, grayscaleCUDA.size() * sizeof(unsigned char), cudaMemcpyDeviceToHost);
        }
        auto endCUDA = std::chrono::high_resolution_clock::now();
        auto durationCUDA = std::chrono::duration_cast<std::chrono::microseconds>(endCUDA - startCUDA);

        cudaFree(d_pixels);
        cudaFree(d_grayscale);

        // Salvar resultados
        std::string serialOutputDir = outputDir + "/serial_case_" + std::to_string(testCase);
        std::string cudaOutputDir = outputDir + "/cuda_case_" + std::to_string(testCase);
        createDirectory(serialOutputDir);
        createDirectory(cudaOutputDir);

        // Salvar cada imagem processada
        for (int i = 0; i < testCase; i++) {
            saveBMP(serialOutputDir + "/output_" + std::to_string(i + 1) + ".bmp", width, height, grayscaleSerial);
            saveBMP(cudaOutputDir + "/output_" + std::to_string(i + 1) + ".bmp", width, height, grayscaleCUDA);
        }

        // Escrever tempos no arquivo
        resultFile << "Test Case: " << testCase << " imagens\n";
        resultFile << "Serial: " << durationSerial.count() << " µs\n";
        resultFile << "CUDA: " << durationCUDA.count() << " µs\n";
        resultFile << "---------------------------------\n";

        // Exibir resultados no console
        std::cout << "Serial: " << durationSerial.count() << " microsegundos" << std::endl;
        std::cout << "CUDA: " << durationCUDA.count() << " microsegundos" << std::endl;
    }

    resultFile.close();
    std::cout << "\nResultados salvos em: " << outputDir + "/performance_results.txt" << std::endl;

    return 0;
}

template <typename T>
std::string numberToString(const T& value) {
    std::ostringstream oss;
    oss << value;
    return oss.str();
}