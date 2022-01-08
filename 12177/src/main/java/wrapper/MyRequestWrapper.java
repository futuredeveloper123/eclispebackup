package wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequestWrapper extends HttpServletRequestWrapper{
//객체 지향 언어 ,,,, 
HttpServletRequest request;

	public MyRequestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
		//프로그램은 메소드를 불러야 일을 함  이건 주는걸 받아서쓰 는것 이 걸 의존성 주입이라고함 !!!
		//DI : 해준거 받아다 쓰는것 (스프링에서 중요하다고 하는것 !!!!)
		//스프링은 프로젝트만들때 제외하고 면접에서 잘 안 물어봄 
		//IOC제어의 역전 , 의존성주입 di, 관점지향프로그래밍(aop), 시큐리티(인증,인가)
	}
	public String[] getParameterValue(String name) {
		String [] ar = request.getParameterValues(name);
		if(ar == null) {
			return null;
		}
		//동일한 크기의 새로운 배열을 생성 
		String []br = new String[ar.length];
		for(int i=0; i<ar.length; i++) {
			br[i]=ar[i].toUpperCase();
		}
		return br;
	}
}