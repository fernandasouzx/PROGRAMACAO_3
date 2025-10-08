package trabalho;
import java.time.LocalDate;
public class Livro extends Item {

    private String autor;
    private int numeroPaginas;
    @Override
    protected void CampoVazioException(String string){
        throw new IllegalArgumentException("O campo '" + string + "' deve ter algo.");
    }
    // Construtor
    public Livro(String titulo, String autor, String descricao, LocalDate dataCadastro,  int numeroPaginas) {
        super(titulo, descricao, dataCadastro);

        if (autor == null || autor.isBlank()) {
            CampoVazioException("Diretor");
        }
        if (numeroPaginas <= 0) {
            CampoVazioException("Numero de Páginas");
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
