package EXPERIMENT;

import java.util.Scanner;

public class EXPI_1B {
    public static void main(String[] args) {
        // Bitwise Operators //
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
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
