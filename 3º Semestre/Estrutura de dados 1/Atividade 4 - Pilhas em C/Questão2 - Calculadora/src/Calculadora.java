public class Calculadora {

    
    float elementos[],infixa[],num[];
    int top,qtd = 100;
    float resultado;

    public Calculadora() {
        elementos = new float[qtd];
        top = -1;
    }

    public void push(float x) {
        top++;
        elementos[top] = x;
    }


    public float pop() {
        float e;
        qtd++;
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

    public float top() {
        return elementos[top];
    }
    public void full(){
        top = qtd;
    }
}
