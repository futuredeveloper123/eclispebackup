package sample;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public void doInsert(HttpServletRequest request, 
			HttpServletResponse response) {
		//파라미터를 읽기
		try {
			//파라미터 인코딩 설정
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String name = request.getParameter("name");
		System.out.println(name);
		//업무 처리
		
		//DAO를 사용해야 하는 경우 DAO 의 매개변수를 생성
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		
		//DAO의 메서드 호출
		int result = dao.doInsert(map);
		
		//결과를 저장
		request.setAttribute("result", result);
	}

	@Override
	public void logout(HttpServletRequest request, 
			HttpServletResponse response) {
		//로그아웃은 Session을 초기화 하는 작업을 수행해주면 됩니다.
		//세션 가져오기
		HttpSession session = request.getSession();
		//세션 초기화
		session.invalidate();
		
	}
}
