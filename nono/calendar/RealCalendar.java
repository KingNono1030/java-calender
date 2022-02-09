package nono.calendar;

import java.util.Iterator;
import java.util.Scanner;
//
//public class RealCalendar {
//	public void print28() {
//		System.out.println("일 월 화 수 목 금 토");
//		System.out.println("--------------------");
//		System.out.println(" 1  2  3  4  5  6  7");
//		System.out.println(" 8  9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
//	}
//
//	public void print30() {
//		System.out.println("일 월 화 수 목 금 토");
//		System.out.println("--------------------");
//		System.out.println(" 1  2  3  4  5  6  7");
//		System.out.println(" 8  9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
//		System.out.println("29 30");
//	}
//
//	public void print31() {
//		System.out.println("일 월 화 수 목 금 토");
//		System.out.println("--------------------");
//		System.out.println(" 1  2  3  4  5  6  7");
//		System.out.println(" 8  9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
//		System.out.println("29 30 31");
//	}
//
//	public static void main(String[] args) {
//		int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
//		int month;
//		String prompt = "cal> ";
//
//		Scanner scanner = new Scanner(System.in);
//		RealCalendar cal = new RealCalendar();
//		for (;;) {
//			System.out.println("월을 입력하세요.");
//			System.out.print(prompt);
//			month = scanner.nextInt();
//			if (month < 1) {
//				System.out.println("Bye~");
//				break;
//			} else if (month > 12) {
//				System.out.println("Bye~");
//				break;
//			} else if (days[month - 1] == 28) {
//				cal.print28();
//			} else if (days[month - 1] == 30) {
//				cal.print30();
//			} else if (days[month - 1] == 31) {
//				cal.print31();
//			}
//		}
//		scanner.close();
//	}
//
//} // 여까지 내가 한거

public class RealCalendar {
	public static void main(String[] args) {
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		System.out.print("월을 입력하세요.\ncal> ");
		Scanner scanner = new Scanner(System.in);
		for (;;) {
			int month = scanner.nextInt();
			if ((month < 1) || (month > 12)) {
				System.out.println("Bye~");
				break;
			} else {
				System.out.println(" SU MO TU WE TH FR SA");
				System.out.println(" --------------------");
				for (int i = 1; i <= days[month - 1]; i++) {
					System.out.printf("%3d", i);
					if(i%7==0) {
						System.out.println();
					}
				}

			}
		}
		scanner.close();

	}

}
// println 특) \n이 포함되어 있어서 알아서 줄바꿈, 그 외 print 애들은 직접 입력해주어야
// scanner.close() 왜 안되는지 모르겠음