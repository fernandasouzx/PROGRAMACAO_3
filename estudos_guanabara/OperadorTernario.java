import java.util.Scanner;
public class OperadorTernario {
    //printa na tela se n1 for maior que n2 entao o resultado é 0, se for o contrario printa 1
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Insira um valor: ");
        int n1 = teclado.nextInt();
        System.out.print("Insira o segundo valor: ");
        int n2 = teclado.nextInt();
        int r;
        r = (n1>n2)?0:1;
        System.out.println(r);
        
        int n3= 14;
        int n4 = 18;
        int r1= (n3>n4)?n3+n4:n3-n4;
        System.out.println(r1);
    }
}
