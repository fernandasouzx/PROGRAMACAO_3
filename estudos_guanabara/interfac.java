import java.io.Console;
public class interfac{
    public static void main(String[]args) throws Exception{
        Console console = System.console();
        String login = console.readLine("Digite o login: ");
        char [] senhachar = console.readPassword("Digite a senha: ");

        String senha = new String(senhachar);

        if(login.equals("Fernanda")&& senha.equals("123")){
            System.out.println("Bem-vindo!");
        }else{
            System.out.println("Senha ou login invalidos!");
        }
    }
}