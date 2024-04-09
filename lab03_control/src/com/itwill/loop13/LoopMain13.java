package com.itwill.loop13;

public class LoopMain13 {

	public static void main(String[] args) {
		// 
		
		
		
		
		System.out.println("교재 Ex 5.");
		
		for(int i = 1; i < 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
					System.out.println();
				
			
		}
		
		
		System.out.println("교재 Ex 6.");
		
		for(int x = 1; x <= 4; x++) {
			for(int y = 1; y <= 4; y++) {
				if (y <= 4 - x) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		System.out.println("교재 Ex 6-2.");
		for(int x = 1; x <= 4; x++) {
			for(int y = 4; y >=1; y--) {
				if (y > x) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			
			}
			System.out.println();
		}
		
		System.out.println("교재 Ex 6-2.");
		
		for(int x = 1; x <= 4; x++) {
			
		}
	}

}
