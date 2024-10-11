public class ExecutarTeste {

    public static void testarCriptografia(String texto, int deslocamento) {
        long startTimeModular = System.nanoTime();
        String criptografiaModular = CifraDeCesar.cifraDeCesarModular(texto, deslocamento);
        long endTimeModular = System.nanoTime();
        long durationModular = endTimeModular - startTimeModular;

        long startTimeSemModular = System.nanoTime();
        String criptografiaSemModular = CifraDeCesar.cifraDeCesarSemModular(texto, deslocamento);
        long endTimeSemModular = System.nanoTime();
        long durationSemModular = endTimeSemModular - startTimeSemModular;

        System.out.println("Criptgrafia Modular: "+ criptografiaModular);
        System.out.println("Criptgrafia sem Modular: "+ criptografiaSemModular + "\n");

        System.out.println("Tempo de execução com aritmética modular: " + durationModular + " nanosegundos");
        System.out.println("Tempo de execução sem aritmética modular: " + durationSemModular + " nanosegundos");
    }
}
