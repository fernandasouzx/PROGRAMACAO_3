/** Escreva um programa que leia dois números inteiros e divida o primeiro pelo segundo.
 * Use try-catch para tratar ArithmeticException (divisão por zero). Exiba uma mensagem
 * amigável caso ocorra erro.
 */
public class Soma {
    int n1, n2, soma;
    public void soma (){
        try {
            this.soma = this.n1/this.n2;
            System.err.println("O resultado da soma é: " + soma);
        } catch (Exception n2) {
            System.err.println("ERRO! divisão por 0");
        }
    }
    public static void main(String[] args) {
       Soma s = new Soma();
       s.n1 = 5;
       s.n2 = 0; 
       s.soma();
    }
}
