package DSA.CODE_SHEET.ARRAYS;

public class sec02_Array {
    //-------- 8. Find the single duplicate element in an array of integers --> O(n) ---------//
    public static int duplicate(int [] a){
        boolean [] visited = new boolean[a.length];
        for (int i=0 ;i<a.length;i++){
            if(visited[a[i]]){
                return a[i];
            }
            visited[a[i]] = true;
        }
        return 0;
    }
    public static void main(String[] args) {
        // 8. Find the single duplicate element
        int [] a = {1,2,3,4,5,6,7,8,9,10,11,12,12};
        System.out.println(duplicate(a));
    }
}
