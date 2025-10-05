/* Modifique a classe Aluno do exercício anterior para: Tornar os atributos
privados. Criar métodos get e set para todos os atributos. No método
main, teste os métodos de acesso e modificação
*/

public class Pessoa1 {
    private String nome;
    private int idade;   

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
        private String matricula;  
        
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
