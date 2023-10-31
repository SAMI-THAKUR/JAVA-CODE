package DSA.CODE;
// @@  USES  @@ //
//  --> FIFO
//  --> minimum manipulation of data

class QLL {
    int topofQ ;  // top of queue is tail of linked list
    int begofQ ;  // beg of queue is head of linked list
    SL sl ;

    public QLL() {
        sl = new SL();
    }
    public boolean isempty() {
        if (sl.head == null)
        {
            return true ;
        }
        return false ;
    }

    // @@  ENQUEUE METHOD {adding element at end of queue and shifting topQ to next}  @@ //
    public void enq(int val) {
        if (isempty()) {
           sl.insert_first(val);
        }
        else {
            sl.insert_last(val);
        }
    }

    // @@  DEQUEUE METHOD {removes the begQ elem and shifts begQ to next elem @@ //
    public  int DQ() {
        if(isempty()) {
            System.out.println("EMPTY");
            return -1 ;
        }
        else {
            int a = sl.head.value ;
            sl.head = sl.head.next ;
            if(sl.head == null) {
                System.out.println("EMPTIED");
            }
            return a ;
        }
    }

    // @@  PEEK METHOD  --> same as STACK @@ //
    public int peek() {
        if (isempty()) {
            System.out.println("is empty");
            return -1;
        }
        else {
            return sl.head.value ;
        }
    }

    public void del() {
        sl.head = null ;
        sl.tail = null ;
        System.out.println("DELETED");
    }
}
public class sec05B_QUEUE_USING_LINKEDLIST {
    public static void main(String[] args) {
        QLL q = new QLL();
        q.enq(2);
        q.enq(100);
        q.enq(300);
        System.out.println(q.DQ());
        System.out.println(q.peek());
       q.enq(101);
       q.DQ();
       q.enq(202);
//       q.DQ();
//       q.DQ();
       q.sl.display();
        System.out.println(q.begofQ);
    }
}



// @@  TIME AND SPACE COMPLEXITY  @@ //
        /*                              Time            Space
        *  --> create queue             O(1)            O(n)
        *  --> enqueue                  O(1)            O(1)
        *  --> dequeue                  O(1)            O(1)
        *  --> PEEK                     O(1)            O(1)
        *  --> is empty                 O(1)            O(1)
               is full
        *  --> delete                   O(1)            O(1)
        */