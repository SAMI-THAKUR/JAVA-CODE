
package MAIN_JAVA.company;




                            //    @@   INTERFACE   @@   //
interface BIKE
  {
      public void speed_up(int inc);
      public void brake(int dec);
      int a=50; //  value of any variable in interface cannot be changed in main method can be changed in implemented method
      public String[] networks();

  }

  interface HORN
  {
     void horn();
     default void horn_2()     //  default method
     {
         System.out.println("electric");
     }

  }

  class av implements BIKE,HORN  //  have to use all method of interface in implement and also same in abstract class //
                                 //   a class can implement multiple INTERFACE together
  {
      int a=90;
      int speed=7;
      public void speed_up(int inc)          //  method of interface BICYCLE
      {
         speed=speed+inc;
          System.out.println(speed);
      }
      public void brake(int dec)
      {
          speed=speed-dec;
      }   // method of interface BICYCLE

      public void horn()     // method of interface HORN
      {
          System.out.println("horn");
      }
      public String[] networks()
      {
          String[] name={"harry","sami","vedant"};
          return name;
      }

  }


                          //  @@  ABSTRACT CLASS  @@  //
abstract class PARENT   //  if a class includes abstract method then class must be abstract //
{
    public void key()
    {
        System.out.println("PARENT CLASS");
    }
            //  @@  ABSTRACT METHOD  @@  //
    abstract public void greet();

}

class CHILD1 extends PARENT
{
    @Override
    public void greet()
    {
        System.out.println("GUTEN GOTT");
    }
    @Override
    public void key()
    {
        System.out.println("CHILD1 CLASS");
    }
}

class CHILD2 extends PARENT
{
                    // CALLING A ABSTRACT METHOD //
    public void greet()
    {
        System.out.println("GOOD MORNING");
    }
    public void hi()
    {
        System.out.println("hi");
    }
    int b;
}







                               //    @@    MAIN CLASS   @@ //
public class chap11A_ABSTRACT_CLASSES {
    public static void main(String[] args) {

        CHILD1 ch1=new CHILD1();
        CHILD2 ch2=new CHILD2();
        PARENT pa=new CHILD1();   //  dynamic method dispatch
        av a=new av();
        BIKE bi=new av();  // similar as dynamic method dispatch //





        System.out.println("ABSTRACT CLASS :-");
        ch1.greet();
        ch2.greet();
        pa.key();
        ch1.key();
        pa.greet();
        ch2.key();
        System.out.println();

        System.out.println("INTERFACE :-");
       a.speed_up(10);
       a.brake(8);
       System.out.println(a.speed);
       a.horn();
        System.out.println(a.a);
        System.out.println();
        System.out.println("STRING CLASS");
        String [] pro=a.networks();
        for (String elements : pro)
        {
            System.out.println(elements);
        }
        System.out.println();

        System.out.println("DEFAULT METHOD AND STATIC");

        a.horn_2();




    }
}
