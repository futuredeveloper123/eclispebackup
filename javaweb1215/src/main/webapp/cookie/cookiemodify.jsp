<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 변경</title>
<%

	//name 이라는 쿠키가 존재하면 수정이고 존재하지 않으면 추가
	Cookie cookie = new Cookie("name", "park");
	response.addCookie(cookie);
%>
</head>
<body>

</body>
</html>