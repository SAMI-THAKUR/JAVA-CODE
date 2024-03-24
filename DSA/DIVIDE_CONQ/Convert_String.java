package DSA.DIVIDE_CONQ;

class convert{
    String s1 ;
    String s2;
    convert(String s1 , String s2){
        this.s1 = s1;
        this.s2 = s2;
    }

    private int min_ops(String s1 , String s2 , int i1 , int i2){
        if(i1==s1.length()){ // case for deletion i.e. when s1 is empty and s2 has some characters
            return s2.length()-i2;
        }
        if(i2==s2.length()){ // case for insertion i.e. when s2 is empty and s1 has some characters
            return s1.length()-i1;
        }
        if(s1.charAt(i1)==s2.charAt(i2)){ // case for no operation i.e. when both characters are same
            return min_ops(s1,s2,i1+1,i2+1);
        }
        int c1 = 1 + min_ops(s1,s2,i1+1,i2); // count for deletion
        int c2 = 1 + min_ops(s1,s2,i1,i2+1); // count for insertion
        int c3 = 1 + min_ops(s1,s2,i1+1,i2+1); // count for replacement
//        System.out.println("c1="+c1+" c2="+c2+" c3="+c3);
        return Math.min(c1,Math.min(c2,c3));
    }

    public void findMin(){
        int min = min_ops(s1,s2,0,0);
        System.out.println("Minimum operations required to convert s1 to s2 = "+min);
    }
}


public class Convert_String {
    public static void main(String[] args) {
        String s1 = "table";
        String s2 = "tbles";
        convert convert = new convert(s1,s2);
        convert.findMin();
    }
}
