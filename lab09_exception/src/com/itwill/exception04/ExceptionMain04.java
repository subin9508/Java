package com.itwill.exception04;

/*
 * 예외 클래스들의 상속 관계:
 * Object
 * |__ Throwable 
 * 		|__ Exception
 * 			|__ RuntimeException
 * 				|__ ArithmeticException, NumberFormatException, NullPointerException, ...
 * 
 * catch 블록이 여러개인 경우, 하위 타입의 예외 타입을 먼저 catch하고,
 * 상위 타입의 예외를 나중에 catch해야 한다. 
 */

public class ExceptionMain04 {

	public static void main(String[] args) {
		// Finally : 예외 상항 발생 여부와 상관없이 항상 실행되는 블록.
		// try 또는 catch 블록에 return 문장이 있어도, 
		// finally 블록이 실행된 후에 return 문장이 실행된다.
		
		
		
		try {
			int x = 100;
			int y = 5;
			System.out.println("몫 = " + (x / y));
			System.out.println("end try");
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("end catch");
			return; // main 메서드 종료
		} finally {
			System.out.println("언제 출력될까요?");
		}
		
		System.out.println("end main");
	} 	
	
	  

}
