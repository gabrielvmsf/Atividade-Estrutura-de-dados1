public class Token {
    public TipoToken nome;
    public String lexema;

    public Token(TipoToken nome, String lexema) {
        this.nome = nome;
        this.lexema = lexema;
    }

    // metodo to string para apresentar de forma mais elaborada e facil a represenar
    // string da classe token

    public String toString(){
        return "<" + nome + "," + lexema + ">";
    }
}
