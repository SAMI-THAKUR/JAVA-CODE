package PRACTICE;
import java.util.*;


class Student{
    Scanner st = new Scanner(System.in);
    int roll;
    String name;
    int marks [] = new int[3];
    int total=0;
    double avg;

    public void insert(){
        System.out.print("ROLL :");
        roll = st.nextInt();
        System.out.print("NAME :");
        name = st.next();
        System.out.print("MARKS :");
        for (int i=0 ; i<marks.length ; i++){
            System.out.print("Subject " + (i+1) + ": ");
            marks[i]= st.nextInt();
            total = total +  marks[i];
        }
         avg = total/3;
    }



    public void display(){
        System.out.println("Name: "+ name);
        System.out.println("Roll: "+ roll);
        System.out.println("Marks: "+ Arrays.toString(marks));
        System.out.println("Sum of Marks: "+total);
        System.out.println("Average: "+ avg);
    }

}
public class practice_2 {
    public static void main(String[] args) {

        Student a[] = new Student[3];
        System.out.print("1-Insert\t");
        System.out.print("2-Display\t");
        System.out.print("3-Exit\t");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int ch;
        int i = 0;
        int st;
        do {
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    if(i==0){
                        a[i++] = new Student();
                        a[0].insert();
                    }else {
                        int k ;
                        System.out.println("1-Create new Student");
                        System.out.println("2-Insert in existing Student");
                        k = sc.nextInt();
                        if(k==1){
                            a[i++] = new Student();
                            a[i-1].insert();
                        } else if (k==2) {
                            for (int j = 0; j < i; j++) {
                                System.out.println(j + 1 + "-" + a[j].name);
                            }
                            System.out.println("Enter your choice: ");
                            st = sc.nextInt();
                            a[st - 1].insert();
                        }else {
                            System.out.println("Invalid Choice");
                        }
                    }

                    break;
                case 2:
                    for (int j = 0; j < i; j++) {
                        System.out.println(j + 1 + "-" + a[j].name);
                    }
                    st = sc.nextInt();
                    a[st - 1].display();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }while (ch != 3) ;
    }
}
