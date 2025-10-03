public class Conta { //definição da CLASSE CONTA
    //atributos
    public int numero; 
    public String nome_titular;
    public double saldo;
    public double saque_feito;
    //os atributois representam o estado de cada objeto criado a partir da classe
   
    //método depositar recebe um valor e adiciona ao saldo
    void depositar(double valor){
        this.saldo = this.saldo + valor; 
        /*O this.saldo se refere ao saldo do objeto atual.
        * O parâmetro valor é o montante que será depositado.
        */
        //this serve para referenciar o proprio objeto
    }
    boolean sacar(double valor){
        if(this.saldo >= valor){
        this.saldo = this.saldo - valor;  // desconta do saldo
        return true;          // saque feito com sucesso
        } else {
        return false;         // não tinha saldo suficiente
    }
    }
    public static void main(String[] args) {
        Conta contafulaninho = new Conta();
        contafulaninho.numero = 12345;
        contafulaninho.nome_titular = "Fulaninho";
        contafulaninho.saldo = 2000.00;

        System.out.println ("Conta de " + contafulaninho.nome_titular);
        System.out.printf("Saldo antes do deposito: %.2f%n" , contafulaninho.saldo);
        
        contafulaninho.depositar(100) ;

        System.out.printf("\nSaldo atual: %.2f%n", contafulaninho.saldo);

        boolean saque_feito = contafulaninho.sacar(100);
        if(saque_feito){
            System.out.printf("\nSaque efetuado com sucesso! Saldo atual: %.2f%n", contafulaninho.saldo);
        }else{
            System.out.printf("\nSaque nao efetuado! Saldo insuficiente! Saldo atual: %.2f%n", contafulaninho.saldo);
        }
    }
}

