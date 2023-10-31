package DSA.PRACTICE;

import java.util.ArrayList;
import java.util.EmptyStackException;

class PLATE
{
    int value ;
    PLATE above ;
    PLATE below ;
    public PLATE(int data)
    {
        value = data ;
    }
}
class STACK
{
    int capacity ;
    PLATE top ;
    PLATE bottom ;
    int size = 0 ;

    public STACK( int cap) {
        capacity = cap ;
    }

    public boolean isF()
    {
        return capacity==size ;
    }

    public void join(PLATE above , PLATE below)
    {
        if (below!=null) below.above =above ;
        if (above != null) above.below = below ;
    }

    public void push(int v)
    {
        if (size>=capacity)
        {
            System.out.println("FULL HAI ");
        }
        size ++ ;
        PLATE newP = new PLATE(v);
        if (size == 1)
        {
            bottom = newP ;
        }
        join(newP , top);
        top = newP ;
    }

    public int Pop()
    {
        if ( top == null) throw new EmptyStackException() ;

        int re = top.value ;
        top = top.below ;
        size -- ;
        return  re ;
    }
    public void dis()
    {
        PLATE temp = top ;
        while (temp!= null)
        {
            System.out.println(temp.value);
            temp = temp.below ;
        }
    }
}
// joining the stack of plates
 class SET_STACKS{
    ArrayList<STACK> st = new ArrayList<STACK>();
    int capacity ;
    public SET_STACKS(int si)
    {
        capacity = si ;
    }

    public STACK get_LAST()
    {
        if (st.size() == 0){ return null;}
        return st.get(st.size() -1 );
    }

    public void push(int v)
    {
        STACK l =  get_LAST();
        if(l != null && !l.isF())
        {
            l.push(v);
        }
        else {
            STACK l1 = new STACK(capacity);
            l1.push(v);
            st.add(l1);
        }
    }
    public int pop()
    {
        STACK l =  get_LAST();
        if (l == null) throw new EmptyStackException() ;
        int result = l.Pop();
        if (l.size ==0)
        {
            st.remove(st.size()-1);
        }
        return result;
    }
}
public class c4B_STACKS_OF_PLATE {
    public static void main(String[] args) {
     SET_STACKS ss = new SET_STACKS(4);
     ss.push(12);
     ss.push(111);
     ss.push(123);
     ss.push(90);
     ss.push(123);
     ss.push(80);
      for (int i= ss.st.size()-1; i>=0; i--)
      {
          ss.st.get(i).dis() ;
          System.out.println("------");
      }
    }
}
