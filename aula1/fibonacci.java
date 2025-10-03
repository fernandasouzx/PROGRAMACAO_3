class fibonacci{
    //F(n) = F(n-1) + F(n-2) para n > 1
    public static int fibonacci(int n){
        return n < 2 ? n : fibonacci(n - 2) + fibonacci(n - 1);
    }
    public static void main(String[] args) {
        for (int i = 0; i <= 30; i++) {
            System.out.println("Fibonacci(" + i + ") = " + fibonacci(i));
        }
    }
}