package DSA.HASHING;
import java.util.ArrayList;
import java.util.Scanner;


class LinearProbing {
    String [] HashTable ;
    int usedCell ;
   LinearProbing(int size){
      HashTable = new String[size];
      usedCell = 0;
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
       double re = usedCell * 1.0/HashTable.length;
       return re;
    }

     // Rehash //
    public void ReHash(String word){
        usedCell = 0;
        ArrayList<String> data = new ArrayList<String>();
        for(String s : HashTable){
            if(s!=null) {
                data.add(s);
            }
        }
        data.add(word);
        HashTable = new String[HashTable.length * 2];
        for(String s: data){
            insert(s);
        }

    }

    public void insert(String word){
       double load = getload();
       if(load >= 0.75){
         ReHash(word);
       }else{
           int index = Hash_func(word,HashTable.length);
           for(int i=index ; i<index+HashTable.length ; i++){
               int newindex = i % HashTable.length;
               if(HashTable[newindex]==null){
                   HashTable[newindex]=word;
                   break;
               }
           }
       }
       usedCell++;
    }

    public boolean search(String word){
       int index = Hash_func(word,HashTable.length);
       for(int i=index ; i<index+HashTable.length ; i++){
           int newindex = i%HashTable.length;
           if(HashTable[newindex]!=null && HashTable[newindex].equals(word)){
               System.out.println("FOUND at "+ newindex);
               return true;
           }
       }
        System.out.println("DNE");
       return false;
    }

    public void delete(String word){
        int index = Hash_func(word,HashTable.length);
        for(int i=index ; i<index+HashTable.length ; i++){
            int newindex = i%HashTable.length;
            if(HashTable[newindex]!=null && HashTable[newindex].equals(word)){
                HashTable[newindex] = null ;
                System.out.println("deleted "+ word + " at index " + newindex);
                return;
            }
        }
        usedCell--;
        System.out.println("DNE");
    }

    public void display(){
       if(HashTable==null){
           System.out.println("DNE");
       }else{
           for(int i=0 ; i<HashTable.length ; i++){
               System.out.print(HashTable[i] + " ");
           }
           System.out.println("");
       }
    }
}
public class sec11B_HASHING_LP {
    public static void main(String args []){
        Scanner sc = new Scanner(System.in);
        LinearProbing lp = new LinearProbing(5);
        lp.insert("SAMI");
        lp.insert("D6ADA");
        lp.insert("THAKUR");
        lp.display();
        lp.search("SAMI");
        lp.search("THAKUR");
        lp.delete("SAMI");
        lp.display();
    }
}
