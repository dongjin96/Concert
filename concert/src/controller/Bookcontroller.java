package controller;

import File.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import model.Member2;
import model.seat;
import view.Application;

public class Bookcontroller {

	public static Scanner scanner = new Scanner(System.in);

	/*
	 * 
	 * 
	 * public static ArrayList<seat> room(){ ArrayList<seat> room = new
	 * ArrayList<seat>(); for (int i = 0; i < 30; i++) { if(i<10) {
	 * 
	 * room.add(new seat("s_seat","name",i+1)); //객체한번에넣기 } else if(i<20) {
	 * room.add(new seat("s_seat","name",i+1)); //객체한번에넣기
	 * 
	 * }else if(i<30) { room.add(new seat("s_seat","name",i+1)); //객체한번에넣기 } }
	 * return room;
	 * 
	 * }
	 */
			//조회하는메소드
			public static void seatview() {
			    int row =1;
			    System.out.print(" S 좌석 : ");
			    for(int i=1; i<=30; i++) {
				 boolean seatcheck = true;
				for( seat temp : Application.seatlist1 ) {
				    if( temp.getSeat_num() == i ) {
					System.out.print(" "+ temp.getMember_id() + " ");
					seatcheck = false;
					break;
				    }
				}
				if(  seatcheck ) {
				    String strnum = String.format( "%02d", i );
				    System.out.print(" "+ strnum + " ");

				}
				if( i % 10 == 0 ) {
				    System.out.println(); row++;
				    if( row == 2 ) System.out.print(" A 좌석 : ");
				    if( row == 3 ) System.out.print(" B 좌석 : ");
				   
				}
			    }
			 System.out.println();   
			}
			//예매하기
			public static void Book( int num, String name) {
			    
			    // 중복체크 
			    for( seat temp : Application.seatlist1 ) {
				if( temp.getSeat_num() == num ) {
				    System.out.println("현재 예매가 된 자리 입니다 ");
				    return; // 예매 막기 
				}
			    }
			    // 중복이 없으면 등록 
			    seat seat = new seat( num , name ); // 예매좌석 객체 
			    Application.seatlist1.add(seat); // 예매좌석을 1관 리스트에 넣기 
			    File.filesave(2);
			}
				
				
			// 이름찾기
			public static String findname(String abc) {
			    for(Member2 temp:Membercontroller.memberlist) {
				if(temp.getId().equals(abc)) {
				    return temp.getName();
				}
			    }return null;
			    
			}
			// 취소 메소드
			public static boolean cancel1(ArrayList<seat> abs, String name) {
				
				int[] bookcancel =new int[3];
				System.out.println(name);
				int count =1;
				for(seat temp : abs) {
					if(temp.getMember_id().equals(name)) {
					bookcancel[count]=temp.getSeat_num();
					System.out.println(count+"번"+"예약 된 좌석 번호 입니다 :"+bookcancel[count]);
					count++;
						
					}
					
				}
				System.out.println("취소 할 좌석 번호 를 입력해주세요 :"); int ch = scanner.nextInt();
				if(ch >bookcancel.length || ch<0 ) {
					System.out.println(" 잘못 입력했습니다");
					return false;
				}else {
				
					System.out.println("하고난거"+abs.get(0).getSeat_num());
					if(Application.seatlist1.isEmpty()) {
						System.out.println("성공121212121212");
					}else if(abs.get(ch).getMember_id()==null){
						System.out.println("getMember_id실패");
					}
					for(seat temp : abs) {
						System.out.println("나s"+temp.getSeat_num());
					}
					abs.remove(ch-1);
					System.out.println("하고난거"+abs.get(0).getSeat_num());
					if(Application.seatlist1.isEmpty()) {
						System.out.println("성공");
					}else if(abs.get(ch).getMember_id()==null){
						System.out.println("getMember_id실패");
					}
					for(seat temp : abs) {
						System.out.println("나중에"+temp.getSeat_num());
					}
					
					File.filesave(2);
					return true;}
				
				
				//int[] bookcancel =new int[3];
		
				/*
				 * for (seat temp: abs) { if(temp.getMember_id().equals(name)) { for (int i = 1;
				 * i < bookcancel.length; i++) { if(bookcancel[i]==0) {
				 * bookcancel[i]=temp.getSeat_num();
				 * System.out.println(i+1+"번"+"예약 된 좌석 번호 입니다 :"+bookcancel[i]); continue; } }
				 * 
				 * System.out.println("취소 할 좌석 번호 를 입력해주세요 :"); int ch1 = scanner.nextInt();
				 * if(ch >bookcancel.length || ch<0 ) { System.out.println(" 잘못 입력했습니다"); return
				 * false; }else {
				 * 
				 * abs.get(bookcancel[ch]).setSeat_num(ch); System.out.println(ch);
				 * System.out.println(bookcancel[ch]); File.filesave(2); return true;}
				 * 
				 * 
				 * }
				 * 
				 * 
				 * 
				 * }
				 */
				
			}

			/*
			 * public static boolean cancel2(ArrayList<seat> abs, String name) { for (seat
			 * temp: abs) { System.out.println(temp.get()); if(temp.getName().equals(name))
			 * { temp.setName("name"); return true; }else {
			 * 
			 * }
			 * 
			 * }return false; }
			 */
			//조회하는 메소드
			public static boolean bookview(ArrayList<seat> asv, String name) {
				for(seat temp : asv) {
					if(temp.getMember_id().equals(name)) {
						System.out.println("회원님의 좌석은 :"+temp.getSeat_num()+"입니다");
						return true;
					}else {
						System.out.println("예약한 좌석이 없습니다");
						return false;
					}
				}return false;
			}
//			public static String book(String name) {
//				 name=findname(id);
//			}
//			for (seat temp : seatlist) {
//	    	    if(temp.getName().equals("name")&&temp.getNum()==num) {
//	    		temp.setName(name);
//	    		System.out.println("예약이 완료되었습니다");
//	    		System.out.println(temp.getName());
//	    	    }
//			}
}
