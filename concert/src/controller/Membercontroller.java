package controller;

import java.util.ArrayList;


import model.Member2;

public class Membercontroller {

	public static ArrayList<Member2>memberlist = new ArrayList<>();
	
	//�α��θ޼ҵ�
	public static boolean login(String id, String password) {
		for ( Member2 member2 : memberlist) {
			if( member2.getId().equals(id) && 
					member2.getPassword().equals(password) ) {
				return true; 
		}else {
			if(member2.getId().equals("admin")&& 
					member2.getPassword().equals(password)) {
				return true;
			}
		}
		}
		return false;
	}
	//ȸ������ �޼ҵ�
	public static boolean signup(Member2 member2) {
		// ��ȿ�� �˻�
		if(member2.getId().length()<4) {
			System.out.println("ID�� 4�����̻� �����մϴ�");
			return false; 
		}
		if(member2.getPassword().length()<4) {
			System.out.println("PW�� 4���� �̻� �����մϴ�");
			return false; 
		}
		if(member2.getName().length()<2) {
			System.out.println("�̸��� 2���� �̻� �����մϴ�");
			return false; 
		}
		if(member2.getPhone().length()<11) {
			System.out.println("��ȭ��ȣ�� - �� �����ϰ� �Է����ּ���");
			return false; 
		}
	
	
	//���̵� �ߺ� üũ
		for (Member2 temp : memberlist) {
			if (temp.getId().equals(member2.getId())) {
				System.out.println("������ ���̵� �����մϴ�");
				return false;
			}
			
		}
		memberlist.add(member2);
		return true;
	}
	
	//���̵� ã��
	public static boolean forgotid(String name,String phone) {
		for(Member2 member2:memberlist) {
			if (member2.getName().equals(name)&&member2.getPhone().equals(phone)) {
				System.out.println("ȸ������ ���̵��Դϴ�:"+member2.getId());
				return true;
			}
		}
		return false;
	}
	//��й�ȣ ã��
	public static boolean forgotpw(String id, String phone) {
		for(Member2  member2 : memberlist) {
			if (member2.getId().equals(id)&&member2.getPhone().equals(phone)) {
				System.out.println("ȸ������ ��й�ȣ�Դϴ� :"+member2.getPassword());
				return true;
				
			}
		}
		return false;
	}
	
	
	
}
