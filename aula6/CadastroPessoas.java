import java.util.HashMap;
import java.util.Scanner;

public class CadastroPessoas {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        HashMap<String, Integer> pessoas = new HashMap<>();

        // Cadastra pelo menos 5 pessoas
        for (int i = 1; i <= 5; i++) {
            System.out.print("Digite o nome da pessoa " + i + ": ");
            String nome = entrada.nextLine();
            System.out.print("Digite a idade de " + nome + ": ");
            int idade = entrada.nextInt();
            entrada.nextLine(); // limpar buffer
            pessoas.put(nome, idade);
        }

        // Consulta idade
        System.out.print("\nDigite um nome para consultar a idade: ");
        String consulta = entrada.nextLine();
        if (pessoas.containsKey(consulta)) {
            System.out.println("Idade de " + consulta + ": " + pessoas.get(consulta));
        } else {
            System.out.println("Pessoa não encontrada.");
        }

        // Remover uma pessoa
        System.out.print("\nDigite o nome de uma pessoa para remover: ");
        String remover = entrada.nextLine();
        if (pessoas.containsKey(remover)) {
            pessoas.remove(remover);
            System.out.println(remover + " removido(a) com sucesso.");
        } else {
            System.out.println("Pessoa não encontrada para remoção.");
        }

        // Mostrar mapa atualizado
        System.out.println("\nMapa atualizado:");
        for (String nome : pessoas.keySet()) {
            System.out.println(nome + " → " + pessoas.get(nome) + " anos");
        }

        entrada.close();
    }
}
