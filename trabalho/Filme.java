package trabalho;

import java.time.LocalDate;
public class Filme extends Item {

    private String diretor;
    private int duracaoMinutos;

    public Filme(String titulo, String descricao, LocalDate dataCadastro, String diretor, int duracaoMinutos) {
        super(titulo, descricao, dataCadastro);
        if (diretor == null || diretor.isBlank()) {
            throw new IllegalArgumentException("O diretor não pode ser vazio.");
        }
        if (duracaoMinutos <= 0) {
            throw new IllegalArgumentException("A duração deve ser positiva.");
        }
        this.diretor = diretor;
        this.duracaoMinutos = duracaoMinutos;
    }
    @Override
    public String exibirDetalhes() {
        return "Filme: " + getTitulo() + "\n" +
            "Descrição: " + getDescricao() + "\n" +
            "Data de Cadastro: " + getDataCadastro() + "\n" +
            "Diretor: " + diretor + "\n" +
            "Duração: " + duracaoMinutos + " minutos\n";
    }   
}