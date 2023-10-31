package MAIN_JAVA.company;
import java.time.*;

import java.time.format.DateTimeFormatter;
import java.util.*;


public class chap15B_ADVANCE_JAVA {
    public static void main(String[] args) {

        DateTimeFormatter dat = DateTimeFormatter.ofPattern("H:m:s");
        // DATE AND TIME CLASS //
        System.out.println(System.currentTimeMillis()/(1000)/(60)/(60)/(24)/365);
           // prints number of millisecond passed  // it keep changing   // it can be stored in long data type //
        long mili = System.currentTimeMillis();
        System.out.println(mili);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Long.MAX_VALUE);


        //  @@  DATE CLASS  @@  //
        Date d2 = new Date(1627709999999l);   // gives the date from millisecond entered from 1970 jan !
        System.out.println(d2);

        Date d= new Date();
        System.out.println(d);

      Date d1= new Date(100,1,1);  // this method add given number of year/month/days to 1900
        System.out.println(d1);

        Date d3 = new Date(122, 9,30);
        System.out.println(d3);
        System.out.println(d.compareTo(d3));  // this method returns 0 if date are same else 1

        System.out.println(d.getTime());  // prints number of millisecond from 1970
        System.out.println(d.getYear());    // number of year passed from 1900
        System.out.println(d1.getYear());   // number of year btw 1900 and 2000
        System.out.println(d.getSeconds());      // current
        System.out.println(d.getMinutes());      // current
        System.out.println(d.getHours());       // current

        System.out.println("GET DATE");
        System.out.println(d.getDate());
        System.out.println(d1.getDate());
        System.out.println(d2.getDate());
        System.out.println(d3.getDate());

        System.out.println();

        //  @@  CALENDAR CLASS  @@  //
        Calendar ca = Calendar.getInstance();
        System.out.println(ca.getCalendarType());  // returns type of calendar
        System.out.println(ca.get(Calendar.YEAR));  // return year
        System.out.println(ca.get(Calendar.MONTH));  // return year
        System.out.println(ca.get(Calendar.WEEK_OF_YEAR));  // return the week of year
        System.out.println(ca.get(Calendar.DAY_OF_MONTH));  // return day of month
        ca.add(Calendar.YEAR,4);   // add 4 years to 2022  // similarly u can add months or week
        System.out.println(ca.get(Calendar.YEAR));
        System.out.println(ca.getMaximum(Calendar.DAY_OF_YEAR));


        //  TIME ZONE  //
       TimeZone ti = TimeZone.getTimeZone("Asia/Karachi");
        System.out.println(ti.getID());   // prints JAVA ID
        System.out.println(ti.getDisplayName());  // prints general name of time zone
        ZonedDateTime zo = ZonedDateTime.now(ZoneId.of("Asia/Karachi"));  // prints date and time of zone id
        System.out.println(zo);

        System.out.println(TimeZone.getAvailableIDs()[12]); // prints JAVA zone id


        // CLOCK CLASS //
        Clock c1 = Clock.system(ZoneId.of("Asia/Karachi"));
        System.out.println(c1.instant()); // prints time of given zone //

        // DURATION CLASS //
        Duration du = Duration.between(LocalTime.now(),LocalTime.of(22,13,25)); // gives difference btw two times
        System.out.println(du.toHours());  // gives difference in hours
        System.out.println(du.toMinutes());  // gives difference in minutes //

        // LOCAL DATE CLASS //
        LocalDate lo = LocalDate.now(ZoneId.of("America/Los_Angeles"));
        LocalDate lo1 = LocalDate.of(2022, 10,31);
        System.out.println(lo.compareTo(lo1));  // compare given dates return 0 if true else 1

        // LOCAL TIME CLASS //
        LocalTime lt = LocalTime.now();
        System.out.println(lt.plusHours(2));  // can add minutes hours or seconds to current time //
                                                        // can even subtract hours minutes seconds //


        // PRINTING ALL ZONE IDS IN JAVA //
        ArrayList<String> ar = new ArrayList();
        Collections.addAll(ar, TimeZone.getAvailableIDs());
        for (int i =0 ; i<=(ar.size()-1) ; i++)
        {
            System.out.println(ar.get(i));
        }










    }
}
