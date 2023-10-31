package MAIN_JAVA.company;
public class chap2_OPERATORS{

    public static void main(String[] args){

        /*********************---ARITHMETIC_OPERATOR---************************************/

        System.out.println("ARITHMETIC OPERATOR");
        int a=2;       // declaring variable //
        int b= 6*a;  //arithmetic operator
        b += 3;  // add 3 to current value of b
        System.out.println(b);   //  for printing something in java // or type (sout) and press enter\
        /*
        * --> print :- prints on same line
        * --> println :- prints on new line
        * */
        int a1=9;
        int b1 = 2;
        int m = 9 % 2; // % -->this is modulo operator adn returns remainder when the written number are divided
        System.out.println(m);

        /**************************---COMPARISON_LOGICAL_BITWISE_OPERATORS---*********************/

        System.out.println("COMPARISON OPERATOR ");
        System.out.println(5==5);  //comparison operators equal to
        System.out.println(5>36);  //comparison operators greater than
        System.out.println(5<36);  //comparison operators less than
        System.out.println(5>=36);  //comparison operators greater than or equal to



        System.out.println("LOGICAL AND BITWISE OPERATORS");

        System.out.println(64<5&&64<8);  //logical operator AND --> if both are true then true
        System.out.println(64<5||64<8);  //logical operator OR  --> if any one is true then true
        System.out.println(!(64<5||64<8));  //logical operator NOT  --> if any one is true then false
                                            // IN THIS ASSOCIATIVITY IS FROM RIGHT TO LEFT

        System.out.println(2&3);  //bitwise operator AND --> 1-1 = 1 , 1-0 = 0 , 0-0 = 0
        System.out.println(2|3);  //bitwise operator OR  --> 1-1 = 1 , 1-0 = 1 , 0-0 = 0
        System.out.println(2^3);  //bitwise operator XOR --> 1-1 = 0 , 1-0 = 1 , 0-0 = 0
        System.out.println(2<<3);  //bitwise operator left shift --> 2-0010 --> 0010000 --> 16
        System.out.println(2>>3);  //bitwise operator right shift --> 2-0010 --> 0000 --> 0
        System.out.println(2>>>3);  //bitwise operator unsigned right shift --> 2-0010 --> 0000 --> 0


        /**************************---PRECEDENCE AND ASSOCIATIVITY---*********************/
        int c= 6*5-30/6;  /*highest precedence goes to * and / they are executed of l->r associativity*/
        int d=6/5-30*2;
        System.out.println(c);
        System.out.println(d);
        int x=6;
        double y=6.55;
        double z=x+y;  /*sum of double and int is double*/
        System.out.println(z);
        int h=57;
        System.out.println(h++);  //first h is assigned then incremented
        System.out.println(h);
        System.out.println(++h);  //first h is incremented then assigned
        System.out.println(h);
        System.out.println(--h);  //decrement operator









    }
}
