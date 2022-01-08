<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

//로그아웃은 세션만 임벨리데이트 invalidate 시키면됨 

<%
//로그아웃 처리는 세션을 클리어하고 원하는 곳으로 이동합니다 .
//항상 리다이렉트로 이동 

session.invalidate();
response.sendRedirect("login.jsp");

%>
</body>
</html>

