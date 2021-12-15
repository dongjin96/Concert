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
		    
		 seatlist.add(new seat("s_seat","name",i+1)); //��ü�ѹ����ֱ�  
		}
		else if(i<20) {
		    seatlist.add(new seat("s_seat","name",i+1)); //��ü�ѹ����ֱ�  
		    
		}else if(i<30) {
		    seatlist.add(new seat("s_seat","name",i+1)); //��ü�ѹ����ֱ�  
		}
	    }
	
	
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
				}else if(result) {
					System.out.println("[�˸�]������ �α��μ���");
					adminmenu(id);
				}else {
					System.out.println("[�˸�]�α��ν���");
				}break;
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
					}
				}
			}
		}
	}//main end
			private static void adminmenu(String id) {
				while(true) {
					System.out.println("+++++++++++++++++�����ڸ޴�++++++++++++++++");
					System.out.println("1.��ȭ��� 2. ��ȭ������ 3.�α׾ƿ�");
				}
		
		
	}

			
			public static void membermenu(String id) {
			    name=findname(id);
				while(true) {
				    	
					
					System.out.println("++++++++++++++++++ȸ���޴�++++++++++++++++");
					System.out.println("1.��ȸ 2.���� 3.���4.�α׾ƿ�>>:");
					int ch = scanner.nextInt();
					switch(ch) {
					case 1:
					    	
						System.out.println("++++++++++++++++++������ȸ++++++++++++++++");
						Bookcontroller.seatview();
						System.out.println("+++++++++++++++++++++++++++++++++++++++");
						
						break;
					case 2:
						System.out.println("++++++++++++++++++����++++++++++++++++");
						
							System.out.println("�̸� :");
					    	System.out.println("�¼��� �������ּ���:");
					    	String name1 = scanner.next();
					    	int num = scanner.nextInt();
					    	for (seat temp : seatlist) {
					    	    if(temp.getName().equals("name")&&temp.getNum()==num) {
					    		temp.setName(name);
					    		System.out.println("������ �Ϸ�Ǿ����ϴ�");
					    		System.out.println(temp.getName());
					    	    }
						    
						}

						System.out.println("+++++++++++++++++++++++++++++++++++++++");
						break;
					case 3:
						System.out.println("++++++++++++++++++�������++++++++++++++++");
						System.out.println(name);
						boolean result =Bookcontroller.cancel(name);
						if(result) {
						    	System.out.println("��Ҽ���~!");
						}else {
						    System.out.println("��ҽ���~!");
						}
						    
						
						System.out.println("+++++++++++++++++++++++++++++++++++++++");
						break;
					case 4:
						System.out.println("�α׾ƿ� �Ǿ����ϴ�");
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



















