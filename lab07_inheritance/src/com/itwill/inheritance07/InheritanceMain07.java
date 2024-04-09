package com.itwill.inheritance07;

/*
 * 추상 메서드(abstract method): 
 * - 메서드의 signature(수식어, 리턴 타입, 메서드 이름, 파라미터 선언)만 선언되어 있고,
 *  메서드의 body(몸통)가 구현되어 있지 않은 메서드.
 *  - 추상 메서드는 반드시 "abstract" 키워드로 수식해야 한다. (리턴 타입 앞에 붙이면 된다.)
 *  - 추상 메서드 선언은 반드시 세미콜론(;)으로 끝내야 한다. (중괄호가 없기 때문에 세미콜론으로 끝부분을 표시해주어야 함)
 *  
 *  추상 클래스(abstract class):
 *  - "abstract" 수식어가 사용된 클래스.
 *  - 대부분의 경우 추상 클래스는 추상 메서드를 가지고 있는 경우가 많다. (항상 그런 것은 아님)
 *  - 클래스가 추상 메서드를 가지고 있는 경우에는 반드시 abstract로 선언해야 한다.
 *  - 추상 클래스는 객체를 생성할 수 없음.
 *  - (객체를 생성하려면) 추상 클래스를 상속하는 클래스를 선언하고, 모든 추상 메서드를 override한 이후에 객체를 생성할 수 있다.
 *   한개라도 추상 메서드가 있으면 그 클래스는 반드시 추상 클래스이어야 한다.
 */

abstract class Animal {
	public abstract void move(); // 추상 메서드 (반드시 body가 없어야 한다.)
}

class Dog extends Animal {
	@Override
	public void move() {
		System.out.println("강아지 총총총...");
	}
}

class Fish extends Animal {

	@Override
	public void move() {
		System.out.println("물고기는 스윔스윔");
		
	}
	
}

class Bird extends Animal {

	@Override
	public void move() {
		System.out.println("새는 훨훨~~~~");
		
	}
	
}
public class InheritanceMain07 {

	public static void main(String[] args) {
		Animal[] animals = {
				new Dog(),
				new Fish(),
				new Bird(),
				// new Animal()
				
		};
		for(Animal a : animals) {
			a.move();
		}
	}

}
