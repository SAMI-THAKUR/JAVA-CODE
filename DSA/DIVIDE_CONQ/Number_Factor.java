package DSA.DIVIDE_CONQ;

import java.util.*;


/*
*  Number Factor Problem
* Given N , count the number of ways to express N as sum of a bunch of values
* for example N=5
* values = {1,3,4}
* output = 6
* 1+1+1+1+1
* 1+4 , 4+1
* 1+1+3 , 1+3+1 , 3+1+1
* */
class N_Factor{
    int  [] values = new int[3];
    N_Factor(int [] values){
        this.values = values;
        Arrays.sort(values);
    }
    public int ways(int n){
        if(n<values[1]){
            return 1;
        }
        if(n==values[1]){
            return 2;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int v : values){
            int m = n-v;
            list.add(ways(m));
        }
        int s = 0;
        for(int i : list){
            s+=i;
        }
        return s;
    }
}


public class Number_Factor {
    public static void main(String[] args) {
        int [] values = {1,3,4};
        N_Factor n_factor = new N_Factor(values);
        System.out.println(n_factor.ways(5));
    }
}
