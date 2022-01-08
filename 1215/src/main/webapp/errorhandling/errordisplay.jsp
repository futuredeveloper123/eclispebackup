<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  exception 객체를 사용하기 위한 설정  -->
    <%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지 </title>
</head>
<body>
<%

	out.println(exception.getLocalizedMessage() + "<br/>");

%>
</body>
</html>