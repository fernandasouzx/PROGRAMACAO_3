package trabalho;
import java.time.LocalDate;

public class Main{
    public static void main(String[] args) {
        Livro livro = new Livro("O Hobbit", "J.R.R. Tolkien", "Aventura fantástica", LocalDate.now(), 310);
        Filme filme = new Filme("Interestelar", "Ficção científica", LocalDate.now(), "Christopher Nolan", 169);

        System.out.println(livro.exibirDetalhes());
        System.err.println("\n");
        System.out.println(filme.exibirDetalhes());
    }
}
