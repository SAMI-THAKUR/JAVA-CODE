package DSA.DIVIDE_CONQ;


class LPS {
    String s ;
    LPS(String s){
        this.s = s;
    }

    private int find_LPS(String s , int i1 , int i2){
        if(i1==i2) return 1;
        if(s.charAt(i1) == s.charAt(i2)) return 2 + find_LPS(s,i1+1,i2-1);
        int c1  = find_LPS(s,i1+1,i2); // count for deletion from front
        int c2 = find_LPS(s,i1,i2-1); // count for deletion from back
        return Math.max(c1,c2);
    }

    public void findLPS(){
        int lps = find_LPS(s,0,s.length()-1);
        System.out.println("Longest Palindromic Subsequence : "+lps);
    }


}


public class Longest_Palindromic_Subsequence {
    public static void main(String[] args) {
        String s = "agbcba";
        LPS lps = new LPS(s);
        lps.findLPS();
    }
}
