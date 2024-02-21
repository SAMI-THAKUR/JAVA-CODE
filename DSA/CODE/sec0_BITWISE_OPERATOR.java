package DSA.CODE;

public class sec0_BITWISE_OPERATOR {
    public static void main(String [] args){
        int num1 = 12;
        int num2 = 7;
        int bitPosition = 2;
        int shiftCount = 3;

        // Bitwise AND
        int resultAnd = num1 & num2;
        System.out.println("Bitwise AND: " + resultAnd);

        // Bitwise OR
        int resultOr = num1 | num2;
        System.out.println("Bitwise OR: " + resultOr);

        // Bitwise XOR
        int resultXor = num1 ^ num2;
        System.out.println("Bitwise XOR: " + resultXor);

        // Bitwise NOT
        int resultNot = ~num1;
        System.out.println("Bitwise NOT: " + resultNot);

        // Left Shift
        int resultLeftShift = num1 << shiftCount;
        System.out.println("Left Shift: " + resultLeftShift);

        // Right Shift
        int resultRightShift = num1 >> shiftCount;
        System.out.println("Right Shift: " + resultRightShift);

        // Setting a Bit
        num1 = num1 | (1 << bitPosition);
        System.out.println("Setting Bit at position " + bitPosition + ": " + num1);

        // Clearing a Bit
        num1 = num1 & ~(1 << bitPosition);
        System.out.println("Clearing Bit at position " + bitPosition + ": " + num1);

        // Checking if a Bit is Set
        boolean isSet = (num1 & (1 << bitPosition)) != 0;
        System.out.println("Bit at position " + bitPosition + " is set: " + isSet);

        // Toggling a Bit
        num1 = num1 ^ (1 << bitPosition);
        System.out.println("Toggling Bit at position " + bitPosition + ": " + num1);
    }
}
