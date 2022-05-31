import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int j = 0;

        Scanner scan = new Scanner(System.in);
        FilaCarros filaCarros = new FilaCarros();
        FilaLavados filaLavados = new FilaLavados();

        for (int i = 0; i < 15; i++) {
            Carro carro = new Carro(i);
            filaCarros.insere(carro);
            j++;
            if(j==3){
                Carro c = filaCarros.remover();
                System.out.println("Carro "+c.getNumId()+" Terminou de ser lavado");
                filaLavados.insere(c);
                j = 0;
                
            }
        }
        for (int i = 0; i < filaCarros.tamanhoFila(); i++) {
            filaLavados.insere(filaCarros.remover());
            
            
        }
        while(true){
            System.out.println("1) Imprimir os dados dos carros já lavados.\n2) ordenar a fila de carros já lavados (segunda fila) pelo númeroidentificador do carro.\n3) Sair do programa");
            int valor = scan.nextInt();
            if(valor == 1){
                for (int i = 0; i < filaLavados.tamanhoFila(); i++){
                    System.out.println("Carro de identificador "+filaLavados.carros.get(i).getNumId()+" já foi lavado");
                }
            } else if (valor == 2){

            } else break;
        }
    }
}
