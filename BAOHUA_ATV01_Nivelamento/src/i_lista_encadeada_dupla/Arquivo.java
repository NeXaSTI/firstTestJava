package i_lista_encadeada_dupla;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Arquivo extends ListaDupla  {
      public static String Read(String Caminho){
        String conteudo = "";
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                    conteudo += linha+"\n";
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }
    public static String Start(String Caminho,ListaDupla lista){
        String conteudo = "";
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            ArrayList<String> salvar = new ArrayList();
            try {
                linha = lerArq.readLine();
                conteudo = linha;
                while(linha!=null){                                     
                    conteudo = linha;
                    salvar.add(conteudo);
                    conteudo = null;
                    linha = lerArq.readLine();                       
                }
                for(int i=0; i<salvar.size();i++){
                    lista.inserir_lista_ordenada(i,salvar.get(i));
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }
    
    public static boolean Write(String Caminho,String Texto){
        try {
            FileWriter arq = new FileWriter(Caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(Texto);
            gravarArq.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean removerOrdenado(String Caminho,ListaDupla lista,String item){
        
        try {
            FileReader fr = new FileReader(Caminho);
            BufferedReader br = new BufferedReader(fr);
            
            String linha = br.readLine();
            ArrayList<String> salvar = new ArrayList();
            
            String achei="";
            while(linha != null){
                achei = linha;
                 if(linha.toLowerCase().contains(item.toLowerCase())==false){
                     salvar.add(linha);  
                 }else {
                     String posicao = achei.split(";")[0];
                     System.out.println(posicao);
                     lista.setPosicao(Integer.parseInt(posicao));
                      
                 }
                 achei = null;
                 linha = br.readLine();
            }
            br.close();
            fr.close();
            FileWriter fw2 = new FileWriter(Caminho, true);
            fw2.close();
            
            FileWriter fw = new FileWriter(Caminho);
            BufferedWriter bw= new BufferedWriter(fw);
            
            for(int i =0; i<salvar.size();i++){
                bw.write(salvar.get(i));
                bw.newLine();
            }

            bw.close();
            fw.close();                            
       }catch(IOException ex){
       
       }
        lista.remover_lista_ordenada(lista.getPosicao());
        lista.setPosicao(-1);
     return true;
    
    }
   
}

