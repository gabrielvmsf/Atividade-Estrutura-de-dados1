public class StackDinamica {
    private CelulaPilha top;

    public void push(String nome) {
        CelulaPilha novaCelula = new CelulaPilha();
        novaCelula.setDado(nome);
        novaCelula.setAnterior(this.top);
        this.top = novaCelula;
    }

    public String pop() {
        if (!isEmpyt()) {
            String d = this.top.getDado();
            //System.out.println("Retirando elem. da pilha..: " + d);
            this.top = this.top.getAnterior();
            return d;
        } else {
            System.out.println("Pilha Vazia!!!");
            return "";
        }
    }

    public boolean isEmpyt() {
        if (this.top == null) {
            return true;
        } else
            return false;
    }

    public int sizePilha() {
        CelulaPilha p;
        int cont = 0;
        p = this.top;
        while (p != null) {
            p = p.getAnterior();
            cont++;
        }
        return cont;
    }

    public void imprimir() {
        CelulaPilha p;
        p = this.top;
        if (isEmpyt()) {
            System.out.println("Pilha Vazia!!!");
        } else {
            while (p != null) {
                System.out.println("Nome na pilha..: " + p.getDado());
                p = p.getAnterior();
            }
        }
    }

    public CelulaPilha top() {
        if (isEmpyt()) {
            System.out.println("Pilha Vazia!!!");
            return null;
        } else {
            System.out.println("Nome no topo da Pilha..: " + top.getDado());
            return this.top;
        }
    }
}
