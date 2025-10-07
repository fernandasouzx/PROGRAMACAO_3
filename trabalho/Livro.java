package trabalho;
import java.time.LocalDate;
public class Livro extends Item {
    private String autor;
    private int numeroPaginas;
    // Construtor
    public Livro(String titulo, String autor, String descricao, LocalDate dataCadastro,  int numeroPaginas) {
        super(titulo, descricao, dataCadastro);

        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("Autor não pode ser vazio.");
        }
        if (numeroPaginas <= 0) {
            throw new IllegalArgumentException("O número de páginas deve ser positivo.");
        }

        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }
    @Override
    public String exibirDetalhes() {
        return "Livro: " + getTitulo() +
               "\nAutor: " + autor +
               "\nDescrição: " + getDescricao() +
               "\nCadastrado em: " + getDataCadastro() +
               "\nPáginas: " + numeroPaginas;
    }
}
