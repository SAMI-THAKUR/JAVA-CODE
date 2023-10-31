package MAIN_JAVA.company;
import java.util.Scanner;


public class chap4_CONDITIONAL
{
    public static void main (String[] args)
    {
        /*************************---IF_STATEMENT---******************************************/
        // if statement is used when we have to check only one condition


        Scanner sc= new Scanner(System.in);
        int a =sc.nextInt();
        if(a>=18)       // FIRST STATEMENT IS PRINT WHEN CONDITION IS TRUE
        {
            System.out.println("you can drive");}
        else {          // SECOND STATEMENT IS PRINT WHEN CONDITION IS FALSE
            System.out.println("no u can't drive");
        }


        int b=sc.nextInt();
        if((b|2)>20)
        {
            System.out.println("correct");
        }
        if(b>a||a>b)      // PRINT YES ONLY WHEN OUTCOME OF LOGICAL OPERATION IS TRUE
        {
            System.out.println("y");
        }
else {
            System.out.println("n");
        }

        /******************---ELSE IF STATEMENT---******************************/
        // else if statement is used when we have to check multiple condition


        System.out.println("enter your age");
        int age=sc.nextInt();
if(age>56)
{
    System.out.println("experienced");

}
else if(age>50)
{
    System.out.println("good");
}
else if(age>40)
{
    System.out.println("medium");
}
else
{
    System.out.println("not experienced");
}

        /***********************---SWITCH CASE---***************************/
        // switch case is used when we have to check multiple condition
        // switch case is faster than if else statement
        // switch case is used when we have to check only one variable

        switch (age)
        {
            case 18:
                System.out.println("ur going to be an adult");
                break;
            case  21 :
                System.out.println("ur going to be mature");
                break;
            case  60:
                System.out.println("ur going to be an senior citizen");
                break;
            case  70:
                System.out.println("overage");
                break;
        }


    }
}
