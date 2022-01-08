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
    	String uri = requestURI.substring(contextPath.length() + 1);
    	
    	switch(uri) {
    		case "subject/list":
    			//필요한 서비스의 메서드를 호출
    			service.getList(request, response);
    			//결과 페이지로 이동
    			RequestDispatcher dispatcher = 
    					request.getRequestDispatcher(
    							"../view/list.jsp");
    			dispatcher.forward(request, response);
    			break;
    		case "subject/detail":
    			//필요한 서비스의 메서드를 호출
    			service.getSubject(request, response);
    			//결과 페이지로 이동
    			RequestDispatcher dispatcher1 = 
    					request.getRequestDispatcher(
    							"../view/detail.jsp");
    			dispatcher1.forward(request, response);
    			break;
    		case "subject/insert":
    			if(request.getMethod().equals("GET")) {
    				//데이터 입력 페이지로 이동
    				RequestDispatcher dispatcher2 = 
    					request.getRequestDispatcher(
    							"../view/insert.jsp");
    				dispatcher2.forward(request, response);
    			}
    			break;
    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
