package sample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "*.do" })
public class DoController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
	//Controller 는 Service를 주입받아야 합니다 .
	private DoService service;
	
    public DoController() {
        super();  
        service = DoServiceImpl.getInstance();
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//분기문 작성  //클라이언트의 요청 URL
		String requestURI = request.getRequestURI();
		//System.out.println(requestURI);
		String contextPath = request.getContextPath();
		//System.out.println(contextPath);
		//위의 두개를 이용해서 requestURI에서 공통된 부분을 제거하기 
		String uri = requestURI.substring(contextPath.length()+1);
		//System.out.println(uri);
		switch(uri) {
		case"insert.do" : 
			//get방식으로요청한 경우는 페이지 이동 
			if(request.getMethod().equals("GET")) {
			//단순페이지 이동은 포워딩 
			//insert.do가 왔을 때 단순 페이지 이동은 forwarding포워딩입니다 
			RequestDispatcher dispacher= request.getRequestDispatcher("do/insert.jsp");
			dispacher.forward(request, response);
			}else {//get방식이 아니면 post //일을 할대는 적절한 서비스 메서드 호출 
				service.doInsert(request, response);
				//끝나고 나면 메인 페이지로 리다이렉트 
				//데이터에 변화를 주는 일을 했다하면 리다이렉트! 아니면 포워딩 
				//일을했을 때는 post로 처리하는 경우가 많음 ,, 데이터 삽입이라하는 데이터 변화주는 일을하면 리다이렉트 
				response.sendRedirect("./"); //메인으로 갈때는 그냥 /(슬래쉬)
				
			}
			break;
		case "logout.do" : 
			service.logout(request, response);
			//끝나고 나면 메인 페이지로 리다이렉트 
			RequestDispatcher dispacher = request.getRequestDispatcher("index.jsp");
			dispacher.forward(request, response);
			
			break;
		}
			
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
