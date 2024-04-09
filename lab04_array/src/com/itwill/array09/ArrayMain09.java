package com.itwill.array09;

import java.util.Random;

public class ArrayMain09 {

	public static void main(String[] args) {
		// 
		Random random = new Random();
		
		// 1차원 정수(int) 배열 3개를 갖는 2차원 배열을 선언 & 초기화.
		int[][] array = new int[3][];
		// 2차원 배열 array의 첫번째 배열에는 난수 2개 저장, 두번째 배열에는 난수 3개, 
		// 세번째 배열에는 난수 4개를 저장. 난수의 범위는 0이상 10미만.
		/*
		array[0] = new int[2]; // 원소 2개를 갖는 1차원 배열.
		array[1] = new int[3]; // 원소 4개를 갖는 1차원 배열.
		array[2] = new int[4];
		*/
		
		// 2차원 배열 array의 내용을 출력.
		for (int x = 0; x < array.length; x++) { // 2차원 배열의 원소 개수
			array[x] = new int [x +2];
			for(int j = 0; j < array[x].length; j++) { // 1차원 배열의 원소 개수
				array[x][j] = random.nextInt(10); // 각각의 인덱스에 난수의 값을 지정하겠다는 의미.
				System.out.print(array[x][j] + " ");
			}
			System.out.println();
		}

		
		

		
		// 2차원 배열의 모든 원소들(정수 9개)의 합을 계산하고 출력
		int sum = 0;
		int count = 0; // 배열의 원소 개수를 저장할 변수
		for(int [] arr : array) {
			for(int arr2 : arr) {
				sum += arr2; // 배열에서 읽은 값을 sum에 더한다.
				count++; // 배열에서 읽은 원소 개수를 증가시킴.
			}
			
		}
		System.out.println("합: " + sum);
		System.out.println("count: " + count);
		// 2차원 배열의 모든 원소들(정수 9개)의 평균을 계산하고 출력

		double mean = 0;
		mean = (double)sum/count;
		System.out.println("평균: " + mean);
	}

}
