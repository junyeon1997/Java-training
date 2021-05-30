package jv.calender;

import java.text.ParseException;
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
		switch (week) {
		case "su":
			return 0;
		case "mo":
			return 0;	
		case "tu":
			return 0;
		case "we":
			return 0;
		case "th":
			return 0;
		case "fr":
			return 0;
		case "sa":
			return 0;
			default:
				return 0;
		}
}
	
	
	public void runPrompt() throws ParseException {
		
		printMenu();
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		
		
		boolean isLoop =true;
		while(isLoop) {
			System.out.println("명령 (1, 2, 3, h, q");
			String cmd = scanner.next();
			switch (cmd) {
			case "1":
				cmdRegister(scanner, cal);
				break;
			case "2":
				cmdSearch(scanner, cal);
				break;
			case "3":
				cmdCal(scanner, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop=false;
				break;
			}
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

	private void cmdSearch(Scanner s, Calender c) throws ParseException {
		
		System.out.println("[일정검색]");
		try {
			System.out.println("날짜를 입력해주세요 (yyyy-MM-dd)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String date = s.next();
		String plan = c.searchPlan(date);
		System.out.println(plan);
	}

	private void cmdRegister(Scanner s, Calender cal) throws ParseException {
        System.out.println("[새 일정 등록]");
        System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
        String date = s.next();
        String text = "";
        s.nextLine(); //ignore one newline
        System.out.println("일정을 입력해 주세요.");
        text = s.nextLine();
        cal.resgisterPlan(date, text);
        
 
    }

public static void main(String[] args) throws ParseException {
	Prompt p = new Prompt();
	p.runPrompt();
	
	}

}

