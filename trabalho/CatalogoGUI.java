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
    private List<Item> itens = new ArrayList<>();
    private JTextField tituloField;
    private JTextArea descricaoArea;
    private JComboBox<String> tipoCombo;
    private JPanel specificPanel;
    private JTextField autorField, paginasField;
    private JTextField diretorField, duracaoField;
    private JTextArea resultadoArea;
    private JTextField buscaField;
    private Color corPersonalizada = new Color(0x64, 0x64, 0x86);
    private Color corHover = new Color(0x7D, 0x7D, 0xA0);

    public CatalogoGUI() {
        setTitle("Catálogo de Livros e Filmes");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(0xF0, 0xF0, 0xF5));

        // --- PAINEL SUPERIOR (CABEÇALHO) ---
        JPanel topPanel = new JPanel(new BorderLayout(20, 0));
        topPanel.setBackground(corPersonalizada);
        topPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        JLabel titleLabel = new JLabel("Catálogo de Livros e Filmes");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        // --- PAINEL DE CONTROLES (BOTÕES E BUSCA) ---
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setBackground(Color.WHITE);
        controlPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Painel para os botões de ação
        JPanel actionButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        actionButtonPanel.setBackground(Color.WHITE);

        actionButtonPanel.add(createCustomButton("Adicionar"));
        actionButtonPanel.add(createCustomButton("Listar"));
        actionButtonPanel.add(createCustomButton("Exportar Dados"));
        actionButtonPanel.add(createCustomButton("Importar Dados"));

        // --- PAINEL DE BUSCA COM FILTRO AO LADO ---
        JPanel searchAndFilterPanel = new JPanel(new BorderLayout(5, 0)); // BorderLayout para alinhar
        searchAndFilterPanel.setBackground(Color.WHITE);
        searchAndFilterPanel.setBorder(BorderFactory.createTitledBorder("Busca por Título, Autor ou Diretor"));

        buscaField = new JTextField();
        buscaField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchAndFilterPanel.add(buscaField, BorderLayout.CENTER); // Campo de busca ocupa o centro

        // ### ALTERAÇÃO AQUI: Botão de filtrar com texto ###
        JButton filtrarButton = new JButton("Filtrar");
        filtrarButton.setToolTipText("Filtrar resultados");
        filtrarButton.setBackground(corPersonalizada);
        filtrarButton.setForeground(Color.WHITE);
        filtrarButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        filtrarButton.setOpaque(true);
        filtrarButton.setBorderPainted(false);
        filtrarButton.addActionListener(new FiltrarListener());
        filtrarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                filtrarButton.setBackground(corHover);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                filtrarButton.setBackground(corPersonalizada);
            }
        });
        
        searchAndFilterPanel.add(filtrarButton, BorderLayout.EAST); // Botão fica à direita

        controlPanel.add(actionButtonPanel);
        controlPanel.add(Box.createVerticalStrut(15));
        controlPanel.add(searchAndFilterPanel);

        // --- PAINEL DE FORMULÁRIO (ESQUERDA) ---
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Bordas para espaçamento interno
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ### ALTERAÇÃO AQUI: Adicionando imagem e título centralizado ao formulário ###
        // 1. Carregar a imagem para o formulário
        ImageIcon formIcon = new ImageIcon("/home/fernanda/logo.jpg"); // <-- **ATENÇÃO:** Coloque o caminho da imagem que quer no formulário
        Image formImg = formIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JLabel imagemLabelForm = new JLabel(new ImageIcon(formImg));
        
        // 2. Criar o label do título
        JLabel formTitleLabel = new JLabel("Adicionar Novo Item");
        formTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        formTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // 3. Adicionar a imagem no topo (linha 0)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa duas colunas
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        formPanel.add(imagemLabelForm, gbc);
        
        // 4. Adicionar o título abaixo da imagem (linha 1)
        gbc.gridy = 1;
        formPanel.add(formTitleLabel, gbc);

        // 5. Resetar gbc e adicionar os outros campos a partir da linha 2
        gbc.gridwidth = 1; // Volta a ocupar uma coluna
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 2; gbc.gridx = 0; formPanel.add(new JLabel("Título:"), gbc);
        gbc.gridx = 1; tituloField = new JTextField(20); formPanel.add(tituloField, gbc);
        
        gbc.gridy = 3; gbc.gridx = 0; formPanel.add(new JLabel("Descrição:"), gbc);
        gbc.gridx = 1; gbc.ipady = 40; // Aumenta a altura da área de descrição
        descricaoArea = new JTextArea(4, 20);
        descricaoArea.setLineWrap(true);
        descricaoArea.setWrapStyleWord(true);
        formPanel.add(new JScrollPane(descricaoArea), gbc);
        gbc.ipady = 0; // Reseta a altura

        gbc.gridy = 4; gbc.gridx = 0; formPanel.add(new JLabel("Tipo:"), gbc);
        gbc.gridx = 1; tipoCombo = new JComboBox<>(new String[]{"Livro", "Filme"}); formPanel.add(tipoCombo, gbc);

        specificPanel = new JPanel(new CardLayout());
        specificPanel.setBackground(Color.WHITE);

        JPanel livroPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        livroPanel.setBackground(Color.WHITE);
        livroPanel.add(new JLabel("Autor:"));
        autorField = new JTextField();
        livroPanel.add(autorField);
        livroPanel.add(new JLabel("Páginas:"));
        paginasField = new JTextField();
        livroPanel.add(paginasField);
        specificPanel.add(livroPanel, "Livro");

        JPanel filmePanel = new JPanel(new GridLayout(2, 2, 5, 5));
        filmePanel.setBackground(Color.WHITE);
        filmePanel.add(new JLabel("Diretor:"));
        diretorField = new JTextField();
        filmePanel.add(diretorField);
        filmePanel.add(new JLabel("Duração (min):"));
        duracaoField = new JTextField();
        filmePanel.add(duracaoField);
        specificPanel.add(filmePanel, "Filme");

        gbc.gridy = 5; gbc.gridx = 0; gbc.gridwidth = 2; formPanel.add(specificPanel, gbc);
        // ### FIM DAS ALTERAÇÕES NO FORMULÁRIO ###

        // Painel central que une formulário e controles
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.add(controlPanel, BorderLayout.NORTH);
        centerPanel.add(formPanel, BorderLayout.CENTER);
        centerPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
        add(centerPanel, BorderLayout.CENTER);

        // Área de resultados (direita)
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        resultadoArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        JScrollPane scrollResultados = new JScrollPane(resultadoArea);
        scrollResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));
        scrollResultados.setPreferredSize(new Dimension(350, 0));
        add(scrollResultados, BorderLayout.EAST);

        // Adicionando ActionListeners aos botões
        for (Component comp : actionButtonPanel.getComponents()) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                String text = button.getText();
                switch (text) {
                    case "Adicionar":
                        button.addActionListener(new AdicionarListener());
                        break;
                    case "Listar":
                        button.addActionListener(new ListarListener());
                        break;
                    case "Exportar Dados":
                        button.addActionListener(new ExportarListener());
                        break;
                    case "Importar Dados":
                        button.addActionListener(new ImportarListener());
                        break;
                }
            }
        }

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
        button.setPreferredSize(new Dimension(160, 40));
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
        if ("Livro".equals(tipo)) {
            diretorField.setText("");
            duracaoField.setText("");
        } else {
            autorField.setText("");
            paginasField.setText("");
        }
    }

    // [ O restante do seu código (classes Listener, limparCampos, main) continua aqui, sem alterações ]
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
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new CatalogoGUI().setVisible(true));
    }
}