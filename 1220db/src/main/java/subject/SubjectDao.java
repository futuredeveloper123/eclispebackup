package subject;

import java.util.ArrayList;
import java.util.List;

import db.DAO;

public class SubjectDao extends DAO{
	//이게 상속의 최대 장점 extends DAO,,,,
	//싱글톤(인스턴스를 하나만 만들 수 있도록 클래스를 디자인하는것)을 위한 코드
	//서버에서 작업을 수행하는 클래스나 공유 데이터를 소유하는 클래스 
	//또는 Entry Point가 되는 클래스를 싱글톤으로 디자인 합ㄴ디ㅏ .
	//entry point 는 출입구 ,, 대문은 하나니까 
	//애플은 생태계가 좋다고 많이함 
	
	private SubjectDao() {
		connect();
		
		//여기서 한번만 연결해주면 끝 
		//이렇게 준비가 다 되어있어야함 ,,,,
		//유일하게 new 안하는애 (new DAO했는데 ) 컨트롤러  -> 컴포런트 제어의 역전 Iot
		//인스턴스 만들어 쓰는게 일반적 프로그래밍 방식 //클래스를 사람이 만들고 클래스인스턴스를 다른 프로그램이 만듦
		//그래서 제어가 역으로 흘렀다 inversionof controll ( Ioc)꼭 외워야함 
		//이렇게 만들어진 인스턴스를 컴퓨런트라고함   ! 그래서 제어의 역전을 젤 먼저 얘기함 
	}
	
	private static SubjectDao dao;
	
	public static SubjectDao getInstance() {
		
		if ( dao == null) {
			dao = new SubjectDao();
			
		}
		return dao;
	}
	//subject 테이블의 모든 데이터를 가져오는 메서드  
	//public 리턴타입 메서드 이름(매개변수 ) 이런식으로 작성 
	public List<Subject> getList (){
		List<Subject> list = new ArrayList<> () ;
		
		try {
			//sql 생성 
			pstmt = con.prepareStatement("select * from subject order by code desc");
			//sql 실행 
			rs=pstmt.executeQuery();
			
			//읽어서  list에 저장 
			while(rs.next()) {
				Subject subject= new Subject();
				//데이터를 읽어서 설정 
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
			System.out.println("fail");
			System.out.println(e.getLocalizedMessage());
		}
		
		return list;
		
		
	}
	
	//상세보기를 위한 메서드 
	//public 리턴타입 메서드이름 (매개변수 ) {
	public Subject getSubject(int code) {
		Subject subject = null;
		try {
			//sql생성 
			pstmt=con.prepareStatement("select * from subject where code =?");
			//?에 실제 값을 바인딩 
			pstmt.setInt(1, code);
			//sql  실행 
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
			System.out.println("fail");
			System.out.println(e.getLocalizedMessage());
		}
		return subject ; 
		
	
	}
	//가장 큰코드를 찾아오는 메서드 
	public int maxCode() {
		int code = 0;
		try {
			//sql 생성 
			pstmt=con.prepareStatement("select max(code) maxcode from subject");
			
			//sql 실행 
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				code = rs.getInt("maxcode");
			}
			rs.close();
			pstmt.close();
			
		}catch(Exception e) {
			System.out.println("fail");
			System.out.println(e.getLocalizedMessage());
		}
		return code;
	}

	
	//데이터를 삽입하는 메서드 
	public int insertSubject(Subject subject) {
	
	int result = 0;
	try {
		//sql 생성 
		pstmt=con.prepareStatement("insert into subject value(?,?,?,?)");
		pstmt.setInt(1, subject.getCode());
		pstmt.setString(2, subject.getTitle());
		pstmt.setString(3, subject.getCategory());
		pstmt.setString(4, subject.getDescription());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		
	}catch(Exception e) {
		System.out.println("fail");
		System.out.println(e.getLocalizedMessage());
	}
	return result;
	
	}
	//기본키를 가지고 데이터를 삭제하는 메서드 
	public int deleteSubject(int code) {
	int result = 0;
	try {
		
		//삭제는 2아래 두줄만 바꾸면 됨 ...
		pstmt=con.prepareStatement("delete from subject where code=?");
		pstmt.setInt(1, code);
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		
	}catch(Exception e) {
		System.out.println("fail");
		System.out.println(e.getLocalizedMessage());
	}
	return result;
		
	}
	//데이터 수정을 위한 메소드 
	public int updateSubject(Subject subject) {
		int result = -1;
		//구조는 항상 비슷비슷하니까 복붙해서 써도 됨 
		try {
			pstmt=con.prepareStatement("update subject set title=?,category=?, description=? where code=?");
			pstmt.setString(1,subject.getTitle());
			pstmt.setString(2, subject.getCategory());
			pstmt.setString(3, subject.getDescription());
			pstmt.setInt(4, subject.getCode());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		}catch(Exception e) {
			System.out.println("fail");
			System.out.println(e.getLocalizedMessage());
		}
		return result;
}
	//데이터 개수를 리턴하는 메서드 
	public int getCount() {
		int cnt =0;
		try {
			//sql 생성 -subject테이블의 데이터 개수 가져오기 
			pstmt = con.prepareStatement("select count(*) cnt from subject");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}
			rs.close();
			pstmt.close();	
		}catch(Exception e) {
			System.out.println("fail");
			System.out.println(e.getLocalizedMessage());
		}
		return cnt;
	}
	//페이지 번호를 받아서 페이지 번호에 해당하는 데이터 5개를 찾아오는 매서드 
	public List<Subject> getList (int pageno)//페이지번호(매개변수) 받기 
		{
		List<Subject> list = new ArrayList<> () ;
		
		
		try {
			//sql 생성 
			pstmt = con.prepareStatement("select * from subject order by code desc limit ?,5");
			//1페이지는 ? 가 0, 2 페이지는 ? 가 5
			pstmt.setInt(1, (pageno-1)*5 );
			
			
			//sql 실행 
			rs=pstmt.executeQuery();
			
			//읽어서  list에 저장 
			while(rs.next()) {
				Subject subject= new Subject();
				//데이터를 읽어서 설정 
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
			System.out.println("fail");
			System.out.println(e.getLocalizedMessage());
		}
		
		return list;
	
	
	
}
}