package com.itwill.enum01;

public enum Season3 {
	SPRING("봄"), // = public static final Season3 SPRING = new Season3();
	SUMMER("여름"),
	FALL("가을"),
	WINTER("겨울");
	
	private String name;
	
	// enum의 생성자의 접근 수식어는 private만 사용 가능하고, 생략 가능하다.
	
	private Season3(String name) { // Season3(String name) {...} 로 적어도 된다. (private 생략 가능)
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
