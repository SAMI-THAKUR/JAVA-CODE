package DSA.CODE;

import java.util.Arrays;
import java.util.Scanner;



class CQ{
    int [] arr;
    int top;
    int begin;
    int size;
    CQ(int size){
        this.size = size;
        arr = new int[size];
        top = -1;
        begin = -1;
        System.out.println("Circular Queue has been created");
    }

    /*------------------------EMPTY() & FULL()------------------------*/
    public boolean empty(){
        if(begin == -1){
            return true;
        }
        return false;
    }

    public boolean full(){
     if((top+1)%size==begin) {
         return true;
     }
        return false;
    }

    /*------------------------ENQUEUE------------------------*/
    public void enq(int data){
        if(full()){
            System.out.println("Queue is full");
        }
        else if(empty()){ // initialize the queue
            begin = 0;
            top++;
            arr[top] = data;
        }
      /*  else if(top == size-1){ // circulation
            top = 0;
            arr[top] = data;
        }*/

        else{             // normal case
            top = (top+1) % size; // circular increment of top
            arr[top] = data;
        }
    }

    /*------------------------DEQUEUE------------------------*/
    public int DQ(){
        if(empty()){
            System.out.println("IS EMPTY");
            return -1;
        }
        else{
            int a = arr[begin];

            if(begin == top){    // only one element is present
                begin = top = -1 ;
                System.out.println("Queue is empty now");
            }
         /*   else if (begin==size-1) {  // circulation
                begin = 0;
            } */
            else {
                begin = (begin+1) % size ; // circular increment of begin
            }
            return a;
        }
    }

    /*------------------------PEEK------------------------*/
    public int peek(){
        if(empty()){
            System.out.println("IS EMPTY");
            return -1;
        }
        else{
            return arr[begin];
        }
    }

    /*------------------------DISPLAY------------------------*/
    public void display() { // --> O(N)
        int temp = begin;
        if (empty()) {
            System.out.println("IS EMPTY");
        } else {
            while (temp != top) {
                System.out.print(arr[temp] + " ");
                temp = (temp + 1) % size;
            }
            System.out.print(arr[temp] + " ");
        }
    }

    /*------------------------DELETE------------------------*/
    public void delete(){
        arr = null;
        System.out.println("Queue has been deleted");
    }
}

public class sec05C_CIRCULAR_QUEUE {
  public static void main(String[] args)
  {
      // CIRCULAR QUEUE //
      // queue is a queue that can be implemented using a single dimensional array
      // in a circular queue, the last element points to the first element making a circle
      // the main advantage of a circular queue over a simple queue is better memory utilization
      // in a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue
      // but using a circular queue, we can use the space to insert the elements

      Scanner sc = new Scanner(System.in);
      CQ c = new CQ(6);
      c.enq(1);
      c.enq(2);
      c.enq(3);
      c.enq(4);
      c.enq(5);
      c.enq(6);
   /*   System.out.println(c.full());
      System.out.println(c.size);
      System.out.println(c.top);
      System.out.println(c.begin);
      */
      c.display();
      c.DQ();
      c.DQ();
      c.DQ();
      System.out.println("\nDisplaying");
      c.enq(0);
      c.enq(99);
      c.enq(100);
      c.display();

  }
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
        *  --> display                  O(n)            O(1)
        *
        */

