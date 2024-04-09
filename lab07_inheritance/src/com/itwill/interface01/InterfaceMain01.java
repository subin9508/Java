package com.itwill.interface01;

import com.itwill.database.Database;
import com.itwill.mysql.MySqlDatabase;
import com.itwill.oracle.OracleDatabase;

/*
 * 인터페이스(interface):
 * 사용 목적: 팀/회사 간의 분업/협업을 하기 위해서 메서드들의 signature를 약속하기 위해서.
 * 인터페이스가 가질 수 있는 멤버:
 *   (1) public static final 필드 - public static final 수식어는 생략 가능.
 *   (2) public abstract 메서드 - public abstract 생략 가능.
 *   인터페이스를 선언할 때는 "interface" 키워드를 사용.
 *   인터페이스는 아주 특별한 추상 클래스이다. 
 *   인터페이스는 객체를 생성할 수 없고, 인터페이스를 "구현"하는 클래스를 선언해서 객체를 생성할 수 있다.
 *    class 클래스이름 extends 상위클래스 이름 {}
 *    class 클래스이름 implements 인터페이스 이름 {}
 * 클래스는 단일 상속만 가능하지만, 인터페이스 구현 개수는 제한이 없음.
 * 	  class T implements A, B, C {}
 * 인터페이스는 상위 인터페이스를 상속(확장)할 수 있다. 인터페이스는 다중 상속이 가능하다.
 * 	  interface I extends A, B {} / 인터페이스는 인터페이스만 상속 가능.
 */

public class InterfaceMain01 {

	public static void main(String[] args) {
		// OracleDatabase 객체를 생성하고, 메서드들을 이용.
		// OracleDatabase db = new OracleDatabase();
		
		// MySqlDatabase 객체를 생성하고, 메서드들을 이용.
		
		Database db = new MySqlDatabase();
		
		
		
		int result = db.insert();
		System.out.println("insert result = " + result);
		
		result = db.select();
		System.out.println("select result = " + result);
		
		

	}

}
