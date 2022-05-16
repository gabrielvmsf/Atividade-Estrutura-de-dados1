public class Operadores {

    
    String elementos[];
    int top,qtd = 100;

    public Operadores() {
        elementos = new String[qtd];
        top = -1;
    }

    public void push(String x) {
        top++;
        elementos[top] = x;
    }


    public String pop() {
        String e;
        e = elementos[top];
        top--;

        return e;
    }

    public void setQtd(int q){
        this.qtd= q;
    }
    public int getQtd(){
        return this.qtd;
    }

    public boolean isEmpty() {
        return (top == -1);
    }
    
    public void empty() {
        top = -1;
    }

    public boolean isFull() {
        return (top == qtd);
    }
    public void full(){
        top = qtd;
    }

    public String top() {
        return elementos[top];
    }
}
