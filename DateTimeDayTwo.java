package jPractice;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeDayTwo {
	
	public static void main(String[] args) {
		
	
	//We can not create Date classes with new keyword since they have private constructor.
	//In everywhere in java , when you use the private constructor
	//you must create static method to instantiate your object
	LocalDate date = LocalDate.now();
	LocalTime time = LocalTime.now();
	LocalDateTime dateTime = LocalDateTime.now();
	
	//plusYear/plusMonth/plusWeek/plusDay (This method will be available to use for LocalDate and LocalDateTime)
	
	date.plusYears(1);
	//Date classes are immutable
	System.out.println(date);
	
	
	//plusHour / plusMonth
	//(This method will be available to use for LocalDate and LocalDateTime)
	
	time=time.plusHours(1);
	System.out.println(time);
	
	//for Date class method we can do method chaining
	System.out.println(dateTime);
	// 2024 12 07 23:50
	//Month is more than 12 since we are using plus method it will increase th year.
	dateTime=dateTime.plusYears(4).plusMonths(8).plusHours(5).minusMinutes(33);
	System.out.println(dateTime);
	
	//Since the Month is more than 12 It throws the exceptions.
    //	LocalDateTime dataTime1 = LocalDateTime.of(2020 ,12 ,20 ,10 ,35);
  /*
   * TASK
   * Create LocalDate using of method and give your birthday
   * then using plus and minus method then using plus and minus method find the current date after that print the result.
   *
   */
	LocalDateTime dataTime2 = LocalDateTime.of(1997 ,02 ,05, 0, 0 );
     System.out.println(dataTime2);
     dataTime2=dataTime2.plusYears(23).plusMonths(2).plusDays(2);
     System.out.println(dataTime2);
     // what is Static Polymorphism
     /*
      * Static Polymorphism is related with compile time in java.
      * Method overloading in java will be decided at compile time.
      * If you have overloaded method , java will decide which method to call at compile time
      *
      * Dynamic Polymorphism(Runtime) ;
      * It is related with method overriding , java will decide which overrided method to call at runtime
      */
	}	
}

class DateTimeDayTwo2 {
	
	public static void main(String[] args) {
		
	
	//We can not create Date classes with new keyword since they have private constructor.
	//In everywhere in java , when you use the private constructor
	//you must create static method to instantiate your object
	LocalDate date = LocalDate.now();
	LocalTime time = LocalTime.now();
	LocalDateTime dateTime = LocalDateTime.now();
	
	//plusYear/plusMonth/plusWeek/plusDay (This method will be available to use for LocalDate and LocalDateTime)
	
	date.plusYears(1);
	//Date classes are immutable
	System.out.println(date);
	
	
	//plusHour / plusMonth
	//(This method will be available to use for LocalDate and LocalDateTime)
	
	time=time.plusHours(1);
	System.out.println(time);
	
	//for Date class method we can do method chaining
	System.out.println(dateTime);
	// 2024 12 07 23:50
	//Month is more than 12 since we are using plus method it will increase th year.
	dateTime=dateTime.plusYears(4).plusMonths(8).plusHours(5).minusMinutes(33);
	System.out.println(dateTime);
	
	//Since the Month is more than 12 It throws the exceptions.
    //	LocalDateTime dataTime1 = LocalDateTime.of(2020 ,12 ,20 ,10 ,35);
  /*
   * TASK
   * Create LocalDate using of method and give your birthday
   * then using plus and minus method then using plus and minus method find the current date after that print the result.
   *
   */
	LocalDateTime dataTime2 = LocalDateTime.of(1997 ,02 ,05, 0, 0 );
     System.out.println(dataTime2);
     dataTime2=dataTime2.plusYears(23).plusMonths(2).plusDays(2);
     System.out.println(dataTime2);
     // what is Static Polymorphism
     /*
      * Static Polymorphism is related with compile time in java.
      * Method overloading in java will be decided at compile time.
      * If you have overloaded method , java will decide which method to call at compile time
      *
      * Dynamic Polymorphism(Runtime) ;
      * It is related with method overriding , java will decide which overrided method to call at runtime
      */
	}	
}

class PeriodPractice {
	
	//This method will take three parameter oldDate , newDate , find the period between this dates.
	
	public static int findPeriod(LocalDate oldDate ,LocalDate newDate ,Period period) {
		int count =0;
		
		while(oldDate.isBefore(newDate)) {
			count++;
			oldDate=oldDate.plus(period);
		}
		System.out.println(count);
	return count;
	}
	public static void main(String[] args) {
	
		LocalDate pastDate= LocalDate.of(2018, 05, 23);
		LocalDate date=LocalDate.now();
	// isBefore and isAfter
	  System.out.println("Is Before Method "+pastDate.isBefore(date));
		System.out.println("Is After Method "+pastDate.isAfter(date));
	     System.out.println(date.isAfter(pastDate));
	   
	     Period period = Period.ofDays(3);
	     date=date.plus(period);
	     System.out.println(date);
	  
	     //Period is not date. Period only to define period of time is java
	     //You can add period to your date.
	     Period months = Period.ofMonths(3);
	     Period year = Period.ofYears(5);
	     Period weeks=Period.ofWeeks(4);
	     //We paid every two weeks in the companies
	     Period biweekly=Period.ofWeeks(2);
	     Period fullPeriod=Period.of(1, 6, 20);
	     Period bonus = Period.of(1, 2, 30);
	    
	     //In period class you can not do method chaining
	     // If you chain the method java will compile and will not give runtime error.
	     // When you chain in Period , Java will get last value.
	     Period period1=Period.ofYears(1).ofWeeks(4).ofDays(6);
	     System.out.println(period1);
	    
	     //We can use Period only with localdate and localtime
	    
	     LocalDateTime dateTime = LocalDateTime.of(2002 , 06 , 25 , 15 ,45);
	     //Every 2 weeks you will get paid.
	     //How many weeks I get paid until now.
	     Period twoWeeks=Period.ofWeeks(2);
	     LocalDateTime currentDateTime = LocalDateTime.now();
	     
	     //While dateTime is before the currentDataTime
	     //add two weeks period and increase the dateTime
	    
	     int paidTimes=0;
	        while (dateTime.isBefore(currentDateTime)) {
	            paidTimes++;
	            dateTime = dateTime.plus(twoWeeks); // we need to re assing like that.
	        }
	        System.out.println(paidTimes);
	   
	       
	       
	        LocalDate old = LocalDate.of(2005, Month.DECEMBER, 13);
	    	LocalDate newD= LocalDate.of(2018, 8, 22);
	    	Period changeOil=Period.ofMonths(3);
	    	
	    	findPeriod(old,newD,changeOil);
	    	
  // If you consider you are changing the shoes every 6 months.
  // Find how many times you bought or changed your shoes between
	    	/*
	    	LocalDateTime dateTime1=LocalDateTime.now();
	    	dateTime1.get
	    	*/
	// TASK 2
	    /*
	     * eVERY INE YEAR , 8 MONTHS , 23 DAY YOU ARE GONING TO DIFFERENT COUNTRY FOR TRAVEL
	     * Between old date and new Date how many time you went to different country.
	     *
	     */
	Period vacationPeriod = Period.of(1, 8, 23);
	findPeriod(old, newD, vacationPeriod);
	
	//Other methods in LocalDate ,LocalTime and LocalDateTime to get the only specific part
	LocalDateTime dateTime1=LocalDateTime.now();
	System.out.println(dateTime1.getDayOfMonth());
	System.out.println(dateTime1.getDayOfYear());
	System.out.println(dateTime1.getMinute());
	
	}
}
class DateTimePractice {
/*
 *  * Period Class will work with Date and LocalDateTime Class
	 * In period we can not give time
	 *
	 * ofDays
	 * ofWeeks
	 * ofMonths
	 * ofYears
	 *
	 * How to Format Date-Time In java ?
	 * We have built in format in Java to use them.
	 *
	 * Date and Time Format Documentation in Java
 */
public static void main(String[] args) {
	Period period = Period.ofWeeks(3);
	System.out.println(period);
	//3 haftanin 21 gun oldugunu veriyor.
	LocalDate date = LocalDate.now();
	//We instantiate(orneklendirmek) the object using static method.
	
	date=date.plus(period);
	System.out.println(date);
    //YYYY-MM-DD This is Default format for Local Date  (pre-set format = default)
	System.out.println(LocalTime.now());//HH:mm:ss.nanoSec
	System.out.println(LocalDateTime.now());//2020-04-08T18:32:28.602951600
	
	
	DateTimeFormatter isoDate = DateTimeFormatter.BASIC_ISO_DATE;//'20111203'
	//yyyy-MM--dd
	//format method will return String
	//you can not say date = isoDate.format(date);
	
	System.out.println(isoDate.format(date));
	String dateFormat=isoDate.format(date);
	
	System.out.println(date);
	
	
	/*
	 * Task
	 * Create one LocalTime object with current time.
	 * Then use ISO LOCAL TIME to modify your time format and print new format
	 */
	LocalTime time=LocalTime.of(14,40,15,2463);
	System.out.println(time);
	
	DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_TIME;
	System.out.println(timeFormatter.format(time));
	
	//We have other pre-defined structure in Java. Short , Medium , Long
	
	DateTimeFormatter formatTime=DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
	System.out.println(formatTime.format(time));
	
	DateTimeFormatter mediumFormat=DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
	System.out.println(mediumFormat.format(LocalTime.now()));
	
	LocalDate date1=LocalDate.now();
	DateTimeFormatter shortDateFormat=DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
	DateTimeFormatter mediumDateFormat=DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
	DateTimeFormatter longDateFormat=DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
	System.out.println("===================================================================");
	
	System.out.println("Short "+shortDateFormat.format(date1));
	System.out.println("Medium "+mediumDateFormat.format(date1));
	System.out.println("Long "+longDateFormat.format(date1));
	
	/*TASK
	 * Using FormatStyle , Short modify your LocalDateTime object and print it
	 * You need call ofLocalizedDateTime method
	 *
	 */
	LocalDateTime localDateTime=LocalDateTime.now();
	System.out.println(localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
	System.out.println(localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
System.out.println("=============================================================================");
//Pattern(Model) for your localDateTime
/*
 * yyyy ====> full year
 * yy   ====> last two digit of year
 * MMMM ====> if you give the MM it will give you full name of month
 * MMM  ====> It will give short name of month APR , JAN
 * MM   ====> It will give two digit of 04
 * M    ====> It will give you one digit 4
 * dd   ====> it will give you the day of month
 * d    ====> it will give one digit
 * HH   ====> It will give two digit of hour
 * H    ====> It will give you one digit
 * mm   ====> it will symbolize the minute
 * a    ====> to be able to display the am or pm
 * ss   ====> will give the second
 * ns   ====> will give the nano second
 */
	
LocalDateTime dateTime=LocalDateTime.now();
System.out.println(dateTime);
// MMMM/dd/yyyy-HH:mm
//DateTimeFormatter  f1 =DateTimeFormatter.ofPattern("MMMM/dd/yyyy-HH:mm a");
DateTimeFormatter  f1 =DateTimeFormatter.ofPattern("MM/d/yy-HH:mm a");
System.out.println(f1.format(dateTime));
LocalDateTime amTime=LocalDateTime.of(2020, 05 , 13 , 7 , 3);
DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd%M%yyyy=H:m a");
System.out.println(f2.format(amTime));
System.out.println(amTime.format(f2));
/*
 * Task
 *  Create the data with following value 2008 January 9
 *  Format the date as following structure Jan/9/08
 */
LocalDateTime extraTime=LocalDateTime.of(2008, Month.JANUARY , 13 , 7 , 3);
//DateTimeFormatter f22 = DateTimeFormatter.ofPattern("MMM/dd/yy");
//System.out.println(extraTime.format(f22));
System.out.println(extraTime.format(DateTimeFormatter.ofPattern("MMM/d/yy")));
}
}
class parseMethod {
	/*
	 * HOW TO CONVERT STRING TO Date Classes ?
	 * .parse method to convert from String to Date object
	 *
	 * "2020-04-29" ===> convert ===> Date Object
	 * We need to use parse method
	 * "10:08" ===> convert ===> Time object
	 * If you are not defining the pattern , you need to give the String with default structure of your relavent Object.
	 *
	 */
   public static void main(String[] args) {
	String strDate="2010-10-24";
	
	LocalDate date=LocalDate.parse(strDate);
	System.out.println(date);
    System.out.println(LocalTime.now());
	
	/*
	 * 22:43.
	 */
    String strTime="18:13:20.314";
    LocalTime time=LocalTime.parse(strTime);
    System.out.println(time);
    System.out.println("==========================");
    String strDateTime="April 24 2015 10 20";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd yyyy HH mm");
	LocalDateTime localDateTime = LocalDateTime.parse(strDateTime, formatter);
	System.out.println(localDateTime);
	/*
	 * 2015=Apr=24/20;10
	 */
	
    DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yyyy=MMM=dd/mm;HH");
    System.out.println(f2.format(localDateTime));
}
}
class DateFormatPractice {
	/* Create the String has value of "06/30/2018-10:01"
	 * Convert string to dateTime object
	 * After that create
	 *
	 */
	
	public static void main(String[] args) {
	// First Create String
		String date = "06/30/2018-10:01";
		/*
		 * Default Date Format ===> 2020-04-11T10:14:19.828
		 * Define DateTimeFormatter object
		 * If your String date structure is different than the java default date structure
		 * You must define your DateTimeFormatter for string
		 *
		 */
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy-HH:mm");
		
		LocalDateTime localDateTime = LocalDateTime.parse(date , formatter );
		System.out.println(localDateTime);
		//Actual format is 06/30/2018-10:01
		//Expected format ===> 30-06-18 %10-01
		
		//LocalDateTime ==> String new format
		DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("dd-MM-yy%HH:mm");
		System.out.println(formatter1.format(localDateTime));
		
		//We can not reassing this value becauase format method return type is a string
		
		String result=formatter1.format(localDateTime);
		System.out.println(result);
		
		/*
		 * Task2                          Day Month Year
		 * Create the String has value of 9.07.15
		 * From this String value convert date time object
		 * After that change the pattern to September/
		 */
		String date2="9.07.15";
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d.MM.yy");
		LocalDate localDate2 = LocalDate.parse(date2 , formatter2 );
		System.out.println(localDate2); //This line will print default patter of LocalDate
		
		DateTimeFormatter formatter3= DateTimeFormatter.ofPattern("MM/dd/yy");
		System.out.println(formatter3.format(localDate2));
		
		//We don't have method chaining in period time.
		
		// || &&  ===> | & those are same

	}
}