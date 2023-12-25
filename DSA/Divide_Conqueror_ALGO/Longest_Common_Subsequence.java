package DSA.Divide_Conqueror_ALGO;
// Subsequence means that the elements of the array are not necessarily contiguous but are in the same order.
// Longest Common Subsequence
// --> in this algo we have to find the longest common subsequence between two strings
// String 1 : "ABCDGH"
// String 2 : "AEDFHR"
// Longest Common Subsequence : "ADH" or "ADH"

class LCS{
    String s1;
    String s2 ;
    LCS(String s1 , String s2){
        this.s1 = s1;
        this.s2 = s2;
    }

    private int find_LCS(String s1 , String s2 , int i1 , int i2){
        if(i1 == s1.length() || i2 == s2.length()) return 0;
        if(s1.charAt(i1)==s2.charAt(i2)){
            return 1 + find_LCS(s1,s2,i1+1,i2+1);
        }
        int c1 = find_LCS(s1,s2,i1+1,i2); // count for deletion from s1
        int c2 = find_LCS(s1,s2,i1,i2+1); // count for deletion from s2
        return Math.max(c1,c2);
    }

    public void findLCS(){
        int lcs = find_LCS(s1,s2,0,0);
        System.out.println("Longest Common Subsequence : "+lcs);
    }
}

public class Longest_Common_Subsequence {
    public static void main(String[] args) {
        System.out.println("Longest Common Subsequence");
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        LCS lcs = new LCS(s1,s2);
        lcs.findLCS();
    }
}
