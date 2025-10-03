public class ComparandoStrings{
    public static void main(String[] args) { 
        String nome1 = "Fernanda"; //String é uma classe
        String nome2 = "Fernanda";
        String nome3 = new String ("Fernanda");
        String resultado;

        //resultado = (nome1 == nome2) ? "igual":"diferente";
        resultado = (nome1.equals(nome3))? "igual":"diferente";
        System.out.println(resultado);
    }
}
