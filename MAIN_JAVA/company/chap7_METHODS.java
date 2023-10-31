package MAIN_JAVA.company;
import java.util.Scanner;

public class chap7_METHODS
{


    /*********************---METHOD OVERLOADING---************************/
    // method overloading is a feature that allows a class to have more than one method having the same name but different parameters //
    public void foo(int e)
    {

        System.out.println("good morning " + e + " bro");

    }
    static void foo() {
        System.out.println("good morning bro");
    }
    static void foo(String a) {
        System.out.println("good morning "+a);
    }

    //    @@@    CHANGING IN A ARRAY    @@@   //
   static void change(int [] arr)
   {
       arr[0]=88;
       arr[1]=77;
       arr[2]=arr[0]*2;
   }
  static void change_2(int c) {
       int d;
       c = 8000;
   }

   //   @@    VOID METHOD    @@   //
   //    static void telljoke() {
   //    System.out.println("hi guys");  }



    /*********************---METHOD DECLARATION---*****************************/
   static int logic(int x,int y)
    {  int z;
        if (x>y)
        {
            z=x+y;
        }
        else
        {
            z=y-x;
        }
        x=8;
        y=9;
        System.out.println(z);
        return z;
    }

    /********************---VARIABLE ARGUMENTS---**************************/
    static void sum(int ...a)
    {
       // Available as int [] a
        int sum=0;
        for (int i=0;i< a.length;i++)
        {
          sum=sum+a[i];
        }
        System.out.println(sum);
    }


    /**************************---RECURSION---*****************************/
    static int HI(int n)
    {
       if (n==0 || n==1)
       {
           return 1;
       }
       else
       {
           return n*HI(n-1);
       }
    }


    /********************---MAIN CLASS---**************************/
    public static void main(String[] args)

    {
        Scanner sc=new Scanner(System.in);
        int a=5;
        int b=7;
        int c;

        /**********************---CALLING_OBJECT---*******************************/
        //   @@   METHOD INVOCATION USING OBJECT CREATION    @@ //
        // METHODS d=new METHODS();
        // c=d.logic(a,b);
        // logic(a,b);

        //   @@   CALLING A STATIC METHOD  @@  //
        System.out.println("calling a class :");
        System.out.println("a + b");
        c=logic(a,b);
        System.out.println(c);
       // telljoke();  // CALLING A METHOD WITH VOID RETURN TYPE
        System.out.println();



        System.out.println("REFERENCE :");
        //   @@   CALLING A METHOD USING REFERENCE   @@   //
        chap7_METHODS me = new chap7_METHODS(); // creating object of class

        // changing in main class //
        int [] marks = {12,13,14};
        int x=45;
        change_2(x);
        System.out.println("no change in value of x");
        System.out.println(x);
         // call by value
         // changes in method does not affect variable in main class because reference is not passed copy of object is passed
        change(marks);
        System.out.println("change in array :");
        //  change in array using method class
        // in case of array reference is passed therefore change is visible in main class
        for (int element: marks)
        {
            System.out.println(element);
        }
        System.out.println();

        //      @@     METHOD OVERLOADING     @@    //
        System.out.println("overloading :");
        foo();
        foo("SAMI"); // method overloading
        System.out.println();


        //   @@  VARIABLE ARGUMENTS   @@   //
        System.out.println("VARIABLE ARGUMENTS :");
        sum(2,3,5); // can take any number of integers even no integers
        sum(1,2,3,4,5);
        sum();
        System.out.println();


        //    @@   RECURSION   @@   //
        // recursion is a process in which a method calls itself continuously
        System.out.println("RECURSION");
        System.out.println(HI(5));
        System.out.println();

    }
}
