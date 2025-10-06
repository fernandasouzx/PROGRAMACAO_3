/** . Crie um enum chamado NivelAcesso com os valores BASICO, INTERMEDIARIO e ADMIN.
 * Em seguida, crie uma classe Usuario que possua: nome, nível de acesso (do tip
 * NivelAcesso). No programa principal, crie três usuários com diferentes níveis de
 * acesso e exiba mensagens personalizadas com base no nível
 */
enum NivelAcesso {
    BASICO,
    INTERMEDIARIO,
    ADMIN
}

// Classe Usuario com nome e nível de acesso
class Usuario {
    private String nome;
    private NivelAcesso nivel;

    // Construtor
    public Usuario(String nome, NivelAcesso nivel) {
        this.nome = nome;
        this.nivel = nivel;
    }

    // Exibe mensagem personalizada de acordo com o nível
    public void exibirMensagem() {
        switch (nivel) {
            case BASICO:
                System.out.println(nome + " possui acesso BÁSICO. Bem-vindo!");
                break;
            case INTERMEDIARIO:
                System.out.println(nome + " possui acesso INTERMEDIÁRIO. Continue evoluindo!");
                break;
            case ADMIN:
                System.out.println(nome + " possui acesso ADMIN. Acesso total concedido!");
                break;
        }
    }
}

// Classe principal com o método main
public class Main {
    public static void main(String[] args) {
        // Criação de três usuários com níveis diferentes
        Usuario u1 = new Usuario("Ana", NivelAcesso.BASICO);
        Usuario u2 = new Usuario("Bruno", NivelAcesso.INTERMEDIARIO);
        Usuario u3 = new Usuario("Carla", NivelAcesso.ADMIN);

        // Exibição das mensagens personalizadas
        u1.exibirMensagem();
        u2.exibirMensagem();
        u3.exibirMensagem();
    }
}
