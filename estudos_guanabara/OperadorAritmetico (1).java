import java.util.Scanner;
public class OperadorAritmetico {
    public static void main(String[] args) {
        System.out.print("Coloque um valor para arredondar: \n");
        Scanner teclado = new Scanner(System.in);
        float valor = teclado.nextFloat();
        valor = (float) Math.round (valor);
        System.out.print("Valor arredondado ficou " + valor);

        System.out.println("---------------------------");

        System.out.print("Coloque um valor para calcular a raiz quadrada: \n");
        int epx = teclado.nextInt();
        int raiz = (int) Math.sqrt(epx);       
        System.out.println("A raiz quadrada de "+epx+" e "+raiz);
    }
}