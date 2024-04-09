package com.itwill.ver02;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {

	
	// singleton
	private static ContactDaoImpl instance = null; // instance : 메서드 영역의 변수
	
	private ContactDaoImpl () {} // 메인 클래스로 부르지 못함. 따라서 public 메서드를 통해 호출. 
	
	public static ContactDaoImpl getInstance() { // 객체 생성 필요없는 메서드.
		if (instance == null) {
			instance = new ContactDaoImpl(); // 힙에 ContactDaoImpl이라는 객체 주소값 생성.
		}
		return instance; // 메서드 호출한 곳으로 리턴.
	} // singleton 구현.
	
	private Contact[] contacts = new Contact[MAX_LENGTH];
	
	
	private int count = 0; // 프로그램 초기엔 저장되어 있는 것이 없기 때문에 0으로 초기화.
							
	
	/**
	 * 회원 정보를 저장하는 배열이 가득 차 있으면 true, 빈 공간(null)이 있으면 false를 리턴.
	 * 
	 * @return true/false
	 */
	public boolean isMemoryFull() {
		return (count == MAX_LENGTH);
	}
	
	public boolean isVaildIndex(int index) {
		return (index >= 0 && index < count);
	}
	
	@Override
	public int create(Contact contact) { // 
		if (isMemoryFull()) {
			return 0;
		} else {
			contacts[count] = contact;
			count++;
			return 1;
		}

	}

	@Override
	public Contact[] read() {
		
		return contacts;
	}

	@Override
	public Contact read(int index) {
		if (index >= 0 && index < count) { // isVaildIndex(index) 
			return contacts[index];
		} else {
			return null;
		}
	}

	@Override
	
	
	public int update(int index, Contact contact) {
		if (index > count && contact == null) {
			System.out.println("수정할 인덱스가 없습니다.");
			return 0;
		} else {

			// contacts[index] = contact;
			contacts[index].setName(contact.getName());
			contacts[index].setPhone(contact.getPhone());
			contacts[index].setEmail(contact.getEmail());
			return 1;
		}
	}

}
