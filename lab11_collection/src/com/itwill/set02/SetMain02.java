package com.itwill.set02;

import java.util.HashSet;
import java.util.Random;

public class SetMain02 {

	public static void main(String[] args) {
		// 1. 정수를 저장하는 HashSet을 선언, 초기화
		HashSet<Integer> set = new HashSet<>();
		
		// 2. 집합(Set)에 [0, 10) 범위의 (서로 다른) 난수 5개를 저장.
		Random random = new Random();
		for(int i = 0 ; i < 5; i++) {
			set.add(random.nextInt(10));
		}
		
		// 3. 향상된 for 문장을 사용해서 집합의 내용을 출력.
		for(Integer x : set) {
			if(set.size() == 5) {
				break;
			}
		}
			System.out.println(set);
			System.out.println("size = " + set.size());
		

	}

}
