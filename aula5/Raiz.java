/** Implemente um programa que contenha: Um método calcularRaiz(int numero) que
 * lance uma exceção (IllegalArgumentException) caso o número seja negativo. A cláusula
 * throws na assinatura do método para indicar a possibilidade da exceção. No método
 * main, capture a exceção com try-catch e mostre uma mensagem adequada ao usuário 
 */
public class Raiz {
    public void calcularRaiz(int numero){
        try {
           if(numero < 0){
           throw new IllegalArgumentException ("Nao ha raiz quadradade valores negativos.");
           } 
            int raiz = (int) Math.sqrt(numero);
            System.out.println("Raiz quadrada é: "+raiz);
        } catch (IllegalArgumentException e ) {
            System.err.println("ERRO! nao ha raiz quadrada de numero negativo");
        }
    }
    public static void main(String[] args) {
        Raiz raiz = new Raiz();
        raiz.calcularRaiz(-25);
    }
}
