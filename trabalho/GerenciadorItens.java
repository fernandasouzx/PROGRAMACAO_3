package trabalho;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class GerenciadorItens {
    private List<Item> itens = new ArrayList<>();

    // Adiciona um item à lista
    public void adicionarItem(Item item) throws ItemInvalidoException {
        if (item == null) {
            throw new ItemInvalidoException("O item não pode ser nulo.");
        }
        itens.add(item); //adiciona os itens no array
    }
    public interface Exportavel {
        String exportar(); // formato CSV ou outro texto
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

    // Conta quantidade de itens por tipo
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
    // Cria objeto a partir de linha
    private static Item fromLinhaArquivo(String linha) throws ItemInvalidoException {
        String[] p = linha.split(";");
        String tipo = p[0];
        try {
            switch (tipo) {
                case "Livro":
                    String titulo = p[1];
                    String descricao = p[2];
                    String autor = p[3];
                    LocalDate dataCadastro = LocalDate.parse(p[4]);
                    int paginas = Integer.parseInt(p[5]);
                    return new Livro(titulo, descricao, autor, dataCadastro, paginas);
                    
                case "Filme":
                titulo = p[1];
                descricao = p[2];
                String diretor = p[3];
                dataCadastro = LocalDate.parse(p[4]);
                int duracao = Integer.parseInt(p[5]);
                return new Filme(titulo, descricao, diretor, dataCadastro, duracao);

                default:
                    throw new ItemInvalidoException("Tipo desconhecido: " + tipo);
            }
        } catch (Exception e) {
            throw new ItemInvalidoException("Erro ao ler linha: " + linha);
        }
    }

    //------------ EXPORTAÇAO -----------------
    public void exportarParaArquivo(String caminho) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            for (Item item : itens) {
                if (item instanceof Livro livro) {
                    writer.write(String.format("Livro;%s;%s;%s;%s;%d\n",
                            livro.getTitulo(),
                            livro.getDescricao(),
                            livro.getAutor(),
                            livro.getDataCadastro(),
                            livro.getNumeroPaginas()));

                            
                } else if (item instanceof Filme filme) {
                    writer.write(String.format("Filme;%s;%s;%s;%s;%d\n",
                            filme.getTitulo(),
                            filme.getDescricao(),
                            filme.getDiretor(),
                            filme.getDataCadastro(),
                            filme.getDuracao()));
                }
                writer.newLine();
                
            }
            System.out.println("Itens exportados com sucesso para: " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao exportar itens: " + e.getMessage());
        }

    }
    //------------ Importação -----------------
    public void importarDeArquivo(String caminho) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("----- Filme -----")) {
                    String titulo = br.readLine().split(": ")[1];
                    String descricao = br.readLine().split(": ")[1];
                    String diretor = br.readLine().split(": ")[1];
                    LocalDate dataCadastro = LocalDate.parse(br.readLine().split(": ")[1]);
                    int duracao = Integer.parseInt(br.readLine().split(": ")[1]);
                    itens.add(new Filme(titulo, descricao, diretor, dataCadastro, duracao));

                } else if (linha.startsWith("----- Livro -----")) {
                    String titulo = br.readLine().split(": ")[1];
                    String descricao = br.readLine().split(": ")[1];
                    String autor = br.readLine().split(": ")[1];
                    LocalDate dataCadastro = LocalDate.parse(br.readLine().split(": ")[1]);
                    int paginas = Integer.parseInt(br.readLine().split(": ")[1]);
                    itens.add(new Livro(titulo, descricao, autor, dataCadastro, paginas));
                }
            }

            System.out.println("Itens importados com sucesso de: " + caminho);

        } catch (Exception e) {
            System.err.println("Erro ao importar itens: " + e.getMessage());
        }
    }
}
