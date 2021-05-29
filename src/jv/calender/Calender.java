package jv.calender;

import java.util.Scanner;

public class Calender {
	
	private static final int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int getmaxDaysOfMonth(int month) {
		return maxDays[month - 1];
	}
	
	public void printSampleCalender() {
		System.out.println("일 월  화  수 목  금  토 ");
		System.out.println("--------------------");
		System.out.println("1  2  3  4  5  6  7");
		System.out.println("8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}

	public static void main(String[] args) {
		
		
		//숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		String prompt = "cal> ";
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		
		int month = 0;
		while(true) {
			System.out.println("달을 입력하세요.");
			System.out.println(prompt);
			month = scanner.nextInt();
			if (month ==-1) {
				break;
			}
			if (month > 12) {
				continue;
			}
			System.out.printf("%d월은 %d일까지 있습니다.\n", month, cal.getmaxDaysOfMonth(month));
			
		}
		System.out.println("프로그램 종료");
		scanner.close();
		
		
		
	}

}
