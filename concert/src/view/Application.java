package view;

import java.lang.reflect.Member;
import java.util.Scanner;

import controller.Concert;
import controller.Membercontroller;
import model.Member2;

public class Application {

	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		mainmenu();
	}
	
	
	private static void mainmenu() {
		while(true) {
			System.out.println("===============회원 커뮤니티===============");
			System.out.println("1.로그인|2.회원가입|3.아이디찾기|4.비밀번호찾기| :");
			System.out.println("=======================================");
			int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("==============로그인=================");
				System.out.println("id찾기:"); String id = scanner.next();
				System.out.println("pw찾기:"); String pw = scanner.next();
				boolean result= Membercontroller.login(id, pw);
				if(result) {
					System.out.println("[알림]로그인성공");
					membermenu(id);
				}else if(result) {
					System.out.println("[알림]관리자 로그인성공");
					adminmenu(id);
				}else {
					System.out.println("[알림]로그인실패");
				}
			}
			if(ch==2) {
				System.out.println("==============회원가입================");
				System.out.println("id : "); String id = scanner.next();
				System.out.println("pw : "); String pw = scanner.next();
				System.out.println("이름: "); String name = scanner.next();
				System.out.println("phone: "); String phone = scanner.next();
				Member2 member2 = new Member2(id, pw, name, phone);
				boolean result=Membercontroller.signup(member2);
				if(result) {
					System.out.println("[알림]회원가입 성공");
				}else {
					System.out.println("[알림]회원가입 실패");
				}
			}
			if(ch==3) {
				System.out.println("==============아이디찾기==============");
				System.out.println("이름 :"); String name= scanner.next();
				System.out.println("phone :");String phone= scanner.next();
				boolean result = Membercontroller.forgotid(name,phone);
				if (result) {
					System.out.println("아이디찾기 성공");
				}else {
					System.out.println("아이디찾기 실패");
				}
			}
			if(ch==4) {
				System.out.println("==============비밀번호찾기==============");
				System.out.println("id입력  :"); String id = scanner.next();
				System.out.println("phone입력 :"); String phone = scanner.next();
				boolean result=Membercontroller.forgotpw(id, phone);{
					if (result) {
						System.out.println("비밀번호찾기 성공");
					}else {
						System.out.println("비밀번호 찾기 실패");
					}
				}
			}
		}
	}//main end
			private static void adminmenu(String id) {
				while(true) {
					System.out.println("+++++++++++++++++관리자메뉴++++++++++++++++");
					System.out.println("1.영화등록 2. 영화등록취소 3.로그아웃");
				}
		
		
	}


			public static void membermenu(String id) {
				
				while(true) {
					System.out.println("++++++++++++++++++회원메뉴++++++++++++++++");
					System.out.println("1.예매2.조회 3.취소4.로그아웃>>:");
					int ch = scanner.nextInt();
					switch(ch) {
					case 1:
						System.out.println("++++++++++++++++++예매menu++++++++++++++++");
						
						System.out.println("+++++++++++++++++++++++++++++++++++++++");	
						
					case 2:
						System.out.println("++++++++++++++++++예매확인++++++++++++++++");
						System.out.println("+++++++++++++++++++++++++++++++++++++++");
						
					case 3:
						System.out.println("++++++++++++++++++예매취소++++++++++++++++");
						System.out.println("+++++++++++++++++++++++++++++++++++++++");
					case 4:
						System.out.println("로그아웃 되었습니다");
						return;
					}
				}
				
			}
}
