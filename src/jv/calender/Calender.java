package jv.calender;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Calender {
	
	private static final int[] maxDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int[] leapMaxDays = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};	
	private static final String saveFile = "canlender.dat";
	
	private HashMap<Date, PlanItem> planMap;
	
	public Calender() {
		planMap = new HashMap<Date, PlanItem>();
		File f = new File(saveFile);
		if(!f.exists()) {
			return;
		}
		try{
			Scanner s = new Scanner(f);
			while(s.hasNext()) {
				String line = s.nextLine();
				String[] words = line.split(",");
				String date = words[0];
				String detail = words[1].replace("\"", "");
				PlanItem p = new PlanItem(date, detail);
				planMap.put(p.getDate(), p);
			}s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void resgisterPlan(String strDate, String plan) {
		
		PlanItem p = new PlanItem(strDate, plan);
		planMap.put(p.getDate(), p);
		
		File f = new File(saveFile);
		String item = p.saveString();
		
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write(item);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public PlanItem searchPlan(String strDate){
		Date date = PlanItem.getDatefromString(strDate);
		return planMap.get(date);
	}
	
	public boolean isLeapYear(int year) {
		if(year % 4 ==0 && (year % 100 !=0 || year % 400 ==0)) {
			return true;
		}else
			return 	false;
	}
	
	public int getmaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return leapMaxDays[month];
		}else {
			return maxDays[month];			
		}
	}
	
	private int getWeekDay(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4; //1970/Jan/1st = Thursday
		
		int count = 0;
		
		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
		
		//System.out.println(count);
		for (int i = 1; i < month; i++) {
			int delta = getmaxDaysOfMonth(year, i);
			count += delta;
		}
		
		count += day-1;
		
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		return weekday;
	}
	
	public void printCalender(int year, int month) {
		System.out.printf("     <<%d년%d월>>\n", year, month);
		System.out.println("  SU MO TU WE TH FR SA ");
		System.out.println("  --------------------");
		
		//get weekday automatically
		int weekday =getWeekDay(year, month, 1);
		
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
		
	}
}

	
