package MAIN_JAVA.company;
import java.util.Scanner;

public class chap5_LOOPS
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int a=1;

        /*******************---WHILE LOOPS---**************************/
        // while loop will not run if the condition is false //
        // entry controlled loop //

      System.out.println("using while loops");
        while (a<6)
        {
            System.out.println(a);
            a++;
        }

        /***************---DO WHILE LOOP---*********************/
        // do while loop will run atleast once even if the condition is false //
        // exit controlled loop //

        System.out.println("using dop while loops");
        do{
            System.out.println(a);
            a++;
        } while (a<6);

        /*******************---FOR LOOP---**************************/
        // for loop is used when we know the number of iterations //
        // entry controlled loop //

        System.out.println("using for loop");
        int n= sc.nextInt();
         for (int i=0;i<n;i++) {
         System.out.println(2*i);
          }

          /*******************---BREAK AND CONTINUE---**************************/

          // break loop //
          // break will terminate the loop //
        System.out.println("break");
            for (int b=1;b<=5;b++) {
                System.out.println(b);
                if (b==2) {
                    System.out.println("end loop");
                    break;
                }
            }

            // continue loop  //
            // continue will skip the current iteration //
        System.out.println("continue loop");
            for(int c=1;c<6;c++) {
                if (c==2) {
                    System.out.println("continue");
                    continue;
                }
                System.out.println(c);
                if (c==4) {
                    System.out.println("cont");
                    continue;
                }
            }
    }
}
