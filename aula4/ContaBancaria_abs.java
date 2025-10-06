/** Crie uma classe abstrata chamada ContaBancaria com os seguintes métodos: public
 * abstract boolean sacar(double valor); public abstract void depositar(double valor);
 * Depois, crie duas subclasses concretas: ContaCorrente (com taxa de saque de R$
 * 1,00), ContaPoupanca (sem taxa de saque) Implemente os métodos abstratos e faça
 * um programa principal para testar as operações de saque e depósito. 
 **/

public abstract class ContaBancaria_abs{
    protected double saldo;

    public abstract  boolean sacar(double valor);
    public abstract void depositar(double valor);

    public double getSaldo(){
        return saldo;
    }
}

// herança - conta corrente herda de conta bancaria
class ContaCorrente extends ContaBancaria_abs{
    @Override

    public boolean sacar(double valor){
        double total = valor + 1.0;
        if(saldo >= total){
            saldo -= total;
            return true;
        }else{
            return false;
        }
        
    }
    @Override
    public void depositar(double valor) {
        saldo += valor;
    }
}
    // herança - conta poupanca herda de conta bancaria
class ContaPoupanca extends ContaBancaria_abs{
    @Override
    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }
}

class Principal{
    public static void main(String[] args) {
        ContaBancaria_abs corrente = new ContaCorrente();
        ContaBancaria_abs poupanca = new ContaPoupanca();

        corrente.depositar(200);
        poupanca.depositar(150);

        System.out.println("Saldo inicial Corrente: " + corrente.getSaldo());
        System.out.println("Saldo inicial Poupança: " + poupanca.getSaldo());

        corrente.sacar(50); // desconta 50 + 1
        poupanca.sacar(50); // desconta 50

        System.out.println("Saldo após saque Corrente: " + corrente.getSaldo());
        System.out.println("Saldo após saque Poupança: " + poupanca.getSaldo());
    }
}
