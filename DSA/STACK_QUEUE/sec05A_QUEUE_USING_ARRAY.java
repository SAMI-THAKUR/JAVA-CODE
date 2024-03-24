package DSA.STACK_QUEUE;

class QUEUE
{
    int arr [] ;
    int topofQ ; // points to the top of queue
    int begofQ ; // points to the beg of queue

    public QUEUE( int size) {
        arr = new int[size];
        topofQ = -1 ;
        begofQ = -1 ;
        System.out.println("QUEUE is created");
    }

    // @@  is FULL method  @@ //
    public boolean isFULL() {
        if(topofQ == arr.length -1)
        {
             return true ;
        }
        return false ;
    }

    // @@  is EMPTY method  @@ //
    public boolean isEMPTY() {
        if(topofQ == -1 || begofQ == arr.length)
            // begofQ == arr.length is for the case when we have dequeued all the elements and begofQ is at the end of array
        {
            return true ;
        }
        return false ;
    }

    /*-------------------ENQUEUE METHOD----------------*/
    // {adding element at end of queue and shifting topQ to next}
    public void enq(int value) {
        if(isFULL())
        {
            System.out.println("is FULL");
        }
        else if(isEMPTY()){
            begofQ = 0 ;
            topofQ ++ ;
            arr[topofQ] = value ;
        }
        else {
            topofQ++ ;
            arr[topofQ]=value;
        }
    }

    /*-----------DEQUEUE METHOD-----------------*/
    // {removes the begQ elem and shifts begQ to next elem}
    public int DQ() {
        if(isEMPTY())
        {
            System.out.println("EMPTY");
            return -1 ;
        }
        else {
            int a = arr[begofQ];
            if (begofQ == topofQ){
                begofQ = topofQ = -1 ;
                System.out.println("QUEUE is emptied");
            }
            else {
                begofQ++;
            }
            return a ;
        }
    }

    /*--------------PEEK METHOD--------------*/
    public int peek() {
        if (isEMPTY())
        {
            System.out.println("is empty");
            return -1;
        }
        else {
            return arr[begofQ];
        }
    }

    public void del()
    {
        arr = null ;
        System.out.println("QUEUE is deleted");
    }
}
public class sec05A_QUEUE_USING_ARRAY {
    public static void main(String[] args) {
        //  QUEUE uses FIFO { first in first out }
        QUEUE q = new QUEUE(5);
        System.out.println(q.isEMPTY());
        q.enq(101);
        q.enq(303);
        q.enq(102);
        q.enq(500);
        q.enq(900);
        q.enq(10001);
        System.out.println(q.peek());
        System.out.println(q.DQ());
        q.DQ();
        q.DQ();
        q.DQ();
        q.DQ();

        System.out.println(q.isEMPTY());
        System.out.println(q.isFULL());


        for (int i=q.begofQ ; i<=q.topofQ ; i++)
        {
            System.out.print(q.arr[i] + "-->");
        }



        // @@  TIME AND SPACE COMPLEXITY  @@ //
        /*                              Time            Space
        *  --> create queue             O(1)            O(1)
        *  --> enqueue                  O(1)            O(1)
        *  --> dequeue                  O(1)            O(1)
        *  --> PEEK                     O(1)            O(1)
        *  --> is empty                 O(1)            O(1)
                  full
        *  --> delete                   O(1)            O(1)
        * */
    }
}
