package MAIN_JAVA.company;
import java.util.*;


// @@ CUSTOM EXCEPTION CLASS @@ //
class myexception extends Exception {
    myexception() {
        System.out.println("yo bro");
    }

    public String getMessage() {
        return "enter correct number ";
    }

    public String toString() {
        return "exception aah gaya";
    }
}

class NEGATIVE extends Exception {
    @Override
    public String toString() {
        return "radius cannot be negative " ;
    }

    @Override
    public String getMessage() {
        return  "bro negative radius hai";
    }
}


    public class chap14B_ERROR_EXCEPTION {
    public static int greet() {
        Scanner sc = new Scanner(System.in);
        // @@ FINALLY BLOCK @@ //
        try {
            int A=10;
            int B =sc.nextInt();
            return A/B;
        }catch (Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println("END OF FUNCTION");   // if we put this without finally this is will be printed only if exception occurs (only if the return type is not void )
        }
        return 0;



    }
    public static double area(int r) throws NEGATIVE {  // throws keyword is a warning for programmer that there can be  A exception in class
        if (r<0) {
            throw new NEGATIVE();
        }
        double area = Math.PI*r*r;
        return area;
    }
    int divide(int a , int b) throws ArithmeticException {
        int result=a/b;
        return result;
    }
       // MAIN //
        public static void main(String[] args) throws NEGATIVE {
            Scanner sc = new Scanner(System.in);


            // @@ EXCEPTION CLASS @@ //
            int d= sc.nextInt();
            if (d<9) {
                try {
                    throw new myexception();   // custom exception
                }catch (myexception e)
                {
                    System.out.println(e.toString());   // print the e message
                    System.out.println(e.getMessage());  // print reason for exception
                    e.printStackTrace();    // gives u line of exception and also print toString
                }
            }
            if(d<10)
            {
                try {
                    throw new Exception("exception aah gaya 2");
                }catch (Exception e)
                {
                    // System.out.println(e.getMessage());
                    System.out.println(e.toString());
                }
            }
                   // @@ THROW AND THROWS KEYWORD @@ //
            chap14B_ERROR_EXCEPTION ch = new chap14B_ERROR_EXCEPTION();
            try {
//                double c = ch.divide(6, 0);
//               System.out.println(c);
               double de = area(sc.nextInt());
               System.out.println(de);

            }catch (NEGATIVE ne)
            {
                System.out.println(ne.getMessage());

            }
             catch (Exception e)
            {
                System.out.println("exception");
            }

// @@ FINALLY BLOCK @@ //
            System.out.println(greet());

            int a1 = 7;
            int b1 = 9;
            while(true) {
                try {
                    System.out.println(a1 / b1);
                } catch (Exception e) {
                    System.out.println(e);
                    break;
                } finally {
                    System.out.println("I am finally for value of b = " + b1);
                }
                b1--;
            }



        }
}
