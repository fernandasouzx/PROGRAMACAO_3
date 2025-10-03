package exemplos_da_aula;
public class String_exemplo {
    public static void main(String[] args) {
        String frase1 = " Muito a aprender ";
        String frase2 = " Voce ainda tem ";
        String completa = frase2+ frase1;
        System.out.println(completa + "!");
        System.out.println("O caractere da pos 4 na frase 1 é:" + frase1.charAt(4));
        System.out.println("Todos os caracteres agora maiusculas da frase 2 é: " + frase2.toUpperCase());
        System.out.println("Todos os caracteres agora minusculas da frase 1 é: " + frase1.toLowerCase());
        System.out.println("A frase completa sem espaços antes e depois da frase completa: " + completa.trim());
        System.out.println("O tamanho da frase completa: " + completa.length());
        System.out.println("Substring de 2 a 8: " + completa.subSequence(2,8));
        System.out.println("Susbstituindo aprender por praticar na frase completa: " + completa.replace("aprender", "praticar"));
    }
}
