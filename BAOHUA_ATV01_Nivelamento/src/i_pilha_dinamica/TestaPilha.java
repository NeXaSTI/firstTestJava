package i_pilha_dinamica;

public class TestaPilha {
    public static void main(String[] args) {
        PilhaDinamica pilha = new PilhaDinamica();
        System.out.println(pilha);
        
        for(int i = 1; i <= 10; i++){

        pilha.inserir_pilha("oi");
        
        }
        System.out.println(pilha);
    }
}
