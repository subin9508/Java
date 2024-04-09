package com.itwill.variable05;

public class VariableMain05 {

	public static void main(String[] args) {
		// boolean 타입: true/false 만을 저장할 수 있는 데이터 타입.
		// 비교 연산, 논리 연산의 결과 값이 boolean 타입.
		// 비교 연산자: ==(같다), !=(다르다), >, >=(크거나 같다), <, <=(작거나 같다) 
		// 논리 연산자: &&(and), ||(or), !(아니다, 변수가 한 개)
		int x = 2; // = : 할당 연산자
		int y = 3;
		
		boolean b1 = (x != y);
		System.out.println(b1);
		
		boolean b2 = (x > y);
		System.out.println(b2);
		
		boolean b3 = (x > 0) && (x < 10);
		System.out.println(b3); 

	}

}
