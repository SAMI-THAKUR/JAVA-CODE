package GAME;
import java.util.*;


class game
{
    public int inputnumber;
    public int numberofguess=0;
    public int number;

    void user()
    {
        System.out.println("guess the number");
        Scanner sca=new Scanner(System.in);
        inputnumber=sca.nextInt();
    }

    game()
    {
        Random ran=new Random();
        number=ran.nextInt(1,10);
    }



    boolean answer()
    {
       return inputnumber==number;
    }
}




public class GUESSTHENUMBER
{
    public static void main(String[] args) {

        System.out.println("guess number btwn 1 to 10");
        game ga=new game();
        int a=ga.numberofguess;
for (int i=a;i<5;i++)
{
    ga.user();
    System.out.println(ga.answer());
    if (ga.number==ga.inputnumber)
    {
        System.out.println("congrats u won");
        break;
    }
    a++;
    System.out.println("number of guess :"+ a);
}
        System.out.println("the number was");
        System.out.println(ga.number);







    }
}
