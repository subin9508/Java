package com.itwill.class05;

public class ClassMain05 {

	public static void main(String[] args) {
		// TODO: Subject, Student 클래스 객체 생성과 메서드 호출 결과 테스트.
		
		// 기본생성자를 사용해서 Subject 타입의 객체 생성.
		Subject sb1 = new Subject();
		sb1.info();
		
		System.out.println();
		
		
		Subject sb2 = new Subject(100, 95, 90, 80);
		sb2.info();
		
		
		System.out.println();
		
		
		
		
		Student stu2 = new Student(1, "홍길동", sb2);
		stu2.all();
		
		
		
		
		
		Student stu1 = new Student();
		stu1.all();
		
	
		
		
		
		
		
		
		
		
		

	}

}
