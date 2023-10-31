package MAIN_JAVA.company;
import java.io.IOException;
import java.util.*;



public class chap14_ERROR_EXCEPTION {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();
        // @@ SYNTAX ERROR @@ //
        // can be caught by IDE or CODE EDITOR //-
        // int a=90 --> semicolon missing
        // d=90;    --> undeclared variable

        // @@ LOGICAL ERROR @@ //
        // when a program runs but gives wrong output //

        // @@ RUNTIME ERROR @@ //
        // happens due to wrong input //
//        int k;
//        Scanner sc = new Scanner(System.in);
//        k = sc.nextInt();
//        System.out.println("Integer part of 1000 divided by k is "+ 1000/k);

        // @@ EXCEPTIONS IN JAVA @@ //
        // CHECKED EXCEPTION :- HANDLED BY COMPILER
        // UNCHECKED EXCEPTION :- RUNTIME
        /*  --> NULL POINT
            --> ARITHMETIC
            --> ARRAY INDEX OUT OF BOND
            --> ILLEGAL ARGUMENT
            --> NUMBER FORMAT
         */


        // @@ EXCEPTION HANDLING @@ //
        // --> TRY CATCH BLOCK IN JAVA  //   used to handle exception without error
        int a = 6000;
        System.out.println("enter denominator");
        int b = sc.nextInt();

        try {
            int c = a / b;
            System.out.println(c);
        } catch (Exception f) {
            System.out.println("failed to divide reason" + f);  // handling arithmetic exception //
            // if user put 0 as input then arithmetic exception occurs //
        }

        // SPECIFIC EXCEPTION HANDLING //
        int[] marks = new int[4];
        marks[0] = 33;
        marks[1] = 10;
        marks[2] = 90;
        marks[3] = 88;
        System.out.println("enter array index");
        int guess = sc.nextInt();
        System.out.println("enter denominator");
        int number= sc.nextInt();
        try {
            System.out.println(marks[guess]);
            System.out.println(guess/number);
        } catch (ArithmeticException e)
        {
            System.out.println("exception is");
            System.out.println(e);
        } catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
        } catch (Exception e)
        {
            System.out.println("exception is");
            System.out.println(e);
        }

        // @@ NESTED TRY CATCH @@ //
        // try in try block is called nested try u can further nest try

boolean try1=true;
        while (try1) {
            int while2= sc.nextInt();
            try {

                try {
                    System.out.println(marks[while2]);
                } catch (ArrayIndexOutOfBoundsException f) {


                    System.out.println("exception in level 2");
                    try1=false;

                }

            } catch (Exception e) {
                System.out.println(e);
                System.out.println("exception in level 1" );
            }
        }
        System.out.println("thanks");







    }
}
