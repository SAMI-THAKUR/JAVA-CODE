package DSA.HASHING;


import java.util.ArrayList;

class Quadratic{
    String Hash [] ;
    int used ;
    Quadratic(int size){
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

    public void insert(String word){
        double load = getload();
        if(load>=0.75){
            ReHash(word);
        }else {
            int index = Hash_func(word,Hash.length);
            int count = 0;
            for (int i=index ; i<index+Hash.length ; i++){
                int newindex = (i+(count*count))%Hash.length;
                if(Hash[newindex]==null){
                    Hash[newindex]=word;
                    break;
                }
                count++;
            }
        }
        used++;
    }


    public boolean search(String word){
        int index = Hash_func(word,Hash.length);
        int count = 0;
        for(int i=index ; i<index+Hash.length ; i++){
            int newindex = (i+(count*count))%Hash.length;
            if(Hash[newindex]!=null && Hash[newindex].equals(word)){
                System.out.println("FOUND at "+ newindex);
                return true;
            }
            count++;
        }
        System.out.println("DNE");
        return false;
    }

    public void delete(String word){
        int index = Hash_func(word,Hash.length);
        int count = 0;
        for(int i=index ; i<index+Hash.length ; i++){
            int newindex = (i+(count*count))%Hash.length;
            if(Hash[newindex]!=null && Hash[newindex].equals(word)){
                Hash[newindex] = null ;
                System.out.println("deleted "+ word+ " at index " + newindex);
                return;
            }
            count++;
        }
        used--;
        System.out.println("DNE");
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
public class sec11C_HASHING_QP {
    public static void main(String[] args) {

        Quadratic qp = new Quadratic(5);
        qp.insert("SAMI");
        qp.insert("D6ADA");
        qp.insert("THAKUR");
        qp.insert("VESIT");
        qp.display();
        qp.search("SAMI");
        qp.search("THAKUR");
        qp.delete("SAMI");
        qp.delete("THAKUR");
        qp.display();

    }
}
