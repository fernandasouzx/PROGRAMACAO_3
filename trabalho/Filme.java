package trabalho;
import java.time.LocalDate;
public class Filme extends Item {

    private String diretor;
    private int duracaoMinutos;

    @Override
    protected void CampoVazioException(String string){
        throw new IllegalArgumentException("O campo '" + string + "' deve ter algo.");
    }

    public Filme(String titulo, String descricao, String diretor, LocalDate dataCadastro, int duracaoMinutos) {
        super(titulo, descricao, dataCadastro);
        if (diretor == null || diretor.isBlank()) {
            CampoVazioException("Diretor");
        }
        if (duracaoMinutos <= 0) {
            CampoVazioException("Duração em minutos");

        }
        this.diretor = diretor;
        this.duracaoMinutos = duracaoMinutos;
    }
    public String getDiretor() {
        return diretor;
    }

    public int getDuracao() {
        return duracaoMinutos;
    }

    @Override
    public String exibirDetalhes() {
        return "Filme: " + getTitulo() + "\n" +
            "Descrição: " + getDescricao() + "\n" +
            "Diretor: " + diretor + "\n" +
            "Data de Cadastro: " + getDataCadastro()+"\n"+ 
            "Duração: " + duracaoMinutos + " minutos\n";
    }   
}