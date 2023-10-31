package DSA.CODE;

import java.util.Scanner;
class SNODE {
    int data ;
    SNODE next ;
    public SNODE(int data) {
        this.data = data ;
    }
}
// @@  STACK USING LINKED LIST  @@ //
class SLL{
    SNODE head= null ;
    SNODE tail ;
    int size = 0;

    private void insert(int value)
    {
        SNODE s = new SNODE(value);
        s.next = head ;
        head = s ;
        size ++ ;
    }

    void print(){
        SNODE temp =  head ;
        while (temp != null)
        {
            System.out.print(temp.data );
            if(temp.next != null){
                System.out.print(" --> ");
            }
            temp = temp.next ;
        }
        System.out.println(" ");
    }

         // @@  IS EMPTY  @@  //
        public boolean isEmpty(){
            if(head==null){
                return true ;
            }
            else {
                return false ;
            }
        }

        // @@  PUSH  @@  //
        public void Push(int value){
            insert(value); // insert at head
        }

        // @@  POP  @@  //
        public int POP(){
            int s = head.data; //  storing the top elem
            head = head.next ; //  setting the top to below ELEM.
            size -- ;          //  reducing the size of stack
            return  s ;
        }

        // @@  PEEK  @@  //
        public int PEEK(){
            return head.data ; //  returning the top elem
        }
        public void delete(){
            head = null;
            System.out.println("STACK DELETED");
        }
    }

class LSTACK
{
    // --> a Linked List STACK never gets full
    SL sl ;   //    SL class from sec03A_SINGLE_LINKED_LIST

    public LSTACK() {
        sl = new SL();
    }
    public boolean is_em()
    {
        if(sl.head==null)
        {
            return true ;
        }
        return  false ;
    }
    public void PUSH(int value)
    {
        sl.insert(value,0);
    }
    public int pop(){
        int s = sl.head.value ;
        sl.head = sl.head.next ;
        return  s ;
    }
    public int peek(){
        return sl.head.value ;
    }
    public void del(){
        sl.head=null;
    }
}
public class sec04B_STACK_USING_LINKEDLIST {
    public static void main(String args[])
    {
        Scanner sc =  new Scanner(System.in);
        SLL sl =  new SLL() ;
sl.Push(23);
sl.Push(30);
sl.Push(45);
sl.Push(10);
sl.Push(101);
sl.print();
        System.out.println(sl.POP());
        System.out.println(sl.PEEK());
        sl.delete();
        //////////////////////////////////
        System.out.println("STACK CLASS");
        LSTACK s = new LSTACK() ;
        s.PUSH(111);
        s.PUSH(90);
        s.PUSH(808);
        s.PUSH(900);
//        System.out.println(s.pop());
        System.out.println(s.peek());
        s.sl.display();



        /*       COMPLEXITY CHART


         *                           TIME COMPLEXITY             SPACE COMPLEXITY
         *   CREATE STACK              O(1)                           O(1)
         *   PUSH                      O(1)                           O(1)
         *   POP                       O(1)                           O(1)
         *   PEEK                      O(1)                           O(1)
         *   isEmpty                   O(1)                           O(1)
         *   and isFull
         *   Delete                    O(1)                           O(1)
         * */

    }
}
