package GAME;
import java.util.Random;
import java.util.Scanner;
public class RPS
{
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
        Random ra = new Random();
        System.out.println("welcome to rock paper scissor");
        System.out.println();
        System.out.println("rock=1\n paper=2\n scissor=3");
        System.out.println("first move");
        int a=sc.nextInt();
        int b=ra.nextInt(1,4);
        if (a==b)
            System.out.println("draw");
        else if (a==1 && b==2)
        {
            System.out.println("b is winner");
        }
        else if (a==2 && b==3)
        {
            System.out.println("b is winner");
        }
        else if (a==3 && b==1)
        {
            System.out.println("b is the winner");
        }
        else if (a==2 && b==1)
        {
            System.out.println("a is winner");
        }
        else if (a==3 && b==2)
        {
            System.out.println("a is winner");
        }
        else if (b==3 && a==1)
        {
            System.out.println("a is winner");
        }

        System.out.println("second move");
        System.out.println(b);

    }

}
