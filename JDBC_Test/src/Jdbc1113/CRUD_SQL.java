package Jdbc1113;
//DAO

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD_SQL {
	// DB접속을 위한 변수 con 선언
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null ;
	public CRUD_SQL() {
		
	}
	
	//1. DB접속
	public void connect() {
		// TODO Auto-generated method stub
		con = DBC.DBconnect();
		//DB에 있는 DBconnect()를 가져온다.
	}

	//2. DB접속 해제
	public void conClose() {
		// TODO Auto-generated method stub
		try {
			con.close();
			System.out.println("DB접속 해제!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 학생 등록
	public void stuJoin(CRUD_DTO stu) {
		String sql = "INSERT INTO STUDENTS(ST_NAME,ST_AGE) VALUES(?,?)";
		try {
			pstmt = con.prepareCall(sql);
			
			pstmt.setString(1, stu.getStuName());
			pstmt.setInt(2, stu.getStuAge());
			
			pstmt.executeUpdate();
			
			
			System.out.println("학생등록이 성공되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("학생등록 실패하였습니다.");
		}	

	}
	// 4. 학생조회
	public void select(CRUD_DTO stu) {
		String sql;
		if (stu.getStuName()!=null) {
			sql = "SELECT ST_NAME AS NAME, ST_AGE AS AGE FROM STUDENTS WHERE ST_NAME= ?";
		} else {sql ="SELECT ST_NAME AS NAME, ST_AGE AS AGE FROM STUDENTS";}
		try {		pstmt = con.prepareCall(sql);
			if (stu.getStuName()!=null) {
					pstmt.setNString(1,stu.getStuName());
					rs = pstmt.executeQuery();
					rs.next();

					System.out.println("\n"+"이름 : "+ rs.getString("NAME"));
					System.out.print("나이 : "+ rs.getInt("AGE") + "\n");
					stu.setStuName(null);
			}else {int i = 1;	int j = 1;
				rs = pstmt.executeQuery();
				while(rs.next()) { //rs에 담긴 데이터 수만큼 반복
					if (j==1) {System.out.println();}
					System.out.println("--------------");
					System.out.print(i+". 이름 : "+ rs.getString("NAME")+"\n");
					System.out.print("   나이 : "+ rs.getInt("AGE") + "\n");
					i++;
					j++;
				}
			}
		
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	


	public void stmod(String name, CRUD_DTO stu) {
		String sql;
		//  전부 바꿀때
		if(stu.getStuAge()+""!=null && stu.getStuName()!=null) {
			sql = "UPDATE STUDENTS SET ST_AGE = ?,ST_NAME = ? WHERE ST_NAME=? ";}
		//  이름만 바꿀때
		else if (stu.getStuName()!=null) {
			sql = "UPDATE STUDENTS SET ST_NAME = ? WHERE ST_NAME=? ";}
		//  나이만 바꿀때
		else {sql = "UPDATE STUDENTS SET ST_AGE = ? WHERE ST_NAME=? ";}
		
		try {  pstmt = con.prepareCall(sql);
													//  전부 바꿀때
			if(stu.getStuAge()+""!=null && stu.getStuName()!=null) {
				pstmt.setInt(1, stu.getStuAge());
				pstmt.setString(2,stu.getStuName());
				pstmt.setString(3, name);
				stu.setStuName(null);}
			else if (stu.getStuName()!=null) {		//  이름만 바꿀때
				pstmt.setString(1, stu.getStuName());
				pstmt.setString(2,name);
				stu.setStuName(null);}
			else {pstmt.setInt(1, stu.getStuAge()); //  나이만 바꿀때
				  pstmt.setString(2,name);}					
			
		pstmt.executeUpdate();
	}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void stdel(CRUD_DTO stu) {
		String sql = "DELETE FROM STUDENTS WHERE ST_NAME=? ";
		
		try {
			pstmt = con.prepareCall(sql);
			
			pstmt.setString(1,stu.getStuName());
			
			pstmt.executeUpdate();
			
			System.out.println("학생 정보가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}











