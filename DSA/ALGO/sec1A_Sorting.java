package DSA.ALGO;

import java.util.Arrays;

public class sec1A_Sorting {
    public static void swap(int i1 , int i2 , int [] a){
        int temp = a[i1];
        a[i1]=a[i2];
        a[i2]=temp;
    }

    // --- Bubble Sort --- // --> Time: O(N^2)  --> Space: O(1)
    public static int [] Bubble_Sort (int [] a){
        int sort [] = a;
        int n = sort.length;
        for (int i=0 ; i<n-1 ; i++){
            for (int j=0 ; j<n-i-1 ; j++){
                if(a[j]>a[j+1]){
                    swap(j,j+1,sort);
                }
            }
        }
        return sort;
        // use //
        // --> when input is almost sorted //
        // --> Space is concerned
        // --> Easy implement
    }

    // --- Selection Sort --- // --> Time: O(N^2)  --> Space: O(1)
    public static int [] Selection_Sort(int [] a){
        int sort [] = a;
        int n= sort.length;
        for (int i=0 ; i<n ; i++){
            int minIndex = i;
            for (int j=i+1 ; j<n ; j++){
                if(a[j]<a[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex!=i){
                swap(i,minIndex,sort);
            }
        }
        return sort;
    }

    public static int [] Insertion_Sort(int [] a){
        int sort [] = a;
        int n = sort.length;
        for (int i=1 ; i<n ; i++){
            int temp = sort[i];
            int j = i;
            while (j>0 && sort[j-1]>temp){
                sort[j] = sort[j-1];
                j--;
            }
            sort[j]=temp;
        }
        return sort;
    }
    public static void main(String[] args) {
        // Types of Sorting
        // ## Space --> Inplace , Not Inplace
        // Inplace : No extra space is required  // Bubble Sort
        // Not Inplace : Extra space is required // Merge Sort
        // ## Stability --> Stable , Unstable
        // Stable : Relative order of elements with same value is maintained       // Bubble Sort
        // Unstable : Relative order of elements with same value is not maintained // Selection Sort


        int arr [] = {1,3,5,2,7,9,4,6,8,10};
        System.out.println(Arrays.toString(Bubble_Sort(arr)));
        System.out.println(Arrays.toString(Selection_Sort(arr)));
        System.out.println(Arrays.toString(Insertion_Sort(arr)));
    }
}
