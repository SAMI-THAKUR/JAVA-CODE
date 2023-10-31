package DSA.PRACTICE;
class NodeS{
    int value ;
    NodeS next ;
    public NodeS(int data , NodeS n) {
        this.value = data;   // adding data to data node
        next = n ;
    }
}
// in this approach if check what is the min value according to every level of stack while push time //
class MinStack {
    NodeS top ;
    NodeS min ;

    public MinStack() {
        top = null;
        min = null ;
    }

    public void push(int val) {

        if(min == null){
            min = new NodeS(val , min ) ;  // assigning min new node and min.next the previous min node //
        }
        else if(min.value < val)
        {
            min = new NodeS(min.value , min);  // assigning min new node and min.next the previous min node //
            System.out.println(min.value);
        }
        else{
            min = new NodeS(val , min );   // assigning min new node and min.next the previous min node //
            System.out.println(min.value);
        }
        top = new NodeS(val , top); // assigning top the new value and previous top to top.next
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
    public void  dis_min()
    {
        while(min!=null)
        {
            System.out.print(min.value + " ");
            min = min.next ;
        }
        System.out.println();

    }
public void dis()
{
    while(top!= null){
        System.out.print(top.value + " ");
        top = top.next;
    }
    System.out.println();
}
}
public class c4A_MINIMUM_STACK {
    public static void main(String[] args) {
        MinStack s = new MinStack();
//        s.push(2);
//        s.push(1);
//        s.push(0);
        s.push(6);
        s.push(8);
        s.push(4);
        s.dis_min();
        s.dis();
    }
}
