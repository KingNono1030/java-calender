package nono.calendar;

import java.util.Scanner;

public class VraiCal {

	private static String[] days = { "SU", "MO", "TU", "WE", "TH", "FR", "SA" };
	public static VraiCal cal = new VraiCal();

	public void print(int year, int month, String firstday) {
		System.out.println();
		System.out.printf("   <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		cal.blank(firstday);
	}

	public void blank(String firstday) {
		for (int i = 0; i < days.length; i++) {
			if (firstday.equals(days[i])) {
				System.out.print("   ".repeat(i));
			}
		}
	}

	public void locate(String firstday, int times) {
		for (int i = 0; i < days.length; i++) {
			if (firstday.equals(days[i])) {
				if (times % 7 == (7 - i)%7) {
					System.out.print("\n");
				}
			}
		}
	}

	public int getMaxdays(int year, int month) {
		int[] date = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			date[1] = 29;
		}
		int Maxday = date[month - 1];
		return Maxday;
	}

	public void makeCalendar(int year, int month, String firstday) {
		for (int i = 1; i <= cal.getMaxdays(year, month); i++) {
			System.out.printf("%3d", i);
			cal.locate(firstday, i);
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		for (;;) {
			System.out.print("년도를 입력하세요.\nYEAR> ");
			int year = scanner.nextInt();
			System.out.print("달을 입력하세요.\nMONTH> ");
			int month = scanner.nextInt();
			System.out.print("첫번째 요일을 입력하세요. (SU MO TU WE TH FR SA).\nWEEKDAY> ");
			String firstday = scanner.next();
			cal.print(year, month, firstday);
			if ((month < 1) || (month > 12)) {
				break;
			} else {
				cal.makeCalendar(year, month, firstday);
				System.out.println();
			}
		}
		System.out.println("Thank you!");
		scanner.close();

	}

}
// 문자열 비교할 때 == 와 (문자열.equals(문자열)) 은 완전히 다르다
// 엥간하면 입력은 메인메서드에서 받고, 입력값을 가지고 다른 메서드로부터 결과를 받는게 편한듯?
// 메인 메서드에서 위에 빌려온 메서드로 보내주는 키는 : F3
// print 반복 System.out.print("   ".repeat(i));