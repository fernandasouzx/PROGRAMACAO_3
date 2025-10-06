import java.util.Scanner;
public class User {
    public static void main(String[] args) {
        System.out.println("Insira um numero inteiro: ");
        Scanner teclado = new Scanner(System.in);
        String num = teclado.nextLine();

        int num_conv = 0; // declaração fora do try
        try {
            num_conv = Integer.parseInt(num);
            System.out.println("Numero convertido para inteiro: " + num_conv);
        } catch (NumberFormatException e) {
            System.out.println("Formato de texto inválido para converter em número inteiro.");
        }finally{
            System.out.println("String convertida: " + num_conv);
        }
        teclado.close();
    }
}
