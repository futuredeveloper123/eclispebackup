package wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequestWrapper extends HttpServletRequestWrapper{
	HttpServletRequest request;
	
	public MyRequestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	public String getParameter(String name) {
		String str = request.getParameter(name);
		if(str == null) {
			return null;
		}
		return str.toUpperCase();
	}
	
	public String [] getParameterValue(String name) {
		String [] ar = request.getParameterValues(name);
		if(ar == null) {
			return null;
		}
		
		//동일한 크기의 새로운 배열을 생성
		String [] br = new String[ar.length];
		//ar 의 내용을 전부 대문자로 변환해서 복제한 배열에 대입
		for(int i=0; i<ar.length; i=i+1) {
			br[i] = ar[i].toUpperCase();
		}
		
		return br;
	}

}



