package com.itwill.switch01;

public class SwitchMain01 {

	public static void main(String[] args) {
		// switch-case 구문: 
		// 해당 case 위치로 이동해서 break 문장을 만날 때까지 실행.
		// 해당하는 case가 없으면 default 블록을 실행.
		// default 블록은 switch 구문에서 항상 가장 마지막에 작성.
		// default 블록은 없어도 된다.
		// case는 하나 이상 반드시 존재해야 한다.
		// switch (변수 또는 식)에서 사용할 수 있는 타입:
		// (1) 정수: byte, short, int, long, char(문자의 유니코드 정수 값을 저장 , 'a')
		// (2) 문자열: String ("a")
		// (3) enum 타입:
		// (주의) switch-case 구문에서는 실수(float, double), boolean 타입은 사용 불가!
	
		String season = "거울";
		switch (season) {
		case "봄": 
			System.out.println("Spring");
//			break; // 진행을 멈춤.
		case "여름":
			System.out.println("Summer");
//			break;
		case "가을":
			System.out.println("Fall");
//			break;
		case "겨울":
			System.out.println("Winter");
//			break;
		default: // '해당하는 케이스가 없으면'의 의미, Switch-Case에서 default는 항상 마지막에 사용. 
			System.out.println("몰라요~");
		}
		
		int number = 12;
		switch (number % 2) {
		case 0:
			System.out.println("짝수");
			break;
		case 1:
			System.out.println("홀수");
			break; // case 1 대신 default: 를 사용해도 결과 값은 같다.
			
		}
		if(number % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}

	}

}
