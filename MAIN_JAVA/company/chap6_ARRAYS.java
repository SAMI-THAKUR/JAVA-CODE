package MAIN_JAVA.company;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class chap6_ARRAYS
{
    public static void main(String[] args)
    {
        /*****************---ARRAYS---*********************/

        // array is a collection of similar data types //
        // array is a data structure //
       Scanner sc=new Scanner(System.in);
        System.out.println("DECLARATION");
        int[] marks = new int[7];   // DECLARATION AND MEMORY ALLOCATION
        marks [0]=23;               // INITIALIZE
        marks [1]=20;
        marks [2]=27;
        marks [3]=31;
        marks [4]=15;
        marks [5]=99;
        marks [6]=80;
        System.out.println(marks[0]+marks[3]);
        marks[5]= sc.nextInt();
        System.out.println(marks[5]);  // accessing array elements
        int [] a= {100, 85, 39, 40};  // DECLARATION AND INITIALIZE together
        System.out.println(a[0]);
        System.out.println(marks.length);   // LENGTH OF ARRAY
        System.out.println(Arrays.stream(marks).max()); // MAXIMUM VALUE OF ARRAY
        Arrays.sort(marks);   // use to sort  array in descending orders



        /********************---PRINTING_ARRAY---**************************************/

        System.out.println("PRINTING AN ARRAY");

        // printing an array using for loop //
        System.out.println("using for loop");
          for (int i=(marks.length-1);i>=0;i--)
          {
              System.out.println(marks[i] );
          }
        int b=marks.length-1;

         // printing an array using while loop //
        System.out.println("using while loop");
          while (b>=0)
        {
            System.out.println(marks[b]);
            b--;
        }

          // ANOTHER WAY OF PRINTING ARRAYS //
        System.out.println(Arrays.toString(marks));

           String [] name= new String[5];
          name [0]="SAMI";
          name [1]="ARHAM";
          name [2]="FARIDA";

         // for - each loop
         System.out.println("PRINTING ARRAY ELEMENT WAY");
         for (String elements:name)
         {
            System.out.println(elements);
         }



        /***********************---MULTIDIMENSIONAL ARRAY---************************/

        System.out.println("MULTIDIMENSIONAL ARRAY");
        int [][] flats= new int[2][2];   // this array has 2 row and 2 columns
        flats [0][0]=25;
        flats [0][1]=12;
        flats [1][0]=22;
        flats [1][1]=20;

        int [][] d= new int[2][3];   // this array has 2 columns and 3 rows
        d [0][0]=12;
        d [0][1]=11;
        d [1][0]=13;
        d [1][1]=20;



        int [][] sum = new int[][]{{0, 0}, {0, 0}};


        System.out.println("SUM OF ARRAY");

        //   @@  PRINTING A 2D ARRAY  @@  //
        for (int i=0;i<2;i++) {
            for (int j=0;j<2;j++) {
               System.out.println(flats[i][j]);
              //   sum[i][j]= flats[i][j] + d[i][j];
              //  System.out.println(sum[i][j]);
            }
        }

                      // REVERSING AN ARRAY  //

        for (int i =0 ; i<(marks.length/2) ; i++)
        {
            int other =(marks.length - i -1) ;
            int temp = marks[i];
            marks[i]= marks[other];
            marks[other]=temp;
        }
        for (int i =0 ; i< marks.length ; i++)
        {
            System.out.print(marks[i] +" ");
        }
        System.out.println();

    }
}
