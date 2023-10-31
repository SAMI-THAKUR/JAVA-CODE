package DSA.PRACTICE;

public class c0_PATTERNS_PROB {
    // PATTERN 1
    static void pattern_1(int n) {
for (int rows=0;rows<=n;rows++) {
    for (int column=1;column<=rows;column++) {
        System.out.print("*");
    }
    System.out.println();
}
    }
    // PATTERN 2
    static void pattern_2(int n) {
        for (int rows=0;rows<=n;rows++) {
            for (int column=n;column>rows;column--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // PATTERN 3
    static void pattern_3(int n) {
        for (int rows=0;rows<=n;rows++) {
            for (int column=1;column<=rows;column++) {
                System.out.print(column);
            }
            System.out.println();
        }
    }
    // PATTERN 4
    static void pattern_4(int n) {
        for (int rows=n-1;rows>=1;rows--) {
            for (int column=1;column<=rows;column++) {
                System.out.print(column);
            }
            System.out.println();
        }
    }
    // PATTERN 5
    static void pattern_5(int n) {
        for (int rows=0;rows<=n;rows++) {
            char a = 'A';
            for (int column=1;column<=rows;column++) {
                System.out.print(a);
                a++;
            }
            System.out.println();
        }
    }
    // PATTERN 6
    static void pattern_6(int n) {
        for (int rows=0;rows<=n;rows++) {
            char a = 'A';
            for (int column=1;column<=rows;column++) {
                System.out.print(a);
                a++;
            }
            System.out.println();
        }
        for (int rows=n-1;rows>=1;rows--) {
            char a = 'A';
            for (int column=1;column<=rows;column++) {
                System.out.print(a);
                a++;
            }
            System.out.println();
        }
    }
    // PATTERN 7
    static void pattern_7(int n) {
        for (int rows=0;rows<=n;rows++) {
            for (int spaces = n; spaces > rows; spaces--) {
                System.out.print(" ");
            }
            for (int columns = 1; columns <= 2 * rows + 1; columns++) {
                System.out.print("*");
            }
            for (int spaces = n; spaces > rows; spaces--) {
                System.out.print(" ");
            }
            System.out.println(" ");
        }
            //
        for(int rows=0;rows<=n;rows++){
            for (int spaces=2;spaces<rows+3;spaces++){
                System.out.print(" ");
            }
            for (int columns=1;columns<=(2*n)-(2*rows+1);columns++){
                System.out.print("*");
            }
            for (int spaces=2;spaces<rows+3;spaces++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    // PATTERN 8  [ THE BINARY PATTERN ]
    static void pattern_8(int n){

        for (int rows=0;rows<=n;rows++){
            int start;
            if (rows%2==0){
                start=1;
            }
            else {
                start=0;
            }
            for (int j=0;j<=rows;j++){
                System.out.print(start);
                start=1-start;  // converts 0-->1 and 1-->0
            }
            System.out.println();
        }
    }
    static void pattern_9(int n) {
        int space = 2*n-2;
        for (int rows=1;rows<=n;rows++) {
            for (int column=1;column<=rows;column++) {
                System.out.print(column);
            }
            for (int j=space;j>=0;j--){
                System.out.print(" ");
            }
            for (int column=rows;column>=1;column--) {
                System.out.print(column);
            }
            space=space-2;
            System.out.println();
        }

    }
  static void pattern_10(int n)
  {
      for(int i=0 ; i<n ; i++)
      {
          for(int space=4 ; space>i ; space--)
          {
              System.out.print(" ");
          }
          for (int j = 0 ; j<=i ; j++)
          {
              System.out.print("*");
          }
          System.out.println("");
      }
  }
  static void pattern_11(int n)
  {
      int k=1 ;
      for(int i=1 ; i<=n ; i++)
      {
          for(int j=1 ; j<=i ; j++)
          {
              System.out.print(k);
              k++;
          }
          System.out.println();
      }
  }
    public static void main(String[] args) {

         pattern_1(4);
        /*
                           *
                           **
                           ***
                           ****
        */
        pattern_2(4);
       //  pattern 1 in reverse
        pattern_3(4);
        /*
        1
        12
        123
        1234
         */
        pattern_4(4);
        // pattern 3 in reverse
        pattern_5(4);
        /*
        A
        AB
        ABC
        ABCD
        */
        pattern_6(4);
        /*
        A
        AB
        ABC
        ABCD
        ABC
        AB
        A
        */
        pattern_7(4);
        /*
         *
        ***
       *****
      *******
     *********
      *******
       *****
        ***
         *
         */
        pattern_8(4);
        /*
        1
        01
        101
        0101
         */
        pattern_9(4);
        pattern_10(5);
        pattern_11(4);

    }
}
