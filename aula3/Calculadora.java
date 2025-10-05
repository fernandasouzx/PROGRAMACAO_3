/** Crie uma classe Calculadora com métodos somar() sobrecarregados
para: dois inteiros, dois doubles, três inteiros. No main, teste cada versão
do método e exiba os resultados.
 **/
public class Calculadora {
    //soma de dois inteiros
    public void somar(int n1, int n2){
        int soma;
        soma = n1+n2;
        System.out.println("Soma de dois inteiros: " + soma);
    }
    //soma de dois doubles
    public void somar(double n1, double n2){
        double soma;
        soma = n1+n2;
        System.out.println("Soma de dois pontos flutuantes: " + soma);
    }
    //soma de tres inteiros
    public void somar(int n1, int n2, int n3){
        int soma;
        soma = n1+n2+n3;
        System.out.println("Soma de tres inteiros: " + soma);
    }
    public static void main(String[] args) {
        Calculadora cal = new Calculadora();
        cal.somar(1,1);
        cal.somar(1.0,2.5);
        cal.somar(3,1,1);
    }
}
