package com.itwill.variable02;

public class VariableMain02 {

	public static void main(String[] args) {
		// 정수를 저장하는 변수 x를 선언하고, 값을 저장(초기화).
		int x = 200;
		
		
		// 정수를 저장하는 변수  y 선언하고, 값을 저장(초기화).
		int y = 2;
		
		// 두 변수 x와 y의 사칙연산(+, -, *, /) 결과를 각각 출력.
		System.out.println(x+y);
		System.out.println(x-y);
		System.out.println(x*y);
		System.out.println(x/y);
		
		System.out.println("x+y = " + (x+y));
		System.out.println("x-y = " + (x-y));
		System.out.printf("%d / %d = %d\n" , x, y, (x/y));
		System.out.println("나눈 나머지 = " + (x % y)); // % : 나머지를 계산하는 연산자 (정수일 때만 의미 있음)
		
		//나누기 연산자(/)
		// 정수 / 정수 결과는 나눈 "몫". (소수점 이하를 계산하지 않음.)
		// 실수 / 실수, 실수 / 정수, 정수 / 실수의 결과는 소수점까지 계산.
		double number1 = 100.0;
		double number2 = 3.0;
		System.out.println(number1 / number2);
		
		
		
	}

}
