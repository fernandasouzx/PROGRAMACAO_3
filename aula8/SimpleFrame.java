/** Crie uma janela (JFrame) com: Um título personalizado. Um JLabel exibindo uma
 * mensagem de boas-vindas. Um JButton com texto “Fechar”. Quando o botão for
 * clicado, a janela deve se fechar.
**/
import java.awt.*;
import javax.swing.*;

public class SimpleFrame extends JFrame {
    public SimpleFrame() {
        setTitle("Minha Janela - Fernanda");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Fundo rosa clarinho
        getContentPane().setBackground(new Color(255, 182, 193)); // rosa claro (RGB)

        // Usa GridBagLayout para centralizar tudo
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;

        // Imagem
        ImageIcon icon = new ImageIcon("/home/fernanda/imagem.png"); // <-- mude o caminho
        Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);

        JLabel imageLabel = new JLabel(icon);
        gbc.gridy = 0;
        add(imageLabel, gbc);

        // Texto de boas-vindas
        JLabel label = new JLabel("Bem-vindo a minha Aplicação!");
        label.setFont(new Font("Chetta Vissto", Font.BOLD, 20));
        label.setForeground(Color.WHITE); // texto branco
        gbc.gridy = 1;
        add(label, gbc);

        // Botão Fechar
        JButton closeButton = new JButton("Fechar");
        closeButton.setBackground(new Color(255, 105, 180)); // define a cor do botao
        closeButton.setFocusPainted(false);
        closeButton.setFont(new Font("Chetta Vissto", Font.BOLD, 14));
        closeButton.addActionListener(e -> System.exit(0));
        gbc.gridy = 2;
        add(closeButton, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleFrame().setVisible(true));
    }
}
