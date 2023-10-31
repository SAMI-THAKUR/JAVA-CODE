package MAIN_JAVA.company;

public class PRIME_NUMBERS {
    public static void main(String[] args) {
        for (int i=2 ; i<=100 ; i++)
        {
            int count=0;
            for (int k=2 ; k<=10 ; k++)
            {
                if (i % k ==0)
                {
                    count++;
                }
                if (i==k)
                {
                    count--;
                }

            }
            if (count==0)
            {
                System.out.print(i + " ");
            }
        }
    }
}
