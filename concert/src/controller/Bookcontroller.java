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
		    		    
		    		room.add(new seat("s_seat","name",i+1)); //��ü�ѹ����ֱ�  
		    		}
		    		else if(i<20) {
		    			room.add(new seat("s_seat","name",i+1)); //��ü�ѹ����ֱ�  
		    		    
		    		}else if(i<30) {
		    			room.add(new seat("s_seat","name",i+1)); //��ü�ѹ����ֱ�  
		    		}
		    	    }
		        return room;
		    	
		    }
			//��ȸ�ϴ¸޼ҵ�
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
			//�����ϱ�
			public static void Book(ArrayList<seat> avx,int num, String name) {
				for (seat temp : avx) {
		    	    if(temp.getName().equals("name")&&temp.getNum()==num) {
		    		temp.setName(name);
		    		System.out.println("������ �Ϸ�Ǿ����ϴ�");
		    		System.out.println(temp.getName());
		    	
		    	    }
				}
				
				File.filesave(1);
			}
			// �̸�ã��
			public static String findname(String abc) {
			    for(Member2 temp:Membercontroller.memberlist) {
				if(temp.getId().equals(abc)) {
				    return temp.getName();
				}
			    }return null;
			    
			}
			// ��� �޼ҵ�
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
			//��ȸ�ϴ� �޼ҵ�
			public static boolean bookview(ArrayList<seat> asv, String name) {
				for(seat temp : asv) {
					if(temp.getName().equals(name)) {
						System.out.println("ȸ������ �¼��� :"+temp.getNum()+"�Դϴ�");
						return true;
					}else {
						System.out.println("������ �¼��� �����ϴ�");
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
//	    		System.out.println("������ �Ϸ�Ǿ����ϴ�");
//	    		System.out.println(temp.getName());
//	    	    }
//			}
}
