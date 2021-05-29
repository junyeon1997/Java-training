package jv.calender;

import java.util.Scanner;

public class Prompt {
	
//	private final static String prompt="cal>";
	
	public void runPrompt() {
		
		//숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		
		int month = -1;
		int year = -1;
		
		while(true) {
			System.out.println("년도을 입력하세요.");
			System.out.println("Year> ");
			year = scanner.nextInt();
			
			System.out.println("달을 입력하세요.");
			System.out.println("Month> ");
			month = scanner.nextInt();
			if (month ==-1) {
				break;
			}
			if (month > 12) {
				continue;
			}
			cal.printCalender(year, month);
			
		}
		System.out.println("프로그램 종료");
		scanner.close();
		
		
	}

public static void main(String[] args) {
	Prompt p = new Prompt();
	p.runPrompt();
	
	}

}