package JavaInterviewProblems;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
public class DatePractice {
    public static String convertFormat (String oldFormat) {
        int indexOfT = oldFormat.indexOf("T");
        String date =oldFormat.substring(0,indexOfT);
        String newFormat = date.replaceAll("-","/");
        return newFormat;
    }
    public static void main(String[] args) {
        String dateTime = "03-10-2020T04:34:13";
        String formatted = convertFormat(dateTime);
        System.out.println(formatted);
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println();
        // the return type of now() Method is object
        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalDateTime dateTime1 = LocalDateTime.now();
        System.out.println(dateTime1);
        /*LocalDate of Method
        There are two different of method
        of method will return LocalDate Object
         */
        LocalDate date1 = LocalDate.of(2020,03,05);
        System.out.println(date1);
        LocalDate date2 = LocalDate.of(2020, Month.APRIL, 05);
        System.out.println(date2);
        /*
        Local Time of Method
        There are three implementation for Of method in LocalTime
        // hour and min
        // hour, min and sec
        // hour, min, sec and nanosec
        of method will return LocalTime Object
         */
        LocalTime time1 = LocalTime.of(10,35);
        System.out.println(time1);
        LocalTime time2 = LocalTime.of(10,20,43);
        System.out.println(time2);
        LocalTime time3 = LocalTime.of(10,15,45,234);
        System.out.println(time3);
        /*
        LocalDateTime of method
        There are seven implementation for of method
         */
        LocalDateTime dateTime2 = LocalDateTime.of(2020,05,5,20,45);
        System.out.println(dateTime);
        // Note: For month value must be  1-12
        // DayOfMonth must be between 1-28/31
        // hour must be 0-23
        // min must be 0-59
    }
}
