/**
 * Programa que, dada a idade de uma pessoa, verifica sua classe eleitoral.
 * Regras usadas:
 * - Idade < 16  → Não eleitor
 * - 16 a 17 anos ou maior de 65 → Eleitor facultativo
 * - 18 a 65 anos → Eleitor obrigatório
 * O programa lê a idade, aplica as condições e mostra a classe eleitoral
 * correspondente no console.
 */
import java.util.Scanner;
public class IdadeVotacao {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe sua idade: ");
        int idade = (int)teclado.nextInt();
        if (idade < 16 ){
            System.out.println("Menor que 16 anos nao pode votar!");
        }
        if((idade == 16) || (idade > 65) || (idade == 17)){
            System.out.println("Voto Facultativo!");
        }
        if(idade >= 18 && idade <= 65){
            System.out.println("Voto Obrigatório!");
        }
        
    }
}
