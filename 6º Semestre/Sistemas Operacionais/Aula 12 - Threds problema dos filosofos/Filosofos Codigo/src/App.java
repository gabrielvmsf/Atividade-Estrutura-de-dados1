import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) {
        int numFilosofos = 5;
        Semaphore[] garfos = new Semaphore[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            garfos[i] = new Semaphore(1);
        }

        Thread[] filosofos = new Thread[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            filosofos[i] = new Thread(new Filosofo(i, garfos));
            filosofos[i].start();
        }
    }
}
