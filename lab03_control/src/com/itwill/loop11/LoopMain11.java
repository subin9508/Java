package com.itwill.loop11;

public class LoopMain11 {

	public static void main(String[] args) {
		// Ex1. 1부터 10까지의 자연수들의 합을 계산하고 출력
		// 1 + 2 + 3 + ... + 9 + 10 = 55
		
		
		int sum = 0; // 1부터 10까지의 자연수들의 합을 저장할 변수
		
		for(int x = 1; x <= 10; x++ ) {
			sum += x; // sum = sum + x;
		}
		System.out.println("1 ~ 10까지의 합" + " : " + sum);
		
		System.out.println();
		
		
		
		
		int sum2 = 0;
		
		int y = 1;
		
		while(y <= 10) {
			sum2 += y;
			y++;
		}
		System.out.println("1 ~ 10까지의 합" + " : " + sum2);
		
		System.out.println();
		
		// Ex2. 1부터 100까지의 자연수들 중에서 짝수들의 합을 계산하고 출력.
		
		int sum3 = 0;
		
		for(int i = 2; i <= 100; i+=2) {
			
			sum3 += i;
		}
		System.out.println("1 ~ 100까지의 짝수들의 합" + " : " + sum3);
		
		
		sum = 0;
		
		for(int b = 1; b <= 100; b++) {
			if(b % 2 == 0) {
				sum += b;
			}
		}
		System.out.println("1 ~ 100까지의 짝수들의 합" + " : " + sum);
		// Ex3. 1부터 100까지의 자연수들 중에서 홀수들의 합을 계산하고 출력.
		
		int sum4 = 0;
		
		for(int j = 1; j <= 100; j+=2) {
			
			sum4 += j;
		}
		System.out.println("1 ~ 100까지의 홀수들의 합" + " : " + sum4);
		
		int sum5 = 0;
		int a = 1;
		while(a <=100) {
			sum5 += a;
			a+=2;
		}
		System.out.println("1 ~ 100까지의 홀수들의 합" + " : " + sum5);
		
		
		sum = 0;
		int x = 1;
		while(x < 100) {
			if(x % 2 != 0) {
				sum += x;
			} 
			x++;
		}
		System.out.println("1 ~ 100까지의 홀수들의 합" + " : " + sum);
	}

}
