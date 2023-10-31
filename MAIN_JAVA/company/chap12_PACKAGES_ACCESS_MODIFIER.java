package MAIN_JAVA.company;   //  this is a user defined package  //
//  java.util is a build in package  //
import java.util.Scanner;   // takes scanner class from util package //
// import java.util.*    //  takes all class from util package //


 class C1
{

    public int A=1;
    private int B=2;
    protected int C=3;
    int D=4;
    public void method1()
    {
        System.out.println("modifier");
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);
    }

    class C3 extends C1
    {
        void meth4()
        {
            System.out.println(A);      //  A SUBCLASS IN SAME PACKAGE CAN ACCESS ALL MODIFIER
            System.out.println(B);
            System.out.println(C);
            System.out.println(D);
        }
    }
}
public class chap12_PACKAGES_ACCESS_MODIFIER {
     int a=40;
     public int b=50;
     protected int c=60;
     private int d=70;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // in terminal(powershell)
        //  javac class_name.java creates a class file from java file which can be run in any OS  //
        //  java class_name run the class file
        // in terminal(command prompt)
        //  javac -d . class_name.java creates a package mention in java file and moves the class file of java file to the package
        //  java package_name.class_name  to run a class //
        System.out.println("package is com.company");
        //  @@  ACCESS MODIFIER  @@  //
        C1 c = new C1();
        c.method1();
        System.out.println(c.A);    // PRIVATE CLASS CANT BE ACCESSED IN MAIN CLASS OF SAME PACKAGE
        c.D=33;
        System.out.println(c.D);


    }
}
