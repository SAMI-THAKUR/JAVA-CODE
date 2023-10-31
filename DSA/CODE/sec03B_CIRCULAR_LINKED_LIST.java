package DSA.CODE;

class CNODE{
    CNODE next;
    int data;

    public CNODE(int data) {
        this.data = data;
    }
}
class CLL{
    CNODE head;
    CNODE tail ;
    int size=0;
    // ###  insert element at 1st position i.e 1st NODE  ###  //
    void insert_first(int data) {
        CNODE n = new CNODE(data);
        if (head==null){  // --> if head is null i.e CLL DNE
            head = n;
            n.next=head; // as this is circular LL the last node should point to head node
            tail=head;
            size += 1;
        }
    }
    void insert_last(int data){   // putting node at LAST of CLL
        CNODE n = new CNODE(data);
        n.next=head;  // as this is CLL last node must point at head;
        tail.next=n;
        tail=n;
        size +=1;
    }
    //  *************************************  //
    //  inserting a node at given location from 0 --> size-1
  void insert(int value,int loc){
     if (head==null) {  // if head is null initializing the CLL
insert_first(value);
      }
     else   if (loc==0){  // if loc is A insert at first
       CNODE n = new CNODE(value);
       n.next= head;
       head=n;
       tail.next=n;
       size +=1;
    }
     else if (loc>=size){  // if loc is grater the size then insert at last
        insert_last(value);
    }
    else {   // inserting in middle location
        CNODE n = new CNODE(value);
        CNODE temp = head;
        int target =0;
         while (target < loc - 1) {
             temp = temp.next;
             target++;
         }
    n.next=temp.next;
        temp.next=n;
        size +=1;
    }
    }
    //  *********************************   //
    //   ###   PRINTING AN LINKED LIST   ###  //
    void display(){

        //  traversing a linked list
     int target =0;
     CNODE temp  = head ;
     while (target <= size-1){
         System.out.print(temp.data +  " ");
         if(target != size -1){
             System.out.print(" --> ");
         }
         temp= temp.next;
         target ++ ;
     }

        System.out.println();
    }
    //   ******************************   //
    //   ###   DELETING A NODE IN CLL    ###  //
    void delete(int loc){
        if (head==null){
            System.out.println("CLL DNE");
        }
        else if(loc==0){   // deleting a first NODE in CLL
            head = head.next;
            tail.next=head;
            size =size-1;
        } else if (loc>=size-1) {   // deleting last node in CLL
            int target=0;
            CNODE temp=head;
            while (target<size-2) {  // size is 6 if we want temp to point at 5
                temp = temp.next;
                target ++;
            }

            temp.next=head;
            tail=temp;
            size=size-1;
        }
        else {   // deleting a middle NODE in CLL
            int target=0;
            CNODE temp = head;
            while (target < loc-1) {
                temp = temp.next;
                target++;
            }
            temp.next=temp.next.next;
            size=size-1;
        }
    }
    //   ###  SEARCHING DSA.ALGO  ###  //  --> same as single LL
    void SEARCh(int val){
        int target =0;
        CNODE temp = head;
        while(target<size){
            if (temp.data==val){
                System.out.println("found at " + target);
                break;
            }
            target ++;
            temp= temp.next;
        }
    }
    void reverse(){
        CNODE temp = head ;
        CNODE t1 =  head;
        CNODE t2 = tail ;
        CNODE next = null;
        CNODE prev =  null;
        while(temp.next!=null){
            next = temp.next;
            temp.next= prev ;
            prev = temp;
            temp = next;
        }
        head = t2 ;
        tail = t1 ;
    }
    void delete(){
        head=null;
        tail.next=null;
        tail=null;
        size=0;
    }
    }
public class sec03B_CIRCULAR_LINKED_LIST {
    public static void main(String[] args) {
        CLL cir = new CLL();
        cir.insert_first(12);
        cir.insert_last(25);
       cir.insert(30,2);
//        System.out.println(cir.tail.next.data);  // as tail points the last node and in CLL last node points head it should print value of first node
        cir.insert(50,1);
        cir.insert(100,3);
        cir.insert(200,0);
        System.out.println("before delete");
        cir.display();
//        cir.delete(4);
//        cir.delete(3);
//        cir.delete(2);
//        cir.delete(1);
//        cir.delete(1);
        cir.display();
        cir.SEARCh(12);  // searching element 12 in CLL
        cir.reverse();
        cir.display();
        cir.delete();  // deleting the whole LL
        cir.display();
        System.out.println(cir.size);

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


    }
}
