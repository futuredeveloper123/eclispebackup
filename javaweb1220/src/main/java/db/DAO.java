package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	//데이터베이스 접속을 위한 인스턴스를 저장할 변수
	protected Connection con;
	//SQL을 실행하기 위한 인스턴스를 저장할 변수
	protected PreparedStatement pstmt;
	//Select 구문의 결과를 저장하기 위한 인스턴스를 저장할 변수
	protected ResultSet rs;
	
	protected void connect() {
		try {
			//드라이버 클래스 로드 - 맨 처음 한번만 수행
			Class.forName("com.mysql.cj.jdbc.Driver");
			//데이터베이스 연결 - 접속해제를 한 경우 접속을 할 때 마다 호출
			con= DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/user00?"
				+ "useUnicode=true&characterEncoding=utf8&"
				+ "serverTimezone=UTC", 
				"user00", "user00");
			
			System.out.println("데이터베이스 접속 성공");
		}catch(Exception e) {
			System.out.println("데이터베이스 접속 실패");
			System.out.println("예외 내용:" + 
					e.getLocalizedMessage());
		}
	}
	
	//데이터베이스를 닫는 메서드
	protected void close() {
		try {
			if(con != null) {
				con.close();
			}
		}catch(Exception e) {
			System.out.println("데이터베이스 접속 해제 실패");
			System.out.println("예외 내용:" + 
					e.getLocalizedMessage());
		}
	}
}
