package listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
	//접속 중인 세션의 개수를 저장하기 위한 변수
	private static int count;
	
	//count를 리턴하는 메서드 - getter
	public static int getCount() {
		return count;
	}
	
	//세션이 생성될 때 호출되는 메서드
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		//세션의 수명을 설정
		HttpSession session = event.getSession();
		session.setMaxInactiveInterval(60 * 5);
		
		count = count + 1;
		System.out.println("현재 접속자 수:" + count);
	}
	//세션이 소멸될 때 호출되는 메서드
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		count = count - 1;
		System.out.println("현재 접속자 수:" + count);
	}
}
