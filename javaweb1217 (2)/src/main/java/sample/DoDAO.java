package sample;

import java.util.Map;

public class DoDAO {
	//싱글톤을 위한 코드
	private DoDAO() {}
	
	private static DoDAO doDAO;
	
	public static DoDAO getInstance() {
		if(doDAO == null) {
			doDAO = new DoDAO();
		}
		return doDAO;
	}
	
	//데이터를 삽입하는 메서드
	public int doInsert(Map<String, Object> map) {
		//데이터를 삽입하는 작업
		
		return 1;
	}
	
	
}
