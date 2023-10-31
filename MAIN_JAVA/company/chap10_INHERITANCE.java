package MAIN_JAVA.company;

import java.math.BigInteger;

//*****************@@ INHERITANCE @@**************//

/****************---BASE CLASS---*******************/
class BASE  {
    BASE() {
        System.out.println("base constructor");
    }
    BASE(int a) {
        System.out.println("base overloaded constructor "+ a);
    }
    int x;
    public void setX(int x) {
        this.x=x;
    }
    public int getX() {
        return x;
    }
    public void key() {
        System.out.println("I AM METHOD OF BASE CLASS"); // METHOD OVERRIDING --> same method in derived classq
    }
}

/****************---DERIVED CLASS 1---****************/
// --> extends keyword --> derived class
// --> derived class is inheriting base class i.e derived class has excess to base class variables
class DERIVED extends BASE {
    DERIVED() {    // CONSTRUCTOR --> same name as class name
        // super(22);  //  super keyword --> calling base class constructor with argument
        System.out.println("derived constructor");
    }

    DERIVED(int b) {   //  OVERLOADED CONSTRUCTOR  //
        super(30);  // base class constructor with argument
        // o/p --> base overloaded constructor 30
        System.out.println("derived overloaded constructor " + b);
    }

    /**---METHOD OVERRIDING---**/
    @Override  // notation recommend to add --> to check if method is overridden or not
    public void key()
    {
        System.out.println("I AM METHOD OF DERIVED CLASS");
    }
}

/****************---DERIVED CLASS 2---****************/
// derived class of derived class
// access to base class variables
class DERIVED2 extends DERIVED
{
    DERIVED2() {
        super(22);  //  super keyword --> calling derived class constructor with arguments
        // o/p --> base overloaded constructor 22
        System.out.println("child of derived class");
    }
}

/****************---KEYWORDS CLASS---****************/
class keyword extends BASE
{
    int a;
    public int getA() {
        return a;
    }
    keyword(int a) {  //  constructor with argument
        super(a); // super keyword
        this.a = a;  //  this keyword --> to call variable of same class this.a means a of this class and a means a of argument
        super.key();   //  super keyword used to call method of base class  //
        // o/p --> I AM METHOD OF BASE CLASS
    }
}


public class chap10_INHERITANCE
{
    public static void main(String[] args) {

        /*-----------DERIVED CLASS 1--------------*/
        System.out.println("calling derived class");
        DERIVED de=new DERIVED();
        System.out.println();
        System.out.println("calling overloaded constructor");
        de=new DERIVED(12);//  calling overloaded constructor with arguments //
        System.out.println();

        System.out.println("calling derived 2");
        DERIVED2 de2=new DERIVED2();
        System.out.println();


        //  @@  INHERITANCE  @@  //
        System.out.println("BASE CLASS");
        BASE ba =new BASE(); //  calling constructor
        ba=new BASE(30);  //  calling overloaded constructor with arguments
        ba.setX(5);  //  setting value of x
        System.out.println(ba.getX()); //  getting value of x
        ba.key();
        System.out.println();


        System.out.println("DERIVED CLASS");   // -->  derived class has excess to base class variables
        de.setX(33);
        System.out.println(de.getX());
        de.key();
        System.out.println();


        /*--------------KEYWORD-----------------*/
        System.out.println("KEYWORD");
        keyword ke=new keyword(40);
        System.out.println(ke.getA());
        System.out.println();


        /*--------------METHOD OVERRIDING------------*/
        System.out.println("method overriding");
        de.key();  // method of parent class
        ba.key();//  method of base class
        System.out.println();

        /*-----------DYNAMIC METHOD OVERRIDING----------*/
        System.out.println("DYNAMIC METHOD OVERRIDING");
        BASE obj1= new DERIVED();   //    dynamic method overriding calls same as derived class
        // means base class object can call derived class method
        //
        // o/p --> base constructor
        //         derived constructor

        //   DERIVED obj2= new BASE();   // not allowed
        //   o/p --> incompatible types: BASE cannot be converted to DERIVED
        // means derived class object cannot call base class method
        System.out.println();







    }
}
