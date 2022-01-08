package filter ;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import wrapper.MyRequestWrapper;

@WebFilter("*.do")
public class DoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("Controller에게 가기 전에 호출 ");
		
		MyRequestWrapper requestWrapper = new MyRequestWrapper((HttpServletRequest)arg0);
		
		arg2.doFilter(requestWrapper, arg1);
		//기록할 로그 생성 
		
		//현재 날짜 및 시간 
		Date date =new Date();
		//날짜까지 만들기 
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy_MM_dd");
		String filename = sdf.format(date) + ".log";
		//날짜와 시간 만들기 
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(date);
		
		//첫번째 매개변수를 우리가 사용하던 HttpServletRequest로 형 변환 
		HttpServletRequest request = (HttpServletRequest)arg0;
		//접속한 ip찾기 
		String ip = arg0.getRemoteAddr();
		
		//요청 찾아오기 
		String requestURI = request.getRequestURI();
		
		//기록할 파일 스트림을 생성 
		//파일 경로에 파일이 있으면 추가 모드가 되도록 생성 
		FileOutputStream fos = new FileOutputStream(filename, true);
		//true 왜 썻는지 한 번 찾아보기 document가서 
		//문자열을 기록하는 스트림 //문자열 기록할때 어떤 스트림 쓴다고 했는지 생각해보기 
		//BufferedReader br = new BufferedReader(new InputStreamReader());
		PrintWriter pw=new PrintWriter(fos);
		//기록
		pw.write(ip+" ");
		pw.write(time+" ");
		pw.write(requestURI+"\n");
		//pw.print사용해도됌.
		pw.flush();
		
		pw.close();
		fos.close();
		//System.out.println("Controller가 처리한 후 호출 ");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
