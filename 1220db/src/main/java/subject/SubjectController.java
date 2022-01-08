package subject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subject/*")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private SubjectService service;
	
    public SubjectController() {
        super();
       
        service = SubjectServiceImpl.getInstance();   
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String uri = requestURI.substring(contextPath.length()+1);
		
		RequestDispatcher dispatcher = null;
		//스위치를 if로 바꾸는중 
		//if는 부분일치 처리가능 switch는 전체일치 처리
		//완전일치 찾을때는 스위치
		if(uri.equals("subject/list")) {
			service.getList(request,response);
			dispatcher = request.getRequestDispatcher("../view/list.jsp");
			dispatcher.forward(request, response);		
			
		}else if(uri.indexOf("subject/detail")>=0) {
			service.getSubject(request,response);
			dispatcher = request.getRequestDispatcher("../../view/detail.jsp");
			dispatcher.forward(request, response);
			
		}else if(uri.equals("subject/insert")) {
			if(request.getMethod().equals("GET")) {
				dispatcher = request.getRequestDispatcher("../view/insert.jsp");
				dispatcher.forward(request, response);
				
			}else if(request.getMethod().equals("POST")) {
				service.insertSubject(request, response);
				response.sendRedirect("list");
			}
		}else if(uri.indexOf("subject/delete")>=0){
				service.deleteSubject(request, response);
				//목록보기로 이동 "../"써주기!! 
				response.sendRedirect("../list");
				
		}else if(uri.indexOf("subject/update")>=0) {
			//수정을 get방식으로 요청하면 데이터를 수정할 수 있도록 출력 
			if(request.getMethod().equals("GET")) {
				//수정을 할대는 먼저 1개의 데이터 찾아오기 
				service.getSubject(request, response);
				//수정 페 이지로 포워딩 
				dispatcher = request.getRequestDispatcher("../../view/update.jsp");
				dispatcher.forward(request, response);	
			}	
			
			//수정을 post방식으로 요청하면 실제 데이터 수정 
			else if(request.getMethod().equals("POST")) {
				service.updateSubject(request, response);
				response.sendRedirect("../list");
				
				//리스트로 갈꺼니까 뭐라고 하면 좋겠는지 생각해보기  
			}
	}
		//json출력을 위한 처리 
		else if(uri.equals("subject/getlist")){
			service.getList(request, response);
			//json 출력 페이지로 포워딩 
			dispatcher = request.getRequestDispatcher("../view/jsonlist.jsp");
			dispatcher.forward(request, response);
		}
		/*
		switch(uri) {
			case "subject/list" :
				//필요한 서비스의 메서드를 호출
				service.getList(request,response);
				//결과 페이지로 이동 
				RequestDispatcher dispatcher = request.getRequestDispatcher("../view/list.jsp");
				dispatcher.forward(request, response);
				break;
			case "subject/detail" :
				//필요한 서비스의 메서드를 호출
				service.getSubject(request,response);
				//결과 페이지로 이동 
				RequestDispatcher dispatcher1 = request.getRequestDispatcher("../view/detail.jsp");
				dispatcher1.forward(request, response);
				break;
			case "subject/insert" :
				//필요한 서비스의 메서드를 호출
				if(request.getMethod().equals("GET")){			
				//결과 페이지로 이동 
				RequestDispatcher dispatcher2 = request.getRequestDispatcher("../view/insert.jsp");
				dispatcher2.forward(request, response);
				}else if(request.getMethod().equals("POST")) {
					//서비스 메서드 호출 
					service.insertSubject(request, response);
					//데이터에 변화를 주는 작업을 수행한 후 결과 페이지로 이동할 때는 
					//리다이렉트를 합니다  
					//리다이렉트를 할 때는 특정 페이지로 이동하는 것이 아니고 
					//페이지를 출력하는 요청으로 리다이렉트 합니다 .
					response.sendRedirect("list");
				}
				break;
	}*/
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
