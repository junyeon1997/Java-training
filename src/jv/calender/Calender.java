package jv.calender;

public class Calender {
	
	private static final int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int[] leapMaxDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};	
	
	public boolean isLeapYear(int year) {
		if(year % 4 ==0 && (year % 100 !=0 || year % 400 ==0)) {
			return true;
		}else
			return 	false;
	}
	
	public int getmaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return leapMaxDays[month - 1];
		}else {
			return maxDays[month - 1];			
		}
	}
	
	public void printCalender(int year, int month, int weekday) {
		System.out.printf("     <<%4d년%3d월>>\n", year, month);
		System.out.println("  SU MO TU WE TH FR SA ");
		System.out.println("  --------------------");
		
		//print black space
		for (int i=0; i<weekday; i++) {
			System.out.print("   ");
		}
		
		int maxDay = getmaxDaysOfMonth(year, month);
		
		int count = 7 - weekday;
		
		
		//print first line
		for (int i = 1; i<=count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		
		//print from second line to last
		for (int i=count+1; i<=maxDay; i++) {
			if(count==7) {count=0;}
			System.out.printf("%3d",i);
			if (i%7==count) {
				System.out.println();
			}
		}System.out.println();
		
//		System.out.println("1  2  3  4  5  6  7");
//		System.out.println("8  9  10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
	}
}

	
