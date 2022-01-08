package subject;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubjectServiceImpl implements SubjectService{
	//Service 는 DAO를 주입받아서 사용합니다.
	private SubjectDao dao;
	
	private SubjectServiceImpl() {
		dao = SubjectDao.getInstance();
	}
	
	private static SubjectService service;
	
	public static SubjectService getInstance() {
		if(service == null) {
			service = new SubjectServiceImpl();
		}
		return service;
	}

	@Override
	public void getList(HttpServletRequest request, 
			HttpServletResponse response) {
		//파라미터를 읽기
		
		//처리
		
		//DAO 의 메서드를 호출
		List<Subject> list = dao.getList();
		
		//처리
		
		//결과를 저장
		//어떻게 이동할 것인지 결정 - 포워딩
		request.setAttribute("list", list);
		
	}

	@Override
	public void getSubject(HttpServletRequest request, HttpServletResponse response) {
		//파라미터를 읽기
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {
			System.out.println("파라미터 인코딩 실패");
			System.out.println(e.getLocalizedMessage());
		}
		String code = request.getParameter("code");
		
		//처리
		
		//DAO 의 메서드를 호출
		Subject subject = dao.getSubject(
				Integer.parseInt(code));
		
		//처리
		
		//결과를 저장
		//어떻게 이동할 것인지 결정 - 포워딩
		request.setAttribute("subject", subject);	
	}

	@Override
	public void insertSubject(HttpServletRequest request, HttpServletResponse response) {
		//파라미터를 읽기
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {}
		
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		//처리
		//코드 만들기
		int code = dao.maxCode() + 1;
		
		//삽입을 위한 데이터를 만들기
		Subject subject = new Subject();
		subject.setCode(code);
		subject.setTitle(title);
		subject.setCategory(category);
		subject.setDescription(description);
		
		//DAO 의 메서드를 호출
		int result = dao.insertSubject(subject);
		
		//처리
		
		//결과를 저장 - 데이터 삽입이어서 리다이렉트 하므로 세션에 저장
		//어떻게 이동할 것인지 결정
		request.getSession().setAttribute("result", result);
		
	}
}
