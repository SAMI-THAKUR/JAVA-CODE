package DSA.CODE;
import java.util.ArrayList;
import java.util.LinkedList;


class Direct_Chain{
    LinkedList<String>[] HashTable;
    int max = 5;
    Direct_Chain(int size){
        HashTable = new LinkedList[size];
    }

    public int Hash_func(String word , int m){
        char ch [] ;
        ch = word.toCharArray();
        int i , sum ;
        for(sum=0,i=0;i<word.length();i++){
            sum = sum + ch[i];  // sum of ASCII value
        }
        return sum % m ; // returning mod with size
    }

    public void insert(String word){
        int index = Hash_func(word,HashTable.length);
        // No Collision Case
        if(HashTable[index]==null){
            HashTable[index] = new LinkedList<String>(); // Creating new LL at index
            HashTable[index].add(word);
        }else{  // Collision Case
            HashTable[index].add(word);
        }
    }

    public boolean search(String word){
        int index = Hash_func(word,HashTable.length);
        if(HashTable[index]!=null && HashTable[index].contains(word)){
            System.out.println("\n" + word + " EXIST at index: " + index);
            return true;
        }
        else {
            System.out.println(word + " DNE");
            return false;
        }

    }

    public void delete(String word){
        int index = Hash_func(word,HashTable.length);
        boolean f = search(word);
        if(f){
           HashTable[index].remove(word);
            System.out.println(word+ " deleted");
        }else {
            System.out.println(word + " DNE");
        }
    }

    // Displaying HashTable //
    public void display(){
        if(HashTable==null){
            System.out.println("DNE");
            return;
        }else{
            System.out.println("\n-----------------HASH_TABLE-------------------");
            for(int i=0 ; i<HashTable.length ; i++){
               /* if(HashTable[i]==null){
                    continue;
                }*/
                System.out.println("Index:" + i + " key:" + HashTable[i]);
            }
        }
    }
}
public class sec11A_HASHING_DC {
    public static void main(String[] args) {
        // Hashing is a technique to convert a range of key values into a range of indexes of an array
        // We're going to use array as a hash table here
        // Hashing is used to index and retrieve items in a database because
        // it is faster to find the item using the shorter hashed key than to find it using the original value
        // is a method of sorting and indexing data records

        // --- Terminology --- //
        // Hash Function --> A function that converts a given big input key to a small practical integer value
        // Key --> Input data to the hash function
        // Hash Value --> Value returned by the hash function
        // Hash Table --> An array that stores pointers to records corresponding to a given hash value i.e map key to Value
        // Collision --> Two or more keys are mapped to the same hash value
        // Best Hashing --> Each key is mapped to a different hash value

        // ---  A good hash function should have following properties --- //
        // 1. Easy to compute
        // 2. Uniform distribution of hash values
        // 3. Less collisions
        // 4. Should use all the input data

        // --- Collision Resolution Techniques --- //
        // Direct Chaining --> Each cell of hash table points to a linked list of records that have same hash function value

        Direct_Chain dc = new Direct_Chain(5);
        dc.insert("SAMI");
        dc.insert("THAKUR");
        dc.insert("AI&DS");
        dc.insert("VESIT");
        dc.insert("D6ADA");
        dc.display();

        System.out.print(dc.HashTable[0].get(1) + " ");

        dc.search("SAMI");
        dc.search("SA");

        dc.delete("SAMI");
        dc.delete("AI&DS");
        dc.display();




    }
}
