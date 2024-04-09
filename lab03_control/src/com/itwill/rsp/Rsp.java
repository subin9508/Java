package com.itwill.rsp;

import java.util.Random;
import java.util.Scanner;


public class Rsp {

    public static void main(String[] args) {
        // 가위/바위/보 (Rock-Scissors-Paper) 게임:
        // 가위 - 0, 바위 - 1, 보 - 2
        
    	Random random = new Random();
    	
    	Scanner sc = new Scanner(System.in);
    	
    
    	// TODO: Random 타입 변수를 선언, 초기화.
        // TODO: Scanner 타입 변수를 선언, 초기화.

        System.out.println("가위바위보 게임");
        System.out.println("---------------");
        System.out.println("[0] 가위");
        System.out.println("[1] 바위");
        System.out.println("[2] 보");
        System.out.println("---------------");
        System.out.print("선택>>> ");
        
		int user = sc.nextInt(); 
		
		switch (user) {
		case 0:
			System.out.println("user = " + "가위");
			break;
		case 1:
			System.out.println("user = " + "바위");
			break;
		case 2:
			System.out.println("user = " + "보");
			break;
		}
    	
    	int computer = random.nextInt(3); // random.nextInt(0, 3);
    	
    	switch (computer) {
		case 0:
			System.out.println("computer = " + "가위");
			break;
		case 1:
			System.out.println("computer = " + "바위");
			break;
		case 2:
			System.out.println("computer = " + "보");
			break;
		}
    	
        
        // TODO: 사용자가 콘솔창에서 입력한 정수를 변수(user)에 저장.
        // TODO: 0 이상 3 미만의 정수 난수 1개를 변수(computer)에 저장.
    	
        if(user == 0 && computer == 1) {
        	System.out.println("Computer win");
        } else if(user == 0 && computer == 0) {
        	System.out.println("Tie");
        } else if(user == 1 && computer == 0) {
        	System.out.println("Computer win");
        } else if(user == 0 && computer == 2) {
        	System.out.println("User win");
        } else if(user == 2 && computer == 0) {
        	System.out.println("Computer win");
        } else if(user == 1 && computer == 1) {
        	System.out.println("Tie");
        } else if(user == 2 && computer == 1) {
        	System.out.println("User win");
        } else if(user == 1 && computer == 2) {
        	System.out.println("User win");
        } else {
        	System.out.println("Tie");
        }
        
        /*
        if(user == 0) { //user: 가위
        	if(computer == 0) {
        		
        	} else if(computer == 1) {
        		
        	} else {
        		
        	}
        	
        } else if (user == 1) { //user: 바위
        	if(computer == 0) {
        		
        	} else if(computer == 1) {
        		
        	} else {
        		
        	}
        } else { //user: 보
        	if(computer == 0) {
        		
        	} else if(computer == 1) {
        		
        	} else {
        		
        	}
        }
        	
        if (user == computer) { // 비김
        	
        } else if (user == 0) { // user: 가위
        	if (computer == 1) { // computer: 바위
        		
        	} else { // 컴퓨터: 보
        		
        	}
        	
        } else if (user == 1) { // 유저: 바위
        	if (computer == 0) { // 컴퓨터: 가위
        		
        	} else { // 컴퓨터: 보
        		
        	}
        	
        } else { //유저: 보
        	if (computer == 0) { //컴퓨터: 가위
        		
        	} else { // 컴퓨터: 바위
        		
        	}
        }
        	 
        if (user == computer) { // 비김
        	
        } else if ((user == 0 && computer == 2) || 
        		(user == 1 && computer == 0) || 
        		(user == 2 && computer ==1)) {
        		// 유저가 이긴 경우
        	
        } else { // 컴퓨터가 이긴 경우
        	
        }
        
        int result = user - computer;
        if(result == 0) { //  비김
        	
        } else if (result == 1 || result == -2) { // 유저가 이긴 경우
        	
        } else { // 컴퓨터가 이긴 경우
        	
        }
        */
        
        // TODO: 가위바위보 게임 결과(User win/Computer win/Tie)를 출력.
        
 

 }
}
