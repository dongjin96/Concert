package view;

import File.File;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Bookcontroller;
import controller.Membercontroller;
import model.Member2;
import model.seat;

public class Application {

	public static Scanner scanner = new Scanner(System.in);
	public static  String name; 
	
	 public static ArrayList<seat> seatlist = new ArrayList<seat>();
	 public static ArrayList<seat> seatlist2 = Bookcontroller.room();
	public static void main(String[] args) {
	
	
		File.fileload(1);	// 회원 파일 불러오기
		File.fileload(2);
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
				System.out.println("id입력:"); String id = scanner.next();
				System.out.println("pw입력:"); String pw = scanner.next();
				boolean result= Membercontroller.login(id, pw);
				if(result) {
					System.out.println("[알림]로그인성공");
					membermenu(id);
					continue;
				}else if(result) {
					System.out.println("[알림]관리자 로그인성공");
				
				}else {
					System.out.println("[알림]로그인실패");
				}return;
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
					return;
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
					return;
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
						return;
					}
				}
			}	
		}
	}//main end
		

			
			public static void membermenu(String id) {
			    name=findname(id);
				while(true) {
				    	
					try {
						
					
					System.out.println("++++++++++++++++++회원메뉴++++++++++++++++");
					System.out.println("1.조회 2.예매 3.취소4.로그아웃>>:");
					int ch = scanner.nextInt();
					if(ch==1) {
					
					    	
						System.out.println("++++++++++++++++++예매조회++++++++++++++++");
						System.out.println("1.관|2.관 :"); ch = scanner.nextInt();
						if (ch==1) {
							Bookcontroller.seatview(seatlist);
						}else {
							Bookcontroller.seatview(seatlist2);
						}
						
						System.out.println("+++++++++++++++++++++++++++++++++++++++");
						
					}else if(ch==2){
						System.out.println("++++++++++++++++++예매++++++++++++++++");
						System.out.println("1.관|2.관 :"); ch = scanner.nextInt();
						if(ch==1) {
							System.out.println("좌석을 선택해주세요:");
					    	int num = scanner.nextInt();
					    	Bookcontroller.Book(seatlist, num, name);
						
						}else {
							System.out.println("좌석을 선택해주세요:");
					    	int num = scanner.nextInt();
					    	Bookcontroller.Book(seatlist2, num, name);
						}
					    	

						System.out.println("+++++++++++++++++++++++++++++++++++++++");
						
					}else if(ch==3){
						System.out.println("++++++++++++++++++예매취소++++++++++++++++");
						System.out.println("1.관|2.관 :"); ch = scanner.nextInt();
						if(ch==1) {
							Bookcontroller.cancel1(seatlist, name);
							
							System.out.println("취소 성공");
						}else if(ch==2) {
							Bookcontroller.cancel2(seatlist2, name);
						
							
						}else {
							System.out.println("취소 실패");
						}
						
						
						
						    
						
						System.out.println("+++++++++++++++++++++++++++++++++++++++");
						
					}else{
						System.out.println("로그아웃 되었습니다");
						return;
					}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				
			}
//			
			
			public static String findname(String abc) {
			    for(Member2 temp:Membercontroller.memberlist) {
				if(temp.getId().equals(abc)) {
				   return temp.getName();
				}
			    }return null;
			    
			}
//			
//			public static boolean cancel(String name) {
//			    for (seat temp: seatlist) {
//				System.out.println(temp.getName());
//				if(temp.getName().equals(name)) {
//				    temp.setName("name");
//				    return true;
//				}else {
//				    
//				}
//				
//			    }return false;
//			}

}



















