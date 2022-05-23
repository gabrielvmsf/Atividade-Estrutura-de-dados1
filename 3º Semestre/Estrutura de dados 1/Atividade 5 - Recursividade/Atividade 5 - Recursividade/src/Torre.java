public class Torre {
    public static long torresHanói(int num, Long T, int qtdDiscos) {
        System.out.println(num);
        if (num == 1 || num == 0) {
            System.out.println("\nA quantidade de movimentos necessarias para uma Torre de Hanói de " + qtdDiscos
                    + " discos é:\n" + T + " movimentos");
            return 1;
        }
        return torresHanói((num - 1), (1 + T + T), qtdDiscos);
    }

    public static long torresHanói2(int num, char a, char b, char c, long T) {
        if (num == 1) {

            System.out.println("Disco " + num + " de " + a + " para " + c + "\nNumero de movimentos: " + T);
            return T;
        } else {
            System.out.println("Disco " + num + " de " + a + " para " + c + "\n");
            torresHanói2((num - 1), a, c, b, (T + 1));
            System.out.println("Disco " + num + " de " + a + " para " + c + "\n");
            return torresHanói2((num - 1), c, b, a, (T + 1));
        }
    }
}