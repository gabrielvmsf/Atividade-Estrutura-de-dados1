public class Analisador {
    Entrada ent;

    public Analisador(String arquivo) {
        this.ent = new Entrada(arquivo);
    }

    public Token proximoToken() {
        // ignorar espaço em branco, quando is read retornar -1 é porque acabou a leitra
        // dos caracteres

        int caractereLido = ent.LerProximoCaractere();

        switch (caractereLido) {
            case ';':
                return new Token(TipoToken.Delim, ";");
            case '*':
                return new Token(TipoToken.OprAriMult, "*");
            case '<':
                caractereLido = (char) ent.LerProximoCaractere();

                switch (caractereLido) {
                    case '>':
                        return new Token(TipoToken.OpRelDif, "<>");
                    case '=':
                        return new Token(TipoToken.OpRelMenorIgual, "<=");
                    case '-':
                        return new Token(TipoToken.PCAtribuir, "<-");
                    default:
                        return new Token(TipoToken.OpRelMenor, "<");
                }
            case '>':
                caractereLido = (char) ent.LerProximoCaractere();

                if (caractereLido == '=') {
                    return new Token(TipoToken.OpRelMaiorIgual, ">=");
                } else {
                    return new Token(TipoToken.OpRelMaior, ">");
                }
            case '/':
                return new Token(TipoToken.OprAriDiv, "/");
            case '+':
                return new Token(TipoToken.OpAritSoma, "+");
            case '-':
                return new Token(TipoToken.OpAritSoma, "-");
            case 's':
                caractereLido = (char) ent.LerProximoCaractere();

                if (caractereLido == 'e') {
                    return new Token(TipoToken.PCSe, "se");
                }
            case '(':
                return new Token(TipoToken.AbrePar, "(");
            case ')':
                return new Token(TipoToken.FechaPar, ")");
            default:
                // Lidar com caso não previsto
                break;
        }

        return null;
    }
}