package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Member2;

	

public class Concert {
	
	public static String name;
	public static Scanner scanner = new Scanner(System.in);
	public static ArrayList<Member2>memberlist = new ArrayList<>();
	String[][] s = new String[10][2];
	String[][] a = new String[10][2];
	String[][] b = new String[10][2];
	int i;
	Concert() {
		for(i=0;i<10;i++) { // 1�� 0���� �¼� ����
			s[i][0]="---";
			s[i][1]="0";
		}
		for(i=0;i<10;i++) {
			a[i][0]="---";
			a[i][1]="0";
		}
		for(i=0;i<10;i++) {
			b[i][0]="---";
			b[i][1]="0";
		}
			
	}
	

	void seatPerson(int seat, int number, String name) { //�������¼��� �̸����� �ٲپ��ش�
		switch(seat) {
		case 1:
			s[number][0]=name;
			s[number][1]="1";
			break;
		case 2:
			a[number][0]=name;
			a[number][1]="1";
		case 3:
			b[number][0]=name;
			b[number][1]="1";
		}
	}
	String getName(){ //�¼� ������ �̸��� �޴� �޼ҵ�
		System.out.print("�̸�>>");
		String name = scanner.next();
		return name;
	}
	
	int getSeatNumber(){ //�¼� ��ȣ�� �޴� �޼ҵ�
		System.out.print("��ȣ>>");
		int num = scanner.nextInt();
		return num;
	}
	
	int seatcheck(int seat, int number, String name) {// ���࿩�θ� Ȯ���Ѵ�
		int check=0;
		switch(seat) {
		case 1 :
			if(s[number][1]=="1"){//�̹� ������ �Ǿ��ִ°���
				System.out.println("�ش��¼��� ����Ǿ��ֽ��ϴ�.");
				check=0;
			}
			else {
				seatPerson(seat, number, name); // ���࿡�����Ѱ��
				System.out.println("����Ǿ����ϴ�~~!");
				check=1; //���༺�������� ���ϰ��� 1
			}
			break;
		case 2:
			if(a[number][1]=="1"){//�̹� ������ �Ǿ��ִ°���
				System.out.println("�ش��¼��� ����Ǿ��ֽ��ϴ�.");
				check=0;
			}
			else {
				seatPerson(seat, number, name); // ���࿡�����Ѱ��
				System.out.println("����Ǿ����ϴ�~~!");
				check=1; //���༺�������� ���ϰ��� 1
			}
			break;
		case 3:
			if(b[number][1]=="1"){//�̹� ������ �Ǿ��ִ°���
				System.out.println("�ش��¼��� ����Ǿ��ֽ��ϴ�.");
				check=0;
			}
			else {
				seatPerson(seat, number, name); // ���࿡�����Ѱ��
				System.out.println("����Ǿ����ϴ�~~!");
				check=1; //���༺�������� ���ϰ��� 1
			}
			break;	
		}
		return check;
		
	}
	int cancel(int num,String name) {
		switch(num) {
		case 1:
			while(true) {
				for(i=0; i<10; i++) {
					if (name.equals(s[i][0])) {// ���� �̸��� �������̸� ������ ��ҽ�Ŵ
						s[i][0]="---";
						s[i][1]="0";
						System.out.println("������ ��ҵǾ����ϴ�!");
						break;
						
					}
				}
					if(!name.equals(s[i][0])) {//�������� �������
						System.out.println("�������� �����ϴ�");
						return 0;
				}else {
					System.out.println("�ٽ� �Է����ּ���");
					break;
				}
				
			}break;
		case 2:
			while(true) {
				for(i=0; i<10; i++) {
					if (name.equals(a[i][0])) {// ���� �̸��� �������̸� ������ ��ҽ�Ŵ
						a[i][0]="---";
						a[i][1]="0";
						System.out.println("������ ��ҵǾ����ϴ�!");
						break;
						
					}
				}
					if(!name.equals(a[i][0])) {//�������� �������
						System.out.println("�������� �����ϴ�");
						return 0;
				}else {
					System.out.println("�ٽ� �Է����ּ���");
					break;
				}
				
			}break;
		case 3:
			while(true) {
				for(i=0; i<10; i++) {
					if (name.equals(b[i][0])) {// ���� �̸��� �������̸� ������ ��ҽ�Ŵ
						b[i][0]="---";
						b[i][1]="0";
						System.out.println("������ ��ҵǾ����ϴ�!");
						break;
						
					}
				}
					if(!name.equals(b[i][0])) {//�������� �������
						System.out.println("�������� �����ϴ�");
						return 0;
				}else {
					System.out.println("�ٽ� �Է����ּ���");
					break;
				}
				
			}break;
		
		}
		return 1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}//ce