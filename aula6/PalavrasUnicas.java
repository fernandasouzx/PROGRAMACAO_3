import java.util.HashSet;
import java.util.Scanner;

public class PalavrasUnicas {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        HashSet<String> palavras = new HashSet<>();

        System.out.println("Digite palavras (digite 'fim' para encerrar):");

        while (true) {
            String palavra = entrada.nextLine();
            if (palavra.equalsIgnoreCase("fim")) {
                break;
            }
            palavras.add(palavra);
        }

        System.out.println("\nPalavras únicas digitadas:");
        for (String p : palavras) {
            System.out.println(p);
        }

        if (palavras.contains("Java")) {
            System.out.println("\nA palavra 'Java' foi digitada!");
        } else {
            System.out.println("\nA palavra 'Java' não foi digitada.");
        }

        entrada.close();
    }
}
