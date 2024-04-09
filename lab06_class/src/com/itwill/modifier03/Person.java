package com.itwill.modifier03;

public class Person {
	private String name; // 읽기 전용 필드
	private int age; // 읽기/쓰기 필드
	
	public Person(String name, int age) {
		if(name != null) {
			this.name = name;
			this.age = age;
			
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public String getName() {
		return this.name;
	}
	 public int getAge() {
		 return this.age;
	 }
	 
	 public void setAge(int age1) {
		if( age1 > 0 ) {
			 this.age = age1;
		} 
			
		 
		 
	 }
}
