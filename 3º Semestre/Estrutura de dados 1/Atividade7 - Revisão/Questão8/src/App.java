import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Pilha P = new Pilha();
        Pilha N = new Pilha();
        Random rand = new Random();
        int num = 0;
        for(int i = 0; i<1000 ; i++){
            int posneg = rand.nextInt(2);

            if(posneg == 0){
                num = rand.nextInt(100);
            } else if (posneg == 1){
                num = rand.nextInt(100);
                num *= (-1);
            }

            if(num>0) P.empilhar(num);
            else if(num<0) N.empilhar(num);
            else if(num==0){
                System.out.println("Elemento retirado pilha P: "+P.desempilhar());
                System.out.println("Elemento retirado pilha N: "+N.desempilhar()+"\n");
            }
        }
    }
}
