import javax.swing.*;
public class LoginAppGUI {
    public static void main(String[] args) {
        // Cria os campos de login e senha
        JTextField loginField = new JTextField();
        JPasswordField senhaField = new JPasswordField();

        Object[] message = {
            "Login:", loginField,
            "Senha:", senhaField
        };

        int option = JOptionPane.showConfirmDialog(
                null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String login = loginField.getText();
            String senha = new String(senhaField.getPassword());

            if (login.equals("Fernanda") && senha.equals("123")) {
                JOptionPane.showMessageDialog(null, "Bem-vindo!");
            } else {
                JOptionPane.showMessageDialog(null, "Senha ou login inválidos!");
            }
        }
    }
}
