import java.util.ArrayList;

public class ÚsuarioEspecial extends Úsuario {

    private ArrayList<Publicações> publicaçõesEmprestadas = new ArrayList<Publicações>();
    
    public ÚsuarioEspecial(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, email, cpf);
    }

    @Override
    public boolean emprestimo(Publicações publicação) {
        publicação.setQtdEmprestado(1);
        publicaçõesEmprestadas.add(publicação);
        return true;
    }

    @Override
    public double devolverEmprestimo(Publicações publicação){
        publicação.setQtdEmprestado(0);
        publicaçõesEmprestadas.remove(publicação);
        if (getQtdRenovações() > 3) {
            this.setMulta((getQtdRenovações()  - 3) * publicação.getValorMulta());
            setQtdRenovações(0);
            return getMulta();
        }
        setQtdRenovações(0);
        setMulta(0);
        return getMulta();
    }

}
