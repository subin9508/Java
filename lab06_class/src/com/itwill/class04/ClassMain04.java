package com.itwill.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		// Rectangle 객체 생성, 메서드 호출
		Rectangle rectangle1 = new Rectangle();
		System.out.println("rectangle1 = " +rectangle1 );
		System.out.println("rectangle1 = " + rectangle1);
		System.out.println("rectangle1 넓이 = " +rectangle1.area() );
		System.out.println("rectangle1 둘레길이 = " +rectangle1.perimeter() );
		
		Rectangle rectangle2 = new Rectangle(10.0, 20.0);
		System.out.println("rectangle2 width = " + rectangle2);
		System.out.println("rectangle2 height = "+ rectangle2);
		System.out.println("rectangle2 넓이 = " + rectangle2.area());
		System.out.println("rectangle2 둘레길이 = "+ rectangle2.perimeter());
		

	} // end main

} // end class
