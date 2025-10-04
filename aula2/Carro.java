/*Crie uma classe chamada Carro com os seguintes atributos: marca (String),
modelo (String), ano (int). Adicione um método exibirInfo() que imprime as
informações do carro. No método main, crie duas instâncias de Carro e chame o
método exibirInfo() para cada uma.
*/
public class Carro {
    //atributos
        String marca;
        String modelo;                                
        int ano;

        //métodos
        void exibirInfo(){
            System.out.println("Marca: " + this.marca);
            System.out.println("Modelo: " + this.modelo);
            System.out.println("Ano: " + this.ano);
            System.out.println("----------------------");
        } 
    public static void main(String[] args) {
        Carro carro1 = new Carro();
        carro1.marca = "Toyota";
        carro1.modelo = "Hillux";
        carro1.ano = 2026;

        Carro carro2 = new Carro();
        carro2.marca = "Honda";
        carro2.modelo = "Civic";
        carro2.ano = 2016;

        carro1.exibirInfo();
        carro2.exibirInfo();             
    }
}
