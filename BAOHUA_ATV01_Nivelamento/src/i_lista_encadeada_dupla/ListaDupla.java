package i_lista_encadeada_dupla;

public class ListaDupla {
    No inicio;
    No fim;
    int tamanho;
    int posicao;

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
    public int tamanho_lista(){
        //Se o inicio for igual a nulo, então retorna zero.
        if(inicio == null){
            return 0;
        }
        //Criando um novo no.
        No no =  new No();
        int cont = 0;
        //Enquanto o no for diferente de nulo, então incrementa o tamanho e no é igual ao próximo no da lista.
        while(no != null){
            cont++;
            no = no.proximo;
        }
        //Retorna a quantidade de lista.
        return cont;
    }
    
    public int lista_vazia(){
        //Se o inicio for igual a nulo, então retorne falso.
        if(inicio == null){
            return 1;
        }
        //Senão, então retorne verdadeiro, então lista não está vazia.
        return 0;
    }
    
    public void inserir_lista_inicio(String dados){
        //Instanciando o no.
        No no =  new No();
        //Colocando as informações dentro do no.
        no.dados = dados;
        no.anterior = null;
        no.proximo = inicio;
        //Se a lista for diferente de nulo, então o meu inicio anterior é igual ao meu novo no.
        if(inicio != null){
            inicio.anterior = no;
        }
        //inicio apontando para o novo no inserido;
        inicio = no;
        //Se o tamanho da lista for igual a zero, então o fim é igual ao inicio.
        if(tamanho == 0){
            fim = inicio;
        }
        //Incrementa a quantidade de elementos na lista. 
        tamanho++;
   }
    
       public void inserir_lista(String dados,String caminho){
        //Instanciando o no.
        Arquivo.Write(caminho, dados);
        inserir_lista_final(dados);
   }
    
    public void inserir_lista_final(String dados){
       No no = new No();
       no.dados = dados ;
       no.proximo = null;
       no.anterior = fim;
       if(fim != null){
           fim.proximo=no;
       } else {
           inicio= fim;
       }
       fim=no;
       tamanho++;
    }
    
    public void inserir_lista_ordenada(int indice, String dados){
              if(indice <=0){
          inserir_lista_inicio(dados);
       }else if(tamanho >= indice){
           inserir_lista_final(dados);
       }else {
           No local = inicio;
           for(int i=0; i<indice-1; i++){
              local= local.proximo;
           }
           No no = new No();
           no.dados= dados;
           no.anterior = local;
           no.proximo = local.proximo;
           local.proximo=no;
           no.proximo.anterior = no;
           tamanho++;
       }
        
    }
    
    public String remover_lista_inicio(){
        //Verificando se a lista está vazia, então se a lista está vazia, retorna nulo.
        if(inicio == null){
            return null;
        }
        //Salva a informação do inicio.
        String out = inicio.dados;
        //Apontando para o próximo
        inicio = inicio.proximo;
       //Se o inicio for diferente de zero, então o inicio do anterior vai ser igual a nulo. 
        if(inicio != null){
            inicio.anterior = null;
        }
        //Senão, então o fim será igual a nulo.
        else{
            fim = null;
        }
        //Decrementa a quantidade de elementos da lista.
        tamanho--;
        return out;
    }
    
    public String remover_lista_final(){
        //Verificando se a lista está vazia, então se a lista está vazia, retorna nulo.
        if(fim == null){
            return null;
        }
        //Salvando a informação do fim.
        String out = fim.dados;
        //Se o fim for diferente de nulo, então meu próximo do fim é igual a nulo.
        if(fim != null){
            fim.proximo = null;
        }
        //Senão, meu inicio vai ser igual a nulo.
        else{
            inicio = null;
        }
        //Decremento a quantidade de elementos da lista.
        tamanho--;
        return out;
    }
    
    public String remover_lista_ordenada(int indice){
        //Se o indice for menor que zero ou maior igual ao tamanho ou inicio igual a nulo, então retorna nulo.
        if(indice < 0 || indice >= tamanho || inicio == null){
            return null;
        }
        //Senão se, indice igual a zero, então remover o elemento no inicio da lista.
        else if(indice == 0){
            return remover_lista_inicio();
        }
         //Senão se, indice igual ao tamanho = 1, então remover o elemento no final da lista.
        else if(indice == tamanho-1){
            return remover_lista_final();
        }
        No local = inicio;
        for(int i = 0; i < indice; i++){
            local = local.proximo;
        }
        if(local.anterior != null){
            local.anterior.proximo = local.proximo;
        }
        if(local.proximo != null){
            local.proximo.anterior = local.anterior;
        }
        tamanho--;
        return local.dados;
    }
    
    public int busca_lista_id(int id){
        if(inicio == null){
            return 0;
        }
        No no = new No();
        while(no != null){
            no = no.proximo;
            if(no == null){
                return 0;
            }
            else{
             
               return 1;
            }
        }
       return 0;
    }
    
    public int imprimir_lista(String dados){
        //Se a lista estiver vazia, então emite mensagem: "Lista vazia";
        if(inicio == null){
            System.out.println("Lista vazia\n");
            return 0;
        }
            //Instanciando um novo no.
            No ler_no = new No();
            System.out.printf("-------------\n");
            //Imprimindo os dados
       do{
            System.out.printf("Dado: %s\n" + ler_no.dados);
            System.out.printf("-------------\n");
            ler_no = ler_no.proximo;
         //Enquanto o no for diferente de nulo, então imprima os próximos dados.
        }while(ler_no != null);
       return 1;
    }
    
    public String toString(){
        String str = "(" + tamanho + ") ";
        No local = inicio;
        while(local!=null){
           str += local.dados+" ";
           local=local.proximo;
        }
       return str;
    }
}