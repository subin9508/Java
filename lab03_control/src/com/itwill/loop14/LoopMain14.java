package com.itwill.loop14;

import java.util.Scanner;



public class LoopMain14 {

	public static void main(String[] args) {
		//
		
		boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정하기 위한 변수.
		int balance = 0; // 은행 계좌의 잔고를 저장하기 위한 변수.
		
		Scanner scanner = new Scanner(System.in); // 콘솔 입력을 위해서.
		
		
		while(run) {
			System.out.println("-----------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------------");
			System.out.print("선택> ");
			
			int number = scanner.nextInt();
			
			switch(number) {
			case 1:
			
				System.out.print("얼마를 예금하시겠습니까?> ");
				int money = scanner.nextInt();
				System.out.println("예금액> " + money);
				balance += money; // 입금액만큼 은행 계좌 잔고에 저장하겠다는 의미.
				break;
				
				
			
			
				
			case 2:
				System.out.print("얼마를 출금하시겠습니까?> ");
				int submoney = scanner.nextInt();
				System.out.println("출금액> " + submoney);
				balance -= submoney; 
				break;
				
				
			
			case 3:
				
				System.out.println("잔고> " + balance);
				break;
			
			
			case 4: 
				
				System.out.println("안녕히 가세요~");
				// break; > 이 때의 break는 switch문만 종료시키고, while문은 종료시키지  못한다. 
				
				
				run = false; // while문을 종료시키기 위한 조건 변경.
			
			
			default:
				
				
			} // switch 종료
				
			
			} // while 종료
			
			System.out.println("프로그램 종료");
			
			
			
			
			/*
			int number = scanner.nextInt();
			
			if(number == 1) {
				//입금 기능 구현
				
			} else if (number == 2) {
				// 출금 기능 구현
			
			} else if (number == 3) {
				// 잔고 확인 기능 구현
				
			} else if (number == 4) {
				// 프로그램 종료
				System.out.println("안녕히 가세요~");
				
				break;
			
			} else {
				System.out.println("1~4 중에서 선택하세요!");
			}
			*/
				
			}
			
			
		}
			
			
		
	


