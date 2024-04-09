package com.itwill.condition07;

import java.util.Random;

public class ConditionMain07 {

	public static void main(String[] args) {
		// 조건문, 비교/논리 연산자 연습
		
		// 난수(random number)를 생성할 수 있는 타입의 변수를 선언하고 초기화.
		Random rand = new Random();
		// new : 새로 만들다
		
		// rand.nextInt(x) : 0이상 x보다 작은 정수 난수를 반환.
		// rand.nextInt(x, y) : x이상 y 미만의 정수 난수를 반환.
		
		int x = rand.nextInt(5); // 0보다 크거나 같고 5보다는 작은 정수들 (0 ~ 4) 중에 랜덤 출력
		// 괄호 안의 숫자에 따라 랜덤 범위 변경, 시작 범위는 항상 0
		// ex) int x = rand.nextInt(1, 3); >> 1이상 3미만의 사이 값 중의 정수
		System.out.println(x);
		
		int java = rand.nextInt(101); // 0이상 101미만의 정수 난수를 저장.
		System.out.println("Java: " + java);
		
		int sql = rand.nextInt(101); 
		System.out.println("SQL: " + sql);
		
		int javascript = rand.nextInt(101);
		System.out.println("JavaScript: " + javascript);
		
		// 세 과목이 모두 40점 이상이고, 평균이 60점 이상이면 "합격",
		// 그렇지 않으면 "불합격"을 출력.
		
		//총점 계산:
		int total = java + sql + javascript;
		System.out.println("총점: " + total);
		
		//평균 계산:
		double mean = (double) total / 3;
		System.out.println("평균: " + mean);
		
		int score = (java + sql + javascript / 3);
		String score2 = (java >= 40 && sql >= 40 && javascript >=40 && score >= 60) ? "합격" : "불합격";
		System.out.println(score2);
		
		if (java >=40 && sql >=40 && javascript >=40 && mean >=60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
	}

}
