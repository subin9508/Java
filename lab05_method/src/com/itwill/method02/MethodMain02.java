package com.itwill.method02;

/*
 * 메서드 선언(정의) 방법:
 * [수식어] 리턴타입 메서드이름([파라미터 선언, ...]) { code; ...}
 * 대괄호 부분은 생략 가능한 부분. 리턴타입, 메서드이름, () 는 필수
 * - 수식어 생략 가능
 * - 아규먼트를 갖지 않는 메서드는 파라미터를 선언하지 않음.
 * - 메서드에 반환값이 없는 경우에는 리턴타입으로 void를 사용해야 함.
 * - 메서드는 클래스 안에서 작성(선언).
 * - 다른 메서드 안에서 메서드를 선언할 수 없음!
 */
public class MethodMain02 {

	public static void main(String[] args) {
		// 아규먼트가 필요하고 반환값이 있는 메서드 작성 연습:
		
	double result = add(1.0, 2.0); // add 메서드 호출
	System.out.println(result);
	
	double result2 = subtract(6.0, 2.0);
	System.out.println(result2);
	
	double result3 = multiply(2.0, 3.0);
	System.out.println(result3);
	
	double result4 = divide(8.0, 4.0);
	System.out.println(result4);
		
	} // end main
	
	/**
	 * 숫자 2개를 전달 받아서, 두 숫자의 덧셈 결과를 반환.
	 * @param x 실수(double).
	 * @param y 실수(double).
	 * @return x + y를 반환.
	 */
	public static double add(double x, double y) {
		return x + y; // return문: 메서드를 호출한 곳으로 값을 반환할 때 사용하는 문장.
		 }
	public static double subtract(double x, double y) {
		return x - y;
	}
	
	public static double multiply(double x, double y) {
		return x * y;
	}
	public static double divide(double x, double y) {
		return x / y;
	}
} // end class
