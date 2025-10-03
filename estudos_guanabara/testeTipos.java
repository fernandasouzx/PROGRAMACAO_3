public class testeTipos{
    public static void main(String[] args){
        //conversão de tipos de inteiro para string
        int idade = 30;
        String valor = Integer.toString(idade);
        System.out.println(valor);
        
         //conversão de tipos de string para inteiro
        String valor2 = "30";
        int idade2 = Integer.parseInt(valor2);
        System.out.println(idade2);
        
        //conversão de tipos de string para float
        String valor3 = "30.5";
        float idade3 = Float.parseFloat(valor3);
        System.out.printf("%.3f%n",idade3);

    }
}