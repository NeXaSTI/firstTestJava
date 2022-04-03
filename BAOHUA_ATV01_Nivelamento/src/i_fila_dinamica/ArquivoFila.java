package i_fila_dinamica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArquivoFila {
    
    public static String Read(String caminho){
        String conteudo = "";
        try{
            FileReader fr = new FileReader(caminho);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            
            try{
                linha = br.readLine();
                while(linha != null){
                    conteudo += linha + "\r\n";
                    linha = br.readLine();
                }
                fr.close();
                return conteudo;
                
            } catch(IOException ioException) {
                System.err.println("\nErro: Não foi possível ler o arquivo");
                return "";
            }
            
        } catch(FileNotFoundException fnfException) {
            System.err.println("\nErro: Arquivo não encontrado");
            return "";
        }
        
    }
    
    public static boolean Write(String caminho, String conteudo){
        try{
            FileWriter fw = new FileWriter(caminho);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(conteudo);
            pw.close();
            return true;
            
        } catch(IOException ioException) {
            System.err.println(ioException.getMessage());
            return false;
        }
        
    }
    
}
