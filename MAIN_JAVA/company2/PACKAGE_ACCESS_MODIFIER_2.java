package MAIN_JAVA.company2;
import MAIN_JAVA.company.chap12_PACKAGES_ACCESS_MODIFIER;  //  accessing user build package


class C2 extends chap12_PACKAGES_ACCESS_MODIFIER
{
    void meth3()
    {
    //    System.out.println(a);
        System.out.println(b);      // YOU CAN ONLY ACCESS PUBLIC AND PROTECTED ACCESS MODIFIER IN SUBCLASS OF DIFFERENT PACKAGE
        System.out.println(c);
    //   System.out.println(d);
    }
}


public class PACKAGE_ACCESS_MODIFIER_2 {
    public static void main(String[] args)  {
        chap12_PACKAGES_ACCESS_MODIFIER pa =new chap12_PACKAGES_ACCESS_MODIFIER();
        System.out.println(pa.b);
     //   System.out.println(pa.c);   //  YOU CAN ONLY ACCESS PUBLIC MODIFIER IN A MAIN CLASS OF DIFFERENT PACKAGE
    //    System.out.println(pa.d);
      //  System.out.println(pa.a);

        C2 ca = new C2();
        ca.meth3();


    }
}
