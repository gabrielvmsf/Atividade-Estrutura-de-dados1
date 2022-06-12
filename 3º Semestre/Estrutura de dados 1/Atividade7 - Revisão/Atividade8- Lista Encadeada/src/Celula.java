public class Celula {
    Celula Proxima;
    Object Elemento;
    
    public Celula(Object elemento){
        this.Elemento = elemento;
    }
    
    public Celula(Celula proxima, Object elemento){
        this.Proxima = proxima;
        this.Elemento = elemento;
    }
    
    public void setProxima(Celula proxima){
        this.Proxima = proxima;
    }
    
    public Celula getProxima(){
        return(this.Proxima);
    }
    
    public Object getElemento(){
        return(this.Elemento);
    }
}