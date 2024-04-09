package com.itwill.controller;

import com.itwill.model.Member;

// MVC 아키텍쳐에서 컨트롤러 역할을 담당할 클래스 - 싱글턴으로 구현.
public class MemberDaoImpl implements MemberDao {
	
	
	//----- singleton 구현
	// 어떤 객체의 주소값을 저장하는 변수.
	private static MemberDaoImpl instance = null;
	
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		if(instance == null) {
			instance = new MemberDaoImpl();
		}
		return instance;
	}
	//----- singleton 구현
	
	// 회원 정보를 저장할 배열 선언
	private Member[] members = new Member[MAX_LENGTH];
	

	//회원 배열에 현재까지 저장된 원소의 개수 -> 새로운 회원 정보를 저장할 위치(배열 인덱스)
	
	private int count = 0; // 배열에 원소가 추가될 때마다 ++.
	// count getter 사용해보기
	
	
	
	
	
	/**
	 * 회원 정보를 저장하는 배열이 가득 차 있으면 true, 빈 공간(null)이 있으면 false를 리턴.
	 * 
	 * @return true/false
	 */
	public boolean isMemoryFull() {
		return (count == MAX_LENGTH);
	}
	
	
	@Override
	public int confirm() {
		if (count == MAX_LENGTH) {
			
			return 0;
		}
		return 1;
	}
	
	
	
	
	
	
	@Override
	public int create(Member member) {
		if(count == MAX_LENGTH) {
			System.out.println("저장 공간이 부족합니다.");
			return 0;
		} else {
		members[count] = member;
			count++;
			return 1;
		}
		
	}

	@Override
	
	
	public Member[] read() {
		
		// TODO 배열 members의 원소들 중 null이 아닌 원소들로만 이루어진 배열을 리턴.
		
			return members;
	} 	

	@Override
	public Member read(int index) {
		if(index >= 0 && index < count) {
			return members[index];
		} else {
			return null;
		}
		
	}

	@Override
	public int update(int index, String password) {
		members[index].setPassword(password);
		
		return 1;
	}

}
