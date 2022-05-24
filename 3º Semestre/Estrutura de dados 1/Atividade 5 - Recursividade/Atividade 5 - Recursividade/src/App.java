import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a quantidade de discos desejadas: ");
        int qtdDiscos = scan.nextInt();
        long T = 1;
        long tempoInicial = System.currentTimeMillis();
        Torre.torresHanói2(qtdDiscos, 'A', 'B', 'C');
        Torre.torresHanói(qtdDiscos, T, qtdDiscos);
        
        long tempoFinal = System.currentTimeMillis();
        long tempoMili = tempoFinal - tempoInicial;
        
        long tempoSeg = tempoMili/1000, tempoMin=tempoSeg/60, tempoHor=tempoMin/60;
        if(tempoMin>=60){
            long t1 = tempoHor*60;
            tempoMin = tempoMin - t1;
        }
        if(tempoSeg>=60){
            long t1 = tempoMin * 60;
            tempoSeg = tempoSeg - t1;
        }
        if (tempoMili>=1000){
            long t1 = tempoSeg * 1000;
            tempoMili = tempoMili - t1;
        }

        System.out.println("Tempo de execução: "+tempoHor+":"+tempoMin+":"+tempoSeg+":"+tempoMili);
    }
}
