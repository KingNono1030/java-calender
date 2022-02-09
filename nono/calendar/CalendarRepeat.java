package nono.calendar;

//import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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

//public class CalendarRepeat {
//	public static void main(String[] args) {
//		int [] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//		System.out.println("반복횟수를 입력하시오");
//		Scanner scanner = new Scanner(System.in);
//		int repeat = scanner.nextInt();
//		for (int i = 0; i < repeat; i++) {
//			System.out.println("달을 입력하시오");
//			int month = scanner.nextInt();
//			System.out.printf("%d월은 %d일까지 있습니다. \n", month, days[month-1]);
//		}
//		scanner.close();
//		System.out.println("Bye!");
//	}
//}

public class CalendarRepeat {
	public static void main(String[] args) {
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (;;) {
			JFrame frame = new JFrame();
			Object result = JOptionPane.showInputDialog(frame, "월을 입력하시오");
			int month = Integer.parseInt((String) result);
			if (month < 1) {
				System.out.println("Have a nice day!");
				break;
			} else if (month > 12) {
				System.out.println("Have a nice day!");
				break;
			} else {
				System.out.printf("%d월은 %d일까지 있습니다 \n", month, days[month - 1]);
			}
		}
	}

}
// println과 print의 차이는 몰루?
// 팝업창 열려면 JFrame frame = new JFrame();
//Object result = JOptionPane.showInputDialog(frame, "   ");
// 무한루프 방법 while(true) / for(;;)
// 루프 깨기 명령어 : break
// 