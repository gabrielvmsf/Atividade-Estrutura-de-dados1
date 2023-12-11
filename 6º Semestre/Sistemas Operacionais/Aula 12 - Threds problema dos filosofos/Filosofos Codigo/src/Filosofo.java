import java.util.concurrent.Semaphore;

class Filosofo implements Runnable {
    private int id;
    private Semaphore[] garfos;

    public Filosofo(int id, Semaphore[] garfos) {
        this.id = id;
        this.garfos = garfos;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando");
        Thread.sleep(1000);
    }

    private void comer() throws InterruptedException {
        System.out.println("Filósofo " + id + " está comendo");
        Thread.sleep(1000);
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();

                // Pega o garfo da esquerda
                garfos[id].acquire();
                System.out.println("Filósofo " + id + " pegou o garfo da esquerda.");

                // Pega o garfo da direita
                garfos[(id + 1) % garfos.length].acquire();
                System.out.println("Filósofo " + id + " pegou o garfo da direita.");

                comer();
                
                // Libera o garfo da esquerda
                garfos[id].release();
                System.out.println("Filósofo " + id + " liberou o garfo da esquerda.");

                // Libera o garfo da direita
                garfos[(id + 1) % garfos.length].release();
                System.out.println("Filósofo " + id + " liberou o garfo da direita.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}