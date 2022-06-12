import java.util.Random;

public class Pessoa {
    private int id;
    private int idade;
    private String sexo;
    private boolean gestante;
    private boolean lactante;
    private boolean necessidadeEspeciais;
    

    public Pessoa(int id, int idade, boolean gestante, boolean lactante, boolean necessidadeEspeciais) {
        Random rand = new Random();
        this.id = id;
        this.idade = idade;

        int num = rand.nextInt(2);
        if(num==1){
            sexo="Feminino";
        } else sexo="Masculino";

        this.gestante = gestante;
        this.lactante = lactante;
        this.necessidadeEspeciais = necessidadeEspeciais;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isGestante() {
        return this.gestante;
    }

    public boolean getGestante() {
        return this.gestante;
    }

    public void setGestante(boolean gestante) {
        this.gestante = gestante;
    }

    public boolean isLactante() {
        return this.lactante;
    }

    public boolean getLactante() {
        return this.lactante;
    }

    public void setLactante(boolean lactante) {
        this.lactante = lactante;
    }

    public boolean isNecessidadeEspeciais() {
        return this.necessidadeEspeciais;
    }

    public boolean getNecessidadeEspeciais() {
        return this.necessidadeEspeciais;
    }

    public void setNecessidadeEspeciais(boolean necessidadeEspeciais) {
        this.necessidadeEspeciais = necessidadeEspeciais;
    }
    
}
