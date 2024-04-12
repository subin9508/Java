package com.itwill.inner01;

public class OuterCls {
	// field
	private int x;
	private int y;
	private String s;
	
	// constructor
	public OuterCls(int x, int y, String s) {
		this.x = x;
		this.y = y;
		this.s = s;
	}
	
	//method
	public int getX() {
		return x;
	}

	@Override
	public String toString() {
		return String.format("OuterCls(x=%d, y=%d, s=%s)", x, y, s);

	}

	// static이 아닌 멤버 내부 클래스
	public class InnerCls {
		// field
		private int y;
		
		// constructor
		public InnerCls(int y) {
			this.y = y;
		}
		
		// method 
		// 내부 클래스는 외부 클래스의 멤버들을 사용할 수 있다.
		public void info() {
			System.out.println("--- InnerCls ---");
			System.out.println("y = " + y); // InnerCls 인스턴스의 필드 사용.
			System.out.println("x = " + getX()); // OuterCls 인스턴스의 필드!
			System.out.println("OuterCls y = " + OuterCls.this.y);
			//-> 내부 클래스의 필드 이름과 외부 클래스의 필드 이름이 같은 경우,
			// 외부 클래스 인스턴스의 필드를 사용하는 방법.
			System.out.println("s = " + s); // OuterCls 인스턴스의 필드!
		}
		
	} // end class InnerCls
	
	
	
} // end Class OuterCls
