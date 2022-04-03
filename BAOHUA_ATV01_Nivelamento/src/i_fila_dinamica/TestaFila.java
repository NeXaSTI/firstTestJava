package i_fila_dinamica;

import java.util.Scanner;

public class TestaFila {
    public static void main(String[] args) {
        
        FilaDinamica fila = new FilaDinamica();
        //INSERIR ELEMENTOS
        fila.inserirFila("1");
        fila.inserirFila("2");
        fila.inserirFila("3");
        fila.inserirFila("4");
        fila.inserirFila("5");
        /*
        //BUSCAR ELEMENTO INEXISTENTE
        fila.buscarFila("4");
        fila.buscarFila("2");
        //IMPRIMIR A FILA CRIADA
        fila.imprimirFila();
        //REMOVER ALGUNS ELEMENTOS
        fila.removerElemento();
        fila.removerElemento();
        fila.removerElemento();
        */
        //CAMINHO PARA O ARQUIVO
        String entradaFila = "src/entrada/EntradaFila.txt";
        //File file = new File("src/entrada/EntradaFila.txt");
        /*
        //Criar Arquivo
        String conteudo = "Something like that";
        if(ArquivoFila.Write(entradaFila, conteudo)){
        System.out.println("Arquivo salvo");
        } else {
        System.out.println("Erro no salvamento");
        }
        */
        //Ler Arquivo
        String conteudo = ArquivoFila.Read(entradaFila);
        if(conteudo.isEmpty()){
            System.err.println("Erro ao ler arquivo");
        } else {
            System.out.println(conteudo);
        }
        //Menu
        Scanner sc = new Scanner(System.in);
        int opcao;
        do{
            fila.imprimirFila();
            System.out.println("Escolha uma das opções para manipular pilhas:\n"
                    + "1. Inserir elemento \n"
                    + "2. Buscar elemento \n"
                    + "3. Remover elemento \n"
                    + "4. Imprimir fila\n"
                    + "5. Ver tamanho da fila\n"
                    + "0. Sair\n"
                    + "Digite o número da opção: ");
            opcao = sc.nextInt();
            if(opcao >= 0 && opcao <= 5){
                switch(opcao){
                    case 1 -> {
                        System.out.println("Digite o elemento que deseja inserir: ");
                        String novoElemento = sc.nextLine();
                        fila.inserirFila(novoElemento);
                        fila.imprimirFila();
                        break;
                    }
                    case 2 -> {
                        System.out.println("Digite o elemento que está procurando: ");
                        String busca = sc.nextLine();
                        fila.buscarFila(busca);
                        break;
                    }
                    case 3 -> {
                        fila.removerElemento();
                        break;
                    }
                    case 4 -> {
                        fila.imprimirFila();
                        break;
                    }
                    case 5 -> {
                        fila.tamanhoFila();
                        break;
                    }
                    default -> {
                            System.exit(0);
                            }
                }
            } else {
                System.out.println("\n\tOpção inválida\n");
            }
        }while(opcao != 0);
        
    }
}
