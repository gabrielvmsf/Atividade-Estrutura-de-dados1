public class StackDinamica {
    private CelulaPilha top;

    public void push(int nome) {
        CelulaPilha novaCelula = new CelulaPilha();
        novaCelula.setDado(nome);
        novaCelula.setAnterior(this.top);
        this.top = novaCelula;
    }

    public int pop() {
        if (!isEmpyt()) {
            int d = this.top.getDado();
            // System.out.println("Retirando elem. da pilha..: " + d);
            this.top = this.top.getAnterior();
            return d;
        } else {
            System.out.println("Pilha Vazia!!!");
            return 0;
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

    public void imprimir(StackDinamica a2, StackDinamica a3) {
        CelulaPilha p;
        p = this.top;
        CelulaPilha p2;
        p2 = a2.getTop();
        CelulaPilha p3;
        p3 = a3.getTop();

        if (isEmpyt()) {
            System.out.println("Pilha Vazia!!!");
        } else {
            System.out.println("pilha 1:   pilha 2:  pilha 3:");
            while (p != null || p2 != null || p3 != null) {
                if (p != null && p2 != null && p3 != null) {
                    System.out.println(p.getDado() + "             " + p2.getDado() + "             " + p3.getDado());
                    p = p.getAnterior();
                    p2 = p2.getAnterior();
                    p3 = p3.getAnterior();
                } else if (p != null && p2 != null) {
                    System.out.println(p.getDado() + "             " + p2.getDado());
                    p = p.getAnterior();
                    p2 = p2.getAnterior();
                } else if (p != null && p3 != null) {

                    System.out.println(p.getDado() + "             " + "              " + p3.getDado());
                    p = p.getAnterior();
                    p3 = p3.getAnterior();

                } else if (p2 != null && p3 != null) {

                    System.out.println("              " + p2.getDado() + "             " + p3.getDado());
                    p2 = p2.getAnterior();
                    p3 = p3.getAnterior();

                } else if (p != null) {
                    System.out.println(p.getDado()+"               " + "             " );
                    p = p.getAnterior();
                } else if (p2 != null) {
                    System.out.println("               " +p2.getDado()+ "             " );
                    p2 = p2.getAnterior();
                } else if (p3 != null) {
                    System.out.println("               " + "             "+p3.getDado() );
                    p3 = p3.getAnterior();
                }
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

    public CelulaPilha getTop() {
        return this.top;
    }

    public void setTop(CelulaPilha top) {
        this.top = top;
    }

}
