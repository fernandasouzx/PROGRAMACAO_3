import java.io.File;
import java.util.Scanner;

public class CaminhoArquivo {
    public static void main(String[] args) {
        System.out.println("Informe o caminho do arquivo: ");
        Scanner teclado = new Scanner(System.in);
        String nome_arq = teclado.nextLine();

        try {
            File arquivo = new File(nome_arq);

            if (!arquivo.exists()) {
                System.out.println("O caminho informado não existe.");
            } else {
                System.out.println("O caminho existe!");

                if (arquivo.isFile()) {
                    System.out.println("É um arquivo.");
                    System.out.println("Tamanho: " + arquivo.length() + " bytes");
                } else if (arquivo.isDirectory()) {
                    System.out.println("É um diretório.");
                    System.out.println("Arquivos contidos nele:");

                    String[] conteudo = arquivo.list();
                    if (conteudo != null && conteudo.length > 0) {
                        for (String nome : conteudo) {
                            System.out.println(" - " + nome);
                        }
                    } else {
                        System.out.println("(Diretório vazio)");
                    }
                }

                System.out.println("Caminho absoluto: " + arquivo.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }

        teclado.close();
    }
}
