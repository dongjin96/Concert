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
	 * room.add(new seat("s_seat","name",i+1)); //��ü�ѹ����ֱ� } else if(i<20) {
	 * room.add(new seat("s_seat","name",i+1)); //��ü�ѹ����ֱ�
	 * 
	 * }else if(i<30) { room.add(new seat("s_seat","name",i+1)); //��ü�ѹ����ֱ� } }
	 * return room;
	 * 
	 * }
	 */
			//��ȸ�ϴ¸޼ҵ�
			public static void seatview() {
			    int row =1;
			    System.out.print(" S �¼� : ");
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
				    if( row == 2 ) System.out.print(" A �¼� : ");
				    if( row == 3 ) System.out.print(" B �¼� : ");
				   
				}
			    }
			 System.out.println();   
			}
			//�����ϱ�
			public static void Book( int num, String name) {
			    
			    // �ߺ�üũ 
			    for( seat temp : Application.seatlist1 ) {
				if( temp.getSeat_num() == num ) {
				    System.out.println("���� ���Ű� �� �ڸ� �Դϴ� ");
				    return; // ���� ���� 
				}
			    }
			    // �ߺ��� ������ ��� 
			    seat seat = new seat( num , name ); // �����¼� ��ü 
			    Application.seatlist1.add(seat); // �����¼��� 1�� ����Ʈ�� �ֱ� 
			    File.filesave(2);
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
				
				int[] bookcancel =new int[3];
				System.out.println(name);
				int count =1;
				for(seat temp : abs) {
					if(temp.getMember_id().equals(name)) {
					bookcancel[count]=temp.getSeat_num();
					System.out.println(count+"��"+"���� �� �¼� ��ȣ �Դϴ� :"+bookcancel[count]);
					count++;
						
					}
					
				}
				System.out.println("��� �� �¼� ��ȣ �� �Է����ּ��� :"); int ch = scanner.nextInt();
				if(ch >bookcancel.length || ch<0 ) {
					System.out.println(" �߸� �Է��߽��ϴ�");
					return false;
				}else {
				
					System.out.println("�ϰ���"+abs.get(0).getSeat_num());
					if(Application.seatlist1.isEmpty()) {
						System.out.println("����121212121212");
					}else if(abs.get(ch).getMember_id()==null){
						System.out.println("getMember_id����");
					}
					for(seat temp : abs) {
						System.out.println("��s"+temp.getSeat_num());
					}
					abs.remove(ch-1);
					System.out.println("�ϰ���"+abs.get(0).getSeat_num());
					if(Application.seatlist1.isEmpty()) {
						System.out.println("����");
					}else if(abs.get(ch).getMember_id()==null){
						System.out.println("getMember_id����");
					}
					for(seat temp : abs) {
						System.out.println("���߿�"+temp.getSeat_num());
					}
					
					File.filesave(2);
					return true;}
				
				
				//int[] bookcancel =new int[3];
		
				/*
				 * for (seat temp: abs) { if(temp.getMember_id().equals(name)) { for (int i = 1;
				 * i < bookcancel.length; i++) { if(bookcancel[i]==0) {
				 * bookcancel[i]=temp.getSeat_num();
				 * System.out.println(i+1+"��"+"���� �� �¼� ��ȣ �Դϴ� :"+bookcancel[i]); continue; } }
				 * 
				 * System.out.println("��� �� �¼� ��ȣ �� �Է����ּ��� :"); int ch1 = scanner.nextInt();
				 * if(ch >bookcancel.length || ch<0 ) { System.out.println(" �߸� �Է��߽��ϴ�"); return
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
			//��ȸ�ϴ� �޼ҵ�
			public static boolean bookview(ArrayList<seat> asv, String name) {
				for(seat temp : asv) {
					if(temp.getMember_id().equals(name)) {
						System.out.println("ȸ������ �¼��� :"+temp.getSeat_num()+"�Դϴ�");
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
