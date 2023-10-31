package DSA.CODE;

import java.util.ArrayList;

class DH{
    String Hash [] ;
    int used ;
    DH(int size){
        Hash = new String[size];
        used = 0 ;
    }

    // --- Hash Function --- //
    public int Hash_func(String word , int m){
        char ch [] ;
        ch = word.toCharArray();
        int i , sum ;
        for(sum=0,i=0;i<word.length();i++){
            sum = sum + ch[i];  // sum of ASCII value
        }
        return sum % m ; // returning mod with size
    }

    // --- Load --- //
    public double getload(){
        double re = used * 1.0/Hash.length;
        return re;
    }

    // Rehash //
    public void ReHash(String word){
        used = 0;
        ArrayList<String> data = new ArrayList<String>();
        for(String s : Hash){
            if(s!=null) {
                data.add(s);
            }
        }
        data.add(word);
        Hash = new String[Hash.length * 2];
        for(String s: data){
            insert(s);
        }

    }


    // ---- SECOND HASH FUNCTION --- //
    private int add(int sum){
        int value = 0;
        while (sum > 0){
            value = value +  (sum%10) ;
            sum  = sum /10;
        }
        return value;
    }

    public int Hash_func_2(String word, int M){
       char ch [];
       ch = word.toCharArray();
       int sum=0;
       for(int i=0;i<word.length();i++){
           sum =+ ch[i];
       }
       while (sum>Hash.length){
           sum = add(sum);
       }
       return sum;
    }
    // ---- INSERT FUNCTION ---- //
    public void insert(String s){
        double load = getload();
        if(load>=0.75){
            ReHash(s);
        }else{
            int x = Hash_func(s,Hash.length);
            int y = Hash_func_2(s,Hash.length);
            for(int i=0;i<Hash.length;i++){
            int newI = (x + i*y) % Hash.length;
            if(Hash[newI]==null){
                Hash[newI]=s;
                break;
            }
            }
        }
        used ++ ;
    }

    public void delete(String s){
        int x = Hash_func(s,Hash.length);
        int y = Hash_func_2(s,Hash.length);
        for(int i=0;i<Hash.length;i++) {
            int newI = (x + i * y) % Hash.length;
            if (s.equals(Hash[newI])) {
                Hash[newI] = null;
                used --;
                break;
            }
        }
    }


    public void display(){
        if(Hash==null){
            System.out.println("DNE");
        }else{
            for(int i=0 ; i<Hash.length ; i++){
                System.out.print(Hash[i] + " ");
            }
            System.out.println("");
        }
    }

}
public class sec11D_HASHING_DH {
    public static void main(String[] args) {

        DH dh = new DH(5);
        dh.insert("SAMI");
        dh.insert("THAKUR");
        dh.insert("VESIT");
        dh.insert("D6ADA");
        dh.insert("AI&DS");
        dh.delete("AI&DS");
        dh.display();

    }
}
