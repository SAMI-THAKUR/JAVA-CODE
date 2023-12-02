package DSA.Divide_Conqueror_ALGO;

import java.util.*;

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
        int [] values = {1,2,3,4};
        N_Factor n_factor = new N_Factor(values);
        System.out.println(n_factor.ways(5));
    }
}
