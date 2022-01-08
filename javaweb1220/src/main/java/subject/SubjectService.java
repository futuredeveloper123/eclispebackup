package subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SubjectService {
	//전체 데이터 가져오기
	public void getList(
		HttpServletRequest request, 
		HttpServletResponse response);
	//상세보기
	public void getSubject(
		HttpServletRequest request, 
		HttpServletResponse response);
	//데이터 삽입
	public void insertSubject(
		HttpServletRequest request, 
		HttpServletResponse response);
}
