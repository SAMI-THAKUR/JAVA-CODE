package PRACTICE;
class Node{
    int value ;
    Node next ;
    public Node(int data , Node n) {
        this.value = data;   // adding data to data node
        next = n ;
    }
}
// in this approach if check what is the min value according to every level of stack while push time //
class MinStack {
    Node top ;
    Node min ;

    public MinStack() {
        top = null;
        min = null ;
    }

    public void push(int val) {

        if(min == null){
            min = new Node(val , min ) ;  // assigning min new node and min.next the previous min node //
        }
        else if(min.value < val)
        {
            min = new Node(min.value , min);  // assigning min new node and min.next the previous min node //
            System.out.println(min.value);
        }
        else{
            min = new Node(val , min );   // assigning min new node and min.next the previous min node //
            System.out.println(min.value);
        }
        top = new Node(val , top);
    }

    public void pop() {
        min = min.next ;
        int result = top.value ;
        top = top.next ;

    }

    public int top() {
        return top.value ;
    }

    public int getMin() {
        return min.value ;
    }
 public void  dis ()
 {
     while(min!=null)
     {
         System.out.print(min.value + " ");
         min = min.next ;
     }

 }

}
public class p5 {
    public static void main(String[] args) {
        MinStack s = new MinStack();
//        s.push(2);
//        s.push(1);
//        s.push(0);
        s.push(6);
//        s.push(8);
        s.push(4);
        s.dis();

    }
}
