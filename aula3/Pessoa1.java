/* Crie uma classe Pessoa com os atributos nome e idade. Depois, crie a 
* subclasse Aluno que herda de Pessoa e adiciona o atributo matricula. Crie 
* um construtor para Aluno que receba todos os dados e utilize super() para 
* inicializar nome e idade. Instancie um objeto de Aluno e mostre suas 
* informações. 
*/
public class Pessoa1 {
    private String nome;
    private int idade;   

    public Pessoa1(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome(){ 
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;

    }

    public int getIdade(){ 
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;

    }

    // subclasse
    public static class Aluno extends Pessoa1 {
        private String matricula;  
        
        public Aluno(String nome, int idade, String matricula){
            super(nome, idade); 
            this.matricula = matricula;
        }

        public String getMatricula() {
            return matricula;
        }

        public void setMatricula(String matricula){
            this.matricula = matricula;
        }
    }

    public static void main(String[] args) {
        Aluno aluno = new Aluno("Fernanda", 20, "1234");
        // Testando getters
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Idade: " + aluno.getIdade());
        System.out.println("Matrícula: " + aluno.getMatricula());

        // Testando setters (modificando os valores)
        aluno.setNome("Ana");
        aluno.setIdade(21);
        aluno.setMatricula("5678");

        System.out.println("\nApós alterações:");
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Idade: " + aluno.getIdade());
        System.out.println("Matrícula: " + aluno.getMatricula());
    }
}

