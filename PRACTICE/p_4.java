package PRACTICE;

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
        if(top == -1){
            return true;
        }
        return false;
    }
    public boolean full(){
      if((top+1)%size==begin){
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
        else if(top == size-1){ // circulation
            top = 0;
            arr[top] = data;
        }
        else{             // normal case
            top++;
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
            arr[begin]=0;
            if(begin == top){    // only one element is present
                begin = top = -1 ;
                System.out.println("Queue is empty now");
            } else if (begin==size-1) {  // circulation
                begin = 0;
            } else {                   // normal case
                begin++;
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
    public void display(){ // --> O(N)
        if(empty()){
            System.out.println("IS EMPTY");
        }
        else{
            do{
                System.out.print(arr[begin]+" ");
                if(begin == size-1 && begin!=top){  // circulation
                    begin = 0;
                }
                else{
                    begin++;
                }
            }while (begin != top+1);
        }
    }

    /*------------------------DELETE------------------------*/
    public void delete(){
        arr = null;
        System.out.println("Queue has been deleted");
    }
}

public class p_4 {
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
        c.DQ();
        c.enq(7);
        c.enq(9);
        System.out.println(c.full());


        System.out.println("Displaying");
        c.display();


    }
}