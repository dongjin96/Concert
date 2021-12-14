package controller;

import java.util.ArrayList;


import model.Member2;

public class Membercontroller {

	public static ArrayList<Member2>memberlist = new ArrayList<>();
	
	//로그인메소드
	public static boolean login(String id, String password) {
		for ( Member2 member2 : memberlist) {
			if( member2.getId().equals(id) && 
					member2.getPassword().equals(password) ) {
				return true; 
		}else {
			if(member2.getId().equals("admin")&& 
					member2.getPassword().equals(password)) {
				return true;
			}
		}
		}
		return false;
	}
	//회원가입 메소드
	public static boolean signup(Member2 member2) {
		// 유효성 검사
		if(member2.getId().length()<4) {
			System.out.println("ID는 4글자이상 가능합니다");
			return false; 
		}
		if(member2.getPassword().length()<4) {
			System.out.println("PW는 4글자 이상 가능합니다");
			return false; 
		}
		if(member2.getName().length()<2) {
			System.out.println("이름은 2글자 이상 가능합니다");
			return false; 
		}
		if(member2.getPhone().length()<11) {
			System.out.println("전화번호는 - 를 제외하고 입력해주세요");
			return false; 
		}
	
	
	//아이디 중복 체크
		for (Member2 temp : memberlist) {
			if (temp.getId().equals(member2.getId())) {
				System.out.println("동일한 아이디가 존재합니다");
				return false;
			}
			
		}
		memberlist.add(member2);
		return true;
	}
	
	//아이디 찾기
	public static boolean forgotid(String name,String phone) {
		for(Member2 member2:memberlist) {
			if (member2.getName().equals(name)&&member2.getPhone().equals(phone)) {
				System.out.println("회원님의 아이디입니다:"+member2.getId());
				return true;
			}
		}
		return false;
	}
	//비밀번호 찾기
	public static boolean forgotpw(String id, String phone) {
		for(Member2  member2 : memberlist) {
			if (member2.getId().equals(id)&&member2.getPhone().equals(phone)) {
				System.out.println("회원님의 비밀번호입니다 :"+member2.getPassword());
				return true;
				
			}
		}
		return false;
	}
	
	
	
}
