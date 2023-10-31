package DSA.PRACTICE;

public class c1_RECURSION_PRAC {
    //  @@  SUM OF DIGITS OF NUMBER  @@  //
    static int sum(int n) {
        if (n==0 || n<0) {
       return 0;
        }

        return n%10 + sum(n/10);   //  --> 112/10  = 11 and 112 % 2 = 2
                                      //  11/10 = (1)  and 11 % 10 = (1)
                                      //  then sum becomes 2 + 1 + 1 + 0
    }

    //  @@  POWER OF A NUMBER  @@  //
    static int power(int n , int m) {
        if (m<0 || n<0) {
            return -1;
        }
        if (m==0) {
            return 1;
        }
        return n*power(n,m-1);  // -->
    }

    //  @@  GREATEST COMMON DIVISOR  @@  //
    static int gcd(int m , int n)
    {
        if (n==0)
        {
            return m;
        }
        //  -->  EUCLIDEAN ALGORITHM
        return gcd(n , m%n);

    }

    //  @@  DECIMAL TO BINARY  @@  //
    static int DcTBi(int n )
    {
        if (n==0)
        {
            return 0;
        }
        return n%2 + 10*DcTBi(n/2);
    }

    public static void main(String[] args) {
        System.out.println(sum(112));   // --> sum of digits
        System.out.println(sum(2222)); // --> sum of digits
        System.out.println(power(5,3)); // --> power of numbers
        System.out.println(gcd(-4,-8));  // --> GCD
        System.out.println(DcTBi(6));  //  --> DECIMAL TO BINARY
    }
}
