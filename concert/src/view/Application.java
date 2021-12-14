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
			System.out.println("===============ȸ�� Ŀ�´�Ƽ===============");
			System.out.println("1.�α���|2.ȸ������|3.���̵�ã��|4.��й�ȣã��| :");
			System.out.println("=======================================");
			int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("==============�α���=================");
				System.out.println("idã��:"); String id = scanner.next();
				System.out.println("pwã��:"); String pw = scanner.next();
				boolean result= Membercontroller.login(id, pw);
				if(result) {
					System.out.println("[�˸�]�α��μ���");
					membermenu(id);
				}else if(result) {
					System.out.println("[�˸�]������ �α��μ���");
					adminmenu(id);
				}else {
					System.out.println("[�˸�]�α��ν���");
				}
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
				
				while(true) {
					System.out.println("++++++++++++++++++ȸ���޴�++++++++++++++++");
					System.out.println("1.����2.��ȸ 3.���4.�α׾ƿ�>>:");
					int ch = scanner.nextInt();
					switch(ch) {
					case 1:
						System.out.println("++++++++++++++++++����menu++++++++++++++++");
						
						System.out.println("+++++++++++++++++++++++++++++++++++++++");	
						
					case 2:
						System.out.println("++++++++++++++++++����Ȯ��++++++++++++++++");
						System.out.println("+++++++++++++++++++++++++++++++++++++++");
						
					case 3:
						System.out.println("++++++++++++++++++�������++++++++++++++++");
						System.out.println("+++++++++++++++++++++++++++++++++++++++");
					case 4:
						System.out.println("�α׾ƿ� �Ǿ����ϴ�");
						return;
					}
				}
				
			}
}
