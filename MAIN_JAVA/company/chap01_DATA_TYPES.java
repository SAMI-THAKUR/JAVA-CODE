package MAIN_JAVA.company;

import java.math.BigInteger;

public class chap01_DATA_TYPES {
    public static void main(String[] args) {

        // PRIMITIVE DATA TYPES  //
        // 8 primitive data types
        // 4 integer types, 2 floating point types, 1 character type, 1 boolean type
        // 1 byte = 8 bits
        // 1 bit can store 0 or 1
        // 1 byte can store 2^8 = 256 values
        byte num = 12;              // 1 byte  --> -128 to 127
        short num0 = 1234;          // 2 byte  --> -32,768 to 32,767
        int num1 = 1234567890;      // 4 byte  --> -2B to 2B
        long  num2 = 12345678900l;  // 8 byte --> -9,223,372,036,85 4,775,808 to  9,223,372,036,85 4,775,807
                                    // --> write l at end of number
        float num3 = 3.145f;        // 4 byte  -->  up to 7 decimal digit
                                    // --> write f at end of number
        double num4 = 2.33333d;     // 8 byte --> 16 decimal digit
                                    // --> write d at end of number
        char c = 'A';               //  2 byte   --> takes single alphabet or special  character --> cover in '  '
                                    //  **   subtraction of two char is a INTEGER   **
        boolean b = true;           //  1 byte   --> takes true or false
                                    //  **   subtraction of two boolean is a INTEGER   **

        //  NON-PRIMITIVE DATA TYPES  //
        // String is a non-primitive data type
        // it is a class and not a data type
        // its length is not specified it is variable  --> in  * chap3_Strings *
        // u can run various operation on it
        String s = "hi guys";    //           --> takes word or sentences   --> cover in "  "


        /****************---CASTING---************************/
        // casting is used to convert one data type to another
        int p = (int) 16.94;  // --> explicit casting:- can store decimal in int by deleting number after decimal point
        System.out.println(p);
        double d= 18 ; // --> this is called implicit casting:- can store int in double
        System.out.println(d);  // it prints 18.0 not just 18
        final float PI = 3.14f; // final keyword used to fix a value for a variable and cannot be change
        // PI = 3.15f;  --> this will give error

        /****************---BIG INTEGER---************************/
        // BigInteger is a class which is used to store very large number
        // it is present in java.math package
        // it is a non-primitive data type
        // it is a class and not a data type
        // its length is not specified it is variable
        BigInteger bi = new BigInteger("12345678901234567890123456789012345678901234567890");
        System.out.println(bi);
        BigInteger bi1 = new BigInteger("12345678901234567890123456789012345678901234567890");
        System.out.println(bi.add(bi1)); // add() is a method of BigInteger class
        System.out.println(bi.multiply(bi1)); // multiply() is a method of BigInteger class
        System.out.println(bi.subtract(bi1)); // subtract() is a method of BigInteger class
        System.out.println(bi.divide(bi1)); // divide() is a method of BigInteger class
        System.out.println(bi.remainder(bi1)); // remainder() is a method of BigInteger class
        System.out.println(bi.max(bi1)); // max() is a method of BigInteger class
        System.out.println(bi.min(bi1)); // min() is a method of BigInteger class
        System.out.println(bi.gcd(bi1)); // gcd() is a method of BigInteger class
    }
}
