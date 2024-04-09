package com.itwill.method05;

public class MethodMain05 {

	public static void main(String[] args) {
		// TODO 메서드를 호출, 그 결과를 출력:
		
		int[] array = {1, 2, 3, 4};
		// sum 메서드 호출, 결과 출력.
		int total = sum(array);
		System.out.println("total = " + total);
		
		
		double average = mean(array);
		System.out.println("average = " + average);
		
		int maxnumber = max(array);
		System.out.println("max = " + maxnumber);
	
	} // end main
	
	/**
	 * sum. (메서드 이름)
	 * 아규먼트로 전달받은 정수들의 1차원 배열의 모든 원소들의 합을 리턴.
	 * @param array 정수들의 1차원 배열(int[]).
	 * @return array의 모든 원소들의 합.
	 */
	public static int sum (int[] array) {
	 int result = 0;
	 for (int x : array) {
		 result += x;
	 }
	 
	 return result;
	}
	
	// public static 리턴타입 sum(파라미터 선언) {}
	
	
	/**
	 * mean.
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들의 평균을 리턴.
	 * @param array 정수들의 1차원 배열(int[]).
	 * @return array 원소들의 평균을 double 타입으로 리턴.
	 */
	public static double mean (int[] array) {
		double result = (double) sum(array) / array.length;
		return result;
	}
	
	/**
	 * max.
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들 중 최댓값을 리턴.
	 * @param array 정수들의 1차원 배열.
	 * @return array 원소들 중 최댓값.
	 */
	public static int max(int[] array) {
		int result = array[0];
		for (int x : array) {
			if(x > result) {
				result = x;
			}
		}
		return result;
	}
	/**
	 * min.
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들 중 최솟값을 리턴.
	 * @param array 정수들의 1차원 배열.
	 * @return array 원소들 중 최솟값.
	 */
	
	
} // end class



