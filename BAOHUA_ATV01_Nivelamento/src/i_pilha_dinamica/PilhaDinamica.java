package i_pilha_dinamica;

class PilhaDinamica {
    No fim;
    int tamanho;
    
    public int tamanho_pilha(){
        if (fim == null)
            return 0;
        int cont = 0;
        No no = new No();
        while(no != null)
        {
            cont++;
            no = no.proximo;
        }
        return cont;
    }
    
    public int pilha_cheia(){
        return 0;
    }
    
    public int pilha_vazia(){
        if (fim == null){
            return 1;
        }
        return 0;
    }
    
    public void inserir_pilha(String dados){
        No no = new No();
        no.dados = dados;
        no.proximo = fim;
        if(fim != null){
            fim.proximo = no;
        }
        fim = no;
        if(tamanho == 0){
            fim = no.proximo;
        }
        tamanho++;
    }
}
