
package MAIN_JAVA.company;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;   //scanner file
public class chap3_STRINGS {
    public static void main (String[] args)
    {

        /***********************---OTHER_WAYS_TO_PRINT---****************************/
       int k=6;
        float j=5.666f;
        // same as printf in C
        System.out.printf("the value of k is %-14d  ",k);                      // %d fpr integer
                                                                               // %f for flaot
                                                                               // %c for character
                                                                               // %s for string
                                                                               // %n for new line
                                                                               // %t for tab
       System.out.println();
       System.out.printf("the value of j is %f and value of k is %d",j,k);
       System.out.println();


       Scanner sc = new Scanner(System.in);  // scanner class
       /*************************---STRING_CLASS---*******************************************/
       String e= "hi " + sc.nextLine() ;   // next line is used to print line
         System.out.println(e);
         //string input can only print one word not a sentence
        String str=new String("This is SAMI" );  // String class
        System.out.println(str);


        /***************************---STRING_METHODS---******************************************/
        String name="SAAI";
        System.out.println(name);
        int l=name.length();   //print length in this case 4
        System.out.println(l);
        System.out.println(name.toLowerCase());  // print in lower case
        System.out.println(name.toUpperCase());  // print in upper case
        String a="   SAMI  ";
        System.out.println(a.trim());  // remove all spaces and print
        System.out.println(name.substring(2));   // print string from entered index to end index
        System.out.println(name.substring(1,4));    // print string between entered index number
        System.out.println(name.replace('A','M'));  //replace M with A
        System.out.println(name.replace("AAI","AM")); //replace character sequence AMI with AM
        System.out.println(name.startsWith("S"));   // PRINT TRUE IF WORD STARTS WiTH ENTERED CHAR
        System.out.println(name.endsWith("I"));  //"""" end with """
        System.out.println(name.lastIndexOf("A")); //last index of A in name
        System.out.println(name.equals("SAAI"));  // returns true if entered string is equal to name (case sensitive)
        System.out.println(name.equalsIgnoreCase("sAAi")); //not case sensitive at least two char must be same in strings
        System.out.println(name.indexOf("A")); //index of char is printed only first
        System.out.println("my name\' is sami"); // escape sequence used in sout  \n(newine)  \t(tabs)  \'(single quote)  \\(backslash)

        //  * all the changes does not happen in original String name it store the change in new location //
        // * String are immutable --> unable to change

        // String to int
        int a1= 12;
        String i = Integer.toString(a1);
        System.out.println(i.charAt(2));
        System.out.println(i);





        /*************************---STRING_BUILDER_CLASS---*******************************************/
        //  * String builder class is mutable
        //  * String builder class is faster than String class
        StringBuilder sb=new StringBuilder("SAMI");
        System.out.println(sb);
        // methods in string builder class

















    }
}
