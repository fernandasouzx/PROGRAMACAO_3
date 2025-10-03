/*
 Programa que armazena em um vetor as notas de 10 alunos.
 
 O programa realiza as seguintes operações:
   - Lê e guarda as 10 notas digitadas pelo usuário;
   - Calcula a média aritmética dessas notas;
   - Exibe a média calculada;
   - Conta e informa quantas notas ficaram acima da média;
   - Conta e informa quantas notas ficaram abaixo da média.
*/
public class vet10notas {
    public static void main(String[] args) {
        double soma = 0;
        double [] vet = {3.3, 4, 5, 8, 9, 9 ,10, 5.5, 8.9, 7.5};
        for(int i = 0; i < vet.length; i++){
            soma += vet[i];
        }
        double media = soma/10;
        System.out.printf("Média: %.2f%n",media);

        int acima = 0;
        int abaixo = 0;

        for(int i=0; i < vet.length; i++){
            if(vet[i] > media){
                acima = acima + 1;
            }
            if(vet[i]<media){
                abaixo = abaixo + 1;
            }
        }
        System.out.println("A quantidade com valores acima da media sao: " + acima);
        System.out.println("A quantidade com valores acima da media sao: " + abaixo);
    }
}
