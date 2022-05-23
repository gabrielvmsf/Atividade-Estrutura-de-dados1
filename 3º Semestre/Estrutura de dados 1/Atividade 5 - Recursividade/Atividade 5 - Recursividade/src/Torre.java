public class Torre {
    public static long torresHanói(int num, Long T, int qtdDiscos) {
        if (num == 1 || num == 0) {
            System.out.println("\nA quantidade de movimentos necessarias para uma Torre de Hanói de " + qtdDiscos + " discos é:\n" + T + " movimentos\n");
            return 1;
        }
        return torresHanói((num - 1), (1 + T + T), qtdDiscos);
    }

    public static long torresHanói2(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("Disco " + num + " de " + a + " para " + c + "\n");
            return 1;
        } else {
            torresHanói2((num - 1), a, c, b);
            System.out.println("Disco " + num + " de " + a + " para " + c + "\n");
            return torresHanói2((num - 1), c, b, a);
        }
    }
}