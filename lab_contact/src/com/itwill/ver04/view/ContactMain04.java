package com.itwill.ver04.view;


import java.util.List;
import java.util.Scanner;

import com.itwill.ver04.controller.ContactDao;
import com.itwill.ver04.controller.ContactDaoImpl;
import com.itwill.ver04.model.Contact;

// MVC 아키텍쳐에서 View 역할.

public class ContactMain04 {
	private final Scanner scanner = new Scanner(System.in);
	private ContactDao dao = ContactDaoImpl.getInstance();

	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.4 ***");
		
		ContactMain04 app = new ContactMain04(); // 객체가 가지고 있는 메서드 이용을 위해 객체 생성.
		
		boolean run = true;
		while (run) {
			try {
			int menu = app.selectMainMenu();
			switch (menu) {
			case 0:
				run = false;
				break;
			case 1:
				app.saveNewContact();
				break;
			case 2:
				app.readAllContacts();
				break;
			case 3:
				app.readContactByIndex();
				break;
			case 4:
				app.updateContact();
				break;
			case 5:
				app.delete();
				break;
			default:
				System.out.println("0~5 범위의 정수로 입력하세요...");
			}
			
			} catch (Exception e) {
				System.out.println("유효한 값만 입력하세요.");
			}
		}	
			
			System.out.println(">>> 프로그램 종료 >>>");

	} // end main
	
	private int selectMainMenu() {
		System.out.println("\n-----------------------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정 [5] 삭제");
		System.out.println("------------------------------------------------------");
		System.out.print("선택> ");
		
			int menu = Integer.parseInt(scanner.nextLine());

			return menu;
		

	}
	
	
	
	private void saveNewContact() {
		System.out.println("\n--- 새 연락처 저장 ---");
		
		
		
		System.out.print("이름 입력>> ");
		String name = scanner.nextLine();
		System.out.print("전화번호 입력>> ");
		String phone = scanner.nextLine();
		System.out.print("이메일 입력>> ");
		String email = scanner.nextLine();
		
		Contact contact = new Contact(0, name, phone, email);
		int result = dao.create(contact);
		if(result == 1) {
			System.out.println("연락처 저장 성공");
		} else {
			System.out.println("연락처 저장 실패");
		}
		
		
		
	}
	
	private void readAllContacts() {
		System.out.println("\n--- 연락처 목록 ---");
		List<Contact> contacts = dao.read(); // 뷰 쪽에서 컨트롤러의 메서드 호출.	
		int index = 0;
		for(Contact c : contacts) {
			System.out.println("[" + index + "]" + c);
		} 
		
	}
	
	private void readContactByIndex() {
		System.out.println("\n--- 인덱스 검색 ---");
		
		System.out.print("검색할 인덱스 입력>> ");
		
		try {
		int index = Integer.parseInt(scanner.nextLine());
		
		Contact contact = dao.read(index);
		
		if(index >= 0 && contact != null) {
			System.out.println(contact);
		} else if (index < 0) {
			System.out.println("양의 정수로 입력하세요.");
		}
		  else  {
			System.out.println("해당 인덱스에는 연락처가 없습니다.");
		}
		} catch(Exception e) {
			 
			System.out.println("해당 인덱스는 범위를 초과하였습니다.");
			
		}
		
		
	}
	
	private void updateContact() {
		System.out.println("\n--- 연락처 정보 업데이트 ---");
		
		System.out.print("업데이트할 인덱스>> ");
		int index = Integer.parseInt(scanner.nextLine());
		
		Contact contact = dao.read(index);
		if(contact == null) {
			return;
		}
		
		System.out.println("수정 전: " + contact);
		
		
		 System.out.print("변경할 이름 입력>> ");
		 String name = scanner.nextLine();
		 contact.setName(name);
		 System.out.print("변경할 전화번호 입력>> ");
		 String phone = scanner.nextLine();
		 contact.setPhone(phone);
		 System.out.print("변경할 이메일 입력>> ");
		 String email = scanner.nextLine();
		 contact.setEmail(email);
		 
		
		
		int result = dao.update(index, contact);
		if(result == 1) {
			System.out.println("연락처 업데이트 성공");
		} else {
			System.out.println("연락처 업데이트 실패");
		}
		System.out.println("수정 후: " + contact);
	}
	
	private void delete() {
		System.out.println("\n--- 연락처 삭제 ---");
		
		System.out.print("삭제할 인덱스>> ");
		int index = Integer.parseInt(scanner.nextLine());
		// List<Contact> contacts = dao.read(); 
		int result = dao.delete(index);
		if(result == 1) {
			System.out.println("연락처 삭제 성공");
		} else {
			System.out.println("연락처 삭제 실패");
		}
	}

}
