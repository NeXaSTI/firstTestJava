package i_fila_dinamica;

public class FilaDinamica {
    No inicio;
    No fim;
    int tamanho;
    
    public FilaDinamica(){
        inicio = null;
        fim = null;
        tamanho = 0;
    }
    
    /* //Não vejo utilidade neste método
    public String verificarFim(){
        if(fim == null){
            return null;
        }
        return fim.elemento;
    }
    */
    
    public boolean filaVazia(){
        return inicio == null;
    }
    /*
    public void inserirFila(String elemento){
        No novoNo = new No();
        novoNo.elemento = elemento;
        novoNo.proximo = inicio;
        inicio = novoNo;
        if(tamanho == 0){
            fim = novoNo;
        }
        tamanho++;
    }
    */
    
    public void inserirFila(String elemento){
        No novoNo = new No();
        novoNo.elemento = elemento;
        novoNo.proximo = null;
        if(fim == null){
            inicio = novoNo;
        } else {
            fim.proximo = novoNo;
        }
        fim = novoNo;
        tamanho++;
    }
    
    //Remove os elementos de trás pra frente -> lista
    /*
    public String removerFila(){
        if(filaVazia()){
            return null;
        }
        String info = fim.elemento;
        if(inicio == fim){
            inicio = null;
            fim = null;
        } else {
            No atual = inicio;
            while(atual != fim){
                atual = atual.proximo;
            }
            fim = atual;
            fim.proximo = null;
        }
        tamanho--;
        return info;
    }
    */
    
    public void removerElemento(){
        if(filaVazia()){
            System.out.println("\nFila Vazia\n");
        }
        //String info = fim.elemento;
        if(inicio == fim){
            inicio = null;
            fim = null;
        } else {
            No atual = inicio;
            inicio = inicio.proximo;
            atual = null;
        }
        tamanho--;
        System.out.println("\nElemento removido\n");
        imprimirFila();
    }
    
    
    public void buscarFila(String elemento){
        if(filaVazia()){
            System.out.println("\nFila vazia\n");
        }
        No noBusca = inicio;
        while(noBusca != null && !(noBusca.elemento.equals(elemento))){
            noBusca = noBusca.proximo;
        }
        if(noBusca == null){
            System.out.println("\nElemento " + elemento + " não encontrado\n");
        } else {
            elemento = noBusca.elemento;
            System.out.println("\nElemento " + elemento + " encontrado\n");
        }
    }
    
    public void tamanhoFila(){
        if(filaVazia()){
            tamanho = 0;
        }
        System.out.println("\nTamanho da fila: " + tamanho);
    }
    
    public void imprimirFila(){
        if(filaVazia()){
            System.out.println("\nFila vazia\n");
        } else {
            String printaFila = "Fila:\n";
            No lerNo = inicio;
            while(lerNo != null){
                printaFila += lerNo.elemento + "\n";
                lerNo = lerNo.proximo;
            }
            System.out.println(printaFila);
        }
    }
}
