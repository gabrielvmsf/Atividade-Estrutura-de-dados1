public class CifraDeCesar {

    public static String cifraDeCesarModular(String texto, int deslocamento) {
        StringBuilder resultado = new StringBuilder();
        deslocamento = deslocamento % 26;  
        
        for (char i : texto.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    resultado.append((char) ('A' + (i - 'A' + deslocamento) % 26));
                } else {
                    resultado.append((char) ('a' + (i - 'a' + deslocamento) % 26));
                }
            } else {
                resultado.append(i); 
            }
        }
        return resultado.toString();
    }

    public static String cifraDeCesarSemModular(String texto, int deslocamento) {
        StringBuilder resultado = new StringBuilder();
        deslocamento = (deslocamento % 26 + 26) % 26; 
        
        for (char i : texto.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    int novaPosicao = i + deslocamento;
                    if (novaPosicao > 'Z') {
                        novaPosicao -= 26;  
                    }
                    resultado.append((char) novaPosicao);
                } else {
                    int novaPosicao = i + deslocamento;
                    if (novaPosicao > 'z') {
                        novaPosicao -= 26;  
                    }
                    resultado.append((char) novaPosicao);
                }
            } else {
                resultado.append(i);  
            }
        }
        return resultado.toString();
    }
}