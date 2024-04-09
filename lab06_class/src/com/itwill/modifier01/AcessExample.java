package com.itwill.modifier01;

public class AcessExample {
	// field
	private int a;
	int b;
	protected int c;
	public int d;
	
	public AcessExample(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	// method
	public void info() {
		System.out.printf("a=%d, b=%d, c=%d, d=%d\n", a, b, c, d);
	}

}
