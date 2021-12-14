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
		for(i=0;i<10;i++) { // 1과 0으로 좌석 구분
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
	

	void seatPerson(int seat, int number, String name) { //예약자좌석을 이름으로 바꾸어준다
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
	String getName(){ //좌석 예약자 이름을 받는 메소드
		System.out.print("이름>>");
		String name = scanner.next();
		return name;
	}
	
	int getSeatNumber(){ //좌석 번호를 받는 메소드
		System.out.print("번호>>");
		int num = scanner.nextInt();
		return num;
	}
	
	int seatcheck(int seat, int number, String name) {// 예약여부를 확인한다
		int check=0;
		switch(seat) {
		case 1 :
			if(s[number][1]=="1"){//이미 예약이 되어있는경우는
				System.out.println("해당좌석이 예약되어있습니다.");
				check=0;
			}
			else {
				seatPerson(seat, number, name); // 예약에성공한경우
				System.out.println("예약되었습니다~~!");
				check=1; //예약성공했으니 리턴값을 1
			}
			break;
		case 2:
			if(a[number][1]=="1"){//이미 예약이 되어있는경우는
				System.out.println("해당좌석이 예약되어있습니다.");
				check=0;
			}
			else {
				seatPerson(seat, number, name); // 예약에성공한경우
				System.out.println("예약되었습니다~~!");
				check=1; //예약성공했으니 리턴값을 1
			}
			break;
		case 3:
			if(b[number][1]=="1"){//이미 예약이 되어있는경우는
				System.out.println("해당좌석이 예약되어있습니다.");
				check=0;
			}
			else {
				seatPerson(seat, number, name); // 예약에성공한경우
				System.out.println("예약되었습니다~~!");
				check=1; //예약성공했으니 리턴값을 1
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
					if (name.equals(s[i][0])) {// 같은 이름의 예약자이면 예약을 취소시킴
						s[i][0]="---";
						s[i][1]="0";
						System.out.println("예약이 취소되었습니다!");
						break;
						
					}
				}
					if(!name.equals(s[i][0])) {//동일하지 않을경우
						System.out.println("예약목록이 없습니다");
						return 0;
				}else {
					System.out.println("다시 입력해주세요");
					break;
				}
				
			}break;
		case 2:
			while(true) {
				for(i=0; i<10; i++) {
					if (name.equals(a[i][0])) {// 같은 이름의 예약자이면 예약을 취소시킴
						a[i][0]="---";
						a[i][1]="0";
						System.out.println("예약이 취소되었습니다!");
						break;
						
					}
				}
					if(!name.equals(a[i][0])) {//동일하지 않을경우
						System.out.println("예약목록이 없습니다");
						return 0;
				}else {
					System.out.println("다시 입력해주세요");
					break;
				}
				
			}break;
		case 3:
			while(true) {
				for(i=0; i<10; i++) {
					if (name.equals(b[i][0])) {// 같은 이름의 예약자이면 예약을 취소시킴
						b[i][0]="---";
						b[i][1]="0";
						System.out.println("예약이 취소되었습니다!");
						break;
						
					}
				}
					if(!name.equals(b[i][0])) {//동일하지 않을경우
						System.out.println("예약목록이 없습니다");
						return 0;
				}else {
					System.out.println("다시 입력해주세요");
					break;
				}
				
			}break;
		
		}
		return 1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}//ce