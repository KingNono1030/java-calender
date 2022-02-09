package nono.calendar;

import java.util.Scanner;

//public class CalendarApp {
//
//	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
//
//	public int getmaxDaysOfMonth(int month) {
//		return MAX_DAYS[month - 1];
//
//	}
//
//	public void printSampleCalendar() {
//		System.out.println("일 월 화 수 목 금 토");
//		System.out.println("--------------------");
//		System.out.println(" 1  2  3  4  5  6  7");
//		System.out.println(" 8  9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
//	}
//
//	public static void main(String[] args) {
//
//		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
//		System.out.println("달을 입력하세요.");
//		Scanner scanner = new Scanner(System.in);
//		int num = scanner.nextInt();
//		scanner.close();
//		CalendarApp cal = new CalendarApp();
//		System.out.printf("%d월은 %d일까지 있습니다.\n", num, cal.getmaxDaysOfMonth(num));
//		cal.printSampleCalendar();
//	}
//
//}
// 들여쓰기가 엉망이다 -> ctrl + shift + F
// 로직, 함수(메서드)들은 엥간하면 밖으로 빼놓는 습관!
// public, private, static, final 등의 함수 난 몰라!

// if 문으로도 해결해볼 수 있어
/*
	public int getmaxDaysOfMonth(int month) {
		if(month == 1){
			return 31;
		}...

	}

// switchcase를 이용할 수도

	public int getmaxDaysOfMonth(int month) {
		switch(month){
			case 2:
				return 28;
			case 4:
				return 30;
			default:
				return 31;
		}...

	}

 */

public class CalendarApp{
//	private final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//
//	public int getMaxdays(int month) {
//		return MAX_DAYS[month-1];		
//	}
	
	public int getMaxdays(int month) {
		switch (month) {
		case 2:
			return 28;
		case 4: case 6: case 9: case 11:
			return 30;
		default:
			return 31;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("달을 입력하세요");
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		scanner.close();
		CalendarApp cal = new CalendarApp();
		System.out.printf("%d월은 %d일까지 있습니다.", month, cal.getMaxdays(month));
	}
}