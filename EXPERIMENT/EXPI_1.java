package EXPERIMENT;

import java.util.Scanner;

public class EXPI_1 {
    public static void main(String[] args) {
        // roots of quadratic equation //
        Scanner sc = new Scanner(System.in);
        int a , b , c;
        a = 1;
        b = 3;
        c = 1;
        int D = (b*b) - (4*a*c);
        if(D>0){
            double root1 = (-b + Math.sqrt(D))/(2*a);
            double root2 = (-b - Math.sqrt(D))/(2*a);
            System.out.println("Roots are real and unequal");
            System.out.println("Root 1 = " + root1);
            System.out.println("Root 2 = " + root2);
    }
        else if(D==0){
            double root1 = (-b + Math.sqrt(D))/(2*a);
            System.out.println("Roots are real and equal");
            System.out.println("Root 1 = " + root1);
        }
        else{
            System.out.println("Roots are imaginary");
        }


        // prime number //
        int n = 5;
        int count = 0;
        for(int i=2 ; i<n/2 ; i++){
            if(n%i==0){
                count++;
                break;
            }
        }
        if(count==0){
            System.out.println(n + " is Prime");
        }
        else{
            System.out.println(n + " is Not Prime");
        }

        // Aim: To implement a Program to
        // demonstrate the working of types of operators
        // (Bitwise, Logical and relational) using  switch cases.

        // Bitwise Operators //
        int x = 5;
        int y = 6;
        // using switch case //
        System.out.println("Bitwise Operators");
        System.out.println("1. Bitwise AND");
        System.out.println("2. Bitwise OR");
        System.out.println("3. Bitwise XOR");
        System.out.println("4. Bitwise NOT");
        System.out.println("5. Bitwise Left Shift");
        System.out.println("6. Bitwise Right Shift");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Bitwise AND");
                System.out.println(x & y);
                break;
            case 2:
                System.out.println("Bitwise OR");
                System.out.println(x | y);
                break;
            case 3:
                System.out.println("Bitwise XOR");
                System.out.println(x ^ y);
                break;
            case 4:
                System.out.println("Bitwise NOT");
                System.out.println(~x);
                break;
            case 5:
                System.out.println("Bitwise Left Shift");
                System.out.println(x << 2);
                break;
            case 6:
                System.out.println("Bitwise Right Shift");
                System.out.println(x >> 2);
                break;
            default:
                System.out.println("Invalid Choice");
        }

    }
}
