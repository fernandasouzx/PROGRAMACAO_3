
/*Crie uma classe Contador que possui: Um atributo estático totalObjetos para 
* contar quantos objetos foram criados; Um construtor que incremente esse 
* contador sempre que um novo objeto for instanciado; Um método estático 
* mostrarTotal() que exibe o total de objetos criados. No main, crie alguns objetos e 
* depois exiba o total utilizando o método estático. */

public class Contador {
    static int totalObjetos; //atributo estatico

    public Contador(){ // construtor
        totalObjetos ++;
    }
    static void mostrarTotal(){ // metodo estatico
        System.out.println("Total de Objetos: " + totalObjetos);
    }
     public static void main(String[] args) {
        Contador cont = new Contador(); //criação de objetos
        Contador cont1 = new Contador();
        Contador.mostrarTotal();
    }
}
