import java.io.*;
import java.net.*;

public class ServidorBob {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor aguardando conexão...");

            Socket socket = servidor.accept();
            System.out.println("Cliente conectado!");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            long primo = 23;
            long base = 5; 
            DiffieHellman bobDH = new DiffieHellman(primo, base);

            saida.println(primo);
            saida.println(base);

            long chavePublicaAlice = Long.parseLong(entrada.readLine());
            saida.println(bobDH.getChavePublica());

            bobDH.calcularChaveCompartilhada(chavePublicaAlice);
            System.out.println("Chave compartilhada calculada por Bob: " + bobDH.getChaveCompartilhada());

            String mensagemCriptografada = entrada.readLine();
            System.out.println("Mensagem criptografada recebida: " + mensagemCriptografada);

            int chaveCesar = (int) bobDH.getChaveCompartilhada();
            String mensagemDecifrada = CaesarCipher.descriptografar(mensagemCriptografada, chaveCesar);
            System.out.println("Mensagem decifrada: " + mensagemDecifrada);

            System.out.print("Digite uma mensagem para Alice: ");
            String resposta = teclado.readLine();
            String respostaCriptografada = CaesarCipher.criptografar(resposta, chaveCesar);
            saida.println(respostaCriptografada);

            entrada.close();
            saida.close();
            socket.close();
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
