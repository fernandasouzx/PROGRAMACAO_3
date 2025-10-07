package trabalho;
import java.time.LocalDate;
public abstract class Item {
    //classe e seus atributos
    private String titulo;
    private String descricao;
    private LocalDate DataCadastro;

    //metodo abstrato
    public abstract String exibirDetalhes();

    //criação dos getters e settes dos atributos
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        if(titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }
        this.titulo = titulo;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        if(descricao == null || descricao.isBlank()){
            throw new IllegalArgumentException("A descrição não pode ser vazio.");
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
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }
        this.titulo = titulo;
        this.descricao = descricao;
        this.DataCadastro = DataCadastro != null ? DataCadastro : LocalDate.now();
    }
}
