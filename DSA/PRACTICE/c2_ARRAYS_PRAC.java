package DSA.PRACTICE;

import java.util.*;
import java.util.LinkedList;

//----------------MISSING NUMBER----------------//
class missing_number
{ public missing_number(int [] num) {
    int n = num.length + 1;
    int b = (n * (n + 1)) / 2;
    int b1 = 0;
    for (int i = 0; i < num.length; i++) {
        b1 = b1 + num[i];
        }
        System.out.println("missing number is " + (b - b1));
    }
}

//------------------PAIR SUM------------------//
class pair_sum {
    public pair_sum(int [] num,int sum) {
        for (int i=0;i<num.length;i++) {
            for (int j=i+1;j<num.length;j++) {
                if ((num[i] + num[j]) == sum) {
                    System.out.println(i + "," + j);
                    continue;
                }
            }
        }
    }
}

//--------------MAX PRODUCT OF TWO INT----------------//
class max_product
{
    public max_product(int max[]) {
        int ref = Integer.MIN_VALUE;
        for (int i=0;i<max.length;i++) {
            for (int j=i+1;j<max.length;j++) {
                if (max[i] * max[j]>ref) {
                    ref=max[i]*max[j];
                }
            }
        }
        System.out.println(ref);
    }
}

//-----------------UNIQUE ARRAY-----------------//
class unique
{
    public boolean isunique(int [] uni)
    {
        for (int i=0;i<uni.length;i++) {
            for (int j=i+1;j<uni.length;j++) {
                if (uni[i]==uni[j]) {
                   return false ;
                }
            }
        }
        return true;
    }
}
class unique_1{
    public boolean unique(int [] uni){
        List<Integer> l = new ArrayList<>();
       for(int i=0 ; i<uni.length ; i++){
           if(l.contains(uni[i])){
              return false ;
           }
           else {
               l.add(uni[i]);
           }
       }

      return true ;
    }

}

//------------------CHECKING PERMUTATION--------------//
class permutation
{
    public boolean check(int [] arr1,int [] arr2)
    {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (Arrays.equals(arr1,arr2))
        {
            return true;
        }
        return false ;
    }
}

//-------------ROTATE AN ARRAY BY 90 DEGREE-------------//
class rotate_90
{
    public rotate_90(int [][] r9)
    {
        int l = r9[0].length;
        int temp = r9[0][0];
        r9[0][0]=r9[l-1][0];
        r9[l-1][0]=r9[l-1][r9.length-1];
        r9[l-1][r9.length-1]=r9[0][r9.length-1];
        r9[0][r9.length-1]=temp;
        /////////////////////////
        int temp2 = r9[0][1];
                r9[0][1]=r9[1][0];
        r9[1][0]=r9[l-1][1];
        r9[l-1][1]=r9[1][2];
        r9[1][2]=temp2;
        for (int i=0 ; i<r9.length;i++)
        {
            for (int k=0 ;k<r9[0].length;k++)
            {
                System.out.print(r9[i][k] + " ");
            }
            System.out.println();
        }
    }
}
public class c2_ARRAYS_PRAC {
    static void reverse(int [] a){
        for (int i=0;i<a.length/2;i++){
        int temp =a[a.length-i-1];
        a[a.length-i-1]=a[i];
        a[i]=temp;
        }
        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num2 [] = {1,2,3,4,5,6,7,8,9,10};
        int num3 []={2,3,6,7,9,10,8,1,4,};

        missing_number mn = new missing_number(num2);
        pair_sum ps = new pair_sum(num2,10);
        max_product mp = new max_product(num2);
        unique u = new unique();
        System.out.println(u.isunique(num2));
        permutation pm = new permutation();
        System.out.println(pm.check(num3,num2));
        int [][] swap = {{1,2,4},{2,4,6},{3,8,9}};
        /*
        124        221
        246        846
        289        964
        */

        rotate_90 rn  = new rotate_90(swap);
        reverse(num2);





    }
}

