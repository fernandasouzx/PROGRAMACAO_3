import java.io.PrintStream;
import java.util.Scanner;

public class LeituraArquivoMultiplasLinhas {
    public static void main(String[] args) {
        System.out.println("Insira as palavras desejadas:\nPara encerrar digite 'Fim'");
        Scanner teclado = new Scanner(System.in);

        try (PrintStream ps = new PrintStream("saida.txt")){
            while(true){
                String linha = teclado.nextLine();
                if(linha.equalsIgnoreCase("Fim")){
                    break;
                }
                ps.println(linha);
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao escrever no arquivo de 'saida.txt'");
        }
        teclado.close();
        System.out.println("Programa Encerrado!");
    }
}
