package view;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Scanner;

import controller.Bookcontroller;
import controller.Membercontroller;
import model.Member2;
import model.seat;

public class Application {

	public static Scanner scanner = new Scanner(System.in);
	public static  String name; 
	
	 public static ArrayList<seat> seatlist = new ArrayList<>();
	public static void main(String[] args) {
	    for (int i = 0; i < 30; i++) {
		if(i<10) {
		    
		 seatlist.add(new seat("s_seat","name",i+1)); //객체한번에넣기  
		}
		else if(i<20) {
		    seatlist.add(new seat("s_seat","name",i+1)); //객체한번에넣기  
		    
		}else if(i<30) {
		    seatlist.add(new seat("s_seat","name",i+1)); //객체한번에넣기  
		}
	    }
	
	
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
				}else if(result) {
					System.out.println("[알림]관리자 로그인성공");
					adminmenu(id);
				}else {
					System.out.println("[알림]로그인실패");
				}break;
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
			    name=findname(id);
				while(true) {
				    	
					
					System.out.println("++++++++++++++++++회원메뉴++++++++++++++++");
					System.out.println("1.조회 2.예매 3.취소4.로그아웃>>:");
					int ch = scanner.nextInt();
					switch(ch) {
					case 1:
					    	
						System.out.println("++++++++++++++++++예매조회++++++++++++++++");
						Bookcontroller.seatview();
						System.out.println("+++++++++++++++++++++++++++++++++++++++");
						
						break;
					case 2:
						System.out.println("++++++++++++++++++예매++++++++++++++++");
						
							System.out.println("이름 :");
					    	System.out.println("좌석을 선택해주세요:");
					    	String name1 = scanner.next();
					    	int num = scanner.nextInt();
					    	for (seat temp : seatlist) {
					    	    if(temp.getName().equals("name")&&temp.getNum()==num) {
					    		temp.setName(name);
					    		System.out.println("예약이 완료되었습니다");
					    		System.out.println(temp.getName());
					    	    }
						    
						}

						System.out.println("+++++++++++++++++++++++++++++++++++++++");
						break;
					case 3:
						System.out.println("++++++++++++++++++예매취소++++++++++++++++");
						System.out.println(name);
						boolean result =Bookcontroller.cancel(name);
						if(result) {
						    	System.out.println("취소성공~!");
						}else {
						    System.out.println("취소실패~!");
						}
						    
						
						System.out.println("+++++++++++++++++++++++++++++++++++++++");
						break;
					case 4:
						System.out.println("로그아웃 되었습니다");
						return;
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



















