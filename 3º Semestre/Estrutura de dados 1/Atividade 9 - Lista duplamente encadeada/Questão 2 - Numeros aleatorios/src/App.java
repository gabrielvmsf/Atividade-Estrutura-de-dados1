import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args){
        Random rand = new Random();
        int ordem[] = new int [1000];
        ListaDupla ld = new ListaDupla();

        for(int i=0; i<1000 ;i++){
            int numero = rand.nextInt(-10000, 10000);
            ordem[i]=numero;
            //System.out.println(ordem[i]);
        }
        Arrays.sort(ordem);
        for(int i=0; i<1000 ;i++){
            ld.Adiciona(ordem[i]);
        }
        //System.out.println(ld.Imprimir());
        
        /*ld.EsvaziaLista();

        for(int i=999; i>=0 ;i--){
            ld.Adiciona(ordem[i]);
        }
        System.out.println(ld.Imprimir());*/

        System.out.println(ld.ImprimirInverso());
    }
}
