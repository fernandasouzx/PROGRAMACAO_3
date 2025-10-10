package trabalho;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class CatalogoGUI extends JFrame {
    private List<Item> itens = new ArrayList<>(); //cria um array para armazenar os livros e filmes
    private JTextField tituloField;
    private JTextArea descricaoArea;
    private JComboBox<String> tipoCombo;
    private JPanel specificPanel;
    private JTextField autorField, paginasField;
    private JTextField diretorField, duracaoField;
    private JTextArea resultadoArea;
    private JTextField buscaField;
    private Color corPersonalizada = new Color(0x64, 0x64, 0x86); //cor definida pelo nome e rga - cinza arroxeado
    private Color corHover = new Color(0x7D, 0x7D, 0xA0); //cor que o mouse passa

    //construtor da classe, onde a interface gráfica é montada.
    public CatalogoGUI() {
        //Cabeçalho e título fixo da janela
        setTitle("Catálogo de Livros e Filmes"); //titulo principal
        setSize(1000, 1000); //define o tamanho inicial da janela em pixels (largura, altura).
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(0xF0, 0xF0, 0xF5)); //define a cor de fundo do painel de conteúdo da janela.

        // Cria o painel superior que tera o título e uma imagem.
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(corPersonalizada);
        topPanel.setBorder(new EmptyBorder(10, 20, 10, 30));

        // Carregar a imagem do canto superior esquerdo
        ImageIcon icon2 = null;
        try {
            icon2 = new ImageIcon("/home/fernanda/image2.jpg"); // Caminho da imagem
            Image img2 = icon2.getImage().getScaledInstance(100, 120, Image.SCALE_SMOOTH);
            icon2 = new ImageIcon(img2);
        } catch (Exception e) {
            System.err.println("Erro ao carregar segunda imagem: " + e.getMessage());
            icon2 = new ImageIcon();
        }
        JLabel imagemLabel2 = new JLabel(icon2);

        // Título centralizado
        JLabel titleLabel = new JLabel("Catálogo de Livros e Filmes", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        // Adiciona imagem à esquerda e título no centro do topo
        topPanel.add(imagemLabel2, BorderLayout.WEST);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(Box.createVerticalStrut(20));
        topPanel.add(titleLabel);

        add(topPanel, BorderLayout.NORTH);

        // Carregar a imagem na janela
        ImageIcon icon = null;
        try {
            icon = new ImageIcon("/home/fernanda/logo.jpg");
            Image img = icon.getImage().getScaledInstance(100, 120, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem: " + e.getMessage());
            icon = new ImageIcon();
        }
        JLabel imagemLabel = new JLabel(icon);
        imagemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Painel de botões e busca
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Painel para todos os botões
        JPanel actionButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        actionButtonPanel.setBackground(Color.WHITE);

        // --- Painel da busca ---
        JPanel buscaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Alinha à esquerda
        buscaPanel.setBackground(Color.WHITE);
        
        // Adiciona o painel de busca antes dos outros botões
        buttonPanel.add(buscaPanel);

        JButton adicionarButton = createCustomButton("Adicionar");
        adicionarButton.addActionListener(new AdicionarListener());
        actionButtonPanel.add(adicionarButton);

        JButton listarButton = createCustomButton("Listar");
        listarButton.addActionListener(new ListarListener());
        actionButtonPanel.add(listarButton);

        JButton filtrarButton = createCustomButton("Filtrar");
        filtrarButton.addActionListener(new FiltrarListener());
        actionButtonPanel.add(filtrarButton);

        JButton exportarButton = createCustomButton("Exportar Dados");
        exportarButton.addActionListener(new ExportarListener());
        actionButtonPanel.add(exportarButton);

        JButton importarButton = createCustomButton("Importar Dados");
        importarButton.addActionListener(new ImportarListener());
        actionButtonPanel.add(importarButton);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 15));
        searchPanel.setBackground(Color.WHITE);

        //CRIA TEXTO AO LADO DA BARRA DE PESQUISA 
        JLabel buscaLabel = new JLabel("Busca por título:");    
        buscaField = new JTextField(30);

        // Adiciona o texto e o campo de busca no mesmo painel
        searchPanel.add(buscaLabel);
        searchPanel.add(buscaField);
        
        buttonPanel.add(actionButtonPanel);
        buttonPanel.add(Box.createVerticalStrut(10)); // Espaço entre botões de ação e busca
        buttonPanel.add(searchPanel);

        // Painel de formulário (esquerda) com imagem no topo
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(imagemLabel, gbc);
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Título:"), gbc);
        gbc.gridx = 1;
        tituloField = new JTextField(20);
        formPanel.add(tituloField, gbc);
        

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Descrição:"), gbc);
        gbc.gridx = 1;
        descricaoArea = new JTextArea(6, 30);
        descricaoArea.setLineWrap(true);
        descricaoArea.setWrapStyleWord(true);
        formPanel.add(new JScrollPane(descricaoArea), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Tipo:"), gbc);
        gbc.gridx = 1;
        tipoCombo = new JComboBox<>(new String[]{"Livro", "Filme"});
        formPanel.add(tipoCombo, gbc);

        specificPanel = new JPanel(new CardLayout());
        specificPanel.setBackground(Color.WHITE);

        JPanel livroPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        livroPanel.setBackground(Color.WHITE);
        livroPanel.add(new JLabel("Autor:"));
        autorField = new JTextField();
        livroPanel.add(autorField);
        livroPanel.add(new JLabel("Páginas:"));
        paginasField = new JTextField();
        livroPanel.add(paginasField);
        specificPanel.add(livroPanel, "Livro");

        JPanel filmePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        filmePanel.setBackground(Color.WHITE);
        filmePanel.add(new JLabel("Diretor:"));
        diretorField = new JTextField();
        filmePanel.add(diretorField);
        filmePanel.add(new JLabel("Duração (min):"));
        duracaoField = new JTextField();
        filmePanel.add(duracaoField);
        specificPanel.add(filmePanel, "Filme");

        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(new JLabel("Campos Específicos:"), gbc);
        gbc.gridx = 1;
        formPanel.add(specificPanel, gbc);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(buttonPanel, BorderLayout.NORTH);
        centerPanel.add(formPanel, BorderLayout.CENTER);
        centerPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
        add(centerPanel, BorderLayout.CENTER);

        resultadoArea = new JTextArea(20, 30); //definie o tamanho da area onde vai os 'resultados'
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        resultadoArea.setBorder(BorderFactory.createTitledBorder("Resultados"));
        add(new JScrollPane(resultadoArea), BorderLayout.EAST);

        tipoCombo.addActionListener(new TipoListener());

        showSpecificPanel("Livro");
    }

    private JButton createCustomButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(corPersonalizada);
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(150, 40)); // Aumente o tamanho aqui (width=150, height=40)
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(corHover);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(corPersonalizada);
            }
        });
        return button;
    }

    private void showSpecificPanel(String tipo) {
        CardLayout cl = (CardLayout) specificPanel.getLayout();
        cl.show(specificPanel, tipo);
        autorField.setText("");
        paginasField.setText("");
        diretorField.setText("");
        duracaoField.setText("");
    }

    private class TipoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            showSpecificPanel((String) tipoCombo.getSelectedItem());
        }
    }

    private class AdicionarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String titulo = tituloField.getText().trim();
                String descricao = descricaoArea.getText().trim();
                String tipo = (String) tipoCombo.getSelectedItem();

                if (titulo.isEmpty()) {
                    throw new IllegalArgumentException("O título não pode estar vazio.");
                }
                if (descricao.isEmpty()) {
                    throw new IllegalArgumentException("A descrição não pode estar vazia.");
                }

                Item item;
                if ("Livro".equals(tipo)) {
                    String autor = autorField.getText().trim();
                    String paginasStr = paginasField.getText().trim();
                    if (autor.isEmpty()) {
                        throw new IllegalArgumentException("O autor não pode estar vazio.");
                    }
                    if (paginasStr.isEmpty()) {
                        throw new IllegalArgumentException("O número de páginas não pode estar vazio.");
                    }
                    int paginas = Integer.parseInt(paginasStr);
                    if (paginas <= 0) {
                        throw new IllegalArgumentException("O número de páginas deve ser maior que zero.");
                    }
                    item = new Livro(titulo, descricao, autor, null, paginas);
                } else {
                    String diretor = diretorField.getText().trim();
                    String duracaoStr = duracaoField.getText().trim();
                    if (diretor.isEmpty()) {
                        throw new IllegalArgumentException("O diretor não pode estar vazio.");
                    }
                    if (duracaoStr.isEmpty()) {
                        throw new IllegalArgumentException("A duração não pode estar vazia.");
                    }
                    int duracao = Integer.parseInt(duracaoStr);
                    if (duracao <= 0) {
                        throw new IllegalArgumentException("A duração deve ser maior que zero.");
                    }
                    item = new Filme(titulo, descricao, diretor, null, duracao);
                }
                itens.add(item);
                limparCampos();
                JOptionPane.showMessageDialog(null, "Item adicionado com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Erro: Campos numéricos inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void limparCampos() {
        tituloField.setText("");
        descricaoArea.setText("");
        autorField.setText("");
        paginasField.setText("");
        diretorField.setText("");
        duracaoField.setText("");
    }

    private class ListarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            resultadoArea.setText("");
            if (itens.isEmpty()) {
                resultadoArea.setText("Nenhum item cadastrado.");
            } else {
                for (Item item : itens) {
                    resultadoArea.append(item.exibirDetalhes() + "\n\n");
                }
            }
        }
    }

    private class FiltrarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String busca = buscaField.getText().trim().toLowerCase();
            resultadoArea.setText("");
            if (busca.isEmpty()) {
                resultadoArea.setText("Por favor, insira um termo de busca.");
                return;
            }
            boolean encontrou = false;
            for (Item item : itens) {
                boolean match = item.getTitulo().toLowerCase().contains(busca) ||
                                item.getDescricao().toLowerCase().contains(busca);
                if (item instanceof Livro) {
                    Livro livro = (Livro) item;
                    match |= livro.getAutor().toLowerCase().contains(busca);
                } else if (item instanceof Filme) {
                    Filme filme = (Filme) item;
                    match |= filme.getDiretor().toLowerCase().contains(busca);
                }
                if (match) {
                    resultadoArea.append(item.exibirDetalhes() + "\n\n");
                    encontrou = true;
                }
            }
            if (!encontrou) {
                resultadoArea.setText("Nenhum item encontrado para: " + busca);
            }
        }
    }

    private class ExportarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Salvar Catálogo");
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (PrintWriter writer = new PrintWriter(file)) {
                    for (Item item : itens) {
                        String linha;
                        if (item instanceof Livro) {
                            Livro livro = (Livro) item;
                            linha = "Livro;" + livro.getTitulo() + ";" + livro.getDescricao() + ";" +
                                    livro.getAutor() + ";" + (livro.getDataCadastro() != null ? livro.getDataCadastro() : "") + ";" +
                                    livro.getNumeroPaginas();
                        } else if (item instanceof Filme) {
                            Filme filme = (Filme) item;
                            linha = "Filme;" + filme.getTitulo() + ";" + filme.getDescricao() + ";" +
                                    filme.getDiretor() + ";" + (filme.getDataCadastro() != null ? filme.getDataCadastro() : "") + ";" +
                                    filme.getDuracao();
                        } else {
                            continue;
                        }
                        writer.println(linha);
                    }
                    JOptionPane.showMessageDialog(null, "Dados exportados com sucesso!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao exportar dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private class ImportarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Importar Catálogo");
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    itens.clear();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        Item item = Item.fromLinhaArquivo(line);
                        if (item != null) {
                            itens.add(item);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Dados importados com sucesso!");
                    resultadoArea.setText("Dados importados. Clique em 'Listar' para visualizar.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao importar dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CatalogoGUI().setVisible(true));
    }
}