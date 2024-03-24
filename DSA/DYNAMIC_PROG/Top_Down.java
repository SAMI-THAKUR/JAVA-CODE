package DSA.DYNAMIC_PROG;

import java.util.*;

// In Top Down we solve sub problems later //


public class Top_Down {
    public static int Fibonacci(int n , HashMap<Integer, Integer> memory){
        if(n==1) return 0;
        if(n==2) return 1;
        if(!memory.containsKey(n)){
            memory.put(n , Fibonacci(n-1 , memory) + Fibonacci(n-2, memory));
        }

        return memory.get(n);

    }
    public static void main(String[] args) {
        HashMap<Integer , Integer> memo = new HashMap<Integer, Integer>();
        System.out.println(Fibonacci(6,memo));
        List<Integer> a = new ArrayList<>();
        Collections.sort(a);

    }
}
