package com.itwill.condition06;

public class ConditionMain06 {

	public static void main(String[] args) {
		// 삼항 연산자 연습
		
		// 1. number 변수가 짝수인 지, 홀수인 지를 저장하는 변수 evenOrOdd:
		int number = 12;
		String evenOrOdd = (number % 2 == 0) ? "짝수" : "홀수";
		System.out.println(evenOrOdd);
		
		// 2. genderCode 라는 변수의 값이 1 또는 3이면 "남성", 그렇지 않으면 "여성" 문자열을 저장
		int genderCode = 2;
		String gender = (genderCode == 1 || genderCode == 3) ? "남성" : "여성"; 
		// 비교 연산자 양 옆은 모두 조건식이어야 한다. 
		// ex) genderCode == 1 || genderCode == 3 (o), genderCode == 1 || 3 (x)
		System.out.println(gender);
	}

}
