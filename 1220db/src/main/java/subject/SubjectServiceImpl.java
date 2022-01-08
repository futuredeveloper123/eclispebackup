package subject;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class SubjectServiceImpl implements SubjectService {
	//*******Service는 DAO를 주입받아서 사용합니다 !!!!******
	private SubjectDao dao;
	
	private SubjectServiceImpl() {
		dao = SubjectDao.getInstance();
		}
	private static SubjectService service;	
	
	static SubjectService getInstance() {
		if ( service == null) {
			service = new SubjectServiceImpl();			
	}	
		return service;
	}/*
	@Override
	public void getList(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터 읽기
		
		//처리
		
		//DAO메서드 호출(지금처럼 파라미터 없을 때는 바로 부름 )

		//처리  		
		List<Subject> list = dao.getList();
		
		
		//결과저장 (어떻게 이동할 것인지 결정 - 포워딩 )
		request.setAttribute("list", list);	
	}*/
	@Override
	public void getList(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터 읽기
		String no =request.getParameter("pageno");
		//페이지 번호를 결정하기 
		//기본 페이지 번호는 1
		int pageno=1;
		//페이지 번호오면 수정 
		if(no !=null && !no.equals("")) {
			pageno=Integer.parseInt(no);
		}
		//list.jsp파일에 출력할 페이지 번호들의 시작 번호와 종료번호를 
		//현재 1페이지 - 1-10
		//현재 5페이지 1-10
		//현재 11페이지 11-20
		//데이터개수를 이용해서 구한 전체 페이지 개수가 마지막 번호보다 작으면 
		//마지막 번호를 전체 페이지 개수로 수정 
		
		//전체 데이터 개수를 가져오기 
		int totalCnt = dao.getCount();
		//전체 페이지 개수 -5는 한 페이지에 보여질 데이터 개수 
		//실제로는 더 큰 숫자를 사용하지만 편의상 5로 설정 
		
		//종료페이지 번호 계산 
		int endpage = (int)(Math.ceil(totalCnt/(double)5));
		//여기가 10 일 될때 까지는 그냥 계속 마지막은 10
		
		//출력할 데이터 가져오기 
		//DAO의 메서드를 호출 
		List<Subject> list = dao.getList(pageno);
		//시작 페이지 번호 계산 
		//int startpage = endpage -9;
		
		//위의 데이터를 json데이터 배열로 변환 
		JSONArray ar = new JSONArray();
		for(Subject subject : list) {
			JSONObject obj = new JSONObject();
			obj.put("code", subject.getCode());
			obj.put("title", subject.getTitle());
			obj.put("category", subject.getCategory());
			obj.put("description", subject.getDescription());
			
			ar.put(obj);
			
		}
		//하나의 제이슨 객체로 데이터 배열 , 현재페이지번호 
		//전체 페이지 개수를 저장 
		JSONObject obj = new JSONObject();
		//출력할 데이터 
		obj.put("list", list);
		//현재까지 출력한 페이지 번호 
		obj.put("pageno", pageno);
		//전체 페이지 개수 
		obj.put("endpage", endpage);
		
		//결과 페이지에 전송하기 위해서 저장 
		request.setAttribute("result", obj);
	
		/*
		//데이터 개수를 가지고 나올 수 있는 페이지 개수를 계산 
		//1개이면 1페이지, 5개면 1페이지 , 6개면 2페이지 
		//120개이면 24페이지 
		int pagecnt = (int)(Math.ceil(totalCnt/(double)5));
		
		//마지막 페이지 번호가 전체 페이지 마지막 번호보다 크면 
		if(endpage > pagecnt ) {
			endpage = pagecnt;
		}
		//이전과 다음 페이지 존재 여부 
		boolean prev = startpage ==1 ? false : true;
		boolean next = endpage >= pagecnt ? false:true;
		
		
		//DAO메서드 호출(지금처럼 파라미터 없을 때는 바로 부름 )
		List<Subject> list = dao.getList(pageno);
		
		//처리 
		
		//저장할것이 걸라 많음 
		//결과저장 (어떻게 이동할 것인지 결정 - 포워딩 )
		request.setAttribute("list", list);	
		request.setAttribute("prev", prev);	
		request.setAttribute("next", next);	
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);*/
		
	}
	
	@Override
	public void getSubject(HttpServletRequest request, HttpServletResponse response) {
		/*
		 // 파라미터 읽기 
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {
			System.out.println("fail");
			System.out.println(e.getLocalizedMessage());	
		}
		//String code = request.getParameter("code");
				*/
		//다----------------------
		//전체 URI가져오기 
		String requestURI = request.getRequestURI();
		//javaweb1220/subject/detail/31 에서 31만 추출하기 
		//부분적으로 추출하는걸 뭘 이용했는지 떠올려 보기 
		//두가지 방법이 있음 하나는 split 하나는 indexof
		
		// "/"로 분할해서 가장 마지막 요소 가져오기 
		String []ar = requestURI.split("/");
		String code = ar[ar.length -1];
		
		
		// "/"의 가장 마지막 위치를 찾아서 그 뒤부터 잘라내기 
		//int idx = requestURI.lastIndexOf("/");
		//code = requestURI.substring(idx+1);
		
		
		//처리
		
		//DAO의 메서드를 호출 
		Subject subject = dao.getSubject(
				Integer.parseInt(code));
				
		request.setAttribute("subject", subject);		
	}
	@Override
	public void insertSubject(HttpServletRequest request, HttpServletResponse response) {
	// 파라미터 읽기
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {}
		
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		
		//처리
		//코드만들기 
		int code = dao.maxCode() +1;
		
		//삽입을 위한 데이터를 만들기 
		Subject subject = new Subject();
		subject.setCode(code);
		subject.setTitle(title);
		subject.setCategory(category);
		subject.setDescription(description);
				
		//DAO메서드 호출(지금처럼 파라미터 없을 때는 바로 부름 )
		int result =  dao.insertSubject(subject);
		
		//처리  		
			
		//결과저장 (어떻게 이동할 것인지 결정 - 포워딩 )
		request.getSession().setAttribute("result", result);
		//데이터 삽입라 리다이렉션 해야해서 세션에 저장 
	}
	
	@Override
	public void deleteSubject(HttpServletRequest request, HttpServletResponse response) {
				
		//전체 URI가져오기 
		String requestURI = request.getRequestURI();
		
		//"/"로 분할해서 가장 마지막 요소 가져오기 
		String []ar = requestURI.split("/");
		String code = ar[ar.length -1];
		
		//DAO의 메서드를 호출 
		int result = dao.deleteSubject(Integer.parseInt(code));
		
		//결과저장 (어떻게 이동할 것인지 결정 - 포워딩)
		request.getSession().setAttribute("result", result);
		//데이터 삽입라 리다이렉션 해야해서 세션에 저장 
	}
	@Override
	public void updateSubject(HttpServletRequest request, HttpServletResponse response) {
		//순서는 항상 insert랑 비슷 !!!! 먼저 파라미터 읽기 
		// 파라미터 읽기
				try {
					request.setCharacterEncoding("utf-8");
				}catch(Exception e) {
					System.out.println("fail encoding");
				}
				
				String code = request.getParameter("code");
				String title = request.getParameter("title");
				String category = request.getParameter("category");
				String description = request.getParameter("description");
				
				//처리
				//코드만들기 
				//Dao 메서드의 매개변수로 생성 
				Subject subject = new Subject();
				subject.setCode(Integer.parseInt(code));
				subject.setTitle(title);
				subject.setCategory(category);
				subject.setDescription(description);
				
						
				//DAO메서드 호출(지금처럼 파라미터 없을 때는 바로 부름 )
				int result =  dao.updateSubject(subject);
				
				//처리  		
					
				//결과저장 (어떻게 이동할 것인지 결정 - 포워딩 )
				request.getSession().setAttribute("result", result);
				//작업끝나면  리다이렉션 해야해서 세션에 저장 (???) 
		
	}
	
		
	}


