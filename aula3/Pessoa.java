/* Crie uma classe Pessoa com os atributos nome e idade. Depois, crie a 
* subclasse Aluno que herda de Pessoa e adiciona o atributo matricula. Crie 
* um construtor para Aluno que receba todos os dados e utilize super() para 
* inicializar nome e idade. Instancie um objeto de Aluno e mostre suas 
* informações. 
*/
public class Pessoa {
    String nome;
    int idade;   

    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome(){ 
        return nome;
    }

    public int getIdade(){ 
        return idade;
    }

    // subclasse
    public static class Aluno extends Pessoa {
        String matricula;  
        
        public Aluno(String nome, int idade, String matricula){
            super(nome, idade); 
            this.matricula = matricula;
        }

        public String getMatricula() {
            return matricula;
        }
    }

    public static void main(String[] args) {
        Aluno aluno = new Aluno("Fernanda", 20, "1234");
        System.out.println(aluno.getNome() + " - " + aluno.getMatricula());
    }
}
