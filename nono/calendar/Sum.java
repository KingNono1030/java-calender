package nono.calendar;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // scanner 클래스 빌려오겠습니다. 키보드, 파일 등의 입력 장치를 연거야. 문을 열어재낀거, 문을 열었으면 닫아야지. -> scanner.close(); warning은 엥간하면 다 없애자
		
//		int c, d;
//		String s1, s2;
//		s1 = scanner.next();
//		s2 = scanner.next();
//		System.out.println(s1 + "\n" + s2);
		
		String num = scanner.nextLine();
		String[] numsplit = num.split(" ");
		int a = Integer.parseInt(numsplit[0]);
		int b = Integer.parseInt(numsplit[1]);
		
		System.out.println("두 수를 입력하세요.");
		System.out.println("두 수의 합은 "+ (a + b) + "입니다.");
		System.out.printf("두 수의 합은 %d입니다.\n", a+b);
		System.out.printf("%d와 %d의 합은 %d입니다.", a, b, a+b);
		scanner.close(); // scanner 닫기
	}

}
// CTRL + SHIFT + M : 자동 IMPORT
// scanner 원래 파일을 읽어서 입력을 쉽게 벋아, but 우리는 파일을 읽는게 아니니까 System.in 은 키보드에서 입력을 받음을 의미.
// 문자열 사이에 int 변수의 합을 구하니 (Ex: a = 1, b= 2, "안녕" + a + b) =. 안녕12, 요래 됨, 문자열로 싸그리 보고 나온 결과인듯?
// system.out.println("안녕"+(a+b)); 괄호로 묶어주면 연산이 됨!
// 혹은 printf 를 이용할 수, printf 안에서는 변수의 속성을 일일이 지정가능. 문자열 사이 %d의 의미는 '이 자리에 int 값을 넣겠습니다 의미', printf("안녕 %d", 3 + 5);