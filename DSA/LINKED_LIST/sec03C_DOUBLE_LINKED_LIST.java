package DSA.LINKED_LIST;
//   DOUBLE LL NODE
class DNODE{
    int data ;  // main content of node
    DNODE prev ;  // next node address
    DNODE next ;  // prev node address
    public DNODE(int data) {
        this.data = data;
    }
}
class DLL{
DNODE head ;
DNODE tail ;
int size = 0 ;
void first_node(int val){
    DNODE n = new DNODE(val);
    n.next=null;
    n.prev=null;
    head = n ;
    tail = n ;
    size ++ ;
}
void insert_last(int val){
    DNODE n = new DNODE(val);
    n.prev=tail;
    n.next=null;
    tail.next=n;
    tail = n;
    size ++ ;

}
    void insert(int val , int loca) {
        int target=0;
        DNODE temp =head;
                        // if head is null this is the initial node of DLL therefore insert first
        if (head==null){
            first_node(val);
        }                    //  ##  if loc =0 should be added at first  ##  //
        else if(loca==0) {
            DNODE n = new DNODE(val);
            n.next=head;
            n.prev=null;
            head.prev = n ;
            head =n;
            size ++;
        }
                               //  ##  if loca is greater than size  ##  //
        else if(loca>=size){
            insert_last(val);
        }
                           // ## ADDING A NODE AT GENERAL LOCATION ##  //
        else if(loca<size || loca>0){

            DNODE n = new DNODE(val);
            while (target < loca - 1) {
                temp = temp.next;
                target++;
            }
            n.prev=temp;
            n.next=temp.next;
            temp.next.prev=n;
            temp.next= n;
            size =size+1;
        }

    }
    void display() {                //  ##    -->   PRINTING THE LINKED LIST  ## //
        DNODE temp= head;
        while(temp!=null) {
            System.out.print(temp.data + " ");
            if(temp.next != null){
                System.out.print(" --> ");
            }
            temp = temp.next;
        }
        System.out.print("\n");
    }
                            //  ##   -->  PRINTING A LINKED LIST IN REVERSE  ##  //
    void display_rev(){
    DNODE temp = tail;
    while(temp!=null){
        System.out.print(temp.data + " ");
        if(temp.prev != null){
            System.out.print("<-- ");
        }
        temp =temp.prev;
    }
        System.out.print("\n");
    }
                       //  **  FINDING A ELEMENT IS SAME AS SINGLE LINKED LIST  **  //
                                  //  ##  DELETING A NODE IN D.L.L  ##  //
    void delete(int loc){
    if(loc==0){
       head = head.next;
       head.prev=null;
       size -- ;
    }
        else if (loc >= size - 1) {
            DNODE temp = head;
            int target = 0;
            while(target < size-2){
                temp = temp.next;
                target ++ ;
            }
            tail.prev = null;
            tail = temp ;
            temp.next=null;
            size--;
        }
        else if(loc<size-1 && loc>0){
            DNODE temp = head ;
            int target =0;
            while(target < loc-2){
                temp = temp.next;
                target ++ ;
            }
            temp.next= temp.next.next;
            temp.next.prev = temp ;
            size -- ;
        }
   }
                       //  ##   REVERSING A DOUBLE LINKED LIST  ##  //
    void reverse (){
DNODE temp = head ;
DNODE t1 = head ;
DNODE t2 = tail ;
while(temp != null){
    DNODE next = temp.next;
    DNODE swap = temp.next;
    temp.next = temp.prev;
    temp.prev = swap ;
    temp = next ;
}
DNODE swap1 = head ;
head = tail;
tail = swap1 ;
    }
    //  ##  DELETION OF ENTIRE DLL  ##  //
    void delete_entire(){
    DNODE temp  = head ;
    while (temp != null){
        temp.prev=null;
        temp=temp.next;
    }
    head = null;
    tail.next=null;
    tail=null;
        System.out.println("Double Linked List is deleted");
    }
}
public class sec03C_DOUBLE_LINKED_LIST {
    public static void main(String[] args) {
        System.out.println("DOUBLE LINKED LIST");
        DLL db = new DLL();
        db.first_node(25);
        db.insert_last(30);
        db.insert(101,0 );
        db.insert(1001,2);
        db.insert(500,4);
        System.out.println(db.head.data);
        System.out.println(db.tail.data);
        System.out.println("DOUBLE LINKED LIST :-");
        db.display();
        System.out.println("DOUBLE LINKED LIST IN REVERSE :-");
        db.display_rev();
        System.out.println("REVERSING THE DLL :-");
        db.reverse();
        db.display();
        db.delete(0); //  --> deleting (25) from DLL
        db.delete(3); //  --> deleting (101) from DLL
        db.delete(2); //  --> deleting 90 from DLL
        System.out.println("AFTER NODES DELETION :-");
        db.display();
        System.out.println(db.size);


        //   ** TIME COMPLEXITY **   //
        /*
         * CREATION  --> O(1)
         * INSERTION --> O(n)
         * SEARCHING --> O(n)
         * TRAVERSING --> O(n)
         * DELETE NODE --> O(n)
         * DELETION OF L.L --> O(n)  --> (more than circular and single)
         */

        //  ** SPACE COMPLEXITY ** //
        /*
         * CREATION --> O(1)
         * INSERTION --> O(1)
         * SEARCHING --> O(1)
         * TRAVERSING --> O(1)
         * */


    }
}
