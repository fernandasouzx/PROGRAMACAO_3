package trabalho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GerenciadorItens {
    private List<Item> itens = new ArrayList<>();

    // Adiciona um item à lista
    public void adicionarItem(Item item) throws ItemInvalidoException {
        if (item == null) {
            throw new ItemInvalidoException("O item não pode ser nulo.");
        }
        itens.add(item);
    }

    // Retorna todos os itens cadastrados
    public List<Item> listarTodos() {
        // retorna uma cópia para evitar modificações externas
        return new ArrayList<>(itens);
    }

    // Busca parcial e case-insensitive por título
    public List<Item> buscarPorTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) return new ArrayList<>();

        String tituloLower = titulo.toLowerCase();
        return itens.stream()
                .filter(i -> i.getTitulo().toLowerCase().contains(tituloLower))
                .collect(Collectors.toList());
    }

    // Conta quantidade de itens por tipo (ex: Livro, Filme, etc)
    public Map<String, Long> contarPorTipo() {
        return itens.stream()
                .collect(Collectors.groupingBy(
                        item -> item.getClass().getSimpleName(),
                        Collectors.counting()
                ));
    }

    // Ordena os itens alfabeticamente por título
    public void ordenarPorTitulo() {
        Collections.sort(itens, Comparator.comparing(Item::getTitulo, String.CASE_INSENSITIVE_ORDER));
    }
}
