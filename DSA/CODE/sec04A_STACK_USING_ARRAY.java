package DSA.CODE;

//   @@   STACK  CLASS   @@   //
class STACK {
    int []  s ;
    int topOfStack  ;
 //  @@  CREATING A STACK  @@  //
    public STACK(int size) {
        this.s = new int [size];
        this.topOfStack = -1 ;
        System.out.println("STACK is created of size " + size);
    }

    //  @@  IS EMPTY  @@  //
    public boolean isempty() {
        if(topOfStack==-1) {
            return true ;
        }
        return false ;
    }

    //  @@  IS FULL  @@  //
    public boolean isfull() {
        if(topOfStack == s.length-1) {
            return true ;
        }
        return false ;
    }

    //  @@  PUSH { INSERTING AN ELEM IN STACK } @@  //
    public void STACK_PUSH(int value) {
        if(isfull()) {
            System.out.println("STACK IS FULL");
        }
        else {
            s[topOfStack + 1 ] = value ;
            topOfStack ++ ;
//            System.out.println("VALUE Is INSERTED");
        }
    }

    //  @@  POP { REMOVING TOP ELEM FROM AN STACK }  @@  //
    public int STACK_POP() {
        if(isempty()) {
            System.out.println("STACK IS EMPTY");
            return  -1 ;
        }
        else{
            int top = s[topOfStack];
            topOfStack -- ;  //  setting the top to below ELEM.
            return  top ;
        }
    }

    //  @@   PEEK METHOD { JUST RETURNS TOP ELEM OF STACK }   @@  //
    public int STACK_PEEK() {
        if(isempty()) {
            System.out.println("IS EMPTY");
            return  -1 ;
        }
        else {
            return s[topOfStack] ;
        }
    }

    //  { DELETING THE STACK }  //
    public void delete() {
        s = null ;
        System.out.println("DELETED THE STACK");
    }
}
public class sec04A_STACK_USING_ARRAY {
    public static void main(String [] args){
        // @@ STACK is data type that uses LIFO-(Last in First out ) @@ //
        // --> back button on browser uses STACK property to take you back to previous site u visited //
        // stack can be created using Linked List and Array //
         STACK st = new STACK(6);
        System.out.println(st.isempty());
        System.out.println(st.isfull());
        // ( ADDING ELEMENTS IN STACK ) //
        st.STACK_PUSH(20);
        st.STACK_PUSH(22);
        st.STACK_PUSH(30);
        st.STACK_PUSH(99);
        st.STACK_PUSH(70);
        st.STACK_PUSH(101);
        int temp = st.STACK_PEEK();
        System.out.println(temp);
        System.out.println(st.s[st.topOfStack]); //  --> printing the top of STACK  //
//        System.out.println(st.STACK_POP());
        System.out.println(st.s[st.topOfStack]); //  --> printing the top of STACK  //
        // @@  printing STACK in LIFO order  @@ //
        for(int i= st.topOfStack ; i>=0 ; i--)
        {
            System.out.print(st.s[i] + " ");
        }
        System.out.println(" ");
        st.delete();



        /*       COMPLEXITY CHART


        *                           TIME COMPLEXITY             SPACE COMPLEXITY
        *   CREATE STACK              O(1)                           O(1)
        *   PUSH                      O(1)                            O(1)
        *   POP                       O(1)                           O(1)
        *   PEEK                      O(1)                            O(1)
        *   isEmpty                   O(1)                             O(1)
        *   and isFull
        *   Delete                    O(1)                             O(1)
        * */

    }
}
