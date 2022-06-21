public class App {
    public static void main(String[] args) throws Exception {
        ListaDupla ld = new ListaDupla();
        ld.Adiciona("Homer");
        ld.Adiciona("Marge");
        System.out.println(ld.Imprimir());

        ld.EsvaziaLista();
        System.out.println(ld.Imprimir());

        ld.Adiciona("Homer");
        ld.Adiciona(0, "Bart");
        ld.Adiciona(1, "Moll");
        System.out.println(ld.Imprimir());

        ld.Adiciona("Homer");
        ld.Adiciona("Bart");
        ld.AdicionaNoComeco("Lisa");

        System.out.println(ld.Imprimir());
        System.out.println(ld.tamanho());
        

        ld.EsvaziaLista();

        ld.Adiciona("Homer");
        ld.Adiciona("Bart");
        System.out.println(ld.Imprimir());
        System.out.println(ld.tamanho());
        

        System.out.println("Marge: "+ld.Contem("Marge")+"Homer: "+ld.Contem("Homer")+"Bart: "+ld.Contem("Bart")+"Maggie: "+ld.Contem("Maggie"));
        System.out.println(ld.Imprimir());
        System.out.println(ld.tamanho());
        

        ld.EsvaziaLista();

        ld.AdicionaNoComeco("Homer");
        ld.AdicionaNoComeco("Bart");
        ld.Adiciona(1, "Marge");
        ld.Adiciona(1, "Maggie");
        ld.AdicionaNoComeco("Ned Flanders");
        ld.Adiciona("Sr. Burns");
        System.out.println(ld.Imprimir());

        ld.RemovedoFim();
        System.out.println(ld.Imprimir()); 

        ld.RemovedoComeco();
        System.out.println(ld.Imprimir());
        System.out.println(ld.tamanho());
        

        System.out.println("Marge: "+ld.Contem("Marge")+"Homer: "+ld.Contem("Homer")+"Bart: "+ld.Contem("Bart")+"Maggie: "+ld.Contem("Maggie"));
        System.out.println(ld.Imprimir());
        System.out.println(ld.tamanho());
        

        ld.RemovedoComeco();
        System.out.println(ld.Imprimir());
        System.out.println(ld.tamanho());
        

        System.out.println("Marge: "+ld.Contem("Marge")+"Homer: "+ld.Contem("Homer")+"Bart: "+ld.Contem("Bart")+"Maggie: "+ld.Contem("Maggie"));
        System.out.println(ld.Imprimir());
        System.out.println(ld.tamanho());
        

        ld.EsvaziaLista();
        System.out.println(ld.Imprimir());


    }
}