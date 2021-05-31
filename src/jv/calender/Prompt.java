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
	
	
	
	public void runPrompt() throws ParseException {
		
		printMenu();
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		
		
		boolean isLoop =true;
		while(isLoop) {
			System.out.println("명령 (1, 2, 3, h, q)");
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
		System.out.println("날짜를 입력해주세요 (yyyy-MM-dd)");
		String date = s.next();
		PlanItem plan = c.searchPlan(date);
		if (plan != null) {
		System.out.println(plan.detail);
		}else {
			System.out.println("일정이 없습니다.");
		}
	}

	private void cmdRegister(Scanner s, Calender cal) throws ParseException {
        System.out.println("[새 일정 등록]");
        System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
        String date = s.next();
        String text = "";
        System.out.println("일정을 입력해 주세요.(끝에;)");
        String word;
        while (!(word = s.next()).endsWith(";")){
        	text += word+" ";
        }
        word = word.replace(";", "");
        text+=word;
        cal.resgisterPlan(date, text);
        
 
    }

public static void main(String[] args) throws ParseException {
	Prompt p = new Prompt();
	p.runPrompt();
	
	}

}

