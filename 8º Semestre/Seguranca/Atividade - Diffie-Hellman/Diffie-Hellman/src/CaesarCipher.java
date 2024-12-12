public class CaesarCipher {
    // Método para criptografar uma mensagem
    public static String criptografar(String mensagem, int chave) {
        StringBuilder mensagemCriptografada = new StringBuilder();
        for (char c : mensagem.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + chave) % 26 + base);
            }
            mensagemCriptografada.append(c);
        }
        return mensagemCriptografada.toString();
    }

    // Método para descriptografar uma mensagem
    public static String descriptografar(String mensagem, int chave) {
        return criptografar(mensagem, 26 - (chave % 26));
    }
}
