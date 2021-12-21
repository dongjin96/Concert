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
	
			
			
			public static ArrayList<seat> room(){
		        ArrayList<seat> room =  new ArrayList<seat>();
		        for (int i = 0; i < 30; i++) {
		    		if(i<10) {
		    		    
		    		room.add(new seat("s_seat","name",i+1)); //객체한번에넣기  
		    		}
		    		else if(i<20) {
		    			room.add(new seat("s_seat","name",i+1)); //객체한번에넣기  
		    		    
		    		}else if(i<30) {
		    			room.add(new seat("s_seat","name",i+1)); //객체한번에넣기  
		    		}
		    	    }
		        return room;
		    	
		    }
			//조회하는메소드
			public static void seatview(ArrayList<seat> room) {
			    for(int i=0; i<30; i++) {
				if(i%10==0) {
				    System.out.println();
				}
				if (i==0) {
				    System.out.print("S ");
				    
				}
				if (i==10) {
				    System.out.print("A ");
				    
				}
				if (i==20) {
				    System.out.print("C ");
				    
				}
				
			
				if(room.get(i).getName().equals("name")) { 
				    System.out.print("--- ");
				}else {
				    System.out.print(room.get(i).getName()); 
				}
				
			    }
			    
			 System.out.println();   
			}
			//예매하기
			public static void Book(ArrayList<seat> avx,int num, String name) {
				for (seat temp : avx) {
		    	    if(temp.getName().equals("name")&&temp.getNum()==num) {
		    		temp.setName(name);
		    		System.out.println("예약이 완료되었습니다");
		    		System.out.println(temp.getName());
		    	
		    	    }
				}
				
				File.filesave(1);
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
			    for (seat temp: abs) {
				System.out.println(temp.getName());
				if(temp.getName().equals(name)) {
				    temp.setName("name");
				    return true;
				}else {
				    
				}
				
			    }return false;
			}
			public static boolean cancel2(ArrayList<seat> abs, String name) {
			    for (seat temp: abs) {
				System.out.println(temp.getName());
				if(temp.getName().equals(name)) {
				    temp.setName("name");
				    return true;
				}else {
				    
				}
				
			    }return false;
			}
			//조회하는 메소드
			public static boolean bookview(ArrayList<seat> asv, String name) {
				for(seat temp : asv) {
					if(temp.getName().equals(name)) {
						System.out.println("회원님의 좌석은 :"+temp.getNum()+"입니다");
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
