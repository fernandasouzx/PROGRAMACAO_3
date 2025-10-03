package exemplos_da_aula;
import java.util.ArrayList;
import java.util.Iterator;

public class Listas {
    public static void main(String[] args) {
        //criando uma lista de contas
        ArrayList <Conta> lista = new ArrayList<>();
        
        // cria um objeto novo
        Conta c = new Conta();
        c.numero = 2;
        lista.add(c);
        c.numero = 1;
        lista.add(0,c); // adiciona na lista o conteudo de c
        
        Iterator i = lista.iterator();
        while(i.hasNext()){
            c=(Conta)i.next();
            System.out.println("Conta Numero: "+c.numero);
        }
    }
}
