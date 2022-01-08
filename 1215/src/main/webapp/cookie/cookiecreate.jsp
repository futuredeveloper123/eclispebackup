<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>make cookie</title>
<%
// 쿠키 생성 
Cookie cookie = new Cookie("name", "cookie");
// 쿠키 전송 - 클라이언트의 웹 브라우저에 저장 
response.addCookie(cookie);

%>
</head>
<body>

	<a href = "cookieread.jsp"> 쿠키읽기   </a>   <br/>

	<a href = "cookiemodify.jsp"> 쿠키변경 </a>   <br/>

	<a href = "cookieremove.jsp"> 쿠키삭제 </a>   <br/> 


</body>
</html>