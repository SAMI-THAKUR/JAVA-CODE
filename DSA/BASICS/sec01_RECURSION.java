package DSA.BASICS;
import java.util.*;

//   three steps of writing RECURSION
//  -->  find the repeating pattern
//  --> find a break condition
//  --> find invalid condition

public class sec01_RECURSION {
    //  @@  FACTORIAL @@  //
    static int fac(int n)
    {
        if (n==0 || n==1)
        {
            return 1;
        }
        return n * fac(n-1);
    }

    //    static void prac(int n)    --> prints number from 1 to n
//    {
//        if (n<1)
//        {
//            System.out.println("less than 1");
//        }
//        else {
//
//            prac(n-1);
//            System.out.println(n);
//        }
//    }


    //   POWER OFN TWO   //
    static int power(int n)
    {
        if (n==0) {
            return 1;
        }
        else {
            int pow = 2*power(n-1);  // continuously multiple two until n becomes 0 ;
            return pow;
        }
    }
    static  void power2(int n1)  //  --> same as previous this uses iteration instead of recursion
    {
      int i=0;
      int power =1;
      while (i<n1)
      {
          power = power*2;
         --n1;
      }
        System.out.println(power);
    }

    //   @@  BASIC  @@  //
//    static void recur(int n)
//    {
//        if (n==1)       //  -->   this is the base condition without this it will get into infinite loop
//        {
//            System.out.println("ALL DOLLS ARE OPENED");
//        }
//        else {
//            recur(n-1);   // -->  calling itself with smaller input
//        }
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//recur(9);
        System.out.println(power(5));
        power2(5);
//        prac(5);

    }
}
