package MAIN_JAVA.company;
import java.util.*; // import all classes of util package

public class chap1_SCANNER_CLASS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); //  Scanner class use to take input from user
        Random ra =new Random();           //  Random class use to generate random int,float,double

        System.out.println(ra.nextInt(12,20));  // 12 is inclusive and 20 is exclusive

        sc.nextInt();   // use to take integer input
        sc.next();  // use to take a single word input
        sc.nextLine();  // use to take a line input
        sc.nextFloat();   // use to take float input
        sc.nextDouble();  // use to take double input
        sc.nextBoolean();  // use to take boolean input
        //  sc.nextChar();  --> this method is not present in scanner class

        /************************************************/

        sc.hasNext();   //boolean value give true for any type of inout
        sc.hasNextInt();   // gives true for string input
//      System.out.println(sc.hasNextInt());  // gives true for integer input
        sc.hasNextFloat();   // gives true for float input
        sc.hasNextDouble();  // gives true for double input
        sc.hasNextBoolean();  // gives true for boolean input
        //  sc.hasNextChar();  --> this method is not present in scanner class
        while (sc.hasNextInt()) {      //  --> when you dk how many inputs are there
            int m= sc.nextInt();                        //  --> this loop runs until user keep putting int values
        }


        /********************---MATHS_CLASS---**********************************/

        //  Math class is present in java.lang package
        Math.abs(12);   // gives absolute value  O/P--> 12
        Math.max(12, 13);   // gives maximum value  O/P--> 13
        Math.min(12, 13);   // gives minimum value  O/P--> 12
        Math.sqrt(12);      // gives square root  O/P--> 3.4641016151377544
        Math.pow(12, 2);    // gives power of 12 to 2  O/P--> 144.0
        Math.ceil(12.3);    // gives ceiling value  O/P--> 13
        Math.floor(12.3);   // gives floor value i.e 12  O/P--> 12
        Math.round(12.3);   // gives round value i.e 12  O/P--> 12
        Math.random();      // gives random value between 0 and 1






    }
}
