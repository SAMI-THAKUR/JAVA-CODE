package DSA.BASICS;
import java.util.*;

public class sec02_ARRAYS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
// ARRAYS ARE CONSECUTIVE MEMORY LOCATION
// CREATING AN ARRAY
//  --> DECLARING AN ARRAY
// --> INSTANTIATION AN ARRAY
        int[] arr = new int[10];    //  --> O(1)
// INITIALIZATION OF ARRAY
     arr[0]=12; //  inserting an element in array
     arr[1]=20; //   -->  O(N) --> N:- number of elements
     arr[2]=22; //
     arr[3]=35;
     arr[4]=90;
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {1,2,3,4,5,};  // all 2 steps in one step
        // --> time complexity  O(1)
        //  TRAVERSING AN ARRAY  //
        for (int i=0 ; i<arr.length ; i++) {
            System.out.println(arr[i]);
        }
        // FINDING AN ELEMENT IN ARRAY
        int find = sc.nextInt();
       int j = 0 ;
        for (int i=0 ; i<arr.length;i++) {
            if (find==arr[i]) {
                System.out.println("THE ELEMENT IS AT "+i);
                return;}
        }
        System.out.println(find + " is not found");
        //  DELETING AN ELEMENT IS ARRAY --> u cannot delete a array element because A array elem cannot be empty
        //  by deleting mean overwriting it with default array value//  2D ARRAY  //
        int[][]  arr2d = new int[2][3];  // --> instantiation and declare
        //  initializing an array
        arr2d[0][0]= 12;
        arr2d[0][1]=23;
        arr2d[1][0]=13;
        arr2d[1][1]=23;
       arr2d[1][2]=90;

        System.out.println(Arrays.deepToString(arr2d));  // prints 2d array
        System.out.println(arr2d[0].length);  // --> gives length of second bracket of 2d array
        // traversing an 2D array and printing it
        // accessing an array  and printing it
        for (int i=0 ; i<arr2d.length;i++)
        {
            for (int k=0 ;k<arr2d[0].length;k++)
            {
                System.out.print(arr2d[i][k] + " ");
            }
            System.out.println();
        }


    }
}
