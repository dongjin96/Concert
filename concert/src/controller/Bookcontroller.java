package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Member2;
import model.seat;
import view.Application;

public class Bookcontroller {

	public static Scanner scanner = new Scanner(System.in);
	
			public static ArrayList<seat> seatlist = Application.seatlist;
			public static  String name; 
			
			//조회하는메소드
			public static void seatview() {
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
				
				
				if(seatlist.get(i).getName().equals("name")) { 
				    System.out.print("--- ");
				}else {
				    System.out.print(seatlist.get(i).getName()); 
				}
				
			    }
			 System.out.println();   
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
			public static boolean cancel(String name) {
			    for (seat temp: seatlist) {
				System.out.println(temp.getName());
				if(temp.getName().equals(name)) {
				    temp.setName("name");
				    return true;
				}else {
				    
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
