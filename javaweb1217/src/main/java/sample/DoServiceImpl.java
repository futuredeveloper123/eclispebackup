package sample;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoServiceImpl implements DoService {
	//Service 는 DAO를 주입받아야 합니다.
	private DoDAO dao;
	
	//싱글톤을 위한 코드
	private DoServiceImpl() {
		dao = DoDAO.getInstance();
	}
	
	private static DoService doService;
	
	public static DoService getInstance() {
		if(doService == null) {
			doService = new DoServiceImpl();
		}
		return doService;
	}

	@Override
	public void doInsert(HttpServletRequest request, HttpServletResponse response) {
		//파라미터를 읽기
		try {
			//파라미터 인코딩 설정
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String name = request.getParameter("name");
		
		//업무 처리
		
		//DAO를 사용해야 하는 경우 DAO 의 매개변수를 생성
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		
		//DAO의 메서드 호출
		int result = dao.doInsert(map);
		
		//결과를 저장
		request.setAttribute("result", result);
	}
}
