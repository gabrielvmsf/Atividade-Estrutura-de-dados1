import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        ListaSimples pessoasAtendidas = new ListaSimples();
        ListaSimples pessoasNãoAtendidas = new ListaSimples();
        int id = 0, k = 0, j = 3;
        int pessoas = 10;
        while (k < 100) {
                for (int l = 0; l < j; l++) {
                    id++;
                    if (pessoas == 10) {
                        pessoas--;
                        Pessoa p = new Pessoa(id, 18, false, false, true);
                        pessoasAtendidas.inserirInicio(p);
                    } else if (pessoas == 9) {
                        pessoas--;
                        Pessoa p = new Pessoa(id, 18, true, false, false);
                        pessoasAtendidas.inserirInicio(p);
                    } else if (pessoas == 8) {
                        pessoas--;
                        Pessoa p = new Pessoa(id, 18, false, true, false);
                        pessoasAtendidas.inserirInicio(p);
                    } else if (pessoas >= 5) {
                        pessoas--;
                        Pessoa p = new Pessoa(id, 18, false, false, false);
                        pessoasAtendidas.inserirInicio(p);
                    } else
                        pessoas = 10;
                    k++;
                }
                pessoas = 10;

                j += 1;

            
        }
        System.out.println("ID Fila de pacientes atendidos:");
        for(int i = 0; i<pessoasAtendidas.getTamanho();i++){
            System.out.println("Id:"+pessoasAtendidas.retirarInicio().getId()+" i: "+i);
        }

    }
}
