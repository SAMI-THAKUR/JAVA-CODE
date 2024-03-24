package DSA.LINKED_LIST;

import java.util.LinkedList;
import java.util.Scanner;
//  LINKED LIST IS MADE UP OF NODES its is also a data type
class NODE {
    int value;  //  --> DATA NODE
    NODE next;  // -->  REFERENCE NODE
     public NODE(int data) {
         this.value = data;   // adding data to data node
    }

}
//  LINKED LIST CLASS
class SL{
    NODE head;  // --> address of first node is stored in head
    NODE tail;  // --> address of last node is stored in tail
    int size=0; // size of LL

    // ##  inserting element at first or initializing LL  ##  //
    public void insert_first(int val) {
        NODE n = new NODE(val);

    n.next = head;  // --> reference node  been directed to head i.e previous first node
    head = n;  // head = new first node
   tail=n;
     size=size+1;

    }
    //  ##  INSERTING THE LAST NODE  ##  //
   public void insert_last(int val)
    {
        NODE n = new NODE(val);
        n.next=null; // if this is last node it should direct to null
        tail.next=n; // previous last node should direct to new node
        tail=n; // tail= new last node
        size +=1; // size incrementation
    }
    void insert(int val , int loca) {
        int target=0;
        NODE temp =head;
        // if head is null this is the initial node of LL therefore insert first
        if (head==null){
            insert_first(val);
        }  // if loc =0 should be added at first
        else if(loca==0) {
            NODE n = new NODE(val);
            n.next=head;
            head =n;
            size =size+1;
        } // if loc = size or greater should be added at last
        else if(loca>=size) {
            insert_last(val);
        }
        // adding element at A middle location
        else if(loca<size || loca>0){
            NODE n = new NODE(val);
            while (target < loca - 1) {
                temp = temp.next;
                target++;
            }
            n.next=temp.next;
            temp.next=n;
            size =size+1;
        }

    }
    void display() {     // printing an LINKED LIST
        NODE temp= head;
       while(temp!=null) {
           System.out.print(temp.value);
           if(temp.next != null){
               System.out.print(" --> ");
           }
           temp = temp.next;
       }
        System.out.println(" ");
    }
    //  ##  FINDING AN ELEMENT IN LINKED LIST  ##  //
    void find(int val) {
        if (head != null) {
            NODE temp = head;
            for (int i = 0; i < size; i++) {
                if (temp.value == val) {
                    System.out.println("found at " + i);
                    break;
                }
                temp = temp.next;
            }
        }
    }
    //  ##  deleting a node from single linked list
    void delete_node(int loc){
        if (loc==0){   // -->  deleting first node
            head=head.next;
            size =size-1;
            if (size==0){
                tail=null;
            }
        }
        else if(loc==size-1){   //  -->  deleting last node
            int target=0;
            NODE temp=head;
            while (target < loc-1) {
                temp = temp.next;
                target++;
            }
            if(temp==head){
                tail=head=null;
                size--;
            }
            temp.next=null;
            tail=temp;
            size=size-1;
        }
        else{   // --> deleting a middle node
            int target=0;
            NODE temp = head;
            while (target < loc-1) {  //  -->  reaching the node before the node to be deleted
                temp = temp.next;
                target++;
            }
            temp.next=temp.next.next;
            size=size-1;
        }
    }

    //  ###  REVERSING A LINKED LIST  ###  //
    void reverse(){
        NODE temp = head ;
        NODE t1 =  head;
        NODE t2 = tail ;
        NODE next = null;
        NODE prev =  null;
        while(temp!=null){
            next = temp.next;
            temp.next= prev ;
            prev = temp;
            temp = next;
        }
        head = t2 ;
        tail = t1 ;
    }

    //   ##  deleting the LINKED_LIST  ##  //
    void delete_entire(){
        head=null ;
        tail=null;
        size=0;
        System.out.println("DELETED THE LL");
    }
}




public class sec03A_SINGLE_LINKED_LIST{

    public static void main(String[] args) {
        // Linked List is a data structure which is made up of nodes
        // each node has a data and a reference to next node
        //  ##  creating a linked list  ##  //

        Scanner sc = new Scanner(System.in);
        SL s = new SL();

        s.insert_first(22);
        s.insert_last(20);
        s.insert(25,0);
        s.insert(255,9);
        s.insert(60,1);
        s.insert(101,3);

        s.display();

        NODE t = s.head;
//        //  ##  printing an LINKED LIST  ##  //
//        for (int i = 0; i<s.size; i++) {
//            System.out.print(t.value);
//            if (i!= s.size-1){
//                System.out.print("-->");
//            }
//            t= t.next;
//        }
        System.out.println();
        s.find(255);
//        s.delete_node(1);  // deleting the node at 1
        s.display();
        s.delete_node(2);  // deleting node at 3
        s.display();
        s.reverse();
        s.display(); // printing the reverse Linked List //
        s.delete_entire();


         //   ** TIME COMPLEXITY **   //
        /*
        * CREATION  --> O(1)
        * INSERTION --> O(n)
        * SEARCHING --> O(n)
        * TRAVERSING --> O(n)
        * DELETE NODE --> O(n)
        * DELETION OF L.L --> O(1)
        */

        //  ** SPACE COMPLEXITY ** //
        /*
        * CREATION --> O(1)
        * INSERTION --> O(1)
        * SEARCHING --> O(1)
        * TRAVERSING --> O(1)
        * */
        LinkedList<Integer> a = new LinkedList<Integer>();



    }
}
