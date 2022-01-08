<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
	<%
		//입력받은 파라미터 가져오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//로그인 성공한 경우
		if(id.equals("root") && pw.equals("1234")){
			//세션에 저장
			session.setAttribute("id", id);
			session.setAttribute("name", "관리자");
			
			response.sendRedirect("login.jsp");
		}else{
			//세션에서 제거
			session.removeAttribute("id");
			session.removeAttribute("name");
			
			response.sendRedirect("login.jsp");
		}
	
	%>
</body>
</html>