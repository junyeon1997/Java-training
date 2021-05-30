package jv.calender;

import java.util.Scanner;

public class Prompt {
	/**
	 * 
	 * @param week 요일명
	 * @return 0=Sunday ~ 6=Saturday
	 */
	
	public int parseDay(String week) {
		if (week.equals("su")) return 0; 
		else if (week.equals("mo")) return 1;
		else if (week.equals("tu")) return 2;
		else if (week.equals("we")) return 3;
		else if (week.equals("th")) return 4;
		else if (week.equals("fr")) return 5;
		else if (week.equals("sa")) return 6;
		else return 0;
	}
	
	
	public void runPrompt() {
		
		//숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		
		int month = -1;
		int year = -1;
		int weekday = 0;
		
		while(true) {
			System.out.println("년도을 입력하세요.(exit: -1)");
			System.out.println("Year> ");
			year = scanner.nextInt();
			
			if ( year == -1)
				break;
			
			System.out.println("달을 입력하세요.(exit: -1)");
			System.out.println("Month> ");
			month = scanner.nextInt();
			
			if (month ==-1) {
				break;
			}
			if (month > 12 || month < 1) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			System.out.println("첫째날의 요일을 입력하세요 (su, mo, tu, we, th, fr, sa)");
			String str_weekday = scanner.next();
			weekday = parseDay(str_weekday);
			
			cal.printCalender(year, month, weekday);
			
		}
		System.out.println("프로그램 종료");
		scanner.close();
		
		
	}

public static void main(String[] args) {
	Prompt p = new Prompt();
	p.runPrompt();
	
	}

}