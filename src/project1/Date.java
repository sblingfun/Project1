/**
 * 
 */
package project1;

import java.util.Calendar;
import java.util.StringTokenizer;


/**
 * This class defines the Date class with a day, month, and year.
 * @author Alex
 */
public class Date implements Comparable<Date>{
	private int year;
	private int month;
	private int day;

	/**
	 * This constructor takes the form "mm/dd/yyyy".
	 * @param date in the form of"mm/dd/yyyy"
	 */
	public Date(String date) {
		StringTokenizer st = new StringTokenizer(date,"/");
		month = Integer.parseInt(st.nextToken());
		day = Integer.parseInt(st.nextToken());
		year = Integer.parseInt(st.nextToken());
	}

	/**
	 * This constructor uses today's date.
	 * 
	 */
	public Date() {
		Calendar current = Calendar.getInstance();
		month = current.get(Calendar.MONTH);
		day = current.get(Calendar.DATE);
		year = current.get(Calendar.YEAR);
	}
	
	/**
	
	public Date(Date date) {
		
	}
	
	public Date today() { //used for checking vs today I think
	
	}
**/

	public boolean isValid() {
		
		if ( invalidYear( this.year ) ) return false;
		if ( invalidMonth( this.month ) ) return false;
		if ( invalidDay( this.day, this.month, this.day ) ) return false;
		/**
		Date currentDate = new Date();
		if(this.year <= ConstantIdentifiers.OLDEST_YEAR || this.year >= currentDate.year) return false; 
				
		//check if month is valid
		if ( this.month > ConstantIdentifiers.NUMMONTHS || this.month < ConstantIdentifiers.FIRSTMONTH ) return false;
		
		//check if date is valid
		if( this.day < ConstantIdentifiers.FIRSTDAY ) return false;
		
		
		if((this.month == 2) && (this.year % 4 == 0) && (!(this.year % 100 == 0)) || (this.year % 400 == 0)){
			if (this.day > 29) return false;
		}	
		if ((mon == 2) && (year%4==0) && (!(year%100==0)) || (year%400==0)){
	        if (day >29){
	            return false;
		**/
		else return true;
	}
	
	private static boolean invalidYear( int year ) {
		Date currentDate = new Date();
		return year <= ConstantIdentifiers.OLDEST_YEAR || year >= currentDate.year;	
	}
	
	private static boolean leapYear( int year ) {
		if ( year % 4 == 0 ) {
			if ( year % 100 == 0 ) {
				if ( year % 400 == 0 )
					return true;
				else
					return false;				
			}
			else
				return true;
		}
		else
			return false;
	}

	private static boolean invalidMonth( int month ) {
		return month > ConstantIdentifiers.NUMMONTHS || month < ConstantIdentifiers.FIRSTMONTH;
	}
	
	private static boolean invalidDay( int day, int month, int year ) {
	    if ( day < ConstantIdentifiers.FIRSTDAY ) return true;
	    if ( month == ConstantIdentifiers.APRIL || month == ConstantIdentifiers.JUNE ||  month == ConstantIdentifiers.SEPTEMBER ||
	    		month == ConstantIdentifiers.NOVEMBER && day > ConstantIdentifiers.THIRTYDAYMAX) return true;
	    if ( month == ConstantIdentifiers.FEB ) {
	    	if ( leapYear(year) && day > ConstantIdentifiers.LEAPFEB ) return true;
	    	else if ( day > ConstantIdentifiers.FEBDAYS) return true;
	    }
	    if (day > ConstantIdentifiers.THIRTYDAYMAX) return true;
	    else return false;
	}

	/**
	@Override
	public int compareTo(Date date) {
	}
	
	**/
	
	/** Testbed main for the Date class...**/
	public static void main(String[] args) {
		/**
		Calendar testCal = Calendar.getInstance();
		System.out.println("current date: " + testCal.getTime());
		System.out.println("current month: " + testCal.get(Calendar.MONTH)); //why does it think its august?
		Date test = new Date();
		System.out.println("month: " + test.month);
		System.out.println("day: " + test.day);
		System.out.println("year: " + test.year);
		
		test = new Date("11/1/1980");
		System.out.println("month: " + test.month);
		System.out.println("day: " + test.day);
		System.out.println("year: " + test.year);		
		
		System.out.println("2000 is a leap year: " + leapYear(2000));
		System.out.println("2001 is a leap year: " + leapYear(2001));
		System.out.println("2004 is a leap year: " + leapYear(2004));
		System.out.println("1970 is a leap year: " + leapYear(1970));
		System.out.println("1972 is a leap year: " + leapYear(1972));
		System.out.println("month: " + test.month);
		**/
		//test case #1 invalid year before 1980
		Date test = new Date("11/1/1979");
		boolean expectedResult = false;
		boolean result = test.isValid();
		System.out.print("Test case #1: ");
		if (result == expectedResult)
			System.out.println("Pass.");
		else
			System.out.println("Fail.");
		
		//test case #2 invalid year after current
		test = new Date("11/1/2022");
		result = test.isValid();
		System.out.print("Test case #2: ");
		if (result == expectedResult)
			System.out.println("Pass.");
		else
			System.out.println("Fail.");
		
		//test case #3 invalid month less than 1
		test = new Date("0/6/2000");
		result = test.isValid();
		System.out.print("Test case #3: ");
		if (result == expectedResult)
			System.out.println("Pass.");
		else
			System.out.println("Fail.");
		
		//test case #4 invalid month greater than 12
		test = new Date("13/6/2000");
		result = test.isValid();
		System.out.print("Test case #4: ");
		if (result == expectedResult)
			System.out.println("Pass.");
		else
			System.out.println("Fail.");
		
		//test case #5 invalid day less than 0
		test = new Date("6/0/2000");
		result = test.isValid();
		System.out.print("Test case #5: ");
		if (result == expectedResult)
			System.out.println("Pass.");
		else
			System.out.println("Fail.");
		
		//test case #6 invalid day greater than 31 in May
		test = new Date("6/32/2000");
		result = test.isValid();
		System.out.print("Test case #6: ");
		if (result == expectedResult)
			System.out.println("Pass.");
		else
			System.out.println("Fail.");
		
		//test case #7 invalid day greater than 28 in Feb on a non-leap year
		test = new Date("6/29/2001");
		result = test.isValid();
		System.out.print("Test case #7: ");
		if (result == expectedResult)
			System.out.println("Pass.");
		else
			System.out.println("Fail.");
		
		//test case #8 invalid day greater than 29 in Feb on a leap year
		test = new Date("6/30/2000");
		result = test.isValid();
		System.out.print("Test case #8: ");
		if (result == expectedResult)
			System.out.println("Pass.");
		else
			System.out.println("Fail.");
		
		//test case #9 valid day of 29 in Feb on a leap year
		test = new Date("6/29/2000");
		result = test.isValid();
		System.out.print("Test case #9: ");
		if (result == !expectedResult)
			System.out.println("Pass.");
		else
			System.out.println("Fail.");

	}
}
