package DSA.CODE_SHEET.ARRAYS;


import java.util.Arrays;

public class sec01_Array {
    //-------- 1. Reverse A array of String --> O(n) ---------//
    public static String reverseString(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while(i < j){
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
        return new  String(arr);
    }

    //-------- 2. Max and Min in an array --> O(n) ----------//
    // return max+min
    public static int max_min(int []arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
        }
        return max+min;
    }

    //-------- 3. Find the "Kth" min element of an array --> O(n) ----------//
    public static int Kmin(int []arr,int k){ // --> using sorting
        Arrays.sort(arr);
        return arr[k-1]; // in case of max element return arr[arr.length-k]
    }
    // another approach is to use min heap // O(nlogk)


    //----- 4. Sort an array of 0s, 1s and 2s {Dutch National Flag problem} --> O(n) --------//
    public static int [] sort012(int a[]){
        int low = 0;
        int mid = 0;
        int high = a.length - 1;     // three pointers
        int temp;
        while (mid <= high) {
            if (a[mid] == 0) {
                if(mid==low){
                    low++;
                    mid++;
                    continue;
                }
                temp = a[mid];
                a[mid]=a[low];
                a[low]=temp;
                low++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else if (a[mid] == 2) {
                temp = a[mid];
                a[mid]=a[high];
                a[high]=temp;
                high--;
            }
        }
        return a;
    }

    //----- 5. Move all the negative elements to one side of the array --> O(n) --------//
    public static int [] separate(int [] a) {
        int low = 0 ;
        int high = a.length-1; // two pointers
        int temp;
        while(low<=high){
            if(a[high]<0){
               temp = a[high];
               a[high]=a[low];
               a[low]=temp;
               low++;
            }
            else if(a[high]>=0){
                high--;
            }
        }
        return a;
    }

    //----- 6. Find the Union and Intersection of the two sorted arrays. --------//
    // returns the number of elements in union
    public static int union(int [] a , int [] b){
        int re=0;
        int [] uni = new int[1000001];
        for(int i:a){
            uni[i]++;
        }
        for(int i:b){
            uni[i]++;
        }

        for(int i=0 ; i<uni.length ;i++) {
            if (uni[i] > 0) {
                re++;
            }
            // for intersection
//            if(uni[i]>1){
//               //
//            }
        }
        return re ;
        // can also be solved using hashset which only contains unique elements //
    }

    //----- 7.Rotate an array one time --------//
    public static void rotate(int arr[], int n)
    {
        for(int i=0 ; i<n-1 ;i++){
            int temp=arr[n-1];
            arr[n-1]=arr[i];
            arr[i]=temp;
        }
    }


    public static void main(String[] args) {

        int test [] = {1,2,3,4,5,6,7,8,9,10}; // for max_min, Kmin
        int test1[] = {0,1,2,0,1,2}; // for sort012
        int test2[] = {-1,2,5,7,-10,44,-90,-11}; // for separate -ve and +ve

        // 1. Reverse A array of String
        System.out.println(reverseString("SAMI")); // IMAS

        // 2. Max and Min in an array
        System.out.println(max_min(test));            // 11

        // 3. Find the "Kth" min element of an array
        System.out.println(Kmin(test,3));          // 3

        // 4. Sort an array of 0s, 1s and 2s {Dutch National Flag problem}
        String s = Arrays.toString(sort012(test1));
        System.out.println(s);                        // [0, 0, 1, 1, 2, 2]

        // 5. Move all the negative elements to one side of the array
        String s1 = Arrays.toString(separate(test2));
        System.out.println(s1);                      // [-11, -1, -90, -10, 7, 44, 5, 2]

        // 6. Find the Union and Intersection of the two sorted arrays.
        System.out.println(union(test,test1));        // 11

        // 7. Rotate an array one time
        rotate(test,10);
        System.out.println(Arrays.toString(test));   // [10, 1, 2, 3, 4, 5, 6, 7, 8, 9]



    }
}
