import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        StackDinamica par = new StackDinamica();
        StackDinamica impar = new StackDinamica();
        int num = 1;
        System.out.println("Escreva valores de -127 a 128 \n(0) finaliza a leitura de dados!");
        while(true){
            num = scan.nextInt();

            if(num == 0) break;
            if(num%2==0){
                par.push(num);
            } else impar.push(num);
        }
        while(!par.isEmpyt()||!impar.isEmpyt()){
            impar.pop();
            if(impar.isEmpyt()) break;
            par.pop();
            if(par.isEmpyt()) break;
        }
        if(!par.isEmpyt()){
            System.out.println("A pilha par ainda possui elementos! total de elementos: "+par.sizePilha());
            System.out.println("Elementos par que não foram retirados:");
            while(!par.isEmpyt()){
                System.out.print(par.pop()+" ");
            }
        } else if(!impar.isEmpyt()){
            System.out.println("A pilha impar ainda possui elementos! total de elementos: "+impar.sizePilha());
            System.out.println("Elementos impar que não foram retirados:");
            while(!impar.isEmpyt()){
                System.out.print(impar.pop()+" ");
            }
        }

    }
}
