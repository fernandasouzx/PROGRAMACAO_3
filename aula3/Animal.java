/**
 * Crie uma classe Animal com um método emitirSom(). Crie duas
 * subclasses: Cachorro e Gato. Sobrescreva o método emitirSom() para
 * imprimir sons diferentes. No main, crie um array de Animal contendo um
 * Cachorro e um Gato, e percorra chamando emitirSom() para cada um.
 */
import java.util.ArrayList;
public class Animal {
    //metodo
    public void emitirSom(){
        //this.som = som;
        System.out.println("Som do animal:" );
    }
    //subclasse cachorro
    public static class Cachorro extends Animal{
        @Override
        public void emitirSom( ){ //sobreescrita
            System.out.println("Au au");
        }
    }
    //subclasse gato
    public static class Gato extends Animal{
        @Override
        public void emitirSom(){ //sobreescrita
            System.out.println("Miau");
        }
    }
    public static void main(String[] args) {
        ArrayList <Animal> animal = new ArrayList<>(); // define o array

        // adicionbando os objetos no array
        animal.add(new Cachorro()); 
        animal.add(new Cachorro());
        animal.add(new Cachorro());
        animal.add(new Gato());
        animal.add(new Gato());
        animal.add(new Gato());

        for (Animal a : animal) {
            a.emitirSom();
        }
    }
}
