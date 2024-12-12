public class DiffieHellman {
    private long chavePrivada;
    private long chavePublica;
    private long chaveCompartilhada;
    private long primo;
    private long base;

    public DiffieHellman(long primo, long base) {
        this.primo = primo;
        this.base = base;
        gerarChavePrivada();
        calcularChavePublica();
    }

    private void gerarChavePrivada() {
        this.chavePrivada = (long) (Math.random() * 1000 + 1);
    }

    private void calcularChavePublica() {
        this.chavePublica = modularExponenciacao(base, chavePrivada, primo);
    }

    public void calcularChaveCompartilhada(long chavePublicaRecebida) {
        this.chaveCompartilhada = modularExponenciacao(chavePublicaRecebida, chavePrivada, primo);
    }

    private long modularExponenciacao(long base, long expoente, long mod) {
        long resultado = 1;
        base = base % mod;
        while (expoente > 0) {
            if ((expoente % 2) == 1) {
                resultado = (resultado * base) % mod;
            }
            expoente = expoente >> 1; 
            base = (base * base) % mod;
        }
        return resultado;
    }

    public long getChavePublica() {
        return chavePublica;
    }

    public long getChaveCompartilhada() {
        return chaveCompartilhada;
    }
}
