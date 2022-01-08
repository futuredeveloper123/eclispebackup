package subject;

import java.util.ArrayList;
import java.util.List;

import db.DAO;

public class SubjectDao extends DAO{
	//싱글톤(인스턴스를 하나만 만들 수 있도록 클래스를 디자인 하는 것)
	//서버에서 작업을 수행하는 클래스 나 공유 데이터를 소유하는 클래스
	// 또는 Entry Point 가 되는 클래스를 싱글톤으로 디자인 합니다.
	private SubjectDao() {
		connect();
	}
	
	private static SubjectDao dao;
	
	public static SubjectDao getInstance() {
		if(dao == null) {
			dao = new SubjectDao();
		}
		return dao;
	}
	//subject 테이블의 모든 데이터를 가져오는 메서드
	public List<Subject> getList() {
		List<Subject> list = new ArrayList<>();
		
		try {
			//SQL 생성
			pstmt = con.prepareStatement(
				"select * from subject order by code desc");
			//SQL 실행
			rs = pstmt.executeQuery();
			
			//읽어서 list에 저장
			while(rs.next()) {
				//하나의 DTO 인스턴스를 생성
				Subject subject = new Subject();
				//데이터 읽어서 설정
				subject.setCode(rs.getInt("code"));
				subject.setCategory(rs.getString("category"));
				subject.setTitle(rs.getString("title"));
				subject.setDescription(rs.getString("description"));
				//list에 저장
				list.add(subject);
			}
			
			rs.close();
			pstmt.close();
			
		}catch(Exception e) {
			System.out.println("전체 데이터 가져오기 실패");
			System.out.println(e.getLocalizedMessage());
		}
		
		return list;
	}
	
	//상세보기를 위한 메서드
	public Subject getSubject(int code) {
		Subject subject = null;
		try {
			//SQL 생성
			pstmt = con.prepareStatement(
				"select * from subject where code = ?");
			//?에 실제 값을 바인딩
			pstmt.setInt(1, code);
			
			//SQL 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				subject = new Subject();
				//데이터 읽어서 설정
				subject.setCode(rs.getInt("code"));
				subject.setCategory(rs.getString("category"));
				subject.setTitle(rs.getString("title"));
				subject.setDescription(rs.getString("description"));
			}
			rs.close();
			pstmt.close();
			
			
		}catch(Exception e) {
			System.out.println("데이터 1개 가져오기 실패");
			System.out.println(e.getLocalizedMessage());
		}
		
		return subject;
	}
	
	//가장 큰 코드를 찾아오는 메서드
	public int maxCode() {
		int code = 0;
		try {
			//SQL 생성
			pstmt = con.prepareStatement(
				"select max(code) maxcode from subject");
			
			//SQL 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				code = rs.getInt("maxcode");
			}
			rs.close();
			pstmt.close();
			
			
		}catch(Exception e) {
			System.out.println("가장 큰 코드 가져오기 실패");
			System.out.println(e.getLocalizedMessage());
		}
		return code;
	}
	
	
	//데이터를 삽입하는 메서드
	public int insertSubject(Subject subject) {
		int result = 0;
		try {
			//SQL 생성
			pstmt = con.prepareStatement(
				"insert into subject values(?,?,?,?)");
			pstmt.setInt(1, subject.getCode());
			pstmt.setString(2, subject.getTitle());
			pstmt.setString(3, subject.getCategory());
			pstmt.setString(4, subject.getDescription());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
			
		}catch(Exception e) {
			System.out.println("데이터 삽입 실패");
			System.out.println(e.getLocalizedMessage());
		}
		return result;
	}
}










