package MAIN_JAVA.company;
import java.util.*;

public class FIBBONACI_SERIES {
    //   --> this prints the nth element of fibbonaci series 1,1,2,3......
    static int fib (int n)
    {
        if (n<0)
        {
            return -1;
        }
        if ((n==0 || n==1))
        {
            return n;
        }
      else {
          return fib(n-1) + fib(n-2);
        }
    }
    public static void main(String[] args) {
        //   -->  prints whole fib series till nth element    //
        //  --> trigonacci series //
       Scanner sc =new Scanner(System.in);
        int n1=0;
       int n2 =1;
        int n3=1;
        int n4;
        System.out.println(n1);
      System.out.println(n2);
        System.out.println(n3);

       int fib = sc.nextInt();
        if (fib==0 || fib==1)
        {
          System.out.println(n1);
          System.out.println(n2);
            System.out.println(n3);
        }

      for (int i =3 ; i<=fib ; i++)
       {

          n4 = n1 + n2 + n3 ;
           System.out.print(n4 + " ");
           n1 =n2;
           n2=n3;
           n3=n4;
          }
//           System.out.println(fib(8));


    }
}
