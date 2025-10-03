/*
 Programa que solicita ao usuário a digitação de números inteiros
 maiores ou iguais a zero em um laço de repetição.

 A entrada de números continua até que o usuário digite um valor negativo,
 que serve como condição de parada.

 Ao final, o programa exibe:
  - a quantidade de números válidos digitados;
  - a média aritmética desses números.
*/

import java.util.Scanner;
public class NumMaiorQueZero{
    public static void main(String[] args) {
        int contador = 0, numero;
        double soma = 0, media = 0;
        
        //laço para entrada de valores, se positivo continua, se negativo laço termina
        for(numero = 0; numero >= numero ; numero++){
            System.out.print("Insira um valor: ");
            Scanner teclado = new Scanner(System.in);
            numero = (int)teclado.nextInt();
            //se valor for positivo faz a contagem, soma e media desses valores
            if(numero >= 0){
                contador += 1;
                soma += numero;
                media = soma/contador;
            }else{ // se numero for negativo o laço termina e printa a media e total de valores digitaf=dos
                System.out.println("Media: " + media);
                System.out.println("Total de valores digitados: " + contador);
            }
        }
    }
}