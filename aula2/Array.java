/*
Crie uma ArrayList<String> para armazenar nomes de alunos.
Adicione pelo menos 5 nomes.
Use um Iterator para percorrer e imprimir cada nome da lista.
Em seguida, remova um nome e exiba novamente a lista atualizada.
*/

import java.util.ArrayList;
import java.util.Iterator;

public class Array {
    String nome;
    
    public static void main(String[] args) {
        ArrayList <Array> array = new ArrayList<>();

        //criando os objetos
        Array nome1 = new Array();
        Array nome2 = new Array();
        Array nome3 = new Array();
        Array nome4 = new Array();
        Array nome5 = new Array();
        
        //definindo o nome dos alunos para cada objeto criado
        nome1.nome = "Valdemi";
        nome2.nome = "Alessandra";
        nome3.nome = "Fernanda";
        nome4.nome = "Evellyn";
        nome5.nome = "Caio";
        
        //adicionando os objetos nomes ao Arraylist
        array.add(nome1);
        array.add(nome2);
        array.add(nome3);
        array.add(nome4);
        array.add(nome5);

        //lista origibal com os 5 alunos
        System.out.println("Lista original:");
        Iterator <Array> i = array.iterator();
        while (i.hasNext()) {
            Array aluno = i.next();
            System.out.println("Alunos: " + aluno.nome);
        }

        array.remove(0); // removendo o primeiro nome

        // depois do remove, criar novo iterator
        System.out.println("\nLista após remover índice 0:");
        i = array.iterator();
        while (i.hasNext()) {
            Array aluno = i.next();
            System.out.println("Alunos: " + aluno.nome);
        }
    }
}
