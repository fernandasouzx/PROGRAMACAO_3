/* 
Crie uma classe Livro com os atributos titulo e autor. Implemente dois
construtores: Um sem parâmetros que define valores padrão. Um com
parâmetros para inicializar os atributos. No método main, instancie dois
objetos utilizando os dois construtores diferentes e exiba os dados.
 */

import trabalho.Livro;

public class Livro {
    String titulo;
    String autor;
    //construtor padrao
    public Livro(){
        this.titulo = "Titulo Padrão";
        this.autor = "Autor Padrão";
    }
    //construtor com parametros
    public Livro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }
    public void mostrarLivro(){
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
    }
    public static void main(String[] args) {
        Livro livro = new Livro();
        Livro livro2 = new Livro("O pequeno principe" , "Antoine de Saint-Exupéry");
        System.out.println("Livro 1 com parametro padrao");
        livro.mostrarLivro();
        System.out.println("----------------------------");
        System.out.println("Livro 2 com parametro");
        livro2.mostrarLivro();
    }
}
