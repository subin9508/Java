package com.itwill.ver04.controller;

import java.util.List;

import com.itwill.ver04.model.Contact;
import com.itwill.ver04.util.FileUtil;

// import static 문장: 클래스에서 public static으로 선언된 멤버(field, method)멤버의 이름을 가져옴.
// import static com.itwill.ver04.util.FileUtil.initializeData;
import static com.itwill.ver04.util.FileUtil.*; // static으로 선언된 모든 멤버 이름들을 다 가져옴.
												// 클래스 이름 생략 가능.

// MVC 아키텍쳐에서 Controller 역할 담당 클래스. DAO(Data Access Object)

public class ContactDaoImpl implements ContactDao {
		//----- singleton
		private static ContactDaoImpl instance = null;
		
		private ContactDaoImpl() {
			// 데이터 폴더를 초기화: 폴더가 없으면 새로 만듦.
			initializeDataDir();
			
			// 연락처 데이터를 초기화: 데이터 파일에서 리스트를 읽어오거나, 빈 리스트를 생성.
			contacts = initializeData();
		}
		public static ContactDaoImpl getInstance() {
			if(instance == null) {
				instance = new ContactDaoImpl();
			}
			return instance;
		}
		//----- singleton
		
		private List<Contact> contacts;
		
		/**
		 * 인덱스가 연락처 리스트의 유효한 범위 안에 있는 지를 리턴.
		 * @param index 검사할 인덱스
		 * @return 유효한 인덱스이면 true, 그렇지 않으면 false.
		 */
		public boolean isValidIndex(int index) {
			return (index >=0) && (index < contacts.size());
		}
		

	@Override
	public int create(Contact contact) {
		contacts.add(contact);
		writeDataToFile(contacts);
		return 1;
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
		if(!isValidIndex(index)) {
			return 0;
		} 
		
		contacts.set(index, contact);
		writeDataToFile(contacts);
		
			return 1;
	
	}

	@Override
	public int delete(int index) {
		if (isValidIndex(index)) {
			contacts.remove(index);
			writeDataToFile(contacts);
			return 1;
		} else {
			return 0;
		}
		
	}

}
