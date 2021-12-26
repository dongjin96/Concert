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
	
	
		File.fileload(1);	// ȸ�� ���� �ҷ�����
		File.fileload(2);
		mainmenu();
		
	}
	
	
	
	
	private static void mainmenu() {
		while(true) {
		   
		
		    
		    	
		    
			System.out.println("===============ȸ�� Ŀ�´�Ƽ===============");
			System.out.println("1.�α���|2.ȸ������|3.���̵�ã��|4.��й�ȣã��| :");
			System.out.println("=======================================");
			int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("==============�α���=================");
				System.out.println("id�Է�:"); String id = scanner.next();
				System.out.println("pw�Է�:"); String pw = scanner.next();
				boolean result= Membercontroller.login(id, pw);
				if(result) {
					System.out.println("[�˸�]�α��μ���");
					membermenu(id);
					continue;
				}else if(result) {
					System.out.println("[�˸�]������ �α��μ���");
				
				}else {
					System.out.println("[�˸�]�α��ν���");
				}return;
			}
			if(ch==2) {
				System.out.println("==============ȸ������================");
				System.out.println("id : "); String id = scanner.next();
				System.out.println("pw : "); String pw = scanner.next();
				System.out.println("�̸�: "); String name = scanner.next();
				System.out.println("phone: "); String phone = scanner.next();
				Member2 member2 = new Member2(id, pw, name, phone);
				boolean result=Membercontroller.signup(member2);
				if(result) {
					System.out.println("[�˸�]ȸ������ ����");
				}else {
					System.out.println("[�˸�]ȸ������ ����");
					return;
				}
			}
			if(ch==3) {
				System.out.println("==============���̵�ã��==============");
				System.out.println("�̸� :"); String name= scanner.next();
				System.out.println("phone :");String phone= scanner.next();
				boolean result = Membercontroller.forgotid(name,phone);
				if (result) {
					System.out.println("���̵�ã�� ����");
				}else {
					System.out.println("���̵�ã�� ����");
					return;
				}
			}
			if(ch==4) {
				System.out.println("==============��й�ȣã��==============");
				System.out.println("id�Է�  :"); String id = scanner.next();
				System.out.println("phone�Է� :"); String phone = scanner.next();
				boolean result=Membercontroller.forgotpw(id, phone);{
					if (result) {
						System.out.println("��й�ȣã�� ����");
					}else {
						System.out.println("��й�ȣ ã�� ����");
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
						
					
					System.out.println("++++++++++++++++++ȸ���޴�++++++++++++++++");
					System.out.println("1.��ȸ 2.���� 3.���4.�α׾ƿ�>>:");
					int ch = scanner.nextInt();
					if(ch==1) {
					
					    	
						System.out.println("++++++++++++++++++������ȸ++++++++++++++++");
						System.out.println("1.��|2.�� :"); ch = scanner.nextInt();
						if (ch==1) {
							Bookcontroller.seatview(seatlist);
						}else {
							Bookcontroller.seatview(seatlist2);
						}
						
						System.out.println("+++++++++++++++++++++++++++++++++++++++");
						
					}else if(ch==2){
						System.out.println("++++++++++++++++++����++++++++++++++++");
						System.out.println("1.��|2.�� :"); ch = scanner.nextInt();
						if(ch==1) {
							System.out.println("�¼��� �������ּ���:");
					    	int num = scanner.nextInt();
					    	Bookcontroller.Book(seatlist, num, name);
						
						}else {
							System.out.println("�¼��� �������ּ���:");
					    	int num = scanner.nextInt();
					    	Bookcontroller.Book(seatlist2, num, name);
						}
					    	

						System.out.println("+++++++++++++++++++++++++++++++++++++++");
						
					}else if(ch==3){
						System.out.println("++++++++++++++++++�������++++++++++++++++");
						System.out.println("1.��|2.�� :"); ch = scanner.nextInt();
						if(ch==1) {
							Bookcontroller.cancel1(seatlist, name);
							
							System.out.println("��� ����");
						}else if(ch==2) {
							Bookcontroller.cancel2(seatlist2, name);
						
							
						}else {
							System.out.println("��� ����");
						}
						
						
						
						    
						
						System.out.println("+++++++++++++++++++++++++++++++++++++++");
						
					}else{
						System.out.println("�α׾ƿ� �Ǿ����ϴ�");
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



















