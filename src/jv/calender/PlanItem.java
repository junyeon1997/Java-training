package jv.calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
	
	public Date planDate;
	public String detail;
	public String location;
	public String people ="";
	
	public static Date getDatefromString(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public PlanItem(String date, String location, String detail) {
		this.planDate = getDatefromString(date);
		this.location = location;
		this.detail = detail;
	}
	
	public Date getDate() {
		return planDate;
	}
	
	public void addPeople(String name) {
		people +=name + ",";
	}

	public String saveString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = formatter.format(planDate);
		return sdate + ", " +"장소: " + location + ", " + "일정: " + detail  + "\n";
	}
	
}
