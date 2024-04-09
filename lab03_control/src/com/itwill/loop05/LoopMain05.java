package com.itwill.loop05;

public class LoopMain05 {

	public static void main(String[] args) {
		// 반복문에서 break와 continue 문장: 
		// (1) break: 반복문 블록을 실행 중에 break 문장을 만나면, 
		// 			break가 포함된 가장 가까운 반복문 블록을 완전히 끝냄.
		for (int x = 0; x < 5; x++) {
			if (x == 3) {
				break;
			}
			System.out.println(x);
		}
		
		System.out.println("----------------------------");
		
		
		
		// (2) continue: 반복문 블록을 실행 중에 continue 문장을 만나면,
		// 			continue 아래의 코드들은 실행하지 않고, 그 다음 반복 과정을 계속 수행.
	
		for (int x = 0; x < 5; x++) { // ;(세미콜론)을 제외하고 선언 부분, 판별식, 증감 부분 생략 가능.
			if (x == 3) {
				continue;
			}
			System.out.println(x);
		}
		
	
		System.out.println("----------------------------");
		
		
		// break 문장의 용도: 무한 반복문 실행 중에 특정 조건을 만족하면 반복문을 종료.
		for (int x = 1; ; x++) { // ; true ; 의 의미. 무한 반복. 강제 종료 필요. 
			System.out.println(x); // 출력 코드 위치에 따라 break 되는 범위가 달라진다.
			if (x == 5) {
				break;
			}
		}
		
	}
	

}
