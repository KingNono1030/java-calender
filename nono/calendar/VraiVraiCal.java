package nono.calendar;

import java.util.Scanner;

public class VraiVraiCal {

	public static VraiVraiCal vcal = new VraiVraiCal();

	public String getDays(int order) {
		String[] days = { "SU", "MO", "TU", "WE", "TH", "FR", "SA" };
		String day = days[order];
		return day;
	}

	public String getfirstday(int year, int month) {
		String firstday = getDays(5);
		firstday = getDays((5 + vcal.getDategap(year, month)) % 7);
		return firstday;
	}

	public int getDategap(int year, int month) {
		int dategap = 0;
		for (int i = 1582; i <= year; i++) {
			if (year == 1582) {
				for (int j = 10; j < month; j++) {
					dategap += vcal.getMaxdays(i, j);
				}
			} else {
				if (i == 1582) {
					for (int j = 10; j <= 12; j++) {
						dategap += vcal.getMaxdays(i, j);
					}
				}
				if ((1582 < i) && (i < year)) {
					for (int j = 1; j <= 12; j++) {
						dategap += vcal.getMaxdays(i, j);
					}
				}
				if (i == year) {
					for (int j = 1; j < month; j++) {
						dategap += vcal.getMaxdays(i, j);
					}
				}
			}
		}
		return dategap;
	}

	public int getMaxdays(int year, int month) {
		int[] date = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			date[1] = 29;
		}
		int Maxday = date[month - 1];
		return Maxday;
	}

	public void print(int year, int month, String firstday) {
		System.out.println();
		System.out.printf("   <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		vcal.blank(firstday);
	}

	public void blank(String firstday) {
		for (int i = 0; i < 7; i++) {
			if (firstday.equals(getDays(i))) {
				System.out.print("   ".repeat(i));
			}
		}
	}

	public void makeCalendar(int year, int month, String firstday) {
		for (int i = 1; i <= vcal.getMaxdays(year, month); i++) {
			System.out.printf("%3d", i);
			vcal.locate(firstday, i);
		}
	}

	public void locate(String firstday, int times) {
		for (int i = 0; i < 7; i++) {
			if (firstday.equals(getDays(i))) {
				if (times % 7 == (7 - i)%7) {
					System.out.print("\n");
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for (;;) {
			System.out.print("년도를 입력하세요.\nYEAR> ");
			int year = scanner.nextInt();
			System.out.print("달을 입력하세요.\nMONTH> ");
			int month = scanner.nextInt();
			String firstday = vcal.getfirstday(year, month);

			vcal.print(year, month, firstday);
			if ((month < 1) || (month > 12)) {
				break;
			} else {
				vcal.makeCalendar(year, month, firstday);
				System.out.println();
				System.out.println();
			}
		}
		System.out.println("Thank you!");
		scanner.close();
	}

}
