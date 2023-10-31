package MAIN_JAVA.company;
import java.util.*;

public class chap15A_ADVANCE_JAVA {
    public static void main(String[] args) {
        // COLLECTION FRAMEWORK //



     // @@  ARRAYLIST  @@ //
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(22);
        l2.add(25);
        l2.add(50);
        l2.add(80);
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(6);  // adding element to AL //
        l1.add(7);
        l1.add(0);
        l1.add(8);
        l1.add(0,2);
        l1.add(0,4);
      l1.addAll(0,l2); // add all elements of l2 in l1 from specified index number
      //  l1.clear();   // clear the whole arrayList

//      for (Integer hi : l1)
//        {
//            System.out.println(hi);
//        }
        System.out.println();
        System.out.println(l1);  // to print AL elements in horizontal manner //
        System.out.println(l1.contains(100));  // if the AL contains the elements then it prints true //
        System.out.println(l1.indexOf(8));  // print the index of written elements and if the number occurs 2 time then its prints the first occurrence
        System.out.println(l1.size());   // prints length of array list
        Collections.sort(l1);   //, sort elements in ascending order
        Collections.sort(l1, Collections.reverseOrder());    // to print in descending first make it ascending then reverse it
        System.out.println("sorted");
        System.out.println(l1);

        Object CLONELIST = new ArrayList<>();
        CLONELIST = l1.clone(); // creates A exact copy of AL
        System.out.println(CLONELIST);

        // @@  LINKED LIST  @@ //







    }


}
