package DSA.DYNAMIC_PROG;

// In Bottom Up approach we solve sub problems first //
// we save the base cases in the dp array //

import java.util.ArrayList;

public class Bottom_Up {
    public static int Fib(int n){
        ArrayList<Integer> tb = new ArrayList<>();
        tb.add(0);
        tb.add(1);
        for(int i=2 ; i<=n-1 ; i++){
            int n1 = tb.get(i-1);
            int n2 = tb.get(i-2);
            tb.add(n2+n1);
        }
        return tb.get(n-1);
    }
    public static void main(String[] args) {
        System.out.println(Fib(6));


    }
}
