<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<%
		//로그인 안 된 상태
		if(session.getAttribute("id") == null){
			out.println("<form action='loginprocess.jsp'>");
			out.println("<form action='loginprocess.jsp'>");
			out.println("아이디: <input type='text' name='id' required='required' id='id'/><br />");
			out.println("비밀번호: <input type='password' name='pw' required='required' id='pw' /><br/>");
			out.println("<input type='submit' value='로그인' />");
			out.println("</form>");
		}
		//로그인 된 상태
		else{
			//세션의 name에 저장한 내용을 가져와서 문자열로 변환
			String name = (String)session.getAttribute("name");
			out.println(name + "님 환영합니다.");
			out.println("<br/> <a href='logout.jsp'>로그아웃</a>");
		}
	%>

	
		
		

	
</body>
</html>