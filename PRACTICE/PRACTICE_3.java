package PRACTICE;
import java.io.StringReader;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;
import java.util.spi.CurrencyNameProvider;


public class PRACTICE_3
{

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a11 = sc.nextInt();
     /*  int x=sc.nextInt();
        String s=sc.next();

        System.out.format("%14s  %13d",s,x);
        System.out.println();
        System.out.format("%-14s %03d",s,x);

        int a=9;
        int b=8;
        System.out.println("a is "+  a);
        System.out.println("b is "  +b);
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println(a);
        System.out.println(b);  */

      //  while(sc.hasNext())                           //  ***********  //
      //  {
      //      System.out.println(sc.next());
      //  }
        for (int i=1 ; i<100 ; i++)
        {int count=0;
            for (int k=2 ; k<=10 ; k++)
            {
                if (i % k == 0)
                {
                    count++;
                }
                if (i==k)
                {
                    count--;
                }
            }
            if (count==0 )
            {
                System.out.println(i);
            }

        }


LocalTime lo1 = LocalTime.now();
        DateTimeFormatter da =  DateTimeFormatter.ofPattern("H:m:s:ms");
        String st = lo1.format(da);
        System.out.println(st);

int a = sc.nextInt();
     String s = String.valueOf(a);
        System.out.println(s);

Calendar ca = Calendar.getInstance();
Currency  cu = Currency.getInstance(new Locale("en" , "pa" +
        ""));
        System.out.println(cu.getSymbol());
        System.out.println(cu.getNumericCode());
        System.out.println(cu.getCurrencyCode());

       String s1m = NumberFormat.getCurrencyInstance(Locale.US).format(a);
        System.out.println(s1m);

        String str2 = "madam";
        String str3 = "";
     int val = str2.compareTo(str3);
        System.out.println(val);

        for (int i = str2.length()-1;i>=0 ; i--)
        {
            str3 = str3 + str2.charAt(i);
        }
        System.out.println(str3);



        String s20 = "hi guys how are you";
        System.out.println(s20.length());
        StringTokenizer str = new StringTokenizer(s20, " .,'?!_@");
        System.out.println(str.countTokens());
        while (str.hasMoreTokens()) {
            System.out.println(str.nextToken());
        }

        String zeroTo255
                = "(\\d{1,3}|2[0-4]\\d|25[0-5])";


        String regex
                = zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255;
        System.out.println(regex);
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        while(sc.hasNext()) {
            String ipAddress = sc.nextLine();
            java.util.regex.Matcher matcher = pattern.matcher(ipAddress);
           if (matcher.matches())
           {
               System.out.println("true");
           }
        }

    }
}
