package jv.calender;

import java.util.Scanner;

public class Prompt {
	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");

	}
	
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
		
		printMenu();
		
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		
		
	
		while(true) {
			String cmd = scanner.next();
			if(cmd.equals("1")) cmdRegister();
			else if (cmd.equals("2")) cmdSearch();
			else if (cmd.equals("3")) cmdCal(scanner, cal);
			else if (cmd.equals("h")) printMenu();
			else if (cmd.equals("q")) 
				break;
		}
	
		System.out.println("프로그램 종료");
		scanner.close();
	}
		
	private void cmdCal(Scanner s, Calender c) {
		int month = -1;
		int year = -1;
		System.out.println("년도을 입력하세요.(exit: -1)");
		System.out.println("Year> ");
		year = s.nextInt();
		
		System.out.println("달을 입력하세요.(exit: -1)");
		System.out.println("Month> ");
		month = s.nextInt();
	
		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
			return;
		}

		c.printCalender(year, month);
	}

	private void cmdSearch() {
		
	}

	private void cmdRegister() {
		
	}

public static void main(String[] args) {
	Prompt p = new Prompt();
	p.runPrompt();
	
	}

}

