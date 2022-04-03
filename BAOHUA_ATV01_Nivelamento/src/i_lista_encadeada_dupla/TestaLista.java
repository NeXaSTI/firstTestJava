package i_lista_encadeada_dupla;

public class TestaLista {
    
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();
        System.out.println(lista);
        
        String caminho = "texte.txt";
        Arquivo.Start(caminho, lista);     
        System.out.println("Inteira:"+lista);
        
        Arquivo.removerOrdenado(caminho, lista, "Pedro");
        System.out.println("Removi Pedro:"+lista);
        String dados = "06;Pedro";
        
        lista.inserir_lista(dados, caminho);
       System.out.println("Adicionei Pedro:"+lista);
    }
    
}
