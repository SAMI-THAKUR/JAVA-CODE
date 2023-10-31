package EXPERIMENT;

import java.util.Scanner;

public class EXPI_2A {
    public static void main(String[] args) {
     // WAP to read the numbers & shift left & right by 3 bits //
     int num , num1 , num2 ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        num = sc.nextInt();
        num1 = num << 3;
        num2 = num >> 3;
        System.out.println("Number after shifting left by 3 bits: " + num1);
        System.out.println("Number after shifting right by 3 bits: " + num2);

    }
}
