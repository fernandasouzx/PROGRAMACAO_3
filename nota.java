
import java.util.Scanner;
// entrada de dados precisa importar o java.util.Scanner
public class nota{
    public static void main(String[] args) {
        Scanner teclado =  new Scanner(System.in);
        //entrada de dados
        System.out.print("Insira o nome do aluno: ");
        String nome = teclado.nextLine();
        System.out.print("Insira a nota1: ");
        double nota1 = teclado.nextDouble();
        System.out.print("Insira a nota1: ");
        double nota2 = teclado.nextDouble();

        //calculo das medias
        double media = (nota1 + nota2)/2;

        // se media do aluno for menor que 5, esta reprovado se nao aprovado
        if (media < 5){
            System.out.println("--------------");
            System.out.println("Reprovado!");
            System.out.println("Aluno: " + nome);
            System.out.printf("Media = %.1f%n", media);
        }else{ 
            System.out.println("--------------");
            System.out.println("Aprovado!");
            System.out.println("Aluno: " + nome);
            System.out.printf("Media = %.1f%n",media);
        }
    }
} 