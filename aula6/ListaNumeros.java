/** Crie um programa em Java que: Utilize um ArrayList<Integer> para armazenar 10
 * números inteiros inseridos pelo usuário. Exiba todos os números. Calcule e mostre a
 * soma total e a média dos números inseridos. Remova os números pares e exiba a lista
 * atualizada.
 * Dica: use métodos como add(), removeIf() e loops for ou for-eachpackage aula6;
*/
import java.util.ArrayList;
import java.util.Scanner;

public class ListaNumeros {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();

        //Ler 10 números do usuário e adicionar à lista
        for (int i = 1; i <= 10; i++) {
            System.out.print("Digite o " + i + "º número inteiro: ");
            int num = entrada.nextInt();
            numeros.add(num);
        }

        //Exibir todos os números inseridos
        System.out.println("\nNúmeros inseridos: " + numeros);

        //Calcular soma e média
        int soma = 0;
        for (int n : numeros) {
            soma += n;
        }
        double media = (double) soma / numeros.size();

        System.out.println("Soma total: " + soma);
        System.out.println("Média: " + media);

        //Remover números pares
        numeros.removeIf(n -> n % 2 == 0);

        //Exibir lista atualizada
        System.out.println("\nLista após remover números pares: " + numeros);

        entrada.close();
    }
}

