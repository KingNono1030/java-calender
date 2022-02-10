package nono.calendar;

import java.util.Scanner;

public class VraiCal {

	private static int[] date = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static String[] days = {"SU", "MO", "TU", "WE", "TH", "FR", "SA"};

	public static VraiCal cal = new VraiCal();

	public void print(int year, int month, String firstday) {

		System.out.println();
		System.out.printf("   <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		if (firstday.equals("SU")) { // 7
		} else if (firstday.equals("MO")) {
			System.out.print("   "); // 6
		} else if (firstday.equals("TU")) {
			System.out.print("      "); // 5
		} else if (firstday.equals("WE")) {
			System.out.print("         "); // 4
		} else if (firstday.equals("TH")) {
			System.out.print("            "); // 3
		} else if (firstday.equals("FR")) {
			System.out.print("               "); // 2
		} else if (firstday.equals("SA")) {
			System.out.print("                  "); // 1
		}
	}

	public int getMaxdays(int year, int month) {
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			date[1] = 29;
		}
		int Maxday = date[month - 1];
		return Maxday;
	}

	public void makeCalendar(int year, int month, String firstday) {
		for (int i = 1; i <= cal.getMaxdays(year, month); i++) {
			System.out.printf("%3d", i);
			if (firstday.equals("SU")) {
				if (i % 7 == 0) {
					System.out.print("\n");
				}
			}
			if (firstday.equals("MO")) {
				if (i % 7 == 6) {
					System.out.print("\n");
				}
			}
			if (firstday.equals("TU")) {
				if (i % 7 == 5) {
					System.out.print("\n");
				}
			}
			if (firstday.equals("WE")) {
				if (i % 7 == 4) {
					System.out.print("\n");
				}
			}
			if (firstday.equals("TH")) {
				if (i % 7 == 3) {
					System.out.print("\n");
				}
			}
			if (firstday.equals("FR")) {
				if (i % 7 == 2) {
					System.out.print("\n");
				}
			}
			if (firstday.equals("SA")) {
				if (i % 7 == 1) {
					System.out.print("\n");
				}
			}

		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		for (;;) {
			System.out.print("년도를 입력하세요.\nYEAR>");
			int year = scanner.nextInt();
			System.out.println("달을 입력하세요.\nYEAR>");
			int month = scanner.nextInt();
			System.out.println("첫번째 요일을 입력하세요. (SU MO TU WE TH FR SA).\nWEEKDAY>");
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