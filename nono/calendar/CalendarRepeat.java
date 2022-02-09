package nono.calendar;

import java.util.Scanner;

//public class CalendarRepeat {
//	public static void main(String[] args) {
//		int [] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//		System.out.println("반복횟수를 입력하시오.");
//		Scanner scanner = new Scanner(System.in);
//		int repeatnum = scanner.nextInt();
//		
//		for (int i = 0; i < repeatnum; i++) {
//			System.out.println("달을 입력하시오.");
//			int month = scanner.nextInt();
//			System.out.printf("%d월은 %d일까지 있습니다. \n", month, days[month-1]);
//		}
//		scanner.close();
//		System.out.println("Bye~");
//	
//		
//		
//	}
//
//}

public class CalendarRepeat {
	public static void main(String[] args) {
		int [] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		System.out.println("반복횟수를 입력하시오");
		Scanner scanner = new Scanner(System.in);
		int repeat = scanner.nextInt();
		for (int i = 0; i < repeat; i++) {
			System.out.println("달을 입력하시오");
			int month = scanner.nextInt();
			System.out.printf("%d월은 %d일까지 있습니다. \n", month, days[month-1]);
		}
		scanner.close();
		System.out.println("Bye!");
	}
}