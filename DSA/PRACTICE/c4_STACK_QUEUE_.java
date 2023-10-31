package DSA.PRACTICE;


import com.sun.jdi.ArrayReference;

import java.util.Arrays;

// @@  THREE IN ONE  @@ //
class TIO
{
    private int num = 4 ; // numbers of STACk
    private int stack_cap ; // STACK CAPACITY
     int [] values ;        // actual stacks
    private int [] sizes ;  // sizes of each array

    public TIO(int size) {
        stack_cap = size ;
        values = new int[size * num];
        sizes = new int[num];
    }

    // isFULL
    public boolean isfull(int stacknum)
    {
        if (sizes[stacknum]==stack_cap)
        {
            return true;
        }
        return false ;
    }

    // isEMPTY
    public boolean isEM(int stacknum)
    {
        if (sizes[stacknum]==0)
        {
            return true ;
        }
        return false ;
    }

    // top index
    private int top(int stacknum)
    {
        int a = stacknum * stack_cap ;
        int siz = sizes[stacknum];
        return a+siz-1 ;
    }

    public void push(int stackn , int value)
    {
        if (isfull(stackn))
        {
            System.out.println("is full");
        }
        else {
            sizes[stackn] ++ ;
            values[top(stackn)] = value ;
        }
    }

    // POP
    public int pop(int stackn)
    {
        if (isEM(stackn))
        {
            System.out.println("is empty");
            return -1 ;
        }
        else {
           int a = values[top(stackn)];
           values[top(stackn)]=0;
           sizes[stackn] -- ;
           return a ;
        }
    }

    // PEEK
    public int peek(int stackn)
    {
        if (isEM(stackn))
        {
            System.out.println("is empty");
            return -1 ;
        }
        else {
            return values[top(stackn)];
        }
    }
}

// MINIMUM OF STACK //

public class c4_STACK_QUEUE_ {
    public static void main(String[] args) {
      TIO t = new TIO(4);
      t.push(0,12);
      t.push(1,33);
      t.push(2,333);
      t.push(0,1011);
      t.push(0,600);
        System.out.println(t.pop(0));
        System.out.println(t.peek(2));
      System.out.println(Arrays.toString(t.values));
    }
}
