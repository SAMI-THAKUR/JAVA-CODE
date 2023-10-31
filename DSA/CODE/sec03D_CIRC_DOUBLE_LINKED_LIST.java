package DSA.CODE;
class CDNODE{
    CDNODE next;  // contains loc. for next node
    CDNODE prev;  // contains loc. for prev node
    int data ;  //  main value of NODE
public CDNODE(int data) {
        this.data = data;
    }
}
class CDLIST{
    CDNODE head ;
    CDNODE tail ;
    int size = 0 ;
    void insert_first(int val){
        CDNODE n = new CDNODE(val);
        head = n;
        tail = n;
        n.next=head;
        n.prev =tail;
        size ++;
    }
    void insert_last(int val){
        CDNODE n = new CDNODE(val);
        n.next=head;
        n.prev=tail;
       tail.next = n;
        tail = n;
        size ++ ;
    }
    void insert(int val , int loc){
        CDNODE n = new CDNODE(val);
        if (head==null)  //  ##  IF head is null create a linked list  //
        {
            insert_first(val);
        }
       else if(loc==0){   //  ##  IF loc is 0 insert at FIRST  //
       n.prev=tail;
       n.next=head;
       head.prev=n;
       head=n;
            size++ ;
       }
else if(loc>size-1){  //  ##  IF loc is greater than size-1 insert at LAST  //
     insert_last(val);
        }
else if(loc==size-1){  //  ##  IF loc is size-1
    n.next = tail ;
    n.prev = tail.prev ;
    tail.prev.next = n ;
    tail.prev = n ;
            size++ ;
        }
else{
    int target = 0;
    CDNODE temp = head ;
    while(target<loc-1){
        temp = temp.next ;
        target ++ ;
    }
    n.prev = temp ;
    n.next = temp.next ;
    temp.next.prev = n ;
    temp.next = n ;
    size ++ ;
        }
    }
    void display(){
        //  traversing a linked list
        int target =0;
        CDNODE temp  = head ;
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
    //   ##   PRINTING  DOUBLE LL  in  reverse  ##   //
    void reverse_display(){
        int target =0;
        CDNODE temp  = tail ;
        while (target <= size-1){
            System.out.print(temp.data +  " ");
            if(target != size -1){
                System.out.print(" --> ");
            }
            temp= temp.prev;
            target ++ ;
        }
        System.out.println();
    }
    //   ##    DELETING A NODE FROM DOUBLE LINKED LIST   ##  //
    void delete(int loc)
    {
        if(loc==0){
            head.next.prev = tail ;
            head = head.next ;
            tail.next = head ;
            size -- ;
        }
        else if(loc>=size-1){
           tail.prev.next = head ;
           tail.next = null;
           tail = tail.prev;
           size-- ;
        }
        else{
            CDNODE temp = head ;
            int target =0;
            while(target < loc-1){
                temp = temp.next;
                target ++ ;
            }
            temp.next= temp.next.next;
            temp.next.prev = temp ;
            size -- ;
        }
    }
    //  ###   REVERSING A CIRCULAR DOUBLE LINKED LIST   ###   //
    void rev(){
        CDNODE temp =  head ;
        int t = 0;
        CDNODE t1 =  head ;
        CDNODE t2 =  tail ;
        CDNODE next = null ;
        CDNODE prev =  tail ;
        while (t<=size){
            next = temp.next ;
            temp.next = prev ;
            prev =  temp ;
            temp =  next ;
            t++ ;
        }
        head = t2 ;
        tail = t1 ;
    }
}
public class sec03D_CIRC_DOUBLE_LINKED_LIST {
    public static void main(String [] args){
        System.out.println("CIRCULAR DOUBLE LINKED LIST");
        CDLIST cd  = new CDLIST();
        cd.insert_first(20);
        cd.insert_last(101);
        cd.insert(500,0);
        cd.insert(300,2);
        cd.insert(401,7);
        cd.insert(900,2);
        cd.display();
//        cd.delete(5);  // deleting  405 from CD LL
//        cd.delete(1);    // deleting 20 from CD  LL
//        cd.delete(1);    //  deleting 900 from  CD LL


        cd.display();
        cd.reverse_display();
cd.rev();
cd.display();
        //   #**#  TIME COMPLEXITY  #**#   //
        /*
       #**  --->  same as DOUBLE LINKED LIST   **#
         * CREATION  --> O(1)
         * INSERTION --> O(n)
         * SEARCHING --> O(n)
         * TRAVERSING --> O(n)
         * DELETE NODE --> O(n)
         * DELETION OF L.L --> O(n)  --> (more than circular and single)
         */

        //  #**#  SPACE COMPLEXITY  #**#  //
        /*
         * CREATION --> O(1)
         * INSERTION --> O(1)
         * SEARCHING --> O(1)
         * TRAVERSING --> O(1)
         * */
    }
}
