package MAIN_JAVA.company;

interface Parent_1
{
    void meth1();
    void meth2();
}
     interface Child_1 extends Parent_1
     {
        void meth3();
        void meth4();

     }
 class I1 implements Child_1 {
     public void meth1() {
         System.out.println("1st method of parent interface");
     }

     public void meth2() {
         System.out.println("2nd method of parent class");
     }

     public void meth3() {
         System.out.println("1st method of child class ");
     }
     public void meth4()
     {
         System.out.println("2nd method of child class");
     }

 }



      //   @@  DEFAULT and STATIC method in INTERFACE  @@  //
interface CAMERA
{
    void takesnap();
    void takevideo();
    private void GREET_i()
    {
        System.out.println("namaste");
    }  // private method
    static void video_4K()   // static method can be called in implemented class in a method
    {
        System.out.println("static method ");

    }
    default void print()     // A default method can be overwritten in implemented class
    {
        System.out.println("default method");
        GREET_i();  // a private method in interface can be called using default method
    }

}
interface WIFI
{
    String [] getnetworks();

}
class CELLPHONE
{
    void call(long phonenumber)
    {
        System.out.println("calling "+ phonenumber);
    }
    void pickcall()
    {
        System.out.println("connecting");
    }
}
    //  class implementing two interface and extending a class //
class SMARTPHONE extends CELLPHONE implements CAMERA,WIFI {

    public void takesnap() {
        System.out.println("taking photo");
    }

    public void takevideo() {
        System.out.println("recording");
    }

    public String[] getnetworks()   // String method
    {
        String[] networks_names = {"HARRY", "SAMI",};
        return networks_names;
    }

    public void static_1()

    {
        CAMERA.video_4K();   //  implementing static class of interface //
    }
}





public class chap11B_ABSTRACT_CLASS_2 {

    public static void main(String[] args) {
        System.out.println("calling through class object");
        SMARTPHONE sm = new SMARTPHONE();
        System.out.println();
        System.out.println("calling through interface reference");
        CAMERA ca = new SMARTPHONE(); // reference of interface : can only call CAMERA interface function //
        ca.takesnap();
        ca.takevideo();
     //   ca.call  -> not allowed

        System.out.println();


        ca.print();  //  implementing default method of interface
        sm.print();
        sm.static_1();   // implementing static method of interface
        sm.call(836989010); // inheritance
        sm.pickcall();


        String[] pro = sm.getnetworks();  // implementing string method
        for (String elemnts : pro) {
            System.out.println(elemnts);
        }
        System.out.println();

        System.out.println("INHERITANCE IN INTERFACE");
        I1 i = new I1();
        i.meth1();
        i.meth2();
        i.meth3();
        i.meth4();



    }
}
