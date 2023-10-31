package DSA.CODE;

import java.util.EmptyStackException;

class HEAP{
    int [] arr ;
    int sizeoftree ;
    String type;
    HEAP(int size,String type){
        sizeoftree=0;
        arr = new int[size+1];
        this.type = type;
    }
//----------PEEK------------//
    public int PEEK(){
        if(sizeoftree==0){
            System.out.println("Heap is empty");
            return -1;
        }
        return arr[1];
    }

//---------- EMPTY & FULL ------------//
    public boolean isEMPTY(){
        if(sizeoftree==0){
            return true;
        }
        return false;
    }

    public boolean isFULL(){
        if(sizeoftree==arr.length-1){
            return true;
        }
        return false;
    }


    public int Size(){
        return sizeoftree;
    }

    public void level(){
        for (int i=1;i<=sizeoftree;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }

//---------- INSERT ------------//
    public void heapify(int n , String type){
        int parent = n/2;
       if(n<=1){
           return;
       }
       if(type == "Min"){
           if(arr[n]<arr[parent]){
               int temp = arr[n];
               arr[n] = arr[parent];
               arr[parent]=temp;
           }
       }else if(type == "Max"){
           if(arr[n]>arr[parent]){
               int temp = arr[n];
               arr[n] = arr[parent];
               arr[parent]=temp;
           }
       }
    heapify(parent,type);
    }

    public void insert(int n){
        if(isFULL()){
            System.out.println("FULL");
            return;
        }
        sizeoftree++;
        arr[sizeoftree]=n;
        heapify(sizeoftree,type);
    }

// --- EXTRACT AN ELEMENT FROM BINARY HEAP --- //
    // only root node can be extracted from Binary Heap //
public void heapifyToptoBottom(int n,String type){
        int left = 2*n;
        int right = 2*n + 1 ;
        int swapchild = sizeoftree+1;
     if(left>sizeoftree){
         return;
     }
     if(type=="Max"){
         // last child of tree //
         if(sizeoftree==left){
             if(arr[n]<arr[left]){
                 int temp = arr[n];
                 arr[n] = arr[left];
                 arr[left]=temp;
             }
         }else {
             if(arr[left]>arr[right]){
                 swapchild = left;
             }else {
                 swapchild = right;
             }

             if(arr[n]<arr[swapchild]){
                 int temp = arr[n];
                 arr[n] = arr[swapchild];
                 arr[swapchild]=temp;
             }
         }
     } else if (type=="Min") {
         if(sizeoftree==left){
             if(arr[n]==left){
                 if(arr[n]>arr[left]){
                     int temp = arr[n];
                     arr[n] = arr[left];
                     arr[left]=temp;
                 }
             }else {
                 if(arr[left]<arr[right]){
                     swapchild = left;
                 }else {
                     swapchild = right;
                 }
                 if(arr[n]>arr[swapchild]){
                     int temp = arr[n];
                     arr[n] = arr[swapchild];
                     arr[swapchild]=temp;
                 }
             }
         }

     }
     heapifyToptoBottom(swapchild , type);
}

public int extract(){
        if(isEMPTY()){
            return -1;
        }
        int a = arr[1];
        arr[1]=arr[sizeoftree];
        sizeoftree--;
        heapifyToptoBottom(1,type);
        return a;
}

public void delete(){
        arr = null ;
}
}
public class sec09_BINARY_HEAP {
    // Uses
    // 1. Priority Queue
    // 2. Prim's Algorithm
    // #. Heap Sort
    public static void main(String[] args) {
        // Heap is a complete binary tree
        // Heap is either a min heap or a max heap
        // Min heap: parent node is smaller than its children
        // Max heap: parent node is larger than its children
        // Heap is not a sorted data structure

        // Heap is implemented using an array
         HEAP h = new HEAP(6,"Max");
         h.insert(11);
         h.insert(20);
         h.insert(5);
         h.insert(90);
         h.insert(101);
         h.insert(102);



         h.level();
         System.out.println(h.extract());
         System.out.println(h.extract());
         h.level();



    }
}
