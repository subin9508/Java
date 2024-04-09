package com.itwill.exception03;

import java.util.Scanner;

public class ExceptionMain03 {
	
	private final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ExceptionMain03 app = new ExceptionMain03();
		
		int x = app.inputInteger();
		System.out.println("x= " + x);
		

	}

	public int inputInteger2() {
		try {
			System.out.print("정수 입력> ");
			return Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("정수로 입력하세요...");
			return inputInteger2(); // 재귀 호출
		}
	}
	
	
	
	
	
	
	public int inputInteger() {
		int result = 0;

		boolean run = true;
		while (run) {
			try {
				System.out.print("정수 입력>> ");
				result = Integer.parseInt(sc.nextLine());
				break; // return result; 로 사용하여 무한 루프를 종료시킬 수는 있지만 문법 오류 발생. (오류 수정: 반복문 밖 return 문을 삭제하면 된다.)
			} catch (NumberFormatException e) {
				System.out.println("x는 정수로 입력하세요.");
				System.out.println(e.getMessage());
			}
		}
		return result;

	}

}
