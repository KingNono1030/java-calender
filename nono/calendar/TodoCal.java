package nono.calendar;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoCal {
	public static VraiVraiCal vcal = new VraiVraiCal(); // 다른 클래스의 메서드 호출을 위한 인스턴스 생성
	public static TodoCal todo = new TodoCal();
	private static Scanner scanner = new Scanner(System.in); // 스캐너의 인스턴스 생성은 반복해서는 안됨. 해보니까 오류남. 그래서 글로벌 변수에 저장함.
	private static ArrayList<ArrayList<String>> datetodolist = null; // 향후 채워넣을 Arraylist의 크기를 0으로 설정
	private static ArrayList<String> todolist = null;
	private static ArrayList<String> dateList = new ArrayList<>(); // arraylist 선언
	private static int[] searchDateArr = new int[3]; //  Arr 특) 크기를 지정해야 함

	public void getCommand(String order) { // 명령어 (1 2 3 h q) 입력에 따라 어떤 메서드를 실행할 지 결정해주는 메서드 
		if (order.equals("1")) {
			todo.firstCommand();
		}
		if (order.equals("2")) {
			todo.secondCommand();
		}
		if (order.equals("3")) {
			todo.getthirdCommand();
		}
		if (order.equals("h")) {
			System.out.println(
					"+----------------------+\n| 1. 일정 등록\n| 2. 일정 검색\n| 3. 달력 보기\n| h. 도움말 q. 종료\n+----------------------+\n");
		} 
	}

	public void firstCommand() {
		System.out.print("\n[일정 등록]\n 날짜를 입력하세요. (YYYY-MM-DD)\n> ");
		scanner.nextLine(); // nextline 호출해 버퍼 처리하기. 이거 안하면 nextline() 뒤에 오는 next()에서의 입력까지 이상해짐.
		String inputDate = scanner.nextLine();
		dateList.add(inputDate); // arraylist when에 요소를 추가. 등록한 일정을 입력한 순서대로 저장한 뒤, 그 순서를 기억해 일정을 호출할 때, 쓰기 위함.
		System.out.print("\n일정을 입력하세요. (일정 사이에는 쉼표로 구분)\n> ");
		String inputTodo = scanner.nextLine();
		String[] inputTodoArr = inputTodo.split(", ");
		todo.getSchedule(inputTodoArr);
		System.out.println("일정이 등록되었습니다.\n");
	}

	private void getSchedule(String[] inputTodoArr) {
		todolist = new ArrayList<String>(); // 루프가 돌 때마다, 새로운 todolist를 생성하기 (arrlist 특 - 집어넣은 순서대로 요소의 위치가 결정
		for (int i = 0; i < inputTodoArr.length; i++) { // 등록한 일정 횟수만큼, todolist 에 일정 저장하기
			todolist.add(inputTodoArr[i]);
		}
		datetodolist.add(todolist);
	}

	public void secondCommand() {
		System.out.println("[일정 검색] 날짜를 입력하세요. (YYYY-MM-DD)");
		scanner.nextLine();
		String searchDate = scanner.nextLine();
		String[] splitSearchDate = searchDate.split("-");
		for (int i = 0; i < splitSearchDate.length; i++) { // 검색한 날짜의 요소 (년, 월, 일)를 정수로 바꾸는 작업 
			searchDateArr[i] = Integer.parseInt(splitSearchDate[i]);
		}
		int dateindex = dateList.indexOf(searchDate); // 등록한 일정이 위치한 날짜 정보를 저장한 datelist 에서, 등록날짜인 inputDate와 검색한 날짜인 searchDate와 비교를 통해, 불러오고자 하는 일정의 위치를 구하는 로직
		int todoCount = datetodolist.get(dateindex).size(); // get(떙).size()
		System.out.printf("%d개의 일정이 있습니다.\n", todoCount);
		for (int i = 0; i < todoCount; i++) {
			System.out.printf("%d. %s.\n", i + 1, datetodolist.get(dateindex).get(i)); // 구한 일정의 위치를 바탕으로, 해당 날짜의 일정들을 호출
		}
	}

	public void getthirdCommand() {
		System.out.println("[달력보기]");
		int searchYear = searchDateArr[0];
		int searchMonth = searchDateArr[1];
		int searchDay = searchDateArr[2];
		todo.getCalendar(searchYear, searchMonth, searchDay);
	}

	public void getCalendar(int searchYear, int searchMonth, int searchDay) { // 달력을 만드는 로직
		String firstWhichDay = vcal.getfirstday(searchYear, searchMonth); // 해당 년도와 월에 처음으로 시작하는 날의 요일을 구하는 로직
		System.out.printf("%d년 %d월 %d일\n", searchYear, searchMonth, searchDay);
		System.out.println();
		System.out.printf("   <<%4d년%3d월%3d일>>\n", searchYear, searchMonth, searchDay);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		for (int i = 0; i < 7; i++) {
			if (firstWhichDay.equals(vcal.getDays(i))) {
				System.out.print("   ".repeat(i));
			}
		}
		for (int i = 1; i <= vcal.getMaxdays(searchYear, searchMonth); i++) {
			System.out.printf("%3d", i);
			todo.calendarLine(firstWhichDay, i, searchDay);
		}
		System.out.println();
		System.out.println();
	}

	public void calendarLine(String firstWhichDay, int dayCount, int searchDay) {
		for (int i = 0; i < 7; i++) {
			if (firstWhichDay.equals(vcal.getDays(i))) {
				if (dayCount % 7 == (7 - i) % 7) { // 토요일이 올 때마다 줄바꿈 하기
					System.out.print("\n");
					if (dayCount == (searchDay + 7 + (-i - searchDay) % 7)) {
						System.out.print("   ".repeat((i + searchDay - 1) % 7));
						System.out.print(" . ");
						System.out.println("   ".repeat(6 - (i + searchDay - 1) % 7)); // 검색한 일정이 있는 날짜에 표시를 하는 로직
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<String> dateList = new ArrayList<>();
		dateList.add(null); // unused local 변수를 처리하기 위해, 아무 정보도 집어 넣지 않음
		datetodolist = new ArrayList<ArrayList<String>>(); // 루프 밖에 위치
		System.out.println(
				"+----------------------+\n| 1. 일정 등록\n| 2. 일정 검색\n| 3. 달력 보기\n| h. 도움말 q. 종료\n+----------------------+\n");
		for (;;) {
			System.out.print("명령 (1, 2, 3, h, q)\n> ");
			String order = scanner.next();
			if (order.equals("q")) { // break 명령어는 루프 안에 위치해야 하기 때문에, 메서드 처리 못 함
				System.out.println("Bye");
				break;
			} else {
				todo.getCommand(order);
			}
		}
		scanner.close();
	}

}
// new 선언은 반복 안되는게 좋아
// 달력 표기만 준비
