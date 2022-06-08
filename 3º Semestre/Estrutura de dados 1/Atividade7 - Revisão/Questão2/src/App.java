public class App {
    public static void main(String[] args) {
        Fila f1 = new Fila();
        Fila f2 = new Fila();
        
        for(int i=0; i<10;i++){ //colocar inteiros na fila
            f1.inserir(i);
        }

        f1.inserir(9);
        f1.inserir(9);
        
        int c = 9;

        while(!(f1.isEmpty())){ //retirar termo
            if(f1.getPrimeiroTermo() == c ){
                System.out.println("termo "+f1.retirar()+" retirado");
            } else {
                f2.inserir(f1.retirar());
            }
        }

        while(!(f2.isEmpty())){ //imprimir fila
            System.out.print(f2.retirar()+" ");
        }
    }
}
