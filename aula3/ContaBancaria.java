/** Crie uma classe ContaBancaria com o atributo numero. Sobrescreva os
métodos toString() e equals(): Teste no main: Crie duas contas com
números iguais e compare com equals(). Imprima um objeto diretamente
para verificar o funcionamento do toString().
*/

public class ContaBancaria{
    int numero;

    //construtor para inicializar 'numero'
    public ContaBancaria(int numero) {
        this.numero = numero;
    } 
    //sobreescrita
    @Override
    public String toString(){
        return "Conta número: " + numero;
    }
    //sobreescrita
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ContaBancaria outra = (ContaBancaria) obj;
        return this.numero == outra.numero;
    }
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria(1234);
        ContaBancaria conta2= new ContaBancaria(1234);
        ContaBancaria conta3 = new ContaBancaria(9999);

        // Testando equals()
        System.out.println(conta1.equals(conta2)); // true (mesmo número)
        System.out.println(conta1.equals(conta3)); // false (número diferente)

        // Testando toString()
        System.out.println(conta1); // imprime: Conta número: 1234
        }
}
