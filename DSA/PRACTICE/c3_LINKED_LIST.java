package DSA.PRACTICE;

import java.util.ArrayList;

//  @@@   THE NODE CLASS   @@@  //
  class Node {
     int value;
     Node next;
     Node() {}
     Node(int val) { this.value = val; }
     Node(int val, Node next) { this.value = val; this.next = next; }
 }
 //  @@@   THE LINKED LIST CLASS   @@@  //
 class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    public void createLL(int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public void insertNode(int nodeValue) {
        if (head == null) {
            createLL(nodeValue);
            return;
        }
        //  @@ inserting the node at last simply  @@ //
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
        size++;
    }
//   ###  TRAVERSING A LL  ###   //
    public void traversalLL() {
        Node tempNode = head;
        for (int i =0; i<size; i++) {
            System.out.print(tempNode.value);
            if (i != size -1) {
                System.out.print(" -> ");
            }
            tempNode = tempNode.next;
        }
        System.out.println("\n");
    }

      //   REMOVING DUPLICATE FROM Linked List //
      void remove_dup(LinkedList n){
         ArrayList<Integer> a = new ArrayList<Integer>();
         Node curr = n.head ;
          a.add(curr.value);
         curr = curr.next ;

         Node prev = null ;
         while(curr != null){
             if(a.contains(curr.value)){
                 // DELETING THE NODE //
                 prev.next = curr.next;
                 size--;
             }
             else {
                 a.add(curr.value);
                 prev = curr ;
             }

             curr = curr.next ;

         }
    }
    //  @@  PRINTING Nth element from last  @@  //
void N_ele(LinkedList l , int n){
        int m =  size - n ;
        Node temp = l.head ;
        for(int i=0 ; i < m ;i++)
        {
            temp = temp.next ;
        }
    System.out.println(temp.value);
}
//  @@   If size of Linked List is not specified use this method  @@ //
     void NthtoLast (LinkedList l1 , int n){
        Node a1 = l1.head ;
        Node a2 = l1.head ;
        for(int i =0 ; i<n; i++)
        {
           if(a2!=null){
               a2 = a2.next ;
           }
           else {
               System.out.println("ERROR");
           }
        }
        while(a2 != null)
        {
            a2 = a2.next;
            a1 = a1.next;
        }
         System.out.println(a1.value);
     }
}

public class c3_LINKED_LIST {

    public static void main(String [] args){

        LinkedList l =  new LinkedList();

        l.createLL(5);
        l.insertNode(2);
        l.insertNode(1);
        l.insertNode(2);
        l.insertNode(5);
        l.insertNode(20);
        l.insertNode(3);


        l.N_ele(l,2);
        l.NthtoLast(l,2);
        l.traversalLL();
        l.remove_dup(l);
        l.traversalLL();


    }
}
