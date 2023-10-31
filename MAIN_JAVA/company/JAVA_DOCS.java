package MAIN_JAVA.company;



/**
 * This class is to demonstrate what java doc really is .
 * <p> hi MY NAME IS SAMI THAKUR </p>
 *
 * @author SAMI
 * @since 2020
 * @version 0.1
 * @see <a href = "https://docs.oracle.com/en/java/javase/14/docs/api/index.html">JAVA DOCS</a>
 */
public class JAVA_DOCS {
    /**
     * this method is ude to add two numbers through arguments of method named add
     * @param a first number to add
     * @param b second number to add
     */
    static void add (int a , int b)
    {
        System.out.println("add method " + a + b);

    }

    /**
     * This method is used to subtract two number through argument of method named subtract 
     * @param a first number to subtract
     * @param b second number to subtract
     * @return subtraction of both numbers
     */
    static int subtract (int a , int b)
    {
        return a-b;
    }
    public static void main(String[] args) {
        System.out.println("this is main java docs :)");
        add(3, 4);
        System.out.println(subtract(14,16));


        // always keep the view type in java docs as package //


    }
}
