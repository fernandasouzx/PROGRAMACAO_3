/** Crie um programa que: Peça ao usuário o nome de um arquivo de texto.
 * Utilize FileInputStream, InputStreamReader e BufferedReader para ler o
 * conteúdo linha a linha. Exiba o conteúdo completo no console.
 * Dica: Trate exceções com try-catch e feche os streams corretamente.
 */ 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LeituraArquivo {
    public static void main(String[] args) throws Exception {
        System.out.println("Informe o nome do arquivo: ");
        Scanner teclado = new Scanner(System.in);
        String arquivo = teclado.nextLine(); 
       try {
           FileInputStream is = new FileInputStream("arquivo.txt");
           InputStreamReader isr = new InputStreamReader(is);
           BufferedReader br = new BufferedReader(isr);
           String linha;
           while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
            br.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao existe" + arquivo);
        }catch(IOException e){
            System.out.println("Erro ao ler o arquivo" + e.getMessage());
        }
        teclado.close();
    }
}
