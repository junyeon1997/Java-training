package jv.calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
	
	public Date planDate;
	public String location;
	public String participants;
	public String detail;
	
	public static Date getDatefromString(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd/HH:mm").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public PlanItem(String date, String location, String participants, String detail) {
		this.planDate = getDatefromString(date);
		this.location = location;
		this.detail = detail;
		this.participants = participants;
	}
	
	public Date getDate() {
		return planDate;
	}
	
	public String saveString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd/HH:mm");
		String sdate = formatter.format(planDate);
		return sdate + ", " +"장소: " + location + ", "+"참여인원: "+ participants + ", " + "일정: "+ detail  + "\n";
	}
	
}
