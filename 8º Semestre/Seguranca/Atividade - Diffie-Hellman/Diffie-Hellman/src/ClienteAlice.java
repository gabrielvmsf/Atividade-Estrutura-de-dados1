import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteAlice {
    public static void main(String[] args) {
        try {
            // Conecta ao servidor na porta 12345
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Conectado ao servidor!");

            // Fluxos de entrada e saída
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);

            // Recebe p e g do servidor
            long primo = Long.parseLong(entrada.readLine());
            long base = Long.parseLong(entrada.readLine());
            System.out.println("Primo recebido: " + primo);
            System.out.println("Base recebida: " + base);

            // Configuração do Diffie-Hellman
            DiffieHellman aliceDH = new DiffieHellman(primo, base);

            // Envia chave pública de Alice e recebe chave pública de Bob
            saida.println(aliceDH.getChavePublica());
            long chavePublicaBob = Long.parseLong(entrada.readLine());

            // Calcula chave compartilhada
            aliceDH.calcularChaveCompartilhada(chavePublicaBob);
            System.out.println("Chave compartilhada calculada por Alice: " + aliceDH.getChaveCompartilhada());

            // Lê a mensagem do usuário
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite a mensagem para Bob: ");
            String mensagem = scanner.nextLine();

            // Envia mensagem criptografada para Bob
            int chaveCesar = (int) aliceDH.getChaveCompartilhada();
            String mensagemCriptografada = CaesarCipher.criptografar(mensagem, chaveCesar);
            saida.println(mensagemCriptografada);
            System.out.println("Mensagem enviada: " + mensagem);
            System.out.println("Mensagem criptografada enviada: " + mensagemCriptografada);

            // Recebe resposta criptografada do servidor
            String respostaCriptografada = entrada.readLine();
            String respostaDecifrada = CaesarCipher.descriptografar(respostaCriptografada, chaveCesar);
            System.out.println("Resposta criptografada recebida: " + respostaCriptografada);
            System.out.println("Resposta decifrada: " + respostaDecifrada);

            // Fecha conexões
            entrada.close();
            saida.close();
            socket.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
