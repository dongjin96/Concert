package File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import controller.Bookcontroller;
import controller.Membercontroller;
import model.Member2;
import model.seat;
import view.Application;

public class File {
	
	// �ʵ�
		// 1. ȸ�������� �����ϴ� ������ ��� 
	private static String memberpath = 
			"C:/Users/������/Desktop/apache-tomcat-9.0.56-windows-x64/�����ڹ�/Concert/concert/src/File/memberlist.txt";
	private static String bookpath=
			"C:/Users/������/Desktop/apache-tomcat-9.0.56-windows-x64/�����ڹ�/Concert/concert/src/File/booklist.txt";
	
	// ���� �޼ҵ� 
	public static boolean filesave( int type ) {
							
		try {				
			FileOutputStream fileOutputStream = null; //������
			if( type == 1 ) { // ȸ������ 
				// 1. ���ϰ�ü�� ��� ���� 
				fileOutputStream = new FileOutputStream( memberpath );
				// 2. �ݺ����� �̿��� ȸ������Ʈ���� �ϳ��� ȸ�� ��������
				for( Member2 member : Membercontroller.memberlist ) {
					// 3. �� ȸ������ �ʵ�[,]�� ȸ��[/n] ����
					String outstring = member.getId()+","+member.getPassword()+","+
										member.getName()+","+member.getPhone()+","+
										"\n";
					// 4. ����Ʈ�� �������� 
					fileOutputStream.write( outstring.getBytes() );
				}
				// 5. ��Ʈ�� ����� �ʱ�ȭ
				fileOutputStream.flush(); // ���Ͻ�Ʈ���� �����ϴ� ����Ʈ ���� 
				fileOutputStream.close(); // ���Ͻ�Ʈ�� �ݱ�
				
				return true; // ����ó�� ����
			}
			
			else	if( type == 2 ) {
				fileOutputStream = new FileOutputStream(bookpath);
				for(seat seat : Application.seatlist ) {
					String outstring = seat.getS_seat()+","+seat.getNum()+","+seat.getName();
				
				fileOutputStream.write(outstring.getBytes());
				}
				fileOutputStream.flush(); 
				fileOutputStream.close(); 
				
				return true; 
			}
			else {
				System.out.println("���� ����");
			}
			
	
		}catch (Exception e) {
			System.out.println(" [�˸�] : ���� ���� ���� �߻� [ �����ڿ��� ���� ]");
		}
		return false; // ����ó�� ����
	}
	
	
	
	
	
	
	
	
	
	
	// �ҷ����� �޼ҵ�
	public static boolean fileload( int type ) {
		try { // ����ó�� �ϴ����� ?? 
			FileInputStream fileInputStream = null;
			if( type == 1 ) {
				// 1. �Է½�Ʈ�� ��� ���� 
				fileInputStream = new FileInputStream(memberpath);
				// 2. ��Ʈ��(����:����Ʈ) ����Ʈ�迭 ���� 
				byte[] bytes = new byte[10000]; // 10kb ����
				// 3. �Է½�Ʈ������ ����Ʈ �о�ͼ� �迭�� ���� 
				fileInputStream.read( bytes );
				// 4. ����Ʈ�迭 -> ���ڿ� ��ȯ
				String instring = new String(bytes);
				// 5. ȸ�� �и��ϱ� \n
				String[] members = instring.split("\n"); // \n ���н� ����ȸ�� �߰� 
				// 6. �ݺ����� �̿��� ȸ���� �ʵ� �и��ϱ� ,
				for( int i = 0 ; i<members.length-1 ;i++ ) { // -1 : ����ȸ�� ����
					// 7. ȸ���� �ʵ� �и� 	
					String[] field = members[i].split(",");
					// 8. �и��� �ʵ带 ��üȭ [ point�ʵ�� int������ ��ȯ : String -> Int ( Integer.parseInt )  ] 
					Member2 member = new Member2( field[0] , field[1] ,  
									field[2], field[3]);
									
					// 9. �� ��ü�� ����Ʈ�� ����
					Membercontroller.memberlist.add(member);
				}
				fileInputStream.close(); // ��Ʈ�� �ݱ� 
				return true; // ���� �ҷ����� ����
			}
		
			if( type == 2 ) {
				fileInputStream = new FileInputStream(bookpath);
				byte[] bytes = new byte[10000];
				fileInputStream.read(bytes);
				String  instring = new String(bytes);
				String[] book = instring.split("\n");
				for (int i = 0; i <book.length; i++) {
					String[] field = book[i].split(",");
					seat seat2 = new seat(instring, i);
					Application.seatlist.add(seat2);
				}
				fileInputStream.close();
				return true;
			}
			if(type==3) {}
		}
		catch (Exception e) {
			System.out.println(" [�˸�] : ���� �ҷ����� ���� �߻� [ �����ڿ��� ���� ]");
		}
		return false; // ���� ������ ���н�
	}
	

	
}

