import java.awt.*;
import java.io.File;
import javax.swing.*;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        // Configurações da janela
        setTitle("Tela de Login - Fernanda");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 182, 193)); // Rosa claro 
        
        // Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Fonte personalizada
        Font customFont = new Font("SansSerif", Font.BOLD, 14);
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("/home/fernanda/BeautifulBloom.ttf")).deriveFont(18f);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(customFont);
        } catch (Exception e) {
            System.out.println("Fonte personalizada não encontrada, usando padrão.");
        }

        //Imagem (opcional)
        ImageIcon icon = new ImageIcon("/home/fernanda/imagem.png"); // ajuste o caminho
        Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        JLabel imageLabel = new JLabel(icon);
        gbc.gridy = 0;
        add(imageLabel, gbc);

        //Título
        JLabel titleLabel = new JLabel("Bem-vinda!");
        titleLabel.setFont(customFont);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 1;
        add(titleLabel, gbc);

        //Painel de login (campos)
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setOpaque(false); // mantém o fundo rosa visível

        JLabel userLabel = new JLabel("Usuário:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Senha:");
        JPasswordField passField = new JPasswordField();

        userLabel.setFont(customFont.deriveFont(14f));
        passLabel.setFont(customFont.deriveFont(14f));

        formPanel.add(userLabel);
        formPanel.add(userField);
        formPanel.add(passLabel);
        formPanel.add(passField);

        gbc.gridy = 2;
        add(formPanel, gbc);

        //Botão de login
        JButton loginButton = new JButton("Entrar");
        loginButton.setFont(customFont.deriveFont(14f));
        loginButton.setBackground(new Color(255, 105, 180)); // rosa forte
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(e -> {
            String username = userField.getText().trim();
            if (username.isEmpty()) {
                username = "Usuário";
            }
            JOptionPane.showMessageDialog(this, 
                "Bem-vindo(a), " + username + "!",
                "Login", 
                JOptionPane.INFORMATION_MESSAGE);
        });

        gbc.gridy = 3;
        add(loginButton, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
        });
    }
}
