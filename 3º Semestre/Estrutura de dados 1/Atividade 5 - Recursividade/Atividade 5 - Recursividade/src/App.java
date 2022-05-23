import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Forma 1 ou 2?");
        int forma = scan.nextInt();
        System.out.println("Digite a quantidade de discos desejadas: ");
        int qtdDiscos = scan.nextInt();
        long T = 1;

        if(forma==1){
            Torre.torresHanói(qtdDiscos, T, qtdDiscos);
        } else if(forma==2){
            Torre.torresHanói2(qtdDiscos, 'A', 'B','C',T);
        }
    }
}
