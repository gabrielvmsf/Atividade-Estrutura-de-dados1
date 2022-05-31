import java.util.Scanner;
import java.util.Random;
public class App {
    public static void main(String[] args) throws Exception {
        int j = 0, i = 0;

        Random gerador = new Random();
        Scanner scan = new Scanner(System.in);
        FilaCarros filaCarros = new FilaCarros();
        FilaLavados filaLavados = new FilaLavados();

        while (true) {
            Carro carro = new Carro(gerador.nextInt(400),"A","A");
            filaCarros.insere(carro);
            i++;
            j++;
            if (j == 3) {
                filaLavados.insere(filaCarros.remover());
                j--;
            }
            if (filaCarros.tamanhoFila()<=2 && i>2 && filaLavados.tamanhoFila()>=19) {
                filaLavados.insere(filaCarros.remover());
                filaLavados.insere(filaCarros.remover());
                break;
            }
        }

        while (true) {
            System.out.println(
                    "\n1) Imprimir os dados dos carros já lavados.\n2) ordenar a fila de carros já lavados pelo número identificador do carro.\n3) Sair do programa");
            int valor = scan.nextInt();
            if (valor == 1) {
                for (i = 0; i < filaLavados.tamanhoFila(); i++) {
                    Carro carro = filaLavados.getCarro(i);
                    System.out.println(
                            "Carro de identificador " + carro.getNumId() + " da marca "+carro.getMarca()+" do dono(a) do veiculo "+carro.getNome()+" já foi lavado");
                }
            } else if (valor == 2) {
                filaLavados.ordenar();
                for (i = 0; i < filaLavados.tamanhoFila(); i++) {
                    Carro carro = filaLavados.getCarro(i);
                    System.out.println(
                            "Carro de identificador " + carro.getNumId() + " da marca "+carro.getMarca()+" do dono(a) do veiculo "+carro.getNome()+" já foi lavado");
                }
            } else if (valor == 3){
                System.out.println("\nPrograma Finalizado!");
                break;
            }
        }
    }
}
