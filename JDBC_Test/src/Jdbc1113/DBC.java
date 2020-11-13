package Jdbc1113;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
	public DBC() {}
	
	public static Connection DBconnect() {
		Connection con = null;
		// DB에 접속정보 저장을 위한
		// Connection 타입의 변수 con 선언
		
		
		// 접속할 DB의 주소정보
		String url = "jdbc:oracle:thin:@192.168.0.220:1521:XE";
		
//		 접속할 유저의 계정정보
		String user = "HEEDONG";
		String password = "1234";
		
		//Database Driver 설정
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,user,password);
			System.out.println("DB 접속 성공!");
		}catch(ClassNotFoundException cne){ //드라이버가 제대로 작동하지 않을 경우
			cne.printStackTrace(); // => 오류가 발생했을 경우 경로를 알려준다.
			System.out.println("DB접속실패 : 드라이버");
		}catch(SQLException se){ // DB 계정 정보가 틀릴경우
			se.printStackTrace();
			System.out.println("DB접속실패 : DB계정");
		}
		
		
		return con;
			
	}
}






















