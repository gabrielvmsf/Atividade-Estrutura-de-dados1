import java.util.ArrayList;
import java.util.List;


public class FilaLavados {
    List<Carro> carros = new ArrayList<Carro>();
    
    void insere(Carro a){
        this.carros.add(a);
    }
    
    Carro remover(){
        return this.carros.remove(0);
    }
    
    boolean filaVazia(){
        return this.carros.isEmpty();
    }
    void Esvaziar(){
        this.carros.clear();
    }
    int tamanhoFila() {
        return this.carros.size();
    }
}