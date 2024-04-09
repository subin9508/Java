package com.itwill.ver01;

import java.util.Scanner;

public class ContactMain {
	private static final int MAX_LENGTH = 3; // 연락처 배열의 최대 길이(원소 개수, 값 고정)
	
	// 필드 선언
	private Scanner scanner = new Scanner(System.in);
	private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처를 저장하기 위한 배열
	private int count = 0; // 현재까지 연락처 배열에 저장된 개수 + 새로운 연락처를 몇번 째 인덱스에 저장할 것인지 결정해주는 변수.
	// count 변수는 배열에 새로운 연락처가 저장될 때마다 count++을 실행.
	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.1");
		
		ContactMain app = new ContactMain(); // 객체 생성을 통해 프로그램 안의 메서드들을 활용할 수 있는 참조변수 생성
		
 // 프로그램을 계속 실행(run = true) 또는 종료(run = false) 여부를 저장하기 위한 변수	
		boolean run = true; 
		
		while (run) { 
			int menu = app.showMainMenu();
			switch(menu) {
			case 0:
				run = false;
				break; // switch만 끝내는 것. 케이스에 부합하면  while문으로 돌아감.
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
				app.updateContactByIndex();
				break;
			default:
				System.out.println("메뉴 번호(0~4)를 확인하세요.");
			}
		}
		
		System.out.println("*** 프로그램 종료 ***");

	} // end main
	
	
	
	
	
	
	private void updateContactByIndex() {
		System.out.println("\n--- 연락처 수정 ---");
		
		System.out.println("인덱스 입력>> ");
		int index = Integer.parseInt(scanner.nextLine());
		if (index < 0 || index >= count) {
			System.out.println("해당 인덱스에는 수정할 정보가 없습니다.");
			return; // 메서드 종료.
		}
		
		System.out.println("수정 전: " + contacts[index].toString());
		
		System.out.print("이름 수정>> ");
		String name = scanner.nextLine(); // 연락처를 수정할 수 있는 정보들.
		contacts[index].setName(name);
		
		System.out.print("전화번호 수정>> ");
		String phone = scanner.nextLine();
		contacts[index].setPhone(phone);
		
		System.out.print("이메일 수정>> ");
		String email = scanner.nextLine();
		contacts[index].setEmail(email);
		
		
		System.out.println("수정 후: " + contacts[index].toString());
		System.out.println("연락처 수정을 성공했습니다.");
		
		
		
		// 입력한 내용으로 배열의 내용을 업데이트.
		/*
		Contact contact = new Contact();  // contacts[index] = new Contact(name, phone, email);
		contact.setName(name);
		contact.setPhone(phone);
		contact.setEmail(email);
		
		
		 contacts[index] = contact;
		
		
		
		
		
		System.out.println("수정 후: " + contact.toString());
		*/
	}






	private void readContactByIndex() {
		System.out.println("\n--- 인덱스 검색 ---");
		System.out.println("인덱스 입력>> ");
		int index = Integer.parseInt(scanner.nextLine());
		
		if (index >= 0 && index < count) {
			System.out.println(contacts[index].toString()); // 해당 인덱스의 연락처를 출력
		} else {
			System.out.println("해당 인덱스에는 연락처가 없습니다.");
		}
		
	}
	
	private void readAllContacts() {
		System.out.println("\n--- 연락처 목록 ---");
		// 인덱스 0번부터 현재 저장된 연락처 개수보다 작을 때까지
		for (int i = 0; i < count; i++) {
			System.out.println(i + " : " + contacts[i].toString());
		}
	}
	
	
	private void saveNewContact() {
		
		
			
		
		
		System.out.println("\n--- 새 연락처 저장 ---");
		if(count == MAX_LENGTH) {
			System.out.println("저장 공간이 부족합니다.");
			return; // 메서드 종료
		}
		System.out.print("이름 입력>> ");
		String name = scanner.nextLine();
		
		System.out.print("전화번호 입력>> ");
		String phone = scanner.nextLine();
		
		System.out.print("이메일 입력>> ");
		String email = scanner.nextLine();
		
		Contact contact = new Contact(name, phone, email);
		
		
		
		// Contact 타입 객체를 연락처 배열 인덱스 count에 저장한다.
		contacts[count] = contact;	
		count++;
		System.out.println("연락처 저장을 성공했습니다.");
		} 
		// 배열 저장 후에는 연락처 저장 개수(인덱스)를 증가시킨다.
		
		
		
		

		
	
	private int showMainMenu() {
		System.out.println("\n---------------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
		System.out.println("---------------------------------------------");
		System.out.print("선택> ");
		int menu = Integer.parseInt(scanner.nextLine());
		
		return menu;
	}

} // end class
