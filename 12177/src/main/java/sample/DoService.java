package sample;

import java.net.http.HttpRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DoService {
	//리퀘스트 request : 클라이언트에게 요청을 화기 위한 객체
	//리스폰스 response : 클라이언트에게 응답을 하기 위한 객체 
	
	//웹에서는 모든 요청 처리 메서드의 원형을 아래처럼 만들어도 됩니다. 
	
	//어자피 여기서는 데이터를 전달해줘야하기 때문에 이런식으로 많이함 
	public void doInsert(HttpServletRequest request , HttpServletResponse response);
	public void logout(HttpServletRequest request , HttpServletResponse response);

}
