package com.itwill.loop01;

public class LoopMain01 {

	public static void main(String[] args) {
		// 반복문
		System.out.println("Java 1");
		
		
		
		
		System.out.println("--------------------");
		
		
		for (int i = 1; i <= 5; i++) {
			System.out.println("Java " + i);
		}
		// 지역 변수(local variable): 메서드 안에서 선언한 변수.
		// 지역 변수의 사용 범위:
		// 지역 변수는 선언된 순간부터 변수가 포함된 블록(중괄호{...} 안 쪽) 안에서만 사용 가능.
		// for 문장의 초기식 (int i = 1;) 에서 선언된 (지역) 변수는 for 블록 안에서만 사용 가능. 
		
		// 증가/감소 연산자: ++(1 증가), --(1 감소)
		// 증가/감소 연산자는 변수 이름 앞 또는 뒤에서 사용 가능: i++(o), ++i(o) > 단독 사용일 때
		
		int x = 1;
		int y = x++ + 1; // 덧셈(+)을 먼저 계산한 후  x값을 1 증가 시킨다.
		// y = x + 1; x++;
		System.out.println("x= " + x + ", y = " + y);
		
		x = 1;
		y = ++x + 1; // x값을 먼저 1 증가 시킨 후 덧셈(+)을 수행.
		// x++; y = x + 1;
		System.out.println("x= " + x + ", y = " + y);
	} // 다른 연산과 섞여있으면 증감 연산자 위치에 따라 처리 순서가 달라진다.
	
		

}
