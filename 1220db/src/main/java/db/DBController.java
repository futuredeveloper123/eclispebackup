package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/connect")
public class DBController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DBController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		//("/connect") 이부분만 끄집어 오는거 
		//전체 요청 경로에서 공통된 부분을 제외하고 가져오기 
		
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String uri=requestURI.substring(
				contextPath.length()+1);
		
		//uri에 따른분기문 작성 
		switch(uri) {
		case"connect" :
			DAO dao = new DAO();
			dao.connect();
			dao.close();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
