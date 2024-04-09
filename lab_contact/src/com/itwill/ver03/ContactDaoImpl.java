package com.itwill.ver03;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver01.Contact;


public class ContactDaoImpl implements ContactDao {

	// singleton
	private static ContactDaoImpl instance = null; 

	private ContactDaoImpl() {
	} 

	public static ContactDaoImpl getInstance() { 
		if (instance == null) {
			instance = new ContactDaoImpl(); 
		}
		return instance; 
	} // singleton 구현.
	
	private List<Contact> contacts = new ArrayList<>(); // 다형성
	
	public boolean isValidIndex(int index) {
		return (index >= 0) && (index < contacts.size());
	}
	
	
	
	@Override
	public int create(Contact contact) {
		try {
		contacts.add(contact);
		return 1;
		} catch (Exception e) {
		return 0;
		}
		
	}

	@Override
	public List<Contact> read() {
		
		return contacts;
	}

	@Override
	public Contact read(int index) {
		if(isValidIndex(index)) {
			return contacts.get(index);
		} else {
			return null;
		}
		
	}

	@Override
	public int update(int index, Contact contact) {
		if(contact == null) {
			System.out.println("수정할 인덱스가 없습니다.");
			return 0;
		} else {
			contacts.set(index, contact);
			// contacts.get(index).setName(contact.getName()); // 이름만 지울 때
		}
		return 1;
	}

	@Override
	public int delete(int index) {
		if(isValidIndex(index)) {
			contacts.remove(index);
			
			return 1;
		} else {
			return 0;
		}
		
		
	}

}
