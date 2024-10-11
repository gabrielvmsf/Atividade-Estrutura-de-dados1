import java.util.Random;

public class Criptografia {
    Random rand = new Random();
    
    private String[] key;
    
    private String[] alfabeto = {
        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
    };

    public int Posicao(String caractere) {
        for (int i = 0; i < alfabeto.length; i++) {
            if (alfabeto[i].equals(caractere)) {
                return i;
            }
        }
        return -1;
    }

    public void GerarKey(String[] texto) {
        key = new String[texto.length];
        String keyString = "";

        for (int i = 0; i < texto.length; i++) {
            int random = rand.nextInt(26);
            key[i] = alfabeto[random];
            keyString += key[i];
        }
        System.out.println("A Key aleatória é: " + keyString);
    }

    public String Codificar(String texto) {
        if (key == null || key.length != texto.length()) {
            return "Erro: Chave inválida.";
        }
        String[] textoV = texto.split("");
        String textoCodificado = "";
    
        int posText = 0, posKey = 0, posCod = 0;
    
        for (int i = 0; i < textoV.length; i++) {
            posText = Posicao(textoV[i]);
            posKey = Posicao(key[i]);
    
            if (posText < 0 || posKey < 0) {
                return "Erro: Texto ou chave inválida.";
            }
            posCod = posText + posKey;
    
            if (posCod >= 26) {
                posCod -= 26;
            }
    
            textoCodificado += alfabeto[posCod];
        }
    
        return textoCodificado;
    }

    public String Decodificar(String texto) {
        if (key == null || key.length != texto.length()) {
            return "Erro: Chave inválida.";
        }
        String[] textoV = texto.split("");
        String textoDecodificado = "";
        
        int posText = 0, posKey = 0, posDecod = 0;
    
        for (int i = 0; i < textoV.length; i++) {
            posText = Posicao(textoV[i]);
            posKey = Posicao(key[i]);
        
            if (posText < 0 || posKey < 0) {
                return "Erro: Texto ou chave inválida.";
            }
        
            posDecod = posText - posKey;
        
            if (posDecod < 0) {
                posDecod += 26; 
            }
        
            textoDecodificado += alfabeto[posDecod];
        }
        
        return textoDecodificado;
    }
}
