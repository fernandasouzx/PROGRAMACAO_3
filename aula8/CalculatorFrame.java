import java.awt.*;
import java.io.File;
import javax.swing.*;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        // Configurações da janela
        setTitle("Calculadora - Fernanda");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Fundo rosa claro
        getContentPane().setBackground(new Color(255, 182, 193));

        // Layout centralizado
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Fonte personalizada
        Font customFont = new Font("SansSerif", Font.BOLD, 14);
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("/home/fernanda/ChettaVissto.ttf")).deriveFont(18f);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(customFont);
        } catch (Exception e) {
            System.out.println("Fonte personalizada não encontrada, usando padrão.");
        }

        //Imagem decorativa
        ImageIcon icon = new ImageIcon("/home/fernanda/imagem.png"); // ajuste o caminho
        Image img = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        JLabel imageLabel = new JLabel(icon);
        gbc.gridy = 0;
        add(imageLabel, gbc);

        //Título
        JLabel titleLabel = new JLabel("Calculadora");
        titleLabel.setFont(customFont);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 1;
        add(titleLabel, gbc);

        //Painel com os campos
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setOpaque(false); // mantém o fundo rosa

        JLabel num1Label = new JLabel("Número 1:");
        JTextField num1Field = new JTextField();
        JLabel num2Label = new JLabel("Número 2:");
        JTextField num2Field = new JTextField();
        JLabel operationLabel = new JLabel("Operação:");
        JComboBox<String> operationCombo = new JComboBox<>(new String[]{"Somar", "Subtrair", "Multiplicar", "Dividir"});
        JCheckBox showDialogCheck = new JCheckBox("Mostrar em janela");
        showDialogCheck.setOpaque(false);
        JLabel resultLabel = new JLabel("Resultado:");
        JLabel resultValue = new JLabel("");

        // Aplica fonte e cor aos rótulos
        for (JLabel label : new JLabel[]{num1Label, num2Label, operationLabel, resultLabel}) {
            label.setFont(customFont.deriveFont(14f));
            label.setForeground(Color.WHITE);
        }
        resultValue.setFont(customFont.deriveFont(14f));
        resultValue.setForeground(Color.WHITE);

        // Adiciona componentes ao painel
        panel.add(num1Label);
        panel.add(num1Field);
        panel.add(num2Label);
        panel.add(num2Field);
        panel.add(operationLabel);
        panel.add(operationCombo);
        panel.add(showDialogCheck);
        panel.add(new JLabel());
        panel.add(resultLabel);
        panel.add(resultValue);

        gbc.gridy = 2;
        add(panel, gbc);

        //Botão calcular
        JButton calculateButton = new JButton("Calcular");
        calculateButton.setFont(customFont.deriveFont(16f));
        calculateButton.setBackground(new Color(255, 105, 180)); // rosa forte
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFocusPainted(false);
        calculateButton.setPreferredSize(new Dimension(120, 35));

        calculateButton.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                String operation = (String) operationCombo.getSelectedItem();
                double result = switch (operation) {
                    case "Somar" -> num1 + num2;
                    case "Subtrair" -> num1 - num2;
                    case "Multiplicar" -> num1 * num2;
                    case "Dividir" -> {
                        if (num2 == 0) throw new ArithmeticException("Divisão por zero!");
                        yield num1 / num2;
                    }
                    default -> 0;
                };

                String resultText = String.format("%.2f", result);
                if (showDialogCheck.isSelected()) {
                    JOptionPane.showMessageDialog(this,
                            "Resultado: " + resultText,
                            "Cálculo",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    resultValue.setText(resultText);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, insira números válidos!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        gbc.gridy = 3;
        add(calculateButton, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorFrame().setVisible(true));
    }
}
