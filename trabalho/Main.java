package trabalho;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Instancia o gerenciador
        GerenciadorItens gerenciador = new GerenciadorItens();

        // Cria alguns itens
        Livro livro = new Livro("O Hobbit", "J.R.R. Tolkien", "Aventura fantástica", LocalDate.now(), 310);
        Filme filme = new Filme("Interestelar", "Ficção científica", LocalDate.now(), "Christopher Nolan", 169);

        try {
            // Adiciona os itens ao gerenciador
            gerenciador.adicionarItem(livro);
            gerenciador.adicionarItem(filme);
            // gerenciador.adicionarItem(null); // Exemplo de exceção
        } catch (ItemInvalidoException e) {
            System.err.println("Erro ao adicionar item: " + e.getMessage());
        }

        // Lista todos os itens
        System.out.println("Todos os itens cadastrados:");
        gerenciador.listarTodos().forEach(item -> System.out.println(item.getTitulo()));

        // Busca por título
        System.out.println("\nBuscar por 'hobbit':");
        gerenciador.buscarPorTitulo("hobbit")
                   .forEach(item -> System.out.println(item.getTitulo()));

        // Contagem por tipo
        System.out.println("\nContagem por tipo:");
        gerenciador.contarPorTipo()
                   .forEach((tipo, qtd) -> System.out.println(tipo + ": " + qtd));

        // Ordena por título e exibe
        gerenciador.ordenarPorTitulo();
        System.out.println("\nItens ordenados por título:");
        gerenciador.listarTodos().forEach(item -> System.out.println(item.getTitulo()));

        // Mostra detalhes
        System.out.println("\nDetalhes dos itens:");
        gerenciador.listarTodos().forEach(item -> System.out.println(item.exibirDetalhes()));
    }
}
