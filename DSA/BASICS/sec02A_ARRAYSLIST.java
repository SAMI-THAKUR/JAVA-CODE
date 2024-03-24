package DSA.BASICS;

import java.util.Scanner;
import java.util.ArrayList;

public class sec02A_ARRAYSLIST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<>();
        //  AL is a basically a resizable array and with extra features
        // in CPP it is called vector
        // it uses wrapper class --> INTEGER   instead of primitive data type 
        //                       --> BOOLEAN
        a.add(20);
        a.add(21);
        a.add(76);
        a.add(29);

        System.out.println(a);  // it itself call A Array.toString()
        System.out.println(a.contains(29)); // checks if AL has 29 in it
        a.get(3); // access A element at specific position
        a.add(2,23); // add elements at A specific index number
//        System.out.println(a.get(2));
        a.set(2,22); // add elements at A specific index number
        System.out.println(a.size());
       //  2D ARRAYLIST
     ArrayList<ArrayList<Integer>> a2d =  new ArrayList<ArrayList<Integer>>();
     ArrayList<Integer> one  = new ArrayList<>();
     one.add(22);
     one.add(30);
     a2d.add(one); //
        System.out.println(a2d);



    }
}
