<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 로그인 처리 </title>
</head>
<body>
<%
//입력 받은 파라미터 가져오기 

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	//로그인 성공햔 경우
	if(id.equals("root") && pw.equals("1234")){
		//세션에 저장 
		session.setAttribute("id",id);
		session.setAttribute("name","관리자 ");
		
		response.sendRedirect("login.jsp");
		//로그인 성공했을 때 어디로 가면 좋을지 정하기 
		
	}else{//실패 했을 때 
		//세션에서 제거 
		session.removeAttribute("id");
		session.removeAttribute("name");
		
		response.sendRedirect("login.jsp");
		
	}

%>
</body>
</html>