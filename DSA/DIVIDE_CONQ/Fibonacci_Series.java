package DSA.DIVIDE_CONQ;

public class Fibonacci_Series {
    public static int fibonacci(int n){
        if(n<=1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }
}
