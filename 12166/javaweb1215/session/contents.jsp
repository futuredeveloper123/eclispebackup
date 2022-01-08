<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컨텐츠</title>
</head>
<body>
	<%
		if(session.getAttribute("id") == null){
			response.sendRedirect("login.jsp");
		}
	%>

	<p>컨텐츠</p>
</body>
</html>