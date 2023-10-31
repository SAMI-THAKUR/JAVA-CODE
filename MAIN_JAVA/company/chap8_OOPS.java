package MAIN_JAVA.company;
import java.util.Scanner;


/********************---# CUSTOM CLASS 1 #---********************/
class employee{  // there can be only one public class  //

    int id = 12;
    private String name = "SAMI";    //  private class need to be called using getters and setters
    int salary = 90000;

    //  @@  CONSTRUCTORS  @@  //
    // constructor is a method which has same name as class name  //
    public employee(String myname)
    {
        id =45;
        name =myname;

    }
    public employee()     // @@  CONSTRUCTOR OVERLOADING  @@  //
    {
        id=90;
        name="SAM";
    }

    void print() {   //  TO DIRECT CALL METHOD IN CUSTOM CALL SHOULD BE PUBLIC and static  or call through object created  //{
        System.out.println("hi guys");
    }

    //  --- GETTERS AND SETTERS --- //
    public void setName(String n) { // write only access
        name = n;
    }

    public String getName() { // read only access
        return name;
    }

}

/************************---### MAIN_CLASS ###---****************************************/
 public class chap8_OOPS
{
    public static void main(String[] args)
    {
        //    @@  CUSTOM CLASS CREATING OBJECT  @@   //
        Scanner sc=new Scanner(System.in);
        System.out.println("CUSTOM CLASS");
        System.out.println();


        employee sam = new employee("SAM"); //  constructor with an argument  //
        employee sami = new employee(); //  constructor without an argument  //
        int b= sami.salary=150000; //  calling a variable  //
        int a= sami.id=445;
        System.out.println("CALLING A FUNCTION");
        System.out.println(a);
        System.out.println(b);
        sami.print(); //  calling a method  //
        System.out.println();


        //   PRIVATE ACCESS MODIFIER  //
        //  GETTERS AND SETTERS //
        // way to access private class or variable //
        System.out.println("private access modifier");
        System.out.println("getters and setters");
        sami.setName(sc.next());  // calling a setter read only access  //
        System.out.println(sami.getName()); // calling a getter write only access  //
    }
}



