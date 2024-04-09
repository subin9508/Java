package com.itwill.variable04;

public class VariableMain04 {

	public static void main(String[] args) {
		// 문자(character) 타입 변수 char 
		// char 타입: 문자 1개의 유니코드 값(2byte 정수)을 저장하는 타입.
		// 문자는 작은따옴표를 사용('a'), 문자열은 큰따옴표를 사용("abc")
		
		char ch1 = 'B';
		System.out.println(ch1);
		System.out.println((int) ch1);
		
		// char는 문자의 유니코드를 저장하는 특별한 종류의 정수 타입.
		// -> 사칙연산이 가능, 크기 비교도 가능.
		char ch2 = (char) (ch1 + 1);
		System.out.println(ch2);
		
		char ch3 = (char) (ch1 - 1); // 타입 변환에 괄호를 쓰지 않으면 변수 선언으로 인식하기 때문에
		// 반드시 괄호를 함께 적어주어야 함.
		System.out.println(ch3);
		
		// 1. 변수는 같은 타입의 값만 저장할 수 있음.
		// int i = 1; i = 1.0 (x)
		// int i = 1; i = 1L (x)
		// int i = 1; i = 2 (o)
		// 2. 큰 범위의 타입에는 작은 범위 타입의 값을 저장할 수 있음.
		// double x = 1.0; (o)
		// double x = 1;(o)
		// double x = (double)1;의 과정이 필요 없음.
		// float x = 1.0; (x)> 실수의 기본 타입이 double이기 때문.
		// 오류를 해결하려면 float x = 1.0F;로 표현.
		// 3. 작은 범위의 타입에 큰 범위 값을 저장하려고 하면 에러가 발생.
		// 예외: short s = 1; (o)
		// 4. 정수 리터럴(literal, 상수): 코드에 박아 놓는 숫자들 의미. (선언 변수 x)
		// 정수 리터럴은 범위를 넘지 않으면 byte, short, char에 저장 가능.
		// 강제 타입 변환(casting): 변수의 타입을 강제로 바꿈.

	}

}
