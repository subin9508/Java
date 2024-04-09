package com.itwill.array05;

import java.util.Random;

public class ArrayMain05 {

    public static void main(String[] args) {
        // 과제:
        // 정수(int) 5개를 저장할 수 있는 배열을 선언하고, 기본값으로 초기화.
    	int[] numbers = new int[5];
    	
    
        // 배열에 0이상 10이하의 난수 5개를 저장. 
    	
    	Random random = new Random();
    	for(int i = 0; i < numbers.length; i++) {
    		numbers[i] = random.nextInt(11);
    	}
    	// 배열 원소들을 출력.
    	for(int x : numbers) { // int x >> 배열에서 꺼낸 원소들을 저장할 수 있는 변수 설정.
    		System.out.print(x+ " ");
    	}
       
    	 System.out.println();
    	
    	 int maxNumber = numbers[0]; // 배열의 첫번째 원소를 최댓값이라고 가정.
    	 int minNumber = numbers[0]; // 배열의 첫번째 원소를 최솟값이라고 가정.
       
      
    	
    	// 배열 원소들 중 최댓값을 찾아서 출력.
    	for(int i = 0; i < numbers.length; i++) {
    		if(maxNumber < numbers[i]) {
    			maxNumber = numbers[i];
    		}
    	
    		
    	/*	
    	for(int x : numbers) { // 배열의 모든 원소를 순서대로 하나씩 꺼내면서 반복
    		if(x > maxNumber) {// 배열에서 꺼낸 값이 (현재까지의) 최댓값보다 크다면
    			maxNumber = x; // 최댓값을 배열에서 꺼낸 값으로 변경.
    		}
    	}
    		*/
    		
    						
    		
    		/*
    		if(minNumber > numbers[i]) {
    			minNumber = numbers[i];
    		}
    	for(int x :numbers) {
    		if(x < minNumber) {
    			minNumber = x;
    		}
    	}
    		*/
    		
    	}
    	
        // 배열 원소들 중 최솟값을 찾아서 출력.
       
        
        System.out.println("최댓값은 " + maxNumber);
        System.out.println("최솟값은 " + minNumber);
    }

}