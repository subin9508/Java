package com.itwill.print;

public class PrintMain {

	public static void main(String[] args) {
		// 여러가지 콘솔 출력 방법:
		
		System.out.println("한 줄 출력(print line)");
		System.out.println("1 + 2"); // "1 + 2" 문자열(string)을 출력
		System.out.println(1 + 2); // 1 + 2 덧셈 결과를 출력
		System.out.println("1 + 2 = " + 3); // 문자열 + 문자열 
		System.out.println("1 + 2 = " + 1 + 2); // 문자열 + 문자열 1 + 문자열 2 순서대로 계산
		System.out.println("1 + 2 = " + (1 + 2)); // -> 1 + 2 = 3 (괄호 안을 먼저 계산 한 후 앞 문자열과 합쳐짐)
		// println은 엔터까지 포함한 것, 따라서 출력한 다음에 커서가 밑에 가서 대기하고 있음.
		// print는 커서가 출력문 바로 옆에서 대기 (줄 바꿈이 없음)
		System.out.print("안녕하세요~");
		System.out.println("Hello");
		
		// formatted printing: 형식을 갖는 출력문
		// \n: 줄바꿈(new line) > 대소문자 구별
		// \t:탭(tab)
		System.out.printf("문자열 포맷: 정수(%d), 실수(%f), 문자열(%s)\n", 123, 3.14, "홍길동"); 
		// 순서대로 타입에 맞게 값을 끌고 옴, 줄 바꿈을 위한 백슬래쉬(\n)는 띄어쓰지 않는다.
		System.out.printf("%d + %d = %d", 1, 2, (1+2));
	}

}
 