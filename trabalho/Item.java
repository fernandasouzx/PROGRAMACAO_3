package trabalho;
import java.time.LocalDate;

public abstract class Item {
    //classe e seus atributos
    private String titulo;
    private String descricao;
    private LocalDate DataCadastro;

    //metodo abstrato
    public abstract String exibirDetalhes();
    protected abstract void CampoVazioException(String string);

    //criação dos getters e settes dos atributos
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        if(titulo == null || titulo.isBlank()){
            CampoVazioException("Titulo");
        }
        this.titulo = titulo;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        if(descricao == null || descricao.isBlank()){
            CampoVazioException("Descricao");
        }
        this.descricao = descricao;
    }
   
    public LocalDate getDataCadastro(){
        return DataCadastro;
    }
    public void setdataCadastro(LocalDate dataCadastro){
        this.DataCadastro = dataCadastro;
    }
    public Item(String titulo, String descricao, LocalDate dataCadastro) {
        if (titulo == null || titulo.isBlank()) {
            CampoVazioException("Titulo");
        }
        this.titulo = titulo;
        this.descricao = descricao;
        this.DataCadastro = DataCadastro != null ? DataCadastro : LocalDate.now();
    }
    public static Item fromLinhaArquivo(String linha) {
        if (linha == null || linha.isBlank()) {
            return null;
        }

        String[] partes = linha.split(";", -1);
        if (partes.length < 5) { 
            System.out.println("Linha inválida: " + linha);
            return null;
        }

        String tipo = partes[0];
        String titulo = partes[1];
        String descricao = partes[2];
        LocalDate dataCadastro = LocalDate.parse(partes[4]);

        try {
            switch (tipo) {
                case "Livro":
                    // Formato: Livro;Titulo;Descricao;Autor;Data;Paginas
                    String autor = partes[3];
                    int paginas = Integer.parseInt(partes[5]);
                    return new Livro(titulo, descricao, autor, dataCadastro, paginas);

                case "Filme":
                    // Formato: Filme;Descricao;Data;Diretor;Duracao
                    String diretor = partes[3];
                    int duracao = Integer.parseInt(partes[5]);
                    return new Filme(titulo, descricao, diretor, dataCadastro, duracao);

                default:
                    System.out.println("Tipo desconhecido: " + tipo);
                    return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao importar linha: " + linha);
            System.out.println("Detalhes: " + e.getMessage());
            return null;
        }
    }
}


